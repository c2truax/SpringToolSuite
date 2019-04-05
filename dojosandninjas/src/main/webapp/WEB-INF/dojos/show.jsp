<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<title>Dojo Page</title>
</head>
<body>
<div class="container">
	<h1><c:out value="${dojo.name }"/> Location Ninjas</h1>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Age</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach items="${dojo.ninjas}" var="n">
    <tr>
      <th scope="row"><c:out value="${n.firstName }"/></th>
      <td><c:out value="${n.lastName }"/></td>
      <td><c:out value="${n.age }"/></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>
</body>
</html>