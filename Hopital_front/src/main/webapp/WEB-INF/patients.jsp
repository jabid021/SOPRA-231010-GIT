<%--
<%@ page import="java.util.List" %>   
<%@ page import="hopital.model.Patient" %> 
--%>

 
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Liste des patients</title>
</head>
<body>


<h1>Page Patients</h1>




		<table class="table table-striped">
		
		<tr><th>Id</th><th>Nom</th><th>Prenom</th><th>Actions</th></tr>
		
		<c:choose>
			<c:when test="${patients.isEmpty()}">
				<tr><td align="center" colspan="4">AUCUN PATIENT</td></tr>
			</c:when>
		
			<c:otherwise>
				<c:forEach items="${patients}" var="patient">
					<tr>
						<td>${patient.id}</td>
						<td>${patient.nom}</td>
						<td>${patient.prenom} <c:if test="${patient.prenom=='Pierre'}"><img width="80" src="assets/img/canard.jpg"></c:if></td>
						<td>
							<a class="btn btn-warning" href="patient?id=${patient.id}">Modifier</a> 
							<a class="ml-1 btn btn-danger" href="patient?id=${patient.id}&delete">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			<%--
			List<Patient> patients = (List<Patient>)request.getAttribute("patients");
			for(Patient patient : patients)
			{
				out.println("<tr><td>"+patient.getId()+"</td><td>"+patient.getNom()+"</td><td>"+patient.getPrenom()+"</td><td><a class='btn btn-warning' href='patient?id="+patient.getId()+"'>Modifier</a> <a class='ml-1 btn btn-danger' href='patient?id="+patient.getId()+"&delete'>Supprimer</a></td></tr>");
			}
			--%>
			</c:otherwise>
		</c:choose>
		
		</table>


<form action="patient?insert" method="post">

	<input type="number" name="id" placeholder="Saisir votre id">
	<input type="text" name="prenom" placeholder="Saisir votre prenom">
	<input type="text" name="nom" placeholder="Saisir votre nom">

	<input type="submit" class='btn btn-success' value="Ajouter">
</form>
</body>
</html>