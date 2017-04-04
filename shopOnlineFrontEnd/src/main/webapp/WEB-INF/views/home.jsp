<!-- // This will be our primary view file.
 -->
 <!-- c prefix will be used in c:if condition down  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>	
	
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>ShopOnline</title>
<link rel='stylesheet' href='<c:url value="/resources/css/style.css" />'
	type='text/css' media='all' />
	
</head>
<body>
	<!-- If the user llogged in, these links w ould not be displayed How I know whether user is logged or not use success message
 -->
	<c:if test="${empty successMsg}">
		<a href="login"><span class="glyphicon glyphicon-user"></span>Login</a>
		<br>
		<a href="registeration"><span class="glyphicon glyphicon-registration-mark"></span>Register</a>
	</c:if>
	
<!-- 	<a href="login">Login</a>
	<br>
	<a href="registeration">Register</a> -->

	<!-- THis is how jsp pages are included in other jsp pages -->
	<!--  For if condition we need to use jstl JSP tag Library-->
	<hr>
	<h1>${successMsg}</h1> 
	${errorMsg}
	<%-- <jsp:include page="registeration.jsp"></jsp:include>
			<jsp:include page="login.jsp"></jsp:include> --%>
	<c:if test="${showLoginPage}">
		<jsp:include page="login.jsp"></jsp:include>
	</c:if>
	<c:if test="${not empty errorMsg}">
		${errorMsg}		
		<jsp:include page="login.jsp"></jsp:include>
	</c:if>
	<c:if test="${showRegisterationPage}">
		<jsp:include page="registeration.jsp"></jsp:include>
	</c:if>

</body>
</html>