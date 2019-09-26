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


			<table border="1">
		<thead>
			<tr>
				<th>Id Devis</th>
				<th>Client</th>

				
				<th>Date de creation</th>
				<th>Statut</th>
				<th>Prix total en euro(s)</th>
				<th>Delai</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${mapDevis}" var="couple" >
				<tr>
					<td><c:out value="${couple.key.id}" /></td>
					<td><c:out value="${couple.key.client.nom} ${couple.key.client.prenom}" /></td>
<!-- 					Delai max à déterminer -->
<%-- 					<td><c:out value="${devis.delaifinal}" /></td> --%>


					<td><c:out value="${couple.key.dateCreation}" /></td>
					<td><c:out value="${couple.key.statut}" /></td>
					<td><c:out value="${couple.value}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<input type="button" value="Retour" onclick="history.go(-1)"/>
			
	</body>
</html>