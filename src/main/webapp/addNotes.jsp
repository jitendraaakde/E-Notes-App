<%@page import="com.User.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
UserDetails user1 = (UserDetails) session.getAttribute("userD");

if (user1 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("login-error", "Please login....");
}
%>






<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allcss.jsp"%>

</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<h1 class="text-center m-3">Add your Notes</h1>

	<div class="container">

		<div class="row">
			<div class="col-md-12 ">
				<form class="p-4" action="AddNotesServlet" method="post">
					<div class="form-group">
						
						<%
						UserDetails us = (UserDetails) session.getAttribute("userD");
						if (us != null) {
						%>
						<input type="hidden" value="<%=us.getId()%>" name="uid" />
						<%
						}
						%>
						<!-- Use userName instead of us.getName() -->







						<label for="exampleInputEmail1">Enter Title</label> <input
							type="text" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" placeholder="Enter Title"
							name="title" required="required">
					</div>
					<div class="form-group mt-4 mb-4">
						<label for="exampleInputEmail1">Enter Note</label>
						<textarea rows="10" cols="" class="form-control" name="content"
							required="required"></textarea>
					</div>
					<div class="container text-center">
						<button type="submit" class="btn btn-primary">Add Notes</button>
					</div>
				</form>
			</div>
		</div>



	</div>


	<%@include file="all_component/footer.jsp"%>

</body>
</html>
