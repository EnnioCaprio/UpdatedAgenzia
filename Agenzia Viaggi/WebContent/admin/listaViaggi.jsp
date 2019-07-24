<%@page import="model.Viaggi"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.Dao.CrudViaggi"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista offerte viaggi</title>
</head>
<body>
	<%
		CrudViaggi cv = new CrudViaggi();
		Viaggi v = new Viaggi();
		ArrayList<Viaggi> lista = cv.listaViaggi(v);
	%>
	<table border="1" align="center">
		<tr>
			<td>ID VIAGGIO</td>
			<td>DESTINAZIONE</td>
			<td>PREZZO</td>
			<td>DISPONIBILITA'</td>
			<td>DATA INIZIO</td>
			<td>DATA FINE</td>
			<td>QUANTITA'</td>
		</tr>
		<%
			for(Viaggi l : lista) {
		%>

		<tr align="center">
			<td><%=l.getIdViaggio()%></td>
			<td><%=l.getDestinazione()%></td>
			<td><%=l.getPrezzo()%></td>
			<td><%=l.getDisponibilita()%></td>
			<td><%=l.getDataininzio()%></td>
			<td><%=l.getDatafine()%></td>
			<td><%=l.getQuantità()%></td>
		</tr>
		<%
			}
		%>
		</border>
	</table>
	<br>
	<form method="post" action="menuAdmin?y=2">
		<input type="text" name="idviaggio" list="list">
		<datalist id="list">
			<%
				for(Viaggi l : lista) {
			%>
			<option><%=l.getIdViaggio()%></option>
			<%
				}
			%>
		</datalist>
		<input type="submit" value="elimina">
	</form>
	<hr>
	<form method="post" action="menuAdmin?y=3">

		<input type="text" name="idviaggio" list="list2">
		<datalist id="list2">
			<%
				for(Viaggi l : lista) {
			%>
			<option><%= l.getIdViaggio()%></option>
			<%
				}
			%>
		</datalist>
		<input type="text" name="quantità">
		<br>
		<input type="submit" value="modifica">
	</form>
</body>
</html>