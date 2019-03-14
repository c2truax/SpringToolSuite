<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Hello Human</title>
</head>
<body>
	<h1>Hello <c:out value="${humanName}"/></h1>
	<h3>Welcome to SpringBoot!</h3>
</body>
</html>