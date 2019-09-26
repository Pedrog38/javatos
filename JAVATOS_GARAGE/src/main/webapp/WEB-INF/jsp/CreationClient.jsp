<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/
loose.dtd">
<html>
<head>
<title>Creer un nouveau client</title>
</head>
<body>

	<h1>CREATION NOUVEAU CLIENT</h1>
			

	<form:form method="post" modelAttribute="creationClient" action="creerClient">
		
		<label>Nom: </label>
		<form:input path="nom" type="text" />
		<b><i><form:errors path="nom" /></i></b> <br>

		<label>Prenom: </label>
		<form:input path="prenom" type="text" />
		<b><i><form:errors path="prenom" /></i></b><br>

		<label>Email: </label>
		<form:input path="mail" type="mail"/>
		<b><i><form:errors path="mail" /></i></b><br>

		<label>Adresse: </label>
		<form:input path="adresse" type="text" />
		<b><i><form:errors path="adresse" /></i></b><br>

		<label>Telephone: </label>
		<form:input path="telephone" type="text" />
		<b><i><form:errors path="telephone" cssclass="error"/></i></b><br>

		<label>Sexe: </label>
		<form:select path="sexe">
		    <form:option value="HOMME" label="HOMME" />
		    <form:option value="FEMME" label="FEMME" />
		</form:select><br>

		<label>Statut: </label>
		<form:select path="statutClient">
   			<c:forEach items="${statutList}" var="statut">
  				<form:option label="${statut.nom}" value="${statut}"/>
  			</c:forEach>
		</form:select><br>
		
		

		
		<input type="button" value="Retour" onclick="history.go(-1)"/><br>

		<input type="submit" value="Creer un nouveau client" />
	</form:form>
</body>