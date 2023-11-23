<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.List" %>   
  <%@ page import="hopital.model.Patient" %> 
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<link  href="style.css" rel="stylesheet" >

<meta charset="UTF-8">
<title>Liste des patients</title>
</head>
<body>

<h1>Page Patients</h1>

		<table class="table table-striped">
		<tr><th>Id</th><th>Nom</th><th>Prenom</th><th>Actions</th></tr>
		
		<%
		List<Patient> patients = (List<Patient>)request.getAttribute("patients");
		for(Patient patient : patients)
		{
			out.println("<tr><td>"+patient.getId()+"</td><td>"+patient.getNom()+"</td><td>"+patient.getPrenom()+"</td><td><a class='btn btn-warning' href='patient?id="+patient.getId()+"'>Modifier</a> <a class='ml-1 btn btn-danger' href='patient?id="+patient.getId()+"&delete'>Supprimer</a></td></tr>");
		}
		%>
		
		</table>


<form action="patient?insert" method="post">

	<input type="number" name="id" placeholder="Saisir votre id">
	<input type="text" name="prenom" placeholder="Saisir votre prenom">
	<input type="text" name="nom" placeholder="Saisir votre nom">

	<input type="submit" class='btn btn-success' value="Ajouter">
</form>
</body>
</html>