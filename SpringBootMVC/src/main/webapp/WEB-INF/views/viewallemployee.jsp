<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=2 align="center">
	<tr>
	<th>empcode</th>
	<th>empname</th>
	<th>salary</th>
	<th>doj</th>
	</tr>
	<j:forEach var="emp" items="${empls}">
		<tr>
		<td><j:out value="${emp.empid }"></j:out></td>
		<td><j:out value="${emp.empname}"></j:out></td>
		<td><j:out value="${emp.empsalary}"></j:out></td>
		<td><j:out value="${emp.doj}"></j:out></td>
		<td><a href="UpdateEmpl?code=${emp.empid}">update</a></td>
		<td><a href="deleteEmpl?code=${emp.empid}">delete</a></td>
		</tr>
	</j:forEach>
	
</table>

</body>
</html>