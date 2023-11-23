<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.List" %>   
  <%@ page import="hopital.model.Patient" %>  
   <%@ page import="hopital.dao.jdbc.DAOPatientJDBC" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Page Patients</h1>

		<table border>
		<tr><th>Id</th><th>Nom</th><th>Prenom</th></tr>
		
		<%
		DAOPatientJDBC daoPatient = new DAOPatientJDBC();
		List<Patient> patients =  daoPatient.findAll();
		
		for(Patient p : patients) 
		{
			out.println("<tr><td>"+p.getId()+"</td><td>"+p.getNom()+"</td><td>"+p.getPrenom()+"</td></tr>");
		}

		
		%>
		
		</table>
		<form action='demo' method='post'>
		<input type='number' name='id' placeholder='Saisir id'>
		<input type='text' name='nom' placeholder='Saisir nom'>
		<input type='text' name='prenom' placeholder='Saisir prenom'>
		<input type='submit' value='GO'>
		</form>
		</body>
		</html>



</body>
</html>