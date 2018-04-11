<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<%-- <%@include file="HeadSection.jsp" %> --%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="hexa.css" rel="stylesheet">
</head>
<style>
table {
	width: 400px;
}
</style>

<body>
	<%@include file="Header.jsp"%>

	<section>
		<div align="center">
			<h1>Your History:</h1>
			<j:if test="${requestScope.history ne null}">
				<table border="5">
					<tr>

						<td>Date</td>
						<td>Exam</td>
						<td>Marks</td>

					</tr>
					<j:forEach items="${history}" var="h">
						<tr>
							<td><fmt:formatDate value="${h.date}" pattern="dd-MMM-yyyy"/></td>
							<td>${h.htype.examType}</td>
							<td>${h.marks}</td>
					</j:forEach>


				</table>

			</j:if>
			<j:if test="${requestScope.history eq null}">
      No History Found For this User!!
		</j:if>
		</div>
	</section>
	<%@include file="Footer.jsp"%>
</body>
</html>