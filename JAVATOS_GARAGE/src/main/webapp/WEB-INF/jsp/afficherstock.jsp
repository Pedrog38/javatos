<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Affichage des stocks de la concession Javatos Garage</title>
</head>
<body>
	<h1>Visualisation de stock</h1>
	<table>
	<thead>
	<tr>
	<th>Mod�le</th>
	<th>Quantit� disponible</th>
	<th>Quantit� r�serv�e</th>
	<th>Quantit� command�e</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${listestock}" var="stock">
	<tr>
	<td><c:out value="${stock.model.nom}" /></td>
	<td><c:out value="${stock.qteDispo}" /></td>
	<td><c:out value="${stock.qteReservee}" /></td>
	<td><c:out value="${stock.qteCommandee}" /></td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
</body>
</html>