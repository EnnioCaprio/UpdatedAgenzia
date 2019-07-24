<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout Cliente</title>
</head>
<body>
<h1>Logout effettuato.</h1>
<% session.invalidate(); %>
<a href="home.jsp">TORNA ALLA HOMEPAGE</a>
</body>
</html>