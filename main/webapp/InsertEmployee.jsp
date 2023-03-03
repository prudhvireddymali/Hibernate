<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<form action="EMSController" method="post">
<table align="center" width="50%">
  <tr><td>Employee Id</td><td><input type="text" name="eid"/></td></tr>
  <tr><td>Employee Name</td><td><input type="text" name="ename"/></td></tr>
  <tr><td>Employee Salary</td><td><input type="text" name="esalary"/></td></tr>
  <tr><td colspan="2" align="center"><input type="submit" value="Insert" name="EMSButton"/></td></tr>
</table>
</form>
</body>
</html>