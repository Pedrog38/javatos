<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 

<html>

<body>
	<h1>Détails du devis N° <c:out value="${devis.id}"/> </h1>

	
			<div>
				<label> Client: ${devis.client}/> </label><br>
				<label> Date: ${devis.date}/> </label><br>
			</div>
	
	<table border="1">
		<thread>
			<tr>
				<th>Model</th>
				<th>Quantite</th>
				<th>Délai de production (jour)</th>
				<th>Prix HT </th>
			</tr>
		</thread>	
	</table>
	
	<table border="1">
		<thread>
			<tr>
				<th>Délai Total: <c:out value="${devis.client}"/> </th><br>
				<th>Tarif HT:   <c:out value="${devis.date}" /> </th>
				<th>Tarif TTC:  <c:out value="${devis.date}" /> </th> 
				<th>Taux TVA  <c:out value="${devis.taux}" /> </th> 
			</tr>
		</thread>	
	</table>

</body>
</html>