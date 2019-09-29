<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">    

<html>
<head>
<title> Liste Commande </title>
</head>
<body>	
		<h1> LISTE COMMANDE (Affichage/ Archive) <c:out value="${AfficherLigneCommandeForm.idCommande }"/> </h1>
		
		<div>
			<label>Client: ${AfficherCommandeForm.nomClient}</label><br>
			<label> Date de création : ${AfficherCommandeForm.commandeDate}</label><br>	
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
			
				<c:forEach items="${AfficherCommandeForm.listLigneCdForm}" var="c">
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
				<label> Délai Total: ${AfficherCommandeForm.delaiCommande} jours </label><br>
				<label> Tarif HT:  ${AfficherCommandeForm.prixTotal} euros </label><br>
			</div>
		<input type="button" value="Retour" onclick="history.go(-1)"/>
		
	
</body>
</html>