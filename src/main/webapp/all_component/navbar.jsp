<%@page import="com.User.UserDetails"%>
<%@page import="com.DAO.UserDAO"%>
<nav class="navbar navbar-expand-lg navbar-dark navbar-custom bg-custom">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Logo</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 flex">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="home.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="addNotes.jsp">Add
						Notes</a></li>

				<li class="nav-item"><a class="nav-link " href="#"
					tabindex="-1" aria-disabled="true">Show Notes</a></li>
			</ul>
			
			<%
			UserDetails user=(UserDetails) session.getAttribute("userD");
			if(user != null){
			%>

			<a href="btn btn-light my-2 my-sm-0 mr-2" data-toggle="model"
				data-target="#exampleModel" type="submit"><%=user.getName() %></a>
			<a href="LogoutServlet" class="btn btn-light my-2 my-sm-0"
				type="submit">Logout</a>
			
			
			<%
			}else{
			%>
			
			<form class="	d-flex">

				<a href="login.jsp" class="btn btn-light my-2 my-sm-0 mr-10"
					type="submit">LogIn</a> <a href="register.jsp"
					class="btn btn-light my-2 my-sm-0 p-1 m-4" type="submit">Register</a>
			</form>
			<%
			}%>
			
		</div>
	</div>
</nav>