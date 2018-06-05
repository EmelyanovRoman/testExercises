<%@ page import="webapp.Account" %><%--
  Created by IntelliJ IDEA.
  User: player1
  Date: 6/4/18
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your information</title>
</head>
<body>
<h1>Your random ID: ${id}</h1>
<h1>Your login: ${login}</h1>
<h1>Your login-hash: ${login_hash}</h1>
<h1>Your password: ${password}</h1>
<h1>Your password-hash: ${password_hash}</h1>

<form action="/login.jsp" method="get">
    <input type="submit" value="Back"/>
</form>

</body>
</html>
