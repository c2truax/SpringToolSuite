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
	<title>Category Page</title>
</head>
<body>
<div class="container">
	<h1><c:out value="${categoryObj.name }"/></h1>
	<div class="d-inline-block mr-5 pr-5">
		<h3>Products:</h3>
		<ul>
			<c:forEach items="${categoryObj.products}" var="p">
				<li><c:out value="${p.name}"/></li>
			</c:forEach>
		</ul>
	</div>
	<div class="d-inline-block ml-5 mt-1 pl-5 align-top">
		<form:form action="/addProduct" modelAttribute="connectionObj">
			<form:hidden path="category" value="${categoryObj.id}"/>
			<form:label path="product">Add Product:</form:label>
			<form:select path="product">
				<c:forEach items="${nonProducts}" var="prod">
					<form:option value="${prod.id}"><c:out value="${prod.name}"/></form:option>
				</c:forEach>
			</form:select>
			<input class="btn btn-success d-block" type="submit" value="Add"/>
		</form:form>
	</div>
</div>
	
</body>
</html>