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
<h3 style="align:center">Welcome to : <j:out value="${sessionScope.username}"></j:out> </h3>
<h3><a href="Logout">Logout</a></h3>
<form action="GetById" method="post">
<table border="0" align="center">
<tr>
<td>Enter Id to Search</td>
<td><input type="text" name="empcode" id="empcode" required></td>
</tr>
<tr>
<td colspan="2"><input type="submit"></td>
</tr>
</table>
</form>
<j:if test="${employee != null}">
<table border=2 align="center" style="margin-top: 20px">
	<tr>
	<th>empcode</th>
	<th>empname</th>
	<th>salary</th>
	<th>doj</th>
	</tr>
		<tr>
		<td><j:out value="${employee.empid }"></j:out></td>
		<td><j:out value="${employee.empname}"></j:out></td>
		<td><j:out value="${employee.empsalary}"></j:out></td>
		<td><j:out value="${employee.doj}"></j:out></td>
		</tr>
		</table>
</j:if>
<j:if test="${info != null}">
<h3 style="color:red;margin-left:200"><j:out value="${info}"></j:out></h3>
</j:if>
<j:if test="${sessionScope.username == 'admin'}">
<h3 style="margin-left: 850px"><a href="AdminView.jsp">Back</a></h3>
</j:if>
<j:if test="${sessionScope.username != 'admin'}">
<h3 style="margin-left: 850px"><a href="UserView.jsp">Back</a></h3>
</j:if>
</j:when>
<j:otherwise>
<h1>Not Authorized</h1>
</j:otherwise>
</j:choose>
</body>
</html>