<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Liste commandes en cours</title>
	
	</head>

	<body>

			<h1>AFFICHER LISTE DES COMMANDES EN COURS</h1>

			<div>
				<p>account: <c:out value="${utilisateur.nom}  ${utilisateur.prenom} - ${utilisateur.fonction}" /> </p>
			</div>

			<table border="1">
		<thead>
			<tr>
				<th>Id Commande</th>
				<th>Client</th>
				<th>Date de creation</th>
				<th>Prix HT</th>
				<th>Statut</th>
				<th></th>
				<th></th>
			</tr>
		</thead>

		<tbody>
			<!--Afficher la liste des commandes comportant le statut "en cours"-->
			<c:forEach items="${listeCommandeEnCours}" var="commande">
				<tr>
					<td><c:out value="${commande.id}" /></td>
					<td><c:out value="${commande.client.nom}" /></td>
					<td><c:out value="${commande.dateCreation}" /></td>
					<!--Prix total de la commande à déterminer, le prix d'une ligne de commande est disponible dans modele-->
					<td><c:out value="${commande.lignecommande.model.prixVente}" /></td>
					<td><c:out value="${commande.statut}" /></td>
					<td><input type="button" value="Visualiser"></td>
					<td><input type="button" value="Livrer"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<input type="button" value="Retour" onclick="history.go(-1)"/>
			
	</body>
</html>