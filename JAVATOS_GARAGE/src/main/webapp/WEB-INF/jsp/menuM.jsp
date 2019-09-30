

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Menu Principal - Magasinier</title>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Menu Principal - Magasinier : <%=request.getUserPrincipal().getName()%></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    	<li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          1 - Devis
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
        <c:url value="/magasinier/afficherListeDevis" var="url" />
          <a class="dropdown-item" href="${url}">Liste des devis</a>
          </div>
      </li>


       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          2 - Commande
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
        	<c:url value="/magasinier/historiqueCommandes" var="url" />
          <a class="dropdown-item" href="${url}">Historique des commandes</a>
          <c:url value="/magasinier/afficherCommandeEnCours" var="url" />
          <a class="dropdown-item" href="${url}">Liste des commandes en cours</a>
          <c:url value="/magasinier/traiterCommande" var="url" />
          <a class="dropdown-item" href="${url}">Traiter nouvelle commande Client/commande Fournisseur</a>
          <c:url value="/magasinier/assignationAfficherListe" var="url" />
          <a class="dropdown-item" href="${url}">Assignation commande selon stock</a>
          
        </div>
      </li>


       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          3 - Stock
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
        	<c:url value="/magasinier/afficherGestionStock" var="url" />
          <a class="dropdown-item" href="${url}">Gestion Stock</a>
          <c:url value="/magasinier/afficherStock" var="url" />
          <a class="dropdown-item" href="${url}">Etat du stock</a>  
        </div>
      </li>
      
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          4 - Gestion administrative
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
        <c:url value="/magasinier/afficherListeModel" var="url" />
          <a class="dropdown-item" href="${url}">Afficher liste des modeles</a>
          <c:url value="/magasinier/creerClientAfficher" var="url" />
          <c:url value="/magasinier/afficherListeClient" var="url" />
          <a class="dropdown-item" href="${url}">Afficher liste des clients</a>
          
        </div>
      </li>
      
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <a class="btn btn-outline-success my-2 my-sm-0" href="${pageContext.servletContext.contextPath}/logout">Logout</a>
    </form>
  </div>
</nav>

                                
              <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
             

</body>
</html>
