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

/**
 *
 * @author training
 */
public class Servlet2 extends HttpServlet {
  @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           int result  = (Integer)req.getAttribute("res");
           PrintWriter pw = resp.getWriter();
           if(result < 0 || result > 9){
            System.err.println("number out of range");
            pw.write("<h1>Number out of range</h1>");
           }
           else {
               System.out.println("number = "+result);
               pw.write("<h1>Number = "+result+"</h1><br>");
               pw.write("Servelet2 done");
           }
    }
}