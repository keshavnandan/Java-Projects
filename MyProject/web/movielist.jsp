<%-- 
    Document   : movielist
    Created on : Jul 19, 2013, 4:17:07 PM
    Author     : training
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.sql.Array"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sun.org.apache.xpath.internal.operations.Mod"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Rotten Potatoes!</title>
</head>
<body>
<h1 class='title'>Rotten Potatoes!</h1>
<div id='main'>
<h1>All Movies</h1>

<table id='movies'>
<thead>
<tr>
<th><a href="MovieServlet?action=movieTitle">Movie Title</a></th>
<th><a href="MovieServlet?action=movieRating">Rating</a></th>
<th><a href="MovieServlet?action=releaseDate">Release Date</a></th>
<th><a href="MovieServlet?action=movieInfo">More Info</a></th>
</tr>
</thead>
<tbody>
    <% ArrayList<Movie> movieList = (ArrayList<Movie>)request.getAttribute("movieList");
        Iterator<Movie> iterator = movieList.iterator();
        while(iterator.hasNext()){
            Movie m = iterator.next();
     %>
            <tr>
                <td><%=m.title></td>
                <td><%=m.rating></td>
                
            </tr>
    <%
        }
    %>
<tr>
<td>Aladdin</td>
<td>G</td>
<td>1992-11-25 00:00:00 UTC</td>
<td><a href="/movies/1">More about Aladdin</a></td>
</tr>
<tr>
<td>The Terminator</td>
<td>R</td>
<td>1984-10-26 00:00:00 UTC</td>
<td><a href="/movies/2">More about The Terminator</a></td>
</tr>
<tr>
<td>When Harry Met Sally</td>
<td>R</td>
<td>1989-07-21 00:00:00 UTC</td>
<td><a href="/movies/3">More about When Harry Met Sally</a></td>
</tr>
<tr>
<td>The Help</td>
<td>PG-13</td>
<td>2011-08-10 00:00:00 UTC</td>
<td><a href="/movies/4">More about The Help</a></td>
</tr>
<tr>
<td>Chocolat</td>
<td>PG-13</td>
<td>2001-01-05 00:00:00 UTC</td>
<td><a href="/movies/5">More about Chocolat</a></td>
</tr>
<tr>
<td>Amelie</td>
<td>R</td>
<td>2001-04-25 00:00:00 UTC</td>
<td><a href="/movies/6">More about Amelie</a></td>
</tr>
<tr>
<td>2001: A Space Odyssey</td>
<td>G</td>
<td>1968-04-06 00:00:00 UTC</td>
<td><a href="/movies/7">More about 2001: A Space Odyssey</a></td>
</tr>
<tr>
<td>The Incredibles</td>
<td>PG</td>
<td>2004-11-05 00:00:00 UTC</td>
<td><a href="/movies/8">More about The Incredibles</a></td>
</tr>
<tr>
<td>Raiders of the Lost Ark</td>
<td>PG</td>
<td>1981-06-12 00:00:00 UTC</td>
<td><a href="/movies/9">More about Raiders of the Lost Ark</a></td>
</tr>
<tr>
<td>Chicken Run</td>
<td>G</td>
<td>2000-06-21 00:00:00 UTC</td>
<td><a href="/movies/10">More about Chicken Run</a></td>
</tr>
<tr>
<td>Gangs of Wasseypur</td>
<td>G</td>
<td>2012-11-20 00:00:00 UTC</td>
<td><a href="/movies/11">More about Gangs of Wasseypur</a></td>
</tr>
</tbody>
</table>
<a href="/movies/new">Add new movie</a>

</div>
</body>
</html>
