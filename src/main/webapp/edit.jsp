<%@page import="studentdetails.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Student s = (Student) request.getAttribute("students"); %>
<form action="update">
id: <input type = "number" name = "id" readonly="true" value=<%= s.getId()  %>><br><br>
name: <input type = "text" name = "name" value=<%= s.getName() %>><br><br>
password: <input type = "text" name = "password" value=<%= s.getPassword() %>><br><br>
location: <input type = "text" name = "location" value=<%= s.getLocation() %>><br><br>
phoneno: <input type = "number" name = "phoneno"value=<%= s.getPhoneNo() %>><br><br>
email: <input type = "text" name = "email" value=<%= s.getEmail() %>><br><br>
submit: <input type = "submit">
</form>
</body>
</html>