<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form:form method="post" modelAttribute="creation" action="creerCreationClient">

			<form:input path="nom"/>
			<b><i><form:errors path="nom" cssclass="error"/></i></b>
			<form:input path="prenom"/>
			<b><i><form:errors path="nom" cssclass="error"/></i></b>
