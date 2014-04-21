/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author training
 */
public class MyServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String s = "Hi! Welcome";
    String hiredate = "";
    String mgr = "";
    String job = "";
    String ename = "";
    int sal = 0;
    int deptno = 0;
    int counter = 0;
    Connection con = null;
    
    @Override
    public void init() throws ServletException {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
            
            System.out.println("Driver Loaded");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        counter++;
        int empno = Integer.parseInt(req.getParameter("t1"));
        
        try{
            Statement q = con.createStatement();
            ResultSet res = q.executeQuery("select * from emp where empno = "+empno);
            while(res.next()){
                ename = res.getString(2);
                job = res.getString(3);
                mgr = res.getString(4);
                hiredate = res.getString(5);
                sal = res.getInt(6);
                deptno = res.getInt(8);
                System.out.println(res.getInt(1)+" "+res.getString(2));
            }
         }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        s = "<tr><td>"+Integer.toString(empno)+"</td><td>"+ename+"</td><td>"+job+"</td><td>"+mgr+"</td><td>"+hiredate+"</td><td>"+Integer.toString(sal)
                +"</td><td>"+Integer.toString(deptno)+"</td></tr>";
        PrintWriter pw = new PrintWriter(resp.getWriter());
        pw.write("<h2><font color = green></font><table border=\"2.5\"><tr><th>Emp No</th><th>Ename</th><th>Job</th><th>Manager</th><th>Hire Date</th><th>Salary</th><th>Dept No</th></tr>"
                +s+ "</table></h2><br><a href=\"/MWebApplication\">Back</a>");
        System.out.println(counter+" done.");
    }

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }
}
