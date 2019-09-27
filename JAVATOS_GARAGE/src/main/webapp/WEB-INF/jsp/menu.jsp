<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security"  uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>

</head>
<body>

<security:authorize access="hasAuthority('Admin')" >
	<a href="<c:url value='/Menu/A'/>">Admin</a>
</security:authorize>
<security:authorize access="hasAuthority('Commercial')">
	<a href="<c:url value='/Menu/C'/>">Commercial</a>
</security:authorize>
<security:authorize access="hasAuthority('Magasinier')">
	<a href="<c:url value='/Menu/M'/>">Magasinier</a>
</security:authorize>

</body>
</html>