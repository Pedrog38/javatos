<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form:form method="post" modelAttribute="assignation" action="assignationModifier">
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
            <c:forEach items="${listAssignationForm}" var="ligneCommande" varStatus="status">
                <tr>
                    <td>
                        <c:out value="${listAssignationForm}"/>
                        <input type="hidden" name="ListeDetailCommande[${status.index}].commande.id" value="${ligneCommande.commande.id}"/>
                    </td>
                    <td>
                        <c:out value="${ligneCommande.commande.client.nom}"/>
                        <input type="hidden" name="ListeDetailCommande[${status.index}].commande.client.nom" value="${ligneCommande.commande.client.nom}"/>
                    </td>
                    <td>
                        <c:out value="${ligneCommande.model.nom}"/>
                        <input type="hidden" name="ListeDetailCommande[${status.index}].model.nom" value="${ligneCommande.model.nom}"/>
                    </td>
                    <td>
                        <c:out value="${ligneCommande.delaiproduction}"/>
                        <input type="hidden" name="ListeDetailCommande[${status.index}].delaiproduction" value="${ligneCommande.delaiproduction}"/>
                    </td>
                    <td>
                        <c:out value="${ligneCommande.quantite}"/>
                        <input type="hidden" name="ListeDetailCommande[${status.index}].quantite" value="${ligneCommande.quantite}"/>
                    </td>
                    <td>
                        <c:out value="${ligneCommande.nbResvervees}"/>
                        <input type="hidden" name="ListeDetailCommande[${status.index}].nbResvervees" value="${ligneCommande.nbResvervees}"/>
                    </td>
    <!-- qté calculé d'après les éléments Qté demandé et Qté reservé  -->
                    <td>
                        <c:out value="${ligneCommande.quantite-ligneCommande.nbResvervees}"/>
                        
                    </td>
    <!-- qté disponible en stock par modele  
    il fut créer une jointure entre ligneCommande, model, stock -->
                    <td>
                        <c:out value="${ligneCommande.stock.qteDispo}"/>
                        <input type="hidden" name="ListeDetailCommande[${status.index}].stock.model.qteDispo" value="${ligneCommande.stock.model.qteDispo}"/>
                    </td>
   <!-- qté à reserver : 1- Doit être entre 0 et (Qté demandé - Qté deja reservé)
   2- créer une liste SaisieQtéAreserver avec size()=size(Listedetailcommande)
   3-  -->              
                    <td>
                        <input type="text" name="saisieQteAReserver[${status.index}]" value="0"/><br/>
                      <!-- faudra gérere les erreurs dans el ccontroller ou dans le pattern du validateur
                      <b><i><form:errors path="listeCourses[${status.index}].quantite" /></i></b> -->  
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