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
	<title>New Person</title>
</head>
<body>
<div class="container">
	<h1>New Person</h1>
	
	<form:form action="/people" method="post" modelAttribute="person">
	    <p>
	        <form:label path="f_name">First Name:</form:label>
	        <form:errors path="f_name"/>
	        <form:input path="f_name"/>
	    </p>
	    <p>
	        <form:label path="l_name">Last Name:</form:label>
	        <form:errors path="l_name"/>
	        <form:input path="l_name"/>
	    </p>   
	    <input class="btn btn-success" type="submit" value="Create"/>
	</form:form>
</div>
</body>
</html>