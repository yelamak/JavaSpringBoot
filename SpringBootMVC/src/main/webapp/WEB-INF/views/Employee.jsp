<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:form action="getemployee" commandName="employee">
id<s:input path="empid"/>
<s:errors path="empid"/><br>
name<s:input path="empname"/>
<s:errors path="empname"></s:errors><br>
salary<s:input path="empsalary"/>
<s:errors path="empsalary"></s:errors><br>
<s:input path="doj"/>
<input type="submit">
</s:form>
</body>
</html>