/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author training
 */
public class WebServlet extends HttpServlet { // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int x = Integer.parseInt(req.getParameter("x"));
        int y = Integer.parseInt(req.getParameter("y"));
//        @EJB
        
    }
    
    
}
