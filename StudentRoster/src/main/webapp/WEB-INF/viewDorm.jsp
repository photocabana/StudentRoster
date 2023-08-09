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
<title><c:out value="${dorm.name}"/></title>
</head>
<body>
	<h1><c:out value="${dorm.name}"/> Students</h1>
	<p><a href="/">Dashboard</a></p>
	<table>
		<tr>
			<th>Student</th>
			<th>Action</th>
		</tr>
		<c:forEach var="student" items="${students}">
			<tr>
				<td><c:out value="${student.name}"/></td>
				<td><a href="/students/remove/${student.id}"><c:out value="Remove"/></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>