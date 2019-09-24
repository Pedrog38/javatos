<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 

<html>

<body>
	<h1>Détails du devis N° <c:out value="${t.id}"/> </h1>

	<table border="1">
		<thread>
			<tr>
				<th>Client:<c:out value="${d.client}"/> </th><br>
				<th>Date:  <c:out value="${d.date}" /> </th>
			</tr>
		</thread>	
	</table>
	
	<table border="1">
		<thread>
			<tr>
				<th>Model</th>
				<th>Quantite</th>
				<th>Délai de production (jour)</th>
				<th>Prix HT </th>
		</thread>
	
	
	
	</table>

</body>
</html>