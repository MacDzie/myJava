<html>
<head>
    <title>Register form</title>
</head>
<body>
    <form action="register" method="post">
        <label>Username<input type="text" name="name" id="name" required/></label><br/>
        <label>Password<input type="password" name="pass" id="pass" required/></label><br/>
        <label>Confirm Password<input type="password" name="pass" id="confirmPass" required/></label><br/>
        <label>Email<input type="text" name="mail" id="mail" required/></label><br/><br/>
        <input type="submit" value="Registration"/>
    </form>
    <a href="login.jsp">Log in</a>
</body>
</html>
