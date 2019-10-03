<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Liste des commandes</title>
	
	</head>
	<body>
			<h1>AFFICHER LISTE DES COMMANDES</h1>

<form:form method="post" modelAttribute="ListeAfficherCommandeForm" action="VisualiserListeCommande">
			<table border="1">
		<thead>
			<tr>
				<th>Id Commande</th>				
				<th>Date de creation</th>
				<th>Client</th>			
				<th>Delai en jours</th>
				<th>Statut</th>
				<th>Prix total TTC en euro(s)</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${ListeAfficherCommandeForm.listeCommandeForm}" var="affCommandeForm" varStatus="status" >
				<tr>
					<td><c:out value="${affCommandeForm.idCommande}" />
                      <form:input type="hidden" path="listeCommandeForm[${status.index}].idCommande" value="${affCommandeForm.idCommande}"/>
                      </td>
					<td><c:out value="${affCommandeForm.commandeDate}" />
					<form:input type="hidden" path="listeCommandeForm[${status.index}].commandeDate" value="${affCommandeForm.commandeDate}"/>
					</td>
					<td><c:out value="${affCommandeForm.nomClient}" />
					<form:input type="hidden" path="listeCommandeForm[${status.index}].nomClient" value="${affCommandeForm.nomClient}"/>
					</td>
 					<td><c:out value="${affCommandeForm.delaiCommande}" />
 					<form:input type="hidden" path="listeCommandeForm[${status.index}].delaiCommande" value="${affCommandeForm.delaiCommande}"/>
 					</td> 
					<td><c:out value="${affCommandeForm.statutCommande}" />
					<form:input type="hidden" path="listeCommandeForm[${status.index}].statutCommande" value="${affCommandeForm.statutCommande}"/>
					</td>
					<td><c:out value="${affCommandeForm.prixTotalTTC}" />
					<form:input type="hidden" path="listeCommandeForm[${status.index}].prixTotalTTC" value="${affCommandeForm.prixTotalTTC}"/>
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