<%-- 
    Document   : index
    Created on : Jul 19, 2013, 9:23:25 AM
    Author     : training
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.sql.DataSource"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stateful Session</title>
    </head>
    <body>
        <h1><form action="StatefulServlet">
                <% 
                    DataSource ds  = (DataSource)(new InitialContext()).lookup("Keshav");
                    Connection con = ds.getConnection();
                    Statement  s = con.createStatement();
                    ResultSet res =  s.executeQuery("select empno from emp");
                    while(res.next()){
                        out.println(res.getInt(1)+"<br>");
                    }
                %>
                <input type="submit" title="Go">
            </form></h1>
    </body>
</html>
