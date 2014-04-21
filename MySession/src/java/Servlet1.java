/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author training
 */
public class Servlet1 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession hs = req.getSession(true);
        hs.setAttribute("xval", req.getParameter("x"));
        PrintWriter pw = resp.getWriter();
        resp.sendRedirect("/MySession/newhtml.html");
    }

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }

}
