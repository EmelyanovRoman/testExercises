<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: player1
  Date: 6/4/18
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>You CAN DO IT!</title>
  </head>
  <body>

  <h1>SiberTeam Welcome ME! :)</h1>
  <p>We will have excellent cooperation!!</p>

  <%
    Date date = new Date();
    out.print("<h2>" + date.toString() + "<h2>");
  %>

  </body>
</html>
