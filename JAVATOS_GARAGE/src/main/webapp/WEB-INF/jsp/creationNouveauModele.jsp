<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/
loose.dtd">
<html>
<head>
<title>Créer un nouveau modèle</title>
</head>
<body>

	<h1>CREATION NOUVEAU MODELE</h1>
			
			<div>
				<p>account: <c:out value="${utilisateur.nom}  ${utilisateur.prenom} - ${utilisateur.fonction}"/></p>
			</div>

	<form:form method="post" modelAttribute="creation" action="creerUnNouveauModele">
		<label>Marque, modele: </label>
		<form:input path="marque" type="text" value="Renault Twingo" />
		<b><i><form:errors path="marque" /></i></b> </br>

		<label>Couleur: </label>
		<form:input path="couleur" type="text" value="Rouge" />
		<b><i><form:errors path="couleur" /></i></b></br>

		<label>Prix HT: </label>
		<form:input path="prixht" type="number" value="10000" />
		<b><i><form:errors path="prixht" /></i></b></br>

		<label>Delai de production: </label>
		<form:input path="delaiprod" type="number" value="5" />
		<b><i><form:errors path="delaiprod" /></i></b></br>

		
		<input type="button" value="Retour" onclick="history.go(-1)"/></br>

		<input type="submit" value="Créer un nouveau modèle" />
	</form:form>
</body>
