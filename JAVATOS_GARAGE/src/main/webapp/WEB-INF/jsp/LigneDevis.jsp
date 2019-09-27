<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>

<html>

<body>
	<h1>Détails du devis N° <c:out value="${AfficherDevisForm.idDevis}"/> </h1>

	
			<div>
				<label> Client: ${AfficherDevisForm.nomClient} </label><br>
				<label> Date de création : ${AfficherDevisForm.dateDeCreation} </label><br>
			</div>
	
	<table border="1">
		<thread>
			<tr>
				<th>Model</th>
				<th>Quantite</th>
				<th>Délai de production (jour)</th>
				<th>Prix HT </th>
			</tr>
		</thread>	
		
		<tbody>
			<c:forEach items="${AfficherDevisForm.listLigneDevisForm}" var="ligneForm">
				<tr>
					<td><c:out value="${ligneForm.nomModel}" /></td>
					<td><c:out value="${ligneForm.quantite}" /></td>                   
					<td><c:out value="${ligneForm.delai}" /></td>
					<td><c:out value="${ligneForm.prixHT}" /></td>			
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
			<div>
				<label> Délai Total: ${AfficherDevisForm.delai} jours </label><br>
				<label> Tarif HT:  ${AfficherDevisForm.prixTotal} euros </label><br>
			</div>
		<input type="button" value="Retour" onclick="history.go(-1)"/>
</body>
</html>