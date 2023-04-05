<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<h1>${msg}</h1>
	<label>${message}</label>

	<%-- <form action="login" method="post" name="loginForm">
		User Name: <input type="text" name="userName"> Password: <input
			type="password" name="password"> <input type="submit"
			value="Login">
	</form> --%>

	<form:form action="login" modelAttribute="user">
		<table>
			<tr>
				<td>Username:</td>
				<td><form:input path="userName" value="PhuongNH"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input path="password" value="12345"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>