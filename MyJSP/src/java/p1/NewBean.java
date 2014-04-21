/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;
import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author training
 */

public class NewBean implements Serializable {
    
    public ArrayList<Emp> getDetails(int deptno) throws ClassNotFoundException, SQLException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
        java.sql.Statement q =  con.createStatement();
        ResultSet res = q.executeQuery("select * from emp where deptno = "+deptno);
        ArrayList<Emp> list = new ArrayList<Emp>();
        while(res.next()){
            Emp e = new Emp();
            e.empno = res.getInt(1);
            e.ename = res.getString(2);
            e.job = res.getString(3);
            e.Manager = res.getString(4);
            e.sal = res.getInt(6);
            e.deptno = res.getInt(8);
            list.add(e);
        }
        return list;
    }
}
