/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author training
 */
public class Servlet1 extends HttpServlet {

    ServletConfig config;
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int result = Integer.parseInt(req.getParameter("x"));
        req.setAttribute("res", result);
        config.getServletContext().getRequestDispatcher("/Servlet2").forward(req, resp);
        PrintWriter pw = resp.getWriter();
        pw.write("Servlet1 Done");
    }
    
    
}