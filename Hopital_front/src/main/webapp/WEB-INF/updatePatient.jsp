<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier Patient</title>
</head>
<body>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<link  href="style.css" rel="stylesheet" >


<h1>Modifier la fiche du patient ${patient.id}</h1>
 	
<form action="patient" method="post">

	<input type="hidden" name="id" value="${patient.id}">
	<input type="text" name="prenom" value="${patient.prenom}" placeholder="Saisir votre prenom">
	<input type="text" name="nom" value="${patient.nom}" placeholder="Saisir votre nom">

	<input type="submit"  class="btn btn-info" value="Modifier">
</form>

<a class="btn btn-primary" href="patient">Retour au tableau</a>
</body>
</html>