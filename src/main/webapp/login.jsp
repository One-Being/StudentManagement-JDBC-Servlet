<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String name =(String)request.getAttribute("name"); %>
<%String message =(String)request.getAttribute("message"); %>
<%if(name!=null ){ %>
<h1>hello<%= name %></h1>
<% } %>
<% if(message!= null){ %>
<h1><%= message %></h1>
<% } %>

<form action="login" method = "post">
name:<input type ="text" name ="name"><br>
password:<input type ="password" name ="password"><br>
Submit:<input type="submit">
</form>

</body>
</html>