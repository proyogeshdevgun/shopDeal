<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
	${message}

	<!--Create Excel Form  -->
	LOGIN:
	<!--Here we will validate login credentials of user by using validate handler -->
	<form action="validate">
		<table>
			<tr>
				<td><span class="glyphicon glyphicon-envelope"></span>UserName:</td>
				<td><input type="text" name="id"></td></tr>
				<tr><td>Password:</td><td><input type="password" name="password"></td></tr>
				<tr><td><input type="submit" value="Login"></td></tr>
		</table>
	</form>
</body>
</html>