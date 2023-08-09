<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Student</title>
</head>
<body>
	<h1>New Student</h1>
	<p><a href="/">Dashboard</a></p>
	<form:form action="/student/new" modelAttribute="student" method="POST">
		<div>
			<form:errors path="name"/>
			<form:label path="name" for="name">Name: </form:label>
			<form:input path="name" type="text"/>
		</div>
		<div>
			<form:select path="dorm">
				<c:forEach var="dorm" items="${dorms}">
					<option value="${dorm.id}">${dorm.name}</option>
				</c:forEach>
			</form:select>
		</div>
		<input value="Add" type="submit"/>
	</form:form>
</body>
</html>