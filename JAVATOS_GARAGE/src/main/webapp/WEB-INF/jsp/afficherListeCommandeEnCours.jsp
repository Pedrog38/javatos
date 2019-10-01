<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Liste commandes en cours</title>
	
	</head>
	<body>
			<h1>AFFICHER LISTE DES COMMANDES EN COURS</h1>
		<form:form method="post" modelAttribute="ListeAfficherCommandeECForm" action="VisualiserListeCommandeEC">
			<table border="1">
		<thead>
			<tr>
				<th>Id Commande</th>
				<th>Client</th>
				<th>Date de creation</th>
				<th>Prix HT</th>
				<th>Statut</th>
			</tr>
		</thead>

		<tbody>
			<!--Afficher la liste des commandes comportant le statut "en cours"-->
			<c:forEach items="${listeCommandeEnCours}" var="commande">
				<tr>
					<td><c:out value="${commande.id}" /></td>
					<td><c:out value="${commande.client.nom}" /></td>
					<td><c:out value="${commande.dateCreation}" /></td>
					<td><c:out value="${commande.lignecommande.model.prixVente}" /></td>
					<td><c:out value="${commande.statut}" /></td>
					<td><form:button type="submit" name="indexVisualiser" value="${status.index}" >Visualiser</form:button></td>
					<td><form:button type="submit" name="indexLivrerClient" value="${status.index}" >Livrer Client</form:button></td>
	
				</tr>
			</c:forEach>
		</tbody>
	</table>
</form:form>
	
	<input type="button" value="Retour" onclick="history.go(-1)"/>
			
	</body>
</html>