<%@page import= "studentdetails.dto.Student" %>
<%@page import ="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#al{
text-align: center;
}
table{
  height: 50vh;
  weight: 50%;
 
}
table,td,th{
border : 2px solid black;
border-collapse: collapse;
}
td{
text-align: center;

}
a{
 text-decoration: none;
 
 
}
</style>
</head>
<body>
<% List<Student> students = (List)request.getAttribute("students"); %>

<table  align = "center" >
<tr>
<th>Id</th>
<th>Name</th>
<th>Password</th>
<th>Location</th>
<th>Phoneno</th>
<th>Email</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<% for(Student student:students){%>
<tr>
<td><%= student.getId() %></td>
<td><%= student.getName() %></td>
<td><%= student.getPassword() %></td>
<td><%= student.getLocation() %></td>
<td><%=student.getPhoneNo() %></td>
<td><%=student.getEmail() %></td>
<td><a href = "edit?id=<%=student.getId() %>">Edit</a></td>
<td><a href = "delete?id=<%=student.getId() %>">delete </a></td>
</tr>
<%} %>

</table>
<div id = "al">
<a href="logout"  > <button>Logout</button> </a>
</div>
</body>
</html>