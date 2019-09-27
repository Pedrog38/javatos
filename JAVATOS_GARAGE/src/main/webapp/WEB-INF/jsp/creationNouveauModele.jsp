
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/
loose.dtd">
<html>
<head>
<title>Creer un nouveau modele</title>
</head>
<body>

	<h1>CREATION NOUVEAU MODELE</h1>
			
		

	<form:form method="post" modelAttribute="creationModele" action="creerModele">
		
		<label>Marque, modele: </label>
		<form:input path="nom" type="text" value="Renault Twingo" />
		<b><i><form:errors path="nom" /></i></b><br>

	
		<label>Puissance (CH): </label>
		<form:select path="puissance">
		    <form:option value="60" label="60" />
		    <form:option value="120" label="120" />
		    <form:option value="240" label="240" />
		    <form:option value="580" label="580" />
		</form:select><br>
		
	
		<label>Couleur: </label>
		<form:select path="couleur">
		    <form:option value="Blanche" label="Blanche" />
		    <form:option value="Rouge" label="Rouge" />
		    <form:option value="Verte" label="Verte" />
		    <form:option value="Bleue" label="Bleue" />
		    <form:option value="Grise" label="Grise" />
		    <form:option value="Jaune" label="Jaune" />
		</form:select><br>

	
		<label>Prix HT: </label>
		<form:input path="prixVente" type="number" value="10000" />
		<b><i><form:errors path="prixVente" /></i></b><br>
		
		<label>Delai de production: </label>
		<form:input path="delaisProd" type="number" value="5" />
		<b><i><form:errors path="delaisProd" /></i></b><br>

		
		<input type="button" value="Retour" onclick="history.go(-1)"/><br>

		<input type="submit" value="Creer un nouveau modele" />
	</form:form>
</body>
