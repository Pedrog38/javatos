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

<section id="cd-intro">
	<h1>Menu Principal</h1>
	
	<style>
	h1 {
		position: absolute;
		width: 90%;
		@include center; 
		text-align: center;
		@include font-size(20px);
		font-weight: bold;
		color: $color-4;
	}
	
	
	#cd-intro {
	position: relative;
	height: 100%;
	background-size: center;
	}
</style>
	
	<label id="menu">


                    <td valign="middle">

                                <h2>
                                    1 - Devis
                                </h2>
                               
                                <h3>
                                   <c:url value="/afficherListeDevis" var="url" />
										<a href="${url}"> Liste des devis</a>
                                </h3>
                                
                                <h3>
                                   <c:url value="/creationDevis" var="url" />
										<a href="${url}"> Créer un devis</a>
                                </h3>
                          
                                <h3>
                                   <c:url value="/validationDevis" var="url" />
										<a href="${url}"> Valider un devis</a>
                      			</h3>
                      			<h3>
                                   <c:url value="/admin/historiqueCommandes" var="url" />
										<a href="${url}"> Historique des commandes</a>
                                </h3>
                                
                                <h3>
                                   <c:url value="/afficherCommandeEnCours" var="url" />
										<a href="${url}"> Liste des commande en cours</a>
                                </h3>
                                
                                <h3>
                                   <c:url value="/traiterCommande" var="url" />
										<a href="${url}"> Traiter nouvelle commande Client/commande Fournisseur</a>
                                </h3>
                         
                          		<h3>
                                   <c:url value="/assignerCommandeSelonStock" var="url" />
										<a href="${url}"> Assignation commande selon stock</a>
                                </h3>
                                 <tr><td>
                                 
                                <h2>
                                    3 - Stock
                                </h2>
                               
                                <h3>
                                   <c:url value="/stockGestion" var="url" />
										<a href="${url}"> Gestion des stocks </a>
                                </h3>
                                
                                <h3>
                                   <c:url value="/afficherStock" var="url" />
										<a href="${url}"> Etat du stock</a>
                                </h3>
                                       
                                <h2>
                                    4 - Gestion Administrative
                                </h2>
                               
                                 <h3>
                                   <c:url value="/admin/creerModeleAfficher" var="url" />
										<a href="${url}"> Création d'un nouveau modèle </a>
                                </h3>
                                
                                <h3>
                                   <c:url value="/admin/creerClientAfficher" var="url" />
										<a href="${url}"> Création d'un nouveau client </a>
                                </h3>
                                
                                <h3>
                                  <c:url value="/admin/afficherListeClient" var="url" />
                                        <a href="${url}"> Afficher liste des clients </a>
                               </h3>
                               
                               <h3>
                                  <c:url value="/admin/afficherListeModel" var="url" />
                                        <a href="${url}"> Afficher liste des modèles </a>
                               </h3>
                      
                                <td><tr>  
                                <a id="logoutLink" href="${pageContext.servletContext.contextPath}/logout">Logout</a>
                                </td></tr>

      </section>

</body>
</html>

