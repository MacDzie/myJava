<%--
  Created by IntelliJ IDEA.
  User: Maciej
  Date: 23/03/2019
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="login" method="post">
        <label>Username<input type="text" name="name" id="name" required/></label><br/>
        <label>Password<input type="password" name="pass" id="pass" required/></label><br/>
        <input type="submit" value="Login"/>
    </form>
</body>
</html>
