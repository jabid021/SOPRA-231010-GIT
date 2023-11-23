<!DOCTYPE html>
<html>
<head>

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