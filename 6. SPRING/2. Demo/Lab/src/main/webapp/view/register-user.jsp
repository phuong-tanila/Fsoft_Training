<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register JSP</title>
<link rel="stylesheet" href="/resources/css/register-user.css">
</head>
<body>
	<form action="<%=request.getContextPath()%>/register" method="post"
		onsubmit="return validateRegister()" name="frm-register">
		<h1>USER DETAIL</h1>
		<table border="1">
			<tbody>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName" id="firstName"
						placeholder="First Name" required></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName" id="lastName"
						placeholder="Last Name" required></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" id="email"
						placeholder="Email" required></td>
				</tr>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="userName" id="userName"
						placeholder="User Name" required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" id="password"
						placeholder="Password" required></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><input type="password" name="confirmPassword"
						id="confirmPassword" placeholder="Confirm Password" required></td>
				</tr>
				<tr>
					<td></td>
					<td><button type="submit" onclick="validateRegister()"
							name="register">Register</button></td>
				</tr>
			</tbody>
		</table>
	</form>
	<script src="/resources/js/register-user.js"></script>
</body>
</html>