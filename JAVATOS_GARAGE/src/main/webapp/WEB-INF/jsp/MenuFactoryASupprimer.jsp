<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Principal</title>

</head>
<body>

	<h1>Menu Principal</h1>
	
	
	<table>
            <tbody>
                <tr>
                    <td valign="middle">
                        <table>
                            <tbody>
                                <tr><td><h2>
                                    1 - Devis
                                </h2></td></tr>
                               
                                <tr><td><h3>
                                   <c:url value="/afficherListeDevis" var="url" />
										<a href="${url}"> Liste des devis</a>
                                </h3></td></tr>
<!-- manque le controller de pierre -->
                                <tr><td><h3>
                                   <c:url value="/creationDevis" var="url" />
										<a href="${url}"> Cr�er un devis</a>
                                </h3></td></tr>
 <!-- manque le tout -->
                                <tr><td><h3>
                                   <c:url value="/validationDevis" var="url" />
										<a href="${url}"> Valider un devis</a>
								</h3></td></tr>
										
								<tr><td><h2>
                                    2 - Commande
                                </h2></td></tr>
 <!-- manque le controller !-->
                      			<tr><td><h3>
                                   <c:url value="/afficherListeCommande" var="url" />
										<a href="${url}"> Historique des commandes</a>
                                </h3></td></tr>
                                
                                <tr><td><h3>
                                   <c:url value="/afficherCommandeEnCours" var="url" />
										<a href="${url}"> Liste des commande en cours</a>
                                </h3></td></tr>
                                
                                <tr><td><h3>
                                   <c:url value="/traiterCommande" var="url" />
										<a href="${url}"> Traiter nouvelle commande Client/commande Fournisseur</a>
                                </h3></td></tr>
                         
                          		<tr><td><h3>
                                   <c:url value="/admin/assignationAfficherListe" var="url" />
										<a href="${url}"> Assignation commande selon stock</a>
                                </h3></td></tr>
                                 
                         		 <tr><td><h2>
                                    3 - Stock
                                </h2></td></tr>
                               
                                <tr><td><h3>
                                   <c:url value="/stockGestion" var="url" />
										<a href="${url}"> Gestion des stocks </a>
                                </h3></td></tr>
                                
                                <tr><td><h3>
                                   <c:url value="/admin/afficherStock" var="url" />
										<a href="${url}"> Etat du stock</a>
                                </h3></td></tr>
                                       
                          <tr><td><h2>
                                    4 - Gestion Administative
                                </h2></td></tr>
                               
                                <tr><td><h3>
                                   <c:url value="/admin/creerModeleAfficher" var="url" />
										<a href="${url}"> Cr�ation d'un nouveau mod�le </a>
                                </h3></td></tr>
                                
                                <tr><td><h3>
                                   <c:url value="/admin/afficherListeModel" var="url" />
										<a href="${url}"> Afficher liste des mod�les </a>
                                </h3></td></tr> 
                                
                                <tr><td><h3>
                                   <c:url value="/admin/creerClientAfficher" var="url" />
										<a href="${url}"> Cr�ation d'un nouveau client </a>
                                </h3></td></tr>
                                
                                <tr><td><h3>
                                   <c:url value="/admin/afficherListeClient" var="url" />
										<a href="${url}"> Afficher liste des clients </a>
                                </h3></td></tr>
                                 
                                 <tr><td>  
                                <a id="logoutLink" href="${pageContext.servletContext.contextPath}/logout">Logout</a>
                                </td></tr>
                            </tbody>
                        </table>
                   </tr>
            </tbody>
        </table>

</body>
</html>
