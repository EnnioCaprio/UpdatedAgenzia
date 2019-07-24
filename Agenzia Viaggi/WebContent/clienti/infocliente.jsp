<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Informazioni personali</title>
</head>
<body>
	<h1>
		Pagina personale
		<%=session.getAttribute("username")%></h1>
	<table>
		<tr>
			<td>Id:</td>
			<td>Nome:</td>
			<td>Cognome:</td>
			<td>Telefono:</td>
			<td>Username:</td>
		</tr>
		<tr>
			<td><%= session.getAttribute("idCliente") %></td>
			<td><%= session.getAttribute("nomeCliente") %></td>
			<td><%= session.getAttribute("cognomeCliente") %></td>
			<td><%= session.getAttribute("telefono") %></td>
			<td><%= session.getAttribute("username") %></td>
		</tr>
	</table>
	
	<form action="menuCliente?y=1" method="post">
		<label>Id:</label><input type="text" name="idCliente" value="<%= session.getAttribute("idCliente") %>"><br>
		<label>Nome:</label><input type="text" name="nomeCliente" value="<%= session.getAttribute("nomeCliente") %>"><br>
		<label>Cognome:</label><input type="text" name="cognomeCliente" value="<%= session.getAttribute("cognomeCliente") %>"><br>
		<label>Telefono:</label><input type="text" name="telefono" value="<%= session.getAttribute("telefono") %>"><br>
		<label>Username:</label><input type="text" name="username" value="<%= session.getAttribute("username") %>"><br>
		<label>Password:</label><input type="text" name="password" value="<%= session.getAttribute("password") %>"><br>
		<input type="submit" value="modifica">
	</form>
</body>
</html>