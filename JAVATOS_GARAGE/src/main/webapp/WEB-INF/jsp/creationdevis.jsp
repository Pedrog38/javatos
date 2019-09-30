<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Affichage des stocks de la concession Javatos Garage</title>
</head>
<body>
	<h1>Nouveau Devis</h1>
	<form:form method="post" modelAttribute="creationDevis"
		action="creerDevis">
		
		<c:url value="/${fonction}/creerClientAfficher" var="url" />
		<a href="${url}">Créer nouveau client</a>
		<p><a href="/${fonction}/creerModeleAfficher">Créer nouveau modèle</a></p>
		<p>
		<form:label path="idClient" >Choix du client :</form:label>
		<form:select path="idClient">
			<c:forEach items="${clients}" var="client">
				<form:option value="${client.id}" label="${client.prenom} ${client.nom}" />
			</c:forEach>
		</form:select>
		</p>
		<p>
		<form:label path="DateDevis">Date du devis :</form:label>
		<form:input path="DateDevis" type="date" max="${DateDevis}" />
		</p>

		<table border="1">
				<thead>
					<tr>
						<th>Modèle || Délais de production || Prix de vente HT</th>
						<th>Quantité</th>
						<th>Bt</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${creationDevis.lignedevis}" var="vlignedevis" varStatus="status"> 
					<tr>
						<td>
							<form:select path="lignedevis[${status.index}].idModel">
								<c:forEach items="${models}" var="model">
									<form:option  value="${model.id}" label=" Modèle : ${model.nom} || Délais de production : ${model.delaisProd} jours || Prix de Vente HT : ${model.prixVente} euros" />
								</c:forEach>
							</form:select>
						</td>
						<td>
							<form:input path="lignedevis[${status.index}].quantite"/>
						</td>
						<td> <form:button name="submit" value="add" > ADD</form:button> </td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<form:button name="submit" value="valid" > Valider </form:button>
			
	</form:form>
	<input type="button" value="Retour" onclick="history.go(-1)"/><br>
</body>
</html>