/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author training
 */
public class CookieServlet extends HttpServlet {

    Cookie c;
    @Override
    public void init() throws ServletException {
    }
    

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       c = new Cookie("BG",req.getParameter("city"));
       resp.addCookie(c);
       PrintWriter pw = resp.getWriter();
       pw.write("<h1>Cookie Stored!!</h1><br><body><form action = \"RetrieveServlet\"><input type=\"submit\"></form></body>");
    }
}
