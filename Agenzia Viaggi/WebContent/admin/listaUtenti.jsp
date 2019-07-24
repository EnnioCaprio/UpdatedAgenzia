<%@page import="model.Clienti"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Dao.CrudAmministratore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		CrudAmministratore cc = new CrudAmministratore();
		Clienti c = new Clienti();
		ArrayList<Clienti> lista = cc.leggiUtenti(c);
	%>
	<table border="1" align="center">
		<tr>
			<td>ID CLIENTE</td>
			<td>USERNAME</td>
			<%
				for(Clienti l : lista){
			%>
		</tr>
		<tr align="center">
			<td><%=l.getIdCliente()%></td>
			<td><%=l.getUsername()%></td>
		</tr>
		<%
			}
		%>
		</border>
	</table>
	<br>
	<form method="post" action="MenuAdmin?y=1">
		<input type ="text" name="idcliente" list="list">
		<datalist id="list"> 
		<% for(Clienti l : lista){ %>
			<option><%= l.getIdCliente() %></option>
		<% } %>
		</datalist>	
		<input type="submit" value="elimina">	
	</form>
</body>
</html>