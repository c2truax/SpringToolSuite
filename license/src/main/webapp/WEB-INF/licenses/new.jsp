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
	<title>New License</title>
</head>
<body>
	<div class="container">
	<h1>New License</h1>
	
	<form:form action="/licenses" method="POST" modelAttribute="license">
	    <p>
	        <form:label path="person">Person:</form:label>
	        <form:errors path="person"/>
	        <form:select path="person">
	        	<c:forEach items="${people}" var="p">
	        	<form:option value="${p}"><c:out value="${p.firstName}"/> <c:out value="${p.lastName}"/></form:option>
	        	</c:forEach>
	        </form:select>
	    </p>
	    <p>
	        <form:label path="state">State:</form:label>
	        <form:errors path="state"/>
	        <form:input path="state"/>
	    </p> 
	    <p>
	        <form:label path="expirationDate">Expiration Date:</form:label>
	        <form:errors path="expirationDate"/>
	        <form:input type="date" path="expirationDate"/>
	    </p>  
	    <input class="btn btn-success" type="submit" value="Create"/>
	</form:form>
</div>
</body>
</html>