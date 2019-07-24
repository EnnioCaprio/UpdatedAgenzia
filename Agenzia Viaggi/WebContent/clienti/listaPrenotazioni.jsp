<%@page import="java.util.ArrayList"%>
<%@page import="model.Viaggi"%>
<%@page import="model.Prenotazioni"%>
<%@page import="java.util.List"%>
<%@page import="model.Dao.CrudPrenotazioni"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<% 
	CrudPrenotazioni cr = new CrudPrenotazioni();
	Prenotazioni p = new Prenotazioni();
	Viaggi v = new Viaggi();
	ArrayList<Prenotazioni> list = cr.listaPrenotazioni();
%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table align="center" border="1">
		<tr align="center" border="1">
			<td>ID PRENOTAZIONE</td>
			<td>DESTINAZIONE</td>
			<td>DATA INIZIO</td>
			<td>DATA FINE</td>
			<td>PREZZO</td>
			<td>QUANTITA PERSONE</td>
		</tr>
		<% for(Prenotazioni l : list){ %>
		<tr>
			<td><%= l.getIdPrenotazioni() %></td>
			<td><%= l.getViaggi().getDestinazione() %></td>
			<td><%= l.getViaggi().getDataininzio() %></td>
			<td><%= l.getViaggi().getDatafine() %></td>
			<td><%= l.getPrezzototale() %></td>
			<td><%= l.getQuantitapersone() %></td>
		</tr>
		<% } %>
	</table>
	<form action="menuCliente?y=3"method= "post">
	<input type="text" name ="idprenotazione" list ="list">
	<datalist id="list" >
	<% for(Prenotazioni l : list){ %>
	<option><%= l.getIdPrenotazioni() %></option>
	<% } %>
	</datalist>
	<input type="submit" value="ELIMINA PRENOTAZIONE">
	
</body>
</html>