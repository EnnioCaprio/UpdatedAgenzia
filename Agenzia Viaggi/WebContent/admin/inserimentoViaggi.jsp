<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento viaggio</title>
</head>
<body>
<form method="post" action="menuAdmin?y=1">
<p><font size="25" color="black">Inserisci un pacchetto di viaggio</font></p>
<br>
<label>Destinazione:</label>  <input type="text" name="destinazione">
<br>
<label>Prezzo:</label>  <input type="text" name="prezzo">
<br>
<label>Data Inizio:</label>  <input type="text" name="datainizio">
<br>
<label>Data Fine:</label>  <input type="text" name="datafine">
<br>
<label>Quantità:</label> <input type="text" name="quantità">
<br>
<input type="submit" value="inserisci">
</form>
</body>
</html>