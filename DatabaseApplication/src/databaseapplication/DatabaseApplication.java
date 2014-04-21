/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseapplication;

import java.sql.*;
import java.util.*;

/**
 *
 * @author training
 */
public class DatabaseApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver Loaded");       
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
            PreparedStatement p = con.prepareStatement("select * from emp where empno = ?");
            Scanner sc = new Scanner(System.in);
            ResultSet res = null;
            int empno = sc.nextInt();
            while(empno != 0){
                p.setInt(1, empno);
                res = p.executeQuery();
                while(res.next()){
                    System.out.println(res.getInt(1)+", "+res.getString(2)+" "+res.getInt("sal"));
                }
                empno = sc.nextInt();
            }
            ResultSetMetaData rsmd = res.getMetaData();
            System.out.println(rsmd.getColumnClassName(1)+" "+rsmd.getColumnName(1));
            res.close();
            p.close();
            con.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
