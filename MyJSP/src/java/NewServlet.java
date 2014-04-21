/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import p1.*;

/**
 *
 * @author training
 */
public class NewServlet extends HttpServlet {

    ServletConfig config;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override    
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int deptno = Integer.parseInt(req.getParameter("dn"));
        System.out.println("Deptno = "+deptno);
        try{
            ArrayList<Emp> list = (new NewBean()).getDetails(deptno);
            req.setAttribute("list", list);
            list = (ArrayList<Emp>)req.getAttribute("list");
            Iterator<Emp> i = list.iterator();
            while(i.hasNext()){
                Emp e = i.next();
                System.out.println(e.ename);
            }
            
            config.getServletContext().getRequestDispatcher("/newjsp.jsp").forward(req, resp);
            System.out.println("Returned from form");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }    

}
