<%-- 
    Document   : newjsp
    Created on : Jul 17, 2013, 11:40:26 AM
    Author     : training
--%>

<%@page import="p1.Emp"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.sql.Array"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Page</title>
    </head>
    <body>
        <table border="2">
            <tr>
                <th>Empno  </th>
                <th>Ename  </th>
                <th>Job</th>
                <th>Manager</th>
                <th>Sal</th>
                <th>Deptno</th>
            </tr>
        <% ArrayList<Emp> list = (ArrayList<Emp>)request.getAttribute("list"); %> 
                <% Iterator<Emp> i = list.iterator();
                    while(i.hasNext()){
                        Emp e = i.next();
                        %>
                        <tr>
                            <td><%=e.empno%></td>
                            <td><%=e.ename%></td>
                            <td><%=e.job%></td>
                            <td><%=e.Manager%></td>
                            <td><%=e.sal%></td>
                            <td><%=e.deptno%></td>
                        </tr>
                <%}%>        
        </table>
        
    </body>
</html>
