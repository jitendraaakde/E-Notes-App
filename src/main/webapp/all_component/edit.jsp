<%@page import="com.Db.DBConnect"%>
<%@page import="com.DAO.PostDAO"%>
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
	<%
	Integer noteid = Integer.parseInt(request.getParameter("note_id"));
	PostDAO post = new PostDAO(DBConnect.getConn());
	Post p = post.getDatabyId(noteid);
	%>




	<%@include file="all_component/navbar.jsp"%>
	<h1 class="text-center m-3">Edit your Notes</h1>

	<div class="container">

		<div class="row">
			<div class="col-md-12 ">
				<form class="p-4" action="NoteEditServlet" method="post">
					<input type="hidden" value="<%=noteid%>" name="noteid" />

					<div class="form-group">

						<label for="exampleInputEmail1">Enter Title</label> <input
							type="text" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" placeholder="Enter Title"
							name="title" required="required" value="<%=p.getTitle()%>">
					</div>
					<div class="form-group mt-4 mb-4">
						<label for="exampleInputEmail1">Enter Note</label>
						<textarea rows="10" cols="" class="form-control" name="content"
							required="required" value="<%=p.getContent()%>>"></textarea>
					</div>
					<div class="container text-center">
						<button type="submit" class="btn btn-primary">Add Notes</button>
					</div>
				</form>
			</div>
		</div>



	</div>

</body>
</html>