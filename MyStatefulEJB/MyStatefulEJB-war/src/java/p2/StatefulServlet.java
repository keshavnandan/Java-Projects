/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import p1.*;

/**
 *
 * @author training
 */

public class StatefulServlet extends HttpServlet {
    StatefulSessionBeanLocal statefulSessionBean = lookupStatefulSessionBeanLocal();
    private StatefulSessionBeanLocal lookupStatefulSessionBeanLocal() {
        try {
            Context c = new InitialContext();
            return (StatefulSessionBeanLocal) c.lookup("java:global/MyStatefulEJB/MyStatefulEJB-ejb/StatefulSessionBean!p1.StatefulSessionBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    int count = 10;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        count--;
        String s = statefulSessionBean.businessMethod("Hi"+Integer.toString(count));  
        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");
        pw.println(s);
    }
}
