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
	<h1>Gestion Reception</h1>
	<table border="1">
	<thead>
	<tr>
	<th>Modèle</th>
	<th>Quantité commandée</th>
	<th>Quantité réceptionnée</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${gestionStocks.listForm}" var="gestionStock" varStatus="status">
	<tr>
	<form:form method="post" modelAttribute="gestionStocks[${status.index}]" action="receptionnercommande">
	<td> <c:out value="${gestionStock.nomModele}" /> </td>
	<td> <c:out value="${gestionStock.qteCommandee}" /> </td>
<%-- 	<td> <form:input path="gestionStocks[${status.index}].qteRecue" /> </td> --%>
	<td> <c:out value="${gestionStock.qteRecue}"></c:out> </td>
	<td> <input type="submit" value="VALIDER RECEPTION" /> </td>
	</form:form>
	</tr>
	</c:forEach>
	</tbody>
	</table>
</body>
</html>