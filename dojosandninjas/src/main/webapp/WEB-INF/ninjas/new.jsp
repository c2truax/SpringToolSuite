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
	<title>New Ninja</title>
</head>
<body>
<div class="container">
	<h1>New Ninja</h1>
	<form:form action="/ninjas" method="POST" modelAttribute="ninja">
	    <p>
	        <form:label path="dojo">Dojo:</form:label>
	        <form:errors path="dojo"/>
	        <form:select path="dojo">
	        	<c:forEach items="${dojos}" var="d">
	        	<form:option value="${d}"><c:out value="${d.name}"/></form:option>
	        	</c:forEach>
	        </form:select>
	    </p>
	    <p>
	        <form:label path="firstName">First Name:</form:label>
	        <form:errors path="firstName"/>
	        <form:input path="firstName"/>
	    </p>
	    <p>
	        <form:label path="lastName">Last Name:</form:label>
	        <form:errors path="lastName"/>
	        <form:input path="lastName"/>
	    </p> 
	    <p>
	        <form:label path="age">Age:</form:label>
	        <form:errors path="age"/>
	        <form:input path="age"/>
	    </p>  
	    <input class="btn btn-success" type="submit" value="Create"/>
	</form:form>
</div>
</body>
</html>