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

<a href="<c:url value='/app/hello'/>">Hello</a>
<a href="<c:url value='creerClientAfficher'/>">Creer un Client</a>
<a href="<c:url value='DevisValidation'/>">Devis à valider</a>

</body>
</html>