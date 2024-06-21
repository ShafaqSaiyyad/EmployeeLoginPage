<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER REGISTRATION FROM</title>
<style>
	body{
		text-align: center;
	}
</style>
</head>
<body>
	<%
		String msg = (String)request.getAttribute("msg");
		out.println(msg);
	%>
	<a href="index.html">HOMEPAGE</a>
</body>
</html>