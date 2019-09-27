<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Liste des devis</title>
	
	</head>
	<body>
			<h1>AFFICHER LISTE DES DEVIS</h1>

<form:form method="post" modelAttribute="ListeAfficherDevisForm" action="VisualiserListeDevis">
			<table border="1">
		<thead>
			<tr>
				<th>Id Devis</th>				
				<th>Date de creation</th>
				<th>Client</th>			
				<th>Delai en jours</th>
				<th>Statut</th>
				<th>Prix total en euro(s)</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${ListeAfficherDevisForm.listeDevisForm}" var="affDevisForm" varStatus="status" >
				<tr>
					<td><c:out value="${affDevisForm.idDevis}" />
                      <form:input type="hidden" path="listeDevisForm[${status.index}].idDevis" value="${affDevisForm.idDevis}"/>
                      </td>
					<td><c:out value="${affDevisForm.dateDeCreation}" />
					<form:input type="hidden" path="listeDevisForm[${status.index}].dateDeCreation" value="${affDevisForm.dateDeCreation}"/>
					</td>
					<td><c:out value="${affDevisForm.nomClient}" />
					<form:input type="hidden" path="listeDevisForm[${status.index}].nomClient" value="${affDevisForm.nomClient}"/>
					</td>
 					<td><c:out value="${affDevisForm.delai}" />
 					<form:input type="hidden" path="listeDevisForm[${status.index}].delai" value="${affDevisForm.delai}"/>
 					</td> 
					<td><c:out value="${affDevisForm.statut}" />
					<form:input type="hidden" path="listeDevisForm[${status.index}].statut" value="${affDevisForm.statut}"/>
					</td>
					<td><c:out value="${affDevisForm.prixTotal}" />
					<form:input type="hidden" path="listeDevisForm[${status.index}].prixTotal" value="${affDevisForm.prixTotal}"/>
					</td> 
					
					<td><form:button type="submit" name="index" value="${status.index}" >Visualiser</form:button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</form:form>
	
	<input type="button" value="Retour" onclick="history.go(-1)"/>
			
	</body>
</html>