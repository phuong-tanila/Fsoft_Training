<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${msg}</h1>
	<h2>
		Welcome <span>${username}</span>!<br>
		The password: <span>${user.password}</span>
		The password:<c:out value="${sessionScope.user.password}"/>
	</h2>
</body>
</html>