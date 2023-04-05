<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<style>
	.error {
		color: red;
	}
</style>
</head>

<body>
	<h2>Login.jsp</h2>
	<form:form action="" method="POST" modelAttribute="user">
		Name: <form:input path="name"/> <br/><br/>
     <button type="submit">Submit</button>
	</form:form>
</body>
</html>
