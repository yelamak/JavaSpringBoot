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
<j:when test="${sessionScope.username != null and sessionScope.username != 'admin'}">
<h3 style="align:center">UserName : <j:out value="${sessionScope.username}"></j:out> </h3>
<h3><a href="Logout">Logout</a></h3>
<table align="center" border="0">

<tr>
<td><a href="ViewEmpls?action=view">View all Employee</a>
</td>
</tr>
<tr>
<td><a href="GetById">View Employee By Id</a>
</td>
</tr>
</table>
</j:when>
<j:otherwise>
<h1>Not Authorized</h1>
</j:otherwise>
</j:choose>
</body>
</html>