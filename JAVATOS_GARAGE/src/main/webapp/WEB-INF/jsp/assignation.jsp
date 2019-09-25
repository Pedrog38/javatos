<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
                        <c:out value="${ass.ligneCommande.commande.id}"/>
                        <form:input type="hidden" path="listAss[${status.index}].ligneCommande.commande.id" value="${ass.ligneCommande.commande.id}"/>
                    </td>
                    <td>
                        <c:out value="${ass.ligneCommande.commande.client.nom} ${ass.ligneCommande.commande.client.prenom}"/>
                        <form:input type="hidden" path="listAss[${status.index}].ligneCommande.commande.client.id" value="${ass.ligneCommande.commande.client.id}"/>
                    </td>
                    <td>
                        <c:out value="${ass.ligneCommande.model.nom}"/>
                        <form:input type="hidden" path="listAss[${status.index}].ligneCommande.model.id" value="${ass.ligneCommande.model.id}"/>
                    </td>
                    <td>
                        <c:out value="${ass.ligneCommande.commande.delaisProd}"/>
                        <form:input type="hidden" path="listAss[${status.index}].ligneCommande.commande.delaisProd" value="${ass.ligneCommande.commande.delaisProd}"/>
                    </td>
                    <td>
                        <c:out value="${ass.ligneCommande.quantite}"/>
                        <form:input type="hidden" path="listAss[${status.index}].ligneCommande.quantite" value="${ass.ligneCommande.quantite}"/>
                    </td>
                    <td>
                        <c:out value="${ass.ligneCommande.nbResvervees}"/>
                        <form:input type="hidden" path="listAss[${status.index}].ligneCommande.nbResvervees" value="${ass.ligneCommande.nbResvervees}"/>
                    </td>
                    <td>
                        <c:out value="${ass.ligneCommande.quantite-ass.ligneCommande.nbResvervees}"/>
                        
                    </td>
                    <td>
                        <c:out value="${ass.stock.qteDispo}"/>
                        <form:input type="hidden" path="listAss[${status.index}].stock.id" value="${ass.stock.id}"/>
                        <form:input type="hidden" path="listAss[${status.index}].stock.qteDispo" value="${ass.stock.qteDispo}"/>
                    </td>
                    <td>
                        <form:input type="text" path="listAss[${status.index}].qteAReserve"/><br/>
                        <form:errors path="listAss[${status.index}].qteAReserve" /></i></b>
                    </td>
                    <td>
                    <input type="submit" value= Assigner >
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</form:form>

