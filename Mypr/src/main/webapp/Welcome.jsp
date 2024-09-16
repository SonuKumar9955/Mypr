<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Page</title>
</head>
<body bgcolor="cyan">
<center>
    <h1>Welcome, <font color="blue">${requestScope.fullName}</font>!</h1>
    <p>We're glad to have you back.</p>
    <a href="Login.jsp">Go to Home</a>
</center>
</body>
</html>