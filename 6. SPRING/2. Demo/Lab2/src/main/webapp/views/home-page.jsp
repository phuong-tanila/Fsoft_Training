<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<ul class="navbar-nav ml-auto">
		<li class="nav-item"><a class="nav-link" style="color: yellow"
			href="#"> <i class="fa fa-user-circle-o"></i>
				${userLogin.userName}
		</a></li>
		<li class="nav-item"><a class="nav-link"
			href="<%=request.getContextPath()%>/logout"> <i
				class="fa fa-user-times"></i> Logout
		</a></li>
	</ul>
</body>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/home-page.js"></script>
</html>