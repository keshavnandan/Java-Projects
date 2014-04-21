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
    
    public ArrayList<Movie> getDetails(int deptno) throws ClassNotFoundException, SQLException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
        java.sql.Statement q =  con.createStatement();
        ResultSet res = q.executeQuery("select * from movie");
        ArrayList<Movie> list = new ArrayList<Movie>();
        while(res.next()){
            Movie e = new Movie();
            e.id = res.getInt(1);
            e.title = res.getString(2);
            e.rating = res.getString(3);
            e.releaseDate = res.getDate(4);
            e.moreInfo = null;
            list.add(e);
        }
        return list;
    }
}
