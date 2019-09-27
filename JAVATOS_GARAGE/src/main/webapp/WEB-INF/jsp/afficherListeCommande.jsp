<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">    

<html>
<head>
<title> Liste Commande </title>
</head>
<body>	
		<h1> LISTE COMMANDE (Affichage/ Archive) </h1>
		<table border="1">
		<!--  Entête de ma table  -->
		 <thead>
			<tr>
				<th>Id Commande</th>
				<th>Client</th>
				<th>Date de création</th>
				<th>Date de livraison</th>
				<th>Id Devis </th>
				<th>Prix Total</th>
				<th>Statut</th>
			</tr>
			</thead>
			<tbody>
			<!--  Corps de ma table  n ligne avec au tant de cellule (td) que l'entête -->
				<c:forEach items="${listeCommande}" var="p">
				<tr>
					<td><c:out value="${c.idCommande}" /></td>
					<td><c:out value="${c.client}"/></td>
					<td><c:out value="${c.dateDeCreation}"/></td>
					<td><c:out value="${c.dateDeLivraison}"/></td>
					<td><c:out value="${c.idDevis}"/></td>
					<td><c:out value="${c.prixTotal}"/></td>
					<td><c:out value="${c.statut}"/></td>
					<td><a href= "/visualiserCommande?id="><c:out value="${c.idCommande}">Visualiser</c:out></a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>