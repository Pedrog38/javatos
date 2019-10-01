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
			Client: <c:out value="${AfficherCommandeForm.nomClient }" />
			<form:input type="hidden" path="nomClient" value="${AfficherCommandeForm.nomClient}" />
			<br/>
				Date de création : <c:out value="${AfficherCommandeForm.commandeDate }" />
			<form:input type="hidden" path="commandeDate" value="${AfficherCommandeForm.commandeDate}" />
		</div>
<br/>
		<table border="1">
			<thead>
				<tr>
					<th>Id Ligne de commande</th>
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
						<c:out value="${c.idLigneCommande}" /> 
						<form:input type="hidden" path="listLigneCdForm[${status.index}].idLigneCommande" value="${c.idLigneCommande}" />
						</td>						
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
						<form:errors path="listLigneCdForm[${status.index}].qteACommanderOk" />
						<form:errors path="listLigneCdForm[${status.index}].qteReserveeOk" />
						<form:errors path="listLigneCdForm[${status.index}].qtesOk" />
						<form:errors path="listLigneCdForm[${status.index}].qtesNotNull" />
						
						
						</td>
						<td>
                    	<form:button type="submit" name="index" value="${status.index}" >Valider</form:button>
                    	</td>
                    	
                   
                   <form:input type="hidden" path="listLigneCdForm[${status.index}].idModel" value="${c.idModel}" />
                   <form:input type="hidden" path="listLigneCdForm[${status.index}].idLigneCommande" value="${c.idLigneCommande}" />
                    
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br/>
	<table border="1">
			<thead>
				<tr>
					<th>Id Ligne de Commande</th>
					<th>Statut</th>
					<th>Model</th>
					<th>Quantite demande</th>
					<th>Quantité reservée</th>
					<th>Quantité commandée</th>
				</tr>
			</thead>

			<tbody>

				<c:forEach items="${AfficherCommandeForm.listLigneCdFormNonModifiable}" var="c" varStatus="stat">
					<tr>
						<td>
						<c:out value="${c.idLigneCommande}" /> 
						<form:input type="hidden" path="listLigneCdFormNonModifiable[${stat.index}].idLigneCommande" value="${c.idLigneCommande}" />
						</td>						
						<td>
						<c:out value="${c.statut}" /> 
						<form:input type="hidden" path="listLigneCdFormNonModifiable[${stat.index}].statut" value="${c.statut}" />
						</td>
						<td>
						<c:out value="${c.nomModel}" /> 
						<form:input type="hidden" path="listLigneCdFormNonModifiable[${stat.index}].nomModel" value="${c.nomModel}" />
						</td>
						<td>
						<c:out value="${c.qteDemande}" /> 
						<form:input type="hidden" path="listLigneCdFormNonModifiable[${stat.index}].qteDemande" value="${c.qteDemande}" />
						</td>
						<td>
						<c:out value="${c.qteDejaReserve}" /> 
						<form:input type="hidden" path="listLigneCdFormNonModifiable[${stat.index}].qteDejaReserve" value="${c.qteDejaReserve}" />
						</td>
						<td>
						<c:out value="${c.qteDejaCommandee}" /> 
						<form:input type="hidden" path="listLigneCdFormNonModifiable[${stat.index}].qteDejaCommandee" value="${c.qteDejaCommandee}" />
						</td>
						
                   
                   <form:input type="hidden" path="listLigneCdFormNonModifiable[${stat.index}].idModel" value="${c.idModel}" />
                   
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</form:form>
		<br/>
	<input type="button" value="Retour" onclick="history.go(-1)" />


</body>
</html>