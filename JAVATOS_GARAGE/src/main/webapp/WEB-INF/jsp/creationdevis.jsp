<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Affichage des stocks de la concession Javatos Garage</title>
</head>
<body>
	<h1>Nouveau Devis</h1>
	<form:form method="post" modelAttribute="creationDevis"
		action="creerDevis">
		<a href="#">Cr�er nouveau client</a>
		<a href="#">Cr�er nouveau mod�le</a>
		<form:select path="client">
			<c:forEach items="${clients}" var="client">
				<form:option value="${client.id}" label="${client.prenom} ${client.nom}" />
			</c:forEach>
		</form:select>
		<%-- 	<p> <c:out value="${creationDevis.dateCreation}"/> </p> --%>
		<form:input path="dateCreation" type="date" disabled="disabled" />
<!-- 		<table> -->
<!-- 			<thead> -->
<!-- 				<tr> -->
<!-- 					<td>Mod�le</td> -->
<!-- 					<td>Quantit�</td> -->
<!-- 					<td>D�lais</td> -->
<!-- 					<td>Prix</td> -->
<!-- 				</tr> -->
<!-- 			</thead> -->
<%-- 			<c:forEach items="${lignesDevis}" var="ligne"> --%>
<!-- 				<tr> -->
<%-- 					<td><c:out value="ligne.model.nom"></c:out></td> --%>
<%-- 					<td><c:out value="ligne.quantite"></c:out></td> --%>
<%-- 					<td><c:out value="ligne.model.delaisProd"></c:out></td> --%>
<%-- 					<td><c:out value="ligne.model.prixVente"></c:out></td> --%>
<!-- 				</tr> -->
<%-- 			</c:forEach> --%>
<!-- 			<tr> -->
<!-- 				<td> -->
<%-- 					<form:select path="model"> --%>
<%-- 						<c:forEach items="${listemodel}" var="model"> --%>
<%-- 							<form:option value="${model.id}">${model.nom}</form:option> --%>
<%-- 						</c:forEach> --%>
<%-- 					</form:select> --%>
<!-- 				</td> -->
<!-- 				<td> <input type="text" /> </td> -->
<!-- 			</tr> -->
<!-- 		</table> -->
	</form:form>
	<table>
		<thead>
			<tr>
				<th>Mod�le</th>
				<th>Quantit� command�e</th>
				<th>Quantit� r�ceptionn�e</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listestock}" var="stock">
				<tr>
					<form:form method="post" modelAttribute="receptionner"
						action="receptionnercommande">
						<td><c:out value="${listestock.model.nom}" /></td>
						<td><c:out value="${listestock.qteCommandee}" /></td>
						<td><form:input path="qteCommandee" /></td>
						<td><input type="submit" value="VALIDER RECEPTION" /></td>
					</form:form>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>