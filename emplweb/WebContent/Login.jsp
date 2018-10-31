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
<form action="Login" method="post">
<table align="center" border="0" style="margin-top: 100px">
<tr><td colspan="2" align=center>Login</td></tr>
<tr><td>Username</td>
<td><input type="text" name="username" id="username" required></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="pass" id="pass" required></td>
</tr>
<tr><td colspan="2" align=center><input type="submit"></td></tr>
<tr><td colspan="2" align=center><j:out value="${error}"></j:out></td></tr>
</table>
</form>
</body>
</html>