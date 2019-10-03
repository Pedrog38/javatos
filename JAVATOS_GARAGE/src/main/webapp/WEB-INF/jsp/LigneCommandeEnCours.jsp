<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">    

<html>
<head>
<title> Liste Commande en Cours </title>
</head>
<body>	
		<h1> LISTE COMMANDE EN COURS <c:out value="${AfficherLigneCommandeECForm.idCommande }"/> </h1>
		
		<div>
			<label>Client: ${AfficherCommandeECForm.nomClient}</label><br>
			<label> Date de création : ${AfficherCommandeECForm.commandeDate}</label><br>	
		</div> 
		
		<table border="1">
		 <thead>
			<tr>
				<th>Model</th>
				<th>Quantite </th>
				<th>Delai de production (jour)</th>
				<th>Prix HT</th>
			</tr>
		</thead>
		
			<tbody>
			
				<c:forEach items="${AfficherCommandeECForm.listLigneCdForm}" var="c">
				<tr>
					<td><c:out value="${c.nomModel}" /></td>
					<td><c:out value="${c.quantite}"/></td>
					<td><c:out value="${c.delai}"/></td>
					<td><c:out value="${c.prixHT}"/></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
				<label> Délai Total: ${AfficherCommandeECForm.delaiCommande} jours </label><br>
				<label> Tarif HT:  ${AfficherCommandeECForm.prixTotal} euros </label><br>
			</div>
		<input type="button" value="Retour" onclick="history.go(-1)"/>
		
	
</body>
</html>