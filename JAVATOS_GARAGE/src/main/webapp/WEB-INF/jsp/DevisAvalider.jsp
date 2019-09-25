<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 

<html>
<head>

<title>Devis à Valider</title>
</head>
<body>
		<h1> DEVIS A VALIDER</h1>
		<table border="1">
		<thead>
			<tr>
				<th>id Devis</th>
				<th>Client</th>
				<th>Date de création</th>   
				<th>Prix HT</th>
			</tr>
		</thead>				
		
		<tbody>
			<c:forEach items="${listeDevisValiderForm}" var="devisForm">
			<tr>
				<td><c:out value="${devisForm.devis.id}"/></td>
				<td><c:out value="${devisForm.devis.client.nom}"/></td>
				<td><c:out value="${devisForm.devis.dateCreation}"/></td>
				<td><c:out value="${devisForm.prixDevis}"/></td>
				<td><a href= "/validerDevis?id="><c:out value="${devisForm.devis.id}"/>Valider</a></td>			
				<td><a href= "/visualiserDevis?id="><c:out value="${devisForm.devis.id}"/>Visualiser</a></td>
				<td><a href= "/annulerDevis?id="><c:out value="${devisForm.devis.id}"/>Annuler</a></td>
				
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>