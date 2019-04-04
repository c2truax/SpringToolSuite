<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<title>Profile Page</title>
</head>
<body>
<div class="container">
	<h1><c:out value="${person.firstName }" /> <c:out value="${person.lastName }" /></h1>
	<div class="d-inline-block">
		<p>License Number:</p>
		<p>State:</p>
		<p>Expiration Date:</p>
	</div>
	<div class="d-inline-block">
		<p><c:out value="${person.license.number }" /></p>
		<p><c:out value="${person.license.state }" /></p>
		<p><c:out value="${person.license.expirationDate }" /></p>
	</div>
</div>
</body>
</html>