<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Affichage de la liste des modèles</title>
</head>
<body>
	<h1>Liste des modèles</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Nom du modèle</th>
				<th>Puissance</th>
				<th>Prix de Vente</th>
				<th>Couleur</th>
				<th>Délai de Production</th>
				</tr>
		</thead>
		<tbody>
			<c:forEach items="${listemodel}" var="model">
				<tr>
					<td><c:out value="${model.nom}" /></td>
					<td><c:out value="${model.puissance}" /></td>
					<td><c:out value="${model.prixVente}" /></td>
					<td><c:out value="${model.couleur}" /></td>
					<td><c:out value="${model.delaisProd}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="button" value="Retour" onclick="history.go(-1)"/><br>
</body>
</html>