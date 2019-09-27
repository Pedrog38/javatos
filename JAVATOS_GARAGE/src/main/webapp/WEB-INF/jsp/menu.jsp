<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>

</head>
<body>

<a href="<c:url value='/app/hello'/>">Hello</a><br>
<a href="<c:url value='/creerClientAfficher'/>">creer Client</a><br>
<a href="<c:url value='/creerModeleAfficher'/>">creer Modele</a><br>
<a href="<c:url value='/afficherListeDevis'/>">afficher Liste des devis</a><br>

</body>
</html>