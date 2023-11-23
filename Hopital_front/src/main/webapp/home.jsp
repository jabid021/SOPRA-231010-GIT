<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<link  href="style.css" rel="stylesheet" >
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>

<h1>Bienvenue sur l'appli Hopital</h1>

<form action="home" method="POST">

	<input type="text" name="login" placeholder="Saisir votre login">
	<input type="password" name="password" placeholder="Saisir votre password">
	<input type="submit" value="Se connecter">
		<div class="error">${error}</div>
</form>



</body>
</html>