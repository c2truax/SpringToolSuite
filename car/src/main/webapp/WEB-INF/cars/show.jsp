<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Show Car</title>
</head>
<body>
	<h1>Welcome to the <c:out value="${car.brand}"/> <c:out value="${car.model}"/>'s page</h1>
	<h2>The current color is: <c:out value="${car.color}"/></h2>
	
	<a href="/cars">Back</a>
</body>
</html>