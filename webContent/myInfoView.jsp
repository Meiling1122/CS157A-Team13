<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Info</title>
</head>
<body>
<%
	if(session.getAttribute("user") == null){
		response.sendRedirect("login.jsp");
	}
	else
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("myInfo");
		dispatcher.include(request, response);
	}
	
%>
<h1>My Info</h1>
<h2>Enrollments</h2>
<%
	String[] list = (String[])session.getAttribute("course_names");
	if (list != null){
		for (String s : list){
			out.println(s + "<br>");
		}
	}

%>
<h2>Name</h2>
Your name is ${studentAccount.studentName} 
<h2>Campus</h2>
${campus}
<h2>AccountID</h2>
Your accountID is ${user.accountID}
<br>
<a href="homepage.jsp">Home</a>
<br>
<a href="checkCourse.jsp">Update Enrollments</a>
<form action="logout">
<input type="submit" value="Logout">
</form>
</body>
</html>