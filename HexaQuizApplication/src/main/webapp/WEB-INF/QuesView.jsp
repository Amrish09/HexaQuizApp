<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
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
input[type=submit] {
	width: 10em;
	height: 2em;
}
</style>
<body>
	<%@include file="Header.jsp"%>
	<section>
		<j:if test="${sessionScope.user ne null}">
			<div id="ques" >


				<form action="viewquiz" method="post">


					<h3>${ques.quesDesc}</h3>
					<br> <br>


					<c:choose>
						<c:when test="${sessionScope.ansmap[ques.quesId] eq ques.optA}">
						   <h4>
								<input type="radio" name="qans" value="${ques.optA}" checked="checked"/>${ques.optA}</h4>
							<h4>
								<input type="radio" name="qans" value="${ques.optB}" />${ques.optB}</h4>
							<h4>
								<input type="radio" name="qans" value="${ques.optC}" />${ques.optC}</h4>
						</c:when>
						<c:when test="${sessionScope.ansmap[ques.quesId] eq ques.optB}">
							
							<h4>
								<input type="radio" name="qans" value="${ques.optA}" />${ques.optA}</h4>
							<h4>
								<input type="radio" name="qans" value="${ques.optB}" checked="checked"/>${ques.optB}</h4>
							<h4>
								<input type="radio" name="qans" value="${ques.optC}" />${ques.optC}</h4>
						</c:when>
						<c:when test="${sessionScope.ansmap[ques.quesId] eq ques.optC}">
							<h4>
								<input type="radio" name="qans" value="${ques.optA}" />${ques.optA}</h4>
							<h4>
								<input type="radio" name="qans" value="${ques.optB}" />${ques.optB}</h4>
							<h4>
								<input type="radio" name="qans" value="${ques.optC}" checked="checked"/>${ques.optC}</h4>
						</c:when>
						<c:otherwise>
							<h4>
								<input type="radio" name="qans" value="${ques.optA}" />${ques.optA}</h4>
							<h4>
								<input type="radio" name="qans" value="${ques.optB}" />${ques.optB}</h4>
							<h4>
								<input type="radio" name="qans" value="${ques.optC}" />${ques.optC}</h4>
						</c:otherwise>
					</c:choose>

					<br> <br> <input type="hidden" name="qid"
						value="${ques.quesId}" />
					<div align="center">
						<j:if test="${sessionScope.currid gt 0}">
							<input type="submit" class="btn-danger" name="btn" value="prev">
						</j:if>
						<j:if test="${sessionScope.currid eq 4}">
							<input type="submit" class="btn-success" name="btn"
								value="finish">
						</j:if>
						<j:if test="${sessionScope.currid lt 4}">
							<input type="submit" class="btn-primary" name="btn" value="next">
						</j:if>

					</div>

				</form>
			</div>
		</j:if>

		<j:if test="${sessionScope.user eq null}">
    Yoy are not Logged in , Please <a href="login">Login</a>
		</j:if>
	</section>
	<%@include file="Footer.jsp"%>
</body>
</html>