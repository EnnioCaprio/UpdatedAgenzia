<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Cliente</title>
</head>
<body>
	<h1>Login effettuato. Benvenuto <font color="red"><%= session.getAttribute("username")%></font></h1>
	<table> 
	<tr><td><a href="menuCliente?x=1">INFO PERSONALI CLIENTE</a></td></tr>
	<tr><td><a href="menuCliente?x=2">LOGOUT</a></td></tr>
	<tr><td><a href="menuCliente?x=3">PRENOTAZIONE VIAGGI</a></td></tr>
	<tr><td><a href="menuCliente?x=4">LISTA PRENOTAZIONI EFFETTUATE</a></td></tr>
</table>
</body>
</html>