<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignation stock par commande</title>
</head>
<body>
<h1>Assignation stock par commande</h1>
<form:form method="post" modelAttribute="listAssignationForm" action="assignationModifierLigne">
   
	<table border="1">
        <thead>
            <tr>
                <th>N° Commande</th>
                <th>Client</th>
                <th>Modèle</th>
                <th>Délai de production</th>
                <th>Qté demandée</th>
                <th>Qté déjà reservée</th>
                <th>Qté en commande</th>
                <th>Stock dispo</th>
                <th>Qté à réserver</th>
            </tr>
        </thead>       
            <c:forEach items="${listAssignationForm.listAss}" var="ass" varStatus="status">
                <tr>
                    <td>
                        <c:out value="${ass.idLigneCommande}"/>
                        <form:input type="hidden" path="listAss[${status.index}].idLigneCommande" value="${ass.idLigneCommande}"/>
                    </td>
                    <td>
                        <c:out value="${ass.nomClient}"/>
                        <form:input type="hidden" path="listAss[${status.index}].nomClient" value="${ass.nomClient}"/>
                    </td>
                    <td>
                        <c:out value="${ass.nomModel}"/>
                        <form:input type="hidden" path="listAss[${status.index}].nomModel" value="${ass.nomModel}"/>
                    </td>
                    <td>
                        <c:out value="${ass.delaisProd}"/>
                        <form:input type="hidden" path="listAss[${status.index}].delaisProd" value="${ass.delaisProd}"/>
                    </td>
                    <td>
                        <c:out value="${ass.quantiteLigneCommande}"/>
                        <form:input type="hidden" path="listAss[${status.index}].quantiteLigneCommande" value="${ass.quantiteLigneCommande}"/>
                    </td>
                    <td>
                        <c:out value="${ass.nbReserveLigneCommande}"/>
                        <form:input type="hidden" path="listAss[${status.index}].nbReserveLigneCommande" value="${ass.nbReserveLigneCommande}"/>
                    </td>
                    <td>
                        <c:out value="${ass.quantiteLigneCommande-ass.nbReserveLigneCommande}"/>
                        
                    </td>
                    <td>
                        <c:out value="${ass.qteDispoStock}"/>
                        <form:input type="hidden" path="listAss[${status.index}].idStock" value="${ass.idStock}"/>
                        <form:input type="hidden" path="listAss[${status.index}].qteDispoStock" value="${ass.qteDispoStock}"/>
                    </td>
                    <td>
                        <form:input type="text" path="listAss[${status.index}].qteAReserve"/><br/>
                        <form:errors path="listAss[${status.index}].qteReserveOk" />
                    </td>
                    <td>
                    <form:button type="submit" name="index" value="${status.index}" >Assigner</form:button>
                   
                    </td>
                </tr>
            </c:forEach>
	    </table>
</form:form>
				<input type="button" value="Retour" onclick="history.go(-1)"/><br>
</body>
</html>

