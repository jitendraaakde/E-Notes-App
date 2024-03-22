<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <style type="text/css">
        .back-img {
            background: url("img/img.jpg");
            width: 100%;
            height: 80vh;
            background-repeat: no-repeat;
            background-size: cover;
        }
    </style>
    <meta charset="ISO-8859-1">
    <title>Home Page</title>
    <%@include file="all_component/allcss.jsp" %>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>


<div class="container-fluid back-img">
    <div class="text-center ">
        <h1 class="text-white">E notes save your notes</h1>
        <a href="login.jsp" class="btn btn-light my-2 my-sm-0 mr-10">Login</a>
        <a href="register.jsp" class="btn btn-light my-2 my-sm-0 mr-10">Register</a>
    </div>
</div>

<%@include file="all_component/footer.jsp" %>
</body>
</html>
