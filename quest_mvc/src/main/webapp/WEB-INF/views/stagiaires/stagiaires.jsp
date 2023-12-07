
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des Stagiaires</title>
</head>
<body>



<div id="content">
  <h1>Liste des Stagiaires</h1>
  <input id="btnAddStagiaire" type="button" class ="btn btn-success" value="Ajouter">
  <a href="index.html"><input type="button" class ="btn btn-info" value="Retour"></a>

  <table class="table table-striped">
    <thead>
      <tr>
        <th>Id</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Email</th>
        <th>Filiere</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${stagiaires}" var="stagiaire">
	    <tr>
	        <td>${stagiaire.id}</td>
	        <td>${stagiaire.nom}</td>
	        <td>${stagiaire.prenom}</td>
	        <td>${stagiaire.email}</td>
	        <td>${stagiaire.filiere.id} - ${stagiaire.filiere.libelle}</td>
	        <td>
	          <a href="stagiaire/${stagiaire.id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
	          <a href="stagiaire/delete/${stagiaire.id}"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
	        </td>
	      </tr>
    
    </c:forEach>
    
	 </tbody>
</table>
  <div id="addFormStagiaire" class="formAjout">
    <h3>Ajouter Stagiaire</h3>
    <form:form action="stagiaire" method="post" modelAttribute="stagiaire" >
   
  <form:hidden path="version"/>
  <form:hidden path="id"/>
  <form:label path="nom">Nom : </form:label> <form:input path="nom" placeholder="Saisir votre nom" /><br>
   <form:label path="prenom">Prenom : </form:label> <form:input path="prenom"  placeholder="Saisir votre prenom" /><br>
   <form:label path="email">Email : </form:label> <form:input path="email" type="email" placeholder="Saisir votre email" /><br> 
	<form:label path="filiere.id">Filiere : </form:label>
 <form:select required="required" path="filiere.id">
 	<form:option value="">Choisir une filiere</form:option>
 	<form:options items="${filieres}" itemValue="id" itemLabel="labelSelect" />
 </form:select><br>
  
   <input class ="btn btn-warning" type="submit" value="Ajouter"> 
   </form:form>
  </div>

</div>

</body>
</html>



<script>

  btnAddStagiaire.onclick=function()
  {
    addFormStagiaire.style.display="block";
  }

</script>
