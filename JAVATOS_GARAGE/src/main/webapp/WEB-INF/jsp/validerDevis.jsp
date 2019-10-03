<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 

<html>
<head>

<title>Devis à Valider</title>
</head>
<body>
		<h1> DEVIS A VALIDER</h1>
		
<form:form method="post" modelAttribute="listeDevisValiderForm" action="TraiterDevisAV">
			<table border="1">
		<thead>
			<tr>
				<th>Id Devis</th>				
				<th>Date de creation</th>
				<th>Client</th>			
				<th>Delai en jours</th>
				<th>Statut</th>
				<th>Prix total TTC en euro(s)</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${listeDevisValiderForm.listeDevisForm}" var="affDevisForm" varStatus="status" >
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
					<td><c:out value="${affDevisForm.prixTotalTTC}" />
					<form:input type="hidden" path="listeDevisForm[${status.index}].prixTotalTTC" value="${affDevisForm.prixTotalTTC}"/>
					</td> 
					<td><form:button type="submit" name="indexValider" value="${status.index}" >Valider</form:button></td>
					<td><form:button type="submit" name="indexVisualiser" value="${status.index}" >Visualiser</form:button></td>
					<td><form:button type="submit" name="indexAnnuler" value="${status.index}" >Annuler</form:button></td>
					
					
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</form:form>
	
	<input type="button" value="Retour" onclick="history.go(-1)"/>
			
	</body>
</html>		