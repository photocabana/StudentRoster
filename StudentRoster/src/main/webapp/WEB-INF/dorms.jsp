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
<title>Dorms</title>
</head>
<body>
	<h1>Dorms</h1>
	<p><a href="/dorm/new">Add A New Dorm</a></p>
	<p><a href="/student/new">Add A New Student</a></p>
	<table>
		<tr>
			<th>Dorm</th>
			<th>Action</th>
		</tr>
		<c:forEach var="dorm" items="${dorms}">
			<tr>
				<td><c:out value="${dorm.name}"/></td>
				<td><a href="/dorms/${dorm.id}"><c:out value="See Students"/></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>