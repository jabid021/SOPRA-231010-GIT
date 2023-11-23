<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier Patient</title>
</head>
<body>

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