<%@page import="com.ems.bean.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="EmployeeFind.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<br>
<%
   Employee emp = (Employee) request.getAttribute("emp");
   out.println("<table align='center' width='60%'>");
   out.println("<tr><th>Employee Id</th><th>Employee Name</th><th>Employee Salary</th></tr>");
   out.println("<tr><td>"+emp.getEid()+"</td><td>"+emp.getEname()+"</td><td>"+emp.getEsalary()+"</th></tr>");
   out.println("</table>");
%>
</body>
</html>