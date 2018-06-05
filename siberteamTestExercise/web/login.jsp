
  <%--Created by IntelliJ IDEA.--%>
  <%--User: player1--%>
  <%--Date: 6/4/18--%>
  <%--Time: 3:06 PM--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <h1>Welcome, Stranger! Please, come in.</h1>

    <form action="/login" method="post">
        login-name: <input type="text" name="name" width="30"/>
        password: <input type="password" name="password" width="10"/>
        <input type="submit" value="Come in"/>
    </form>

</body>
</html>
