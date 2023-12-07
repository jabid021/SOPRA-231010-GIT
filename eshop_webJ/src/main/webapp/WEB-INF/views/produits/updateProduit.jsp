<html>
<head>

<title>Fiche Produit ${produit.id}</title>
</head>
<body>
	<div id="content">

		<h3>Modifier Produit ${produit.id}</h3>
		<form:form action="produit/${produit.id}" method="post" modelAttribute="produit">
		<form:hidden path="id"/>
		<table>
				<tr>
					<td><form:label path="libelle">Libelle :</form:label></td>
					<td><form:input required="required" path="libelle" placeholder="Saisir votre libelle"/><form:errors cssClass="error" path="libelle"/></td>
				</tr>
				<tr>
					<td><form:label path="prix">Prix :</form:label></td>
					<td><form:input required="required" path="prix" type="number" placeholder="Saisir prix" step="0.01"/><form:errors cssClass="error" path="prix"/></td>
				</tr>
				<tr>
					<td><form:label path="fournisseur.id">Fournisseur :</form:label></td>
					<td><form:select required="required" path="fournisseur.id">
							<form:option value="">Choisir un fournisseur</form:option>
							<form:options items="${fournisseurs}" itemValue="id" itemLabel="infos"/>
					</form:select></td>
				</tr>
			</table>
		<input class="btn btn-warning" type="submit" value="Modifier">
			<a href="produit"><input type="button" class="btn btn-info"
				value="Retour"></a>
		</form:form>
		


			
		
	</div>
</body>
</html>
