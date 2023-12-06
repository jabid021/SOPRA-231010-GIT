<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>Accueil</h1>

	<a href="home?id=2&prenom=toto">Vers HOME</a>
	


	<form action="home" method="post">
		<input type="hidden" name="id" value="2"/>
		<input type="text" name="prenom" value="toto"/>
		<input type="submit" value="Envoyer"/>
	</form>
</body>
</html>