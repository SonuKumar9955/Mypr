<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body bgcolor="cyan">
<center>
<font color="Blue"><h1> Login Form</h1></font><br/><br/><br/><br/>
<font color="red">${errMessage}</font>
<form action="LoginServlet" method="post">
<font color="blue">UserId</font><input type="text" name="userName"><br/>
<font color="blue">Password</font><input type="password" name="password"><br/>
<input type="submit" value="LogIn" name="submit">
<input type="reset" value="Clear"><br/>
</form>
</center>
</body>
</html>