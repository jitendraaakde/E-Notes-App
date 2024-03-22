<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%
	UserDetails user2 = (UserDetails) session.getAttribute("userD");

	if (user2 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("login-error", "Please login....");
	}
	%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Home page</h1>
</body>
</html>