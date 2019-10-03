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
	<form:form method="post" modelAttribute="gestionStocks" action="receptionnercommande">
	
	<table border="1">
	<thead>
	<tr>
	<th>Modèle</th>
	<th>Quantité commandée</th>
	<th>Quantité réceptionnée</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${gestionStocks.listForm}" var="listForm" varStatus="status">
	<tr>
	<td> 
		<c:out value="${listForm.nomModele}"/>
        <form:input type="hidden" path="listForm[${status.index}].nomModele" value="${listForm.nomModele}"/>
    </td>
    <td> 
		<c:out value="${listForm.qteCommandee}"/>
        <form:input type="hidden" path="listForm[${status.index}].qteCommandee" value="${listForm.qteCommandee}"/>
    </td>
	<td>
	<form:input type="text" path="listForm[${status.index}].qteRecue" />
	<form:errors path="listForm[${status.index}].qteRecueOk" />
	<form:input type="hidden" path="listForm[${status.index}].idModel" value="${listForm.idModel}"/>
	</td>
	<td> <form:button type="submit" name="index" value="${status.index}" >Valider réception</form:button> </td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	
	</form:form>
	<a href="/">Retour Menu Principal</a>
</body>
</html>