<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome JSP</title>
</head>
<body>
	<%!String str = "Hello, Welcome to the First JSP!";%>
	<%=str%>
	Today is:
	<%=new Date()%>

	<%-- 
	<jsp:setProperty property="HelloWorld" name="userName" />
	<jsp:forward page="Welcome.jsp"></jsp:forward> --%>
</body>
</html>