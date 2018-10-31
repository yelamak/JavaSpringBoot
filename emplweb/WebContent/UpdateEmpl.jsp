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
<j:choose >
<j:when test="${sessionScope.username != null}">
<h3 style="align:center">Username : <j:out value="${sessionScope.username}"></j:out> </h3>
<h3><a href="Logout">Logout</a></h3>
<j:set var="emp" value="${employee}"></j:set>
<form action="UpdateEmpl" method="post">
code<input type="text" name="empcode" value="${emp.empid }" readonly>
	name<input type="text" name="empname" value="${emp.empname}" required>
	salary<input type="text" name="salary" value="${emp.empsalary}" required>
	dob<input type="date" name="dob" value="${emp.doj}" required>
	<input type="submit">

</form>
</j:when>
<j:otherwise>
<h1>Not Authorized</h1>
</j:otherwise>
</j:choose>
</body>
</html>