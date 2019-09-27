<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Detail commande</title>
	
	</head>

	<body>
			

			<h1>DETAIL COMMANDE ID: ${commande.id}</h1>

			<div>
				<p>account: <c:out value="${utilisateur.nom}  ${utilisateur.prenom} - ${utilisateur.fonction}" /> </p>
			</div>

			<div>
				<!--Infos relatives à la commande choisie-->
				<label>Client: ${commande.client.nom} </label>
				<label>Date: ${commande.date_creation} </label>
			</div>





			<table border="1">
		<thead>
			<tr>
				<th>Modèle</th>
				<th>Quantité</th>
				<th>Délai de production</th>
				<th>Prix HT</th>
			</tr>
		</thead>

		<tbody>
			<!--Pour afficher toutes les lignes d'une commande selectionnée via son id-->
			<c:forEach items="${listeLigneParCommande}" var="commande">
				<tr>
					<td><c:out value="${ligneCommande.modele}" /></td>
					<td><c:out value="${ligneCommande.quantite}" /></td>
					<td><c:out value="${ligneCommande.delaiProduction}" /></td>
					<td><c:out value="${ligneCommande.prix}" /></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<input type="button" value="Retour" onclick="history.go(-1)"/>
			
	</body>
</html>