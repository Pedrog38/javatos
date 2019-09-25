<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Liste des devis</title>
	
	</head>

	<body>
			

			<h1>AFFICHER LISTE DES DEVIS</h1>

			<div>
				<p>account: <c:out value="${utilisateur.nom}  ${utilisateur.prenom} - ${utilisateur.fonction}" /> </p>
			</div>

			<table border="1">
		<thead>
			<tr>
				<th>Id Devis</th>
				<th>Client</th>
				<th>Delai</th>
				<th>Prix total en euro(s)</th>
				<th>Date de création</th>
				<th>Statut</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${listeDevis}" var="devis">
				<tr>
					<td><c:out value="${devis.id}" /></td>
					<td><c:out value="${devis.client.nom}" /></td>
					<!--Delai max à déterminer-->
					<td><c:out value="${devis.delaifinal}" /></td>
					<!--Prix total à déterminer-->
					<td><c:out value="${devis.prixtotal}" /></td>
					<td><c:out value="${devis.dateCreation}" /></td>
					<td><c:out value="${devis.statut}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<input type="button" value="Retour" onclick="history.go(-1)"/>
			
	</body>
</html>