<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%-- <%@include file="HeadSection.jsp" %> --%>
<head>

<link href="hexa.css" rel="stylesheet">
</head>
<style>
#plus{
	width: 100%;
	margin: 0 auto;
	background-color: wheat;
	box-shadow: 5px 5px 5px black;
	opacity:0.5;
}
#frmbuttn {
	margin-top: 10px;
}
div{
opacity: 0.9;
}
body {
    background-image: url("color.jpg");
    background-position: center;
    background-repeat: no-repeat, repeat;
    background-size: 70% 70%;
   
}


</style>
<body>

<%@include file="Header.jsp" %>  
<section>

<div  id="plus" class="container h-100 d-flex justify-content-center" style="width:100%;margin: 0 auto;">
    <div class="jumbotron my-auto" style="width:50%;margin: 150px auto;min-height:200px;opacity:1">
<form action="checkLogin" method="post">
				<input class="form-control transparent-input" type="text"  name="username"  placeholder="Enter your UserName" required="required" />	
				<input  class="form-control transparent-input" type="password" name="upassword" placeholder="Enter your password" required="required"/>
				<input class="btn btn-primary" type="submit" value="login" id="frmbuttn" style="margin-left: 30%">
		</form>
		</div>
</div>

 


</section>
<%@include file="Footer.jsp" %>
</body>
</html>