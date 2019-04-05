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
	<title>Product Page</title>
</head>
<body>
<div class="container">
	<h1><c:out value="${productObj.name }"/></h1>
	
	<div class="d-inline-block mr-5 pr-5">
		<h3>Categories:</h3>
		<ul>
			<c:forEach items="${productObj.categories}" var="c">
				<li><c:out value="${c.name}"/></li>
			</c:forEach>
		</ul>
	</div>
	<div class="d-inline-block ml-5 mt-1 pl-5 align-top">
		<form:form action="/addCategory" modelAttribute="connectionObj">
			<form:hidden path="product" value="${productObj.id}"/>
			<form:label path="category">Add Category:</form:label>
			<form:select path="category">
				<c:forEach items="${nonCategories}" var="cat">
					<form:option value="${cat.id}"><c:out value="${cat.name}"/></form:option>
				</c:forEach>
			</form:select>
			<input class="btn btn-success d-block" type="submit" value="Add"/>
		</form:form>
	</div>
</div>
	
</body>
</html>