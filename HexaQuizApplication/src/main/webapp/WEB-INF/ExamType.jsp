<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<!DOCTYPE html>
<html>
<%-- <%@include file="HeadSection.jsp" %> --%>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="hexa.css" rel="stylesheet">
</head>
<style>

select {
        width:200px;
    }

</style>
<body>
<%@include file="Header.jsp" %>
<section>
<j:if test="${sessionScope.user ne null}">


<h2>Lets Start The Quiz!! All The Best!!</h2>
<div align="center" style="padding:10px;">
		<form action="quizquestions"><b >Choose Exam</b>
				<select name="examid">
				  <option value="1">Java</option>
				  <option value="2">MYSql</option>
				</select>
				<input type="submit" id="start" value="start" class="btn-success">
		</form>
		
		
		<!-- <b>View your Quiz History Here:</b> --><a href="quizhistory"  class="btn">view history</a>
		
</div>

</j:if>
<j:if test="${sessionScope.user eq null}">
    Yoy are not Logged in , Please <a href="login">Login</a>
</j:if>
</section>
<%@include file="Footer.jsp" %>
</body>
</html>