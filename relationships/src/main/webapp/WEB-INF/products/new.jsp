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
	<title>New Product</title>
</head>
<body>
	<div class="container">
		<h1>New Product</h1>
		<p><form:errors path="productObj.*"/></p>
		<form:form action="/products" method="POST" modelAttribute="productObj">
	    <p>
	        <form:label path="name">Name:</form:label>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="description">Description:</form:label>
	        <form:input path="description"/>
	    </p> 
	    <p>
	        <form:label path="price">Price:</form:label>
	        <form:input path="price"/>
	    </p>   
	    <input class="btn btn-success" type="submit" value="Create"/>
	</form:form>
	</div>
</body>
</html>