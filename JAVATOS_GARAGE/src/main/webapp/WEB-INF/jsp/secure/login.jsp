<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mon formulaire !!!</title>

</head>
	<form action="login" method="post">
		<div>
			<input type="text" name="username" placeholder="Login" />
		</div>
		<div>
			<input type="password" name="password" placeholder="Password" />
		</div>
		<div>
			<input type="submit" value="Connection" />
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.
		token}" />
	</form>
</html>