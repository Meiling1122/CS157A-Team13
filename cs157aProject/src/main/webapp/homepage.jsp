<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	if(session.getAttribute("user") == null){
		response.sendRedirect("login.jsp");
	}
%>
Welcome ${user.username}
<br>
You are now logged in
<br>
<a href="myInfo">My Info</a>
<form action="logout">
<input type="submit" value="Logout">
</form>
</body>
</html>