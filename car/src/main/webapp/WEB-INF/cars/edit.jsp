<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<title>Edit Car</title>
</head>
<body>
	    
	<h1>Editing <c:out value="${car.brand}"/> <c:out value="${car.model}"/></h1>
	
	<form:form action="/cars/${car.id }" method="post" modelAttribute="car">
		<input type="hidden" name="_method" value="put" />
	    <p>
	        <form:label path="brand">Brand:</form:label>
	        <form:errors path="brand"/>
	        <form:input path="brand"/>
	    </p>
	    <p>
	        <form:label path="model">Model:</form:label>
	        <form:errors path="model"/>
	        <form:textarea path="model"/>
	    </p>
	    <p>
	        <form:label path="color">Color:</form:label>
	        <form:errors path="color"/>
	        <form:input path="color"/>
	    </p>    
	    <input type="submit" value="Submit"/>
	</form:form>    
</body>
</html>