<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTRAZIONE</title>
</head>
<body>
<form action="loginCliente?y=2" method="post">
	<table>
	<tr><td>NOME<input type="text"name="nome" required></td></tr>
	<tr><td>COGNOME<input type="text"name="cognome" required></td></tr>
	<tr><td>TELEFONO<input type="text"name="telefono" required></td></tr>
	<tr><td>USERNAME<input type="text"name="username" required></td></tr>
	<tr><td>PASSWORD<input type="password"name="password" required></td></tr>
	</table>
	<input type ="submit" value = "conferma" >
</form>
</body>
</html>