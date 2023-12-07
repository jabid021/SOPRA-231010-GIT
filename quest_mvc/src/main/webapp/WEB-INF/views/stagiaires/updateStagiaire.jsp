
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Modifier Stagiaire</title>
</head>
<body>




<div id="content">
  <h3>Modifier Stagiaire ${stagiaire.id}</h3>
  <form:form action="stagiaire" method="post" modelAttribute="stagiaire" >
  <form:errors path="*" cssClass="error" element="div"/>
  
  
  <br>

  <form:hidden path="version"/>
  <form:hidden path="id"/>
  <form:label path="nom">Nom : </form:label> <form:input path="nom" placeholder="Saisir votre nom" />
  <form:errors path="nom" cssClass="error"></form:errors>
  <br>
   <form:label path="prenom">Prenom : </form:label> <form:input path="prenom"  placeholder="Saisir votre prenom" />
    <form:errors path="prenom" cssClass="error"/>
   <br>
   <form:label path="email">Email : </form:label> <form:input path="email" type="email" placeholder="Saisir votre email" />
    <form:errors path="email" cssClass="error"><span class="error">CE MESSAGE A LA PLACE</span></form:errors>
   <br> 
  <!-- <form:input path="email" type="password" placeholder="Saisir votre password" /><br>--> 
 <!--<form:input path="id" type="number" placeholder="Saisir votre age" /><br>--> 
 <!--<form:input path="filiere.debut" value="${stagiaire.filiere.debut}" type="date" /><br>--> 

 	<form:label path="filiere.id">Filiere : </form:label>
 <form:select required="required" path="filiere.id">
 	<form:option value="">Choisir une filiere</form:option>
 	<form:options items="${filieres}" itemValue="id" itemLabel="labelSelect" />
 </form:select><br>
  
   <input class ="btn btn-warning" type="submit" value="Modifier"> 
   <a href="stagiaire"><input type="button" class ="btn btn-info" value="Retour"></a>
  
  
  </form:form>
  <!--<form action="stagiaire" method="post">
   <input type="hidden" name="version" value="${stagiaire.version}">
  	<input type="hidden" name="id" value="${stagiaire.id}">
  Nom :<input value="${stagiaire.nom}" name="nom" type="text" placeholder="Saisir votre nom"><br>
  Prenom :<input value="${stagiaire.prenom}" name="prenom" type="text" placeholder="Saisir votre prenm"><br>
  Email :<input value="${stagiaire.email}" name="email" type="email" placeholder="Saisir votre email"><br>
  Filiere
     <select name="filiere.id">
      <c:forEach items="${filieres}" var="filiere">
	      <c:choose>
		      	<c:when test="${stagiaire.filiere.id==filiere.id}">
		      	 	<option selected value="${filiere.id}" >${filiere.id} - ${filiere.libelle}</option>
		      	</c:when>
		      	
		      	<c:otherwise>
		      	 	<option value="${filiere.id}" >${filiere.id} - ${filiere.libelle}</option>
		      	</c:otherwise>
	      	</c:choose>
      	</c:forEach>
      </select><br>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="stagiaire"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
  -->
</div>


</body>
</html>