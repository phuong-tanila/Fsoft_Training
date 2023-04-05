<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<c:url value="/customer-list" var="urlListCustomer" />
	<h1>${msg}</h1>
	<h2>
		Welcome <span style="color: red">${username}</span>!<br>
		The password: <span>${user.password}</span><br />
		The password: <c:out value="${sessionScope.user.password}" />
	</h2>
	<a href="${urlListCustomer}">Click here to view Customer List</a>
</body>
</html>