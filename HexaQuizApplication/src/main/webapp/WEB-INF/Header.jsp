<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>



	<img src="logo.jpg" height="65px" width="70px" /><span id="one">exaQuiz</span>
	<span id="two">Application</span><br />



	<c:if test="${sessionScope.user ne null}">
		<div align="right"> <div align="left"><b><h3>Hi ${sessionScope.user.userName},Welcome to HexaQuiz Application</h3></b> </div>
			<a href="logout" class="btn-danger">Logout</a>
		</div>
	</c:if>
	<c:if test="${sessionScope.user eq null}">
		<div align="right"> <div align="left"><b><h3>Hi Guest,Welcome to HexaQuiz Application</h3></b> </div>
		</div>
	</c:if>
	


	<%-- <c:if test="${sessionScope.user ne null}">
	    Hi ${sessionScope.user.userName} <a href="logout">Logout</a>
	</c:if> --%>
	<hr />
</header>
