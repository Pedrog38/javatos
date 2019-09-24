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
                                
                                <tr><td><h3>
                                   <c:url value="/creationDevis" var="url" />
										<a href="${url}"> Créer un devis</a>
                                </h3></td></tr>
                                
                                <tr><td><h3>
                                   <c:url value="/validationDevis" var="url" />
										<a href="${url}"> Valider un devis</a>
                                </h3></td></tr>
                         
                          <tr><td><h2>
                                    2 - Commandes
                                </h2></td></tr>
                               
                                <tr><td><h3>
                                   <c:url value="/historiqueCommandes" var="url" />
										<a href="${url}"> Historique des commandes</a>
                                </h3></td></tr>
                                
                                <tr><td><h3>
                                   <c:url value="/afficherCommandeEnCours" var="url" />
										<a href="${url}"> Liste des commande en cours</a>
                                </h3></td></tr>
                                                                                                
                          <tr><td><h2>
                                    3 - Stock
                                </h2></td></tr>
                               
                                <tr><td><h3>
                                   <c:url value="/afficherStock" var="url" />
										<a href="${url}"> Etat du stock</a>
                                </h3></td></tr>
                                       
                          <tr><td><h2>
                                    4 - Gestion Admin
                                </h2></td></tr>
                               
                                <tr><td><h3>
                                   <c:url value="/creationModel" var="url" />
										<a href="${url}"> Création d'un nouveau modèle </a>
                                </h3></td></tr>
                                
                                <tr><td><h3>
                                   <c:url value="/creationClient" var="url" />
										<a href="${url}"> Création d'un nouveau client </a>
                                </h3></td></tr>
                                
                                <td><tr> 
                                <a id="logoutLink" href="${pageContext.servletContext.contextPath}/logout">Logout</a>
                                </td></tr>
                            </tbody>
                        </table>
                   </tr>
            </tbody>
        </table>

</body>
</html>

