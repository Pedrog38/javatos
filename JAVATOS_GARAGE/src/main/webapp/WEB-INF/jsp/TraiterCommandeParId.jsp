<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 

<html>
<head>

<title>Traiter Commande N°<c:out value="${t.id}"/> </title>
</head>
<body>
		<h1> Traiter Commande N°<c:out value="${t.id}"/></h1>
		
		<table border="1">
		<thread>
			<tr>
				<th>Client:<c:out value="${t.client}"/> </th><br>
				<th>Date: <c:out value="${t.date}" /> </th>
			</tr>
		</thread>	
		</table>
		
		<table border="1">
		<thead>
			<tr>
				<th>Statut</th>
				<th>Modèle</th>
				<th>Quantité demandé</th>
				<th>Quantité à réserver</th>
				<th>Quantité à commander au fournisseur</th>
				<th>Stock</th>
			</tr>
		</thead>				
		
		<tbody>
			<c:forEach items="${listeTraiterCommande}" var="p">
			<tr>
				<td><c:out value="${t.statut}"/></td>
				<td><c:out value="${t.modele}"/></td>
				<td><c:out value="${t.quantiteDemande}"/></td>
				<td><c:out value="${t.quantiteReserver}"/></td>
				<td><c:out value="${t.quantiteAcommanderFournisseur}"/></td>
				<td><a href= "/validerCommande?id="<c:out value="${t.id}"/>Valider</a></td>			
		

			</tr>
			</c:forEach>
		</tbody>
	</table>
					
		
		<a href="ToutCommander"> Tout Commander</a>
		<a href="ToutReserver"> Tout Réserver</a>
		<a href="ValiderAutomatique"> Valider Automatique</a>
		

</body>
</html>





























