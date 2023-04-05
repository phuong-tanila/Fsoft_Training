<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="../resources/css/register-user.css" rel="stylesheet">
<script src="../resources/js/register-user.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>USER DETAIL</h1>
	<form method="post">
		<div class="row">
			<label for="firstName" class="col-sm-5 col-form-label">First
				Name:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="firstName" name="firstName">
			</div>
		</div>
		<div class="row">
			<label for="lastName" class="col-sm-5 col-form-label">Last
				Name:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="lastName" name="lastName">
			</div>
		</div>
		<div class="row">
			<label for="email" class="col-sm-5 col-form-label">Email:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="email" name="email">
			</div>
		</div>
		<div class="row">
			<label for="userName" class="col-sm-5 col-form-label">User
				Name:</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="userName" name="userName">
			</div>
		</div>
		<div class="row">
			<label for="password" class="col-sm-5 col-form-label">Password:</label>
			<div class="col-sm-3">
				<input type="password" class="form-control" id="password" name="password">
			</div>
		</div>
		<div class="row">
			<label for="confirmPassword" class="col-sm-5 col-form-label">Confirm
				Password:</label>
			<div class="col-sm-3">
				<input type="password" class="form-control" id="confirmPassword" name="confirmPassword">
			</div>
		</div>
		<button class="btn btn-primary" type="submit">Submit</button>
	</form>
</body>
</html>