<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
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
		<j:if test="${sessionScope.username == 'admin' and sessionScope.action != 'view'}">
		 <j:if test="${sessionScope.action == 'update'}"><td>
		<a href="UpdateEmpl?code=${emp.empid}">update</a></td></j:if>
		<j:if test="${sessionScope.action == 'delete'}"><td>
		<a href="DeleteEmpl?code=${emp.empid}">delete</a></td></j:if>
		 
		<%--  <td>
		<a href="UpdateEmpl?code=${emp.empid}">update</a></td>
		<td>
		<a href="DelEmpl?code=${emp.empid}">delete</a></td> --%>
		 </j:if>
		</tr>
	</j:forEach>
	
</table>
<h4 style="color:red;margin-left:100px"><j:out value="${error}"></j:out></h4>
<h4 style="color:green;margin-left:100px"><j:out value="${success}"></j:out></h4>
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