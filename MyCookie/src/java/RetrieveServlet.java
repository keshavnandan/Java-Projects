/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
 *
 * @author training
 */
public class RetrieveServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] carr = req.getCookies();
        String[] in = new String[carr.length];
        PrintWriter pw = resp.getWriter();
        for(int i = 0; i < carr.length;i++){
            in[i] = carr[i].getValue();
            System.out.println(in[i]);
            resp.setContentType("text/html");
            pw.write(in[i]+"<br>");
        }        
    }
}
