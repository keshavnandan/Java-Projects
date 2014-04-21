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
public class Servlet2 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession hs = req.getSession(false);
        int x = Integer.parseInt((String)hs.getAttribute("xval"));
        int y = Integer.parseInt(req.getParameter("y"));
        PrintWriter pw = resp.getWriter();
        pw.write("<h2><font color = red><th>X = "+x+"</th></font><br><font color = green><th>Y = "+y+"</th></font><br></h2><h1><font color = blue><th> X + Y = "+(x+y)+"</th></font></h1>");
    }
}
