<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Traiter Commande</title>
</head>
<body>

	<form:form method="post" modelAttribute="AfficherCommandeForm"
		action="VisualiserLigneCommandeNouvelle">
		<h1>
			Traiter Commande n°
			<c:out value="${AfficherCommandeForm.idCommande }" />
			<form:input type="hidden" path="idCommande" value="${AfficherCommandeForm.idCommande}" />
		</h1>

		<div>
			<label>Client: ${AfficherCommandeForm.nomClient}</label><br> <label>
				Date de création : ${AfficherCommandeForm.commandeDate}</label><br>
		</div>

		<table border="1">
			<thead>
				<tr>
					<th>Statut</th>
					<th>Model</th>
					<th>Quantite demande</th>
					<th>Quantite disponible en stock</th>
					<th>Quantité à reserver</th>
					<th>Quantité à commander</th>
				</tr>
			</thead>

			<tbody>

				<c:forEach items="${AfficherCommandeForm.listLigneCdForm}" var="c" varStatus="status">
					<tr>
						<td>
						<c:out value="${c.statut}" /> 
						<form:input type="hidden" path="listLigneCdForm[${status.index}].statut" value="${c.statut}" />
						</td>
						<td>
						<c:out value="${c.nomModel}" /> 
						<form:input type="hidden" path="listLigneCdForm[${status.index}].nomModel" value="${c.nomModel}" />
						</td>
						<td>
						<c:out value="${c.qteDemande}" /> 
						<form:input type="hidden" path="listLigneCdForm[${status.index}].qteDemande" value="${c.qteDemande}" />
						</td>
						
						<td>
						<c:out value="${c.qteDispo}" /> 
						<form:input type="hidden" path="listLigneCdForm[${status.index}].qteDispo" value="${c.qteDispo}" />
						</td>
						<td>
						<form:input type="text" path="listLigneCdForm[${status.index}].qteAReserver" value="${c.qteAReserver}" />
						</td>
						<td>
						<form:input type="text" path="listLigneCdForm[${status.index}].qteACommander" value="${c.qteACommander}" />
						</td>
						<td>
                    	<form:button type="submit" name="index" value="${status.index}" >Valider</form:button>
                   
                   <form:input type="hidden" path="listLigneCdForm[${status.index}].idModel" value="${c.idModel}" />
                   <form:input type="hidden" path="listLigneCdForm[${status.index}].idLigneCommande" value="${c.idLigneCommande}" />
                    </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form:form>
	<input type="button" value="Retour" onclick="history.go(-1)" />


</body>
</html>