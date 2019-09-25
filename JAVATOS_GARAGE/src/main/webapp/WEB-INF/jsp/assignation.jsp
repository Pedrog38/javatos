<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form:form method="post" modelAttribute="assignationForm" action="assignationModifier">
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
            <c:forEach items="${listAssignationForm}" var="ass" varStatus="status">
                <tr>
                    <td>
                        <c:out value="${listAssignationForm.lignecommande.commande.id}"/>
                        <input type="hidden" name="ass[${status.index}].lignecommande.commande.id" value="${listAssignationForm.lignecommande.commande.id}"/>
                    </td>
                    <td>
                        <c:out value="${listAssignationForm.lignecommande.commande.client}"/>
                        <input type="hidden" name="ass[${status.index}].lignecommande.commande.client" value="${listAssignationForm.lignecommande.commande.client}"/>
                    </td>
                    <td>
                        <c:out value="${listAssignationForm.lignecommande.model}"/>
                        <input type="hidden" name="ass[${status.index}].lignecommande.model" value="${listAssignationForm.lignecommande.model}"/>
                    </td>
                    <td>
                        <c:out value="${listAssignationForm.lignecommande.delaisProd}"/>
                        <input type="hidden" name="ass[${status.index}].lignecommande.delaisProd" value="${listAssignationForm.lignecommande.delaisProd}"/>
                    </td>
                    <td>
                        <c:out value="${listAssignationForm.lignecommande.quantite}"/>
                        <input type="hidden" name="ass[${status.index}].lignecommande.quantite" value="${listAssignationForm.lignecommande.quantite}"/>
                    </td>
                    <td>
                        <c:out value="${listAssignationForm.lignecommande.nbResvervees}"/>
                        <input type="hidden" name="ass[${status.index}].lignecommande.nbResvervees" value="${listAssignationForm.lignecommande.nbResvervees}"/>
                    </td>
                    <td>
                        <c:out value="${listAssignationForm.lignecommande.quantite-listAssignationForm.lignecommande.nbResvervees}"/>
                        
                    </td>
                    <td>
                        <c:out value="${listAssignationForm.stock.qteDispo}"/>
                        <input type="hidden" name="ass[${status.index}].stock.qteDispo" value="${ligneCommande.stock.model.qteDispo}"/>
                    </td>
                    <td>
                        <input type="text" name="ass[${status.index}].qteAReserve" value="0"/><br/>
                    </td>
                    <td>
                    <input type="submit" value= Assigner>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</form:form>

<!--  Calcul dans le controller et le if aussi  
le "post" recupere l'information $
le "get" fait la mise a jour des autres colonnes-->