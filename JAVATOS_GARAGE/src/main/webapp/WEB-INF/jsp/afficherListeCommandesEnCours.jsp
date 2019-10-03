<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Liste commandes en cours</title>
	
	</head>

	<body>

			<h1>AFFICHER LISTE DES COMMANDES EN COURS</h1>

<form:form method="post" modelAttribute="ListeAfficherCommandeForm" action="VisualiserCommande">
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
			<c:forEach items="${ListeAfficherCommandeForm.listCommandeFormPretes}" var="affCommandeForm" varStatus="status" >
				<tr>
					<td><c:out value="${affCommandeForm.idCommande}" />
                      <form:input type="hidden" path="listCommandeFormPretes[${status.index}].idCommande" value="${affCommandeForm.idCommande}"/>
                      </td>
					<td><c:out value="${affCommandeForm.commandeDate}" />
					<form:input type="hidden" path="listCommandeFormPretes[${status.index}].commandeDate" value="${affCommandeForm.commandeDate}"/>
					</td>
					<td><c:out value="${affCommandeForm.nomClient}" />
					<form:input type="hidden" path="listCommandeFormPretes[${status.index}].nomClient" value="${affCommandeForm.nomClient}"/>
					</td>
 					<td><c:out value="${affCommandeForm.delaiCommande}" />
 					<form:input type="hidden" path="listCommandeFormPretes[${status.index}].delaiCommande" value="${affCommandeForm.delaiCommande}"/>
 					</td> 
					<td><c:out value="${affCommandeForm.statutCommande}" />
					<form:input type="hidden" path="listCommandeFormPretes[${status.index}].statutCommande" value="${affCommandeForm.statutCommande}"/>
					</td>
					<td><c:out value="${affCommandeForm.prixTotalTTC}" />
					<form:input type="hidden" path="listCommandeFormPretes[${status.index}].prixTotalTTC" value="${affCommandeForm.prixTotalTTC}"/>
					</td> 
					
					<td><form:button type="submit" name="indexVisualisePrete" value="${status.index}" >Visualiser</form:button></td>
					<td><form:button type="submit" name="indexLivrerPrete" value="${status.index}" >Livrer</form:button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
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
			<c:forEach items="${ListeAfficherCommandeForm.listCommandeFormEnTraitement}" var="affCommandeForm" varStatus="status" >
				<tr>
					<td><c:out value="${affCommandeForm.idCommande}" />
                      <form:input type="hidden" path="listCommandeFormEnTraitement[${status.index}].idCommande" value="${affCommandeForm.idCommande}"/>
                      </td>
					<td><c:out value="${affCommandeForm.commandeDate}" />
					<form:input type="hidden" path="listCommandeFormEnTraitement[${status.index}].commandeDate" value="${affCommandeForm.commandeDate}"/>
					</td>
					<td><c:out value="${affCommandeForm.nomClient}" />
					<form:input type="hidden" path="listCommandeFormEnTraitement[${status.index}].nomClient" value="${affCommandeForm.nomClient}"/>
					</td>
 					<td><c:out value="${affCommandeForm.delaiCommande}" />
 					<form:input type="hidden" path="listCommandeFormEnTraitement[${status.index}].delaiCommande" value="${affCommandeForm.delaiCommande}"/>
 					</td> 
					<td><c:out value="${affCommandeForm.statutCommande}" />
					<form:input type="hidden" path="listCommandeFormEnTraitement[${status.index}].statutCommande" value="${affCommandeForm.statutCommande}"/>
					</td>
					<td><c:out value="${affCommandeForm.prixTotalTTC}" />
					<form:input type="hidden" path="listCommandeFormEnTraitement[${status.index}].prixTotalTTC" value="${affCommandeForm.prixTotalTTC}"/>
					</td> 
					<td><form:button type="submit" name="indexVisualiseEnTraitement" value="${status.index}" >Visualiser</form:button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</form:form>
	
	<input type="button" value="Retour" onclick="history.go(-1)"/>
			
	</body>
</html>