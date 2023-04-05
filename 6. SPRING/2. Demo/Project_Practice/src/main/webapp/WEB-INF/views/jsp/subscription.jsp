<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST"
		action="${pageContext.request.contextPath}/subscription"
		modelAttribute="preferences">

		<table>
			<tr>
				<td>Subscribe to newsletter?:</td>
				<%-- Approach 1: Property is of type java.lang.Boolean --%>
				<td><form:checkbox path="receiveNewsletter" /></td>
			</tr>
			<tr>
				<td>Interests:</td>
				<%-- Approach 2: Property is of an array or of type java.util.Collection --%>
				<td>
					<%-- 		Quidditch: <form:checkbox path="interests"
						value="Quidditch" /> Herbology: <form:checkbox path="interests"
						value="Herbology" /> Defence Against the Dark Arts: <form:checkbox
						path="interests" value="Defence Against the Dark Arts" /> --%>
						 <form:checkboxes path="interests" items="${interestList}" />
				</td>
			</tr>
			<tr>
				<td>Favourite Word:</td>
				<%-- Approach 3: Property is of type java.lang.Object --%>
				<td>Magic: <form:checkbox path="favouriteWord" value="Magic" />
				</td>
			</tr>
			<tr>
				<td>Gender:</td>
				<%-- <td><form:radiobutton path="gender" value="M" />Male <br /> <form:radiobutton
						path="gender" value="F" />Female</td> --%>
				<td><form:radiobuttons path="gender" items="${genderOptions}" />
				</td>
			</tr>
			<tr>
				<td>Skills:</td>
				<td>
					<%-- <form:select path="skill">
						<form:option value="Java">Java</form:option>
						<br />
						<form:option value="SQLserver">SQLserver</form:option>
						<br />
					</form:select> --%> <form:select path="skill" items="${skills}" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>