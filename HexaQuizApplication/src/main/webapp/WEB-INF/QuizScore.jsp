<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<!DOCTYPE html>
<html>

<%-- <%@include file="HeadSection.jsp" %> --%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="hexa.css" rel="stylesheet">
</head>
<style>
table{
	
	width: 400px;
}

</style>

<body>
	<%@include file="Header.jsp"%>

	<section>
	<div align="center">
	<h1>Your Score:</h1>
		<j:if test="${sessionScope.user ne null}">
			<table border="5">
				<tr>
					<td>User Name</td>
					<td>${sessionScope.user.userName}</td>
				</tr>
				<tr>
					<td>Exam</td>
					<td>${sessionScope.examid}</td>
				</tr>
				
				<tr>
					<td>Score</td>
					<td>${score}</td>
				</tr>
			</table>
			
		</j:if>
		<j:if test="${sessionScope.user eq null}">
 You are not Logged in , Please <a href="login">Login</a>
		</j:if>
		</div>
	</section>
	<%@include file="Footer.jsp"%>
</body>
</html>