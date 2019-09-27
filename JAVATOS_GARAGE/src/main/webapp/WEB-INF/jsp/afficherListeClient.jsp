<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Affichage de la liste client</title>
</head>
<body>
	<h1>Liste des clients</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Statut</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Sexe</th>
				<th>Téléphone</th>
				<th>E-mail</th>
				<th>Adresse</th>
				<th>Date de création</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listeclient}" var="client">
				<tr>
					<td><c:out value="${client.statut.nom}" /></td>
					<td><c:out value="${client.nom}" /></td>
					<td><c:out value="${client.prenom}" /></td>
					<td><c:out value="${client.sexe}" /></td>
					<td><c:out value="${client.telephone}" /></td>
					<td><c:out value="${client.mail}" /></td>
					<td><c:out value="${client.adresse}" /></td>
					<td><c:out value="${client.dateCreation}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>