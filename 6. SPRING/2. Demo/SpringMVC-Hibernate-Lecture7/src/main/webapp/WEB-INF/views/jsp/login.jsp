<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>${msg}</h1>
	<label>${message}</label>
	<form action="login" method="post" name="loginForm">
		User Name: <input type="text" name="userName"> Password: <input
			type="password" name="password"> <input type="submit"
			value="Login">
	</form>

</body>
</html>