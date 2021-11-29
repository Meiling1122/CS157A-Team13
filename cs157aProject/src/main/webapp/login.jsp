<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
</head>
<style>
body{
background-color: lightblue;
text-align: center;
}
</style>
<body>
	<form action="login">
		<label for="username">Username</label><br>
		<input type="text" id="username" name="username"><br>
		<label for="password">Password</label><br>
		<input type="password" id="password" name="password"><br>
		<input type="Submit" value="Log In"><br>
	</form>
</body>
<a href="createAccount.jsp">Create Account</a>
</html>