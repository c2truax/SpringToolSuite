<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>All Cars</title>
</head>
<body>
	<h1>All Cars</h1>
	<table>
		<thead>
			<tr>
				<th>Brand</th>
				<th>Model</th>
				<th>Color</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allCars}" var="car">
				<tr>
					<td><c:out value="${car.brand}"/></td>
					<td><c:out value="${car.model}"/></td>
					<td><c:out value="${car.color}"/></td>
					<td>
						<a href="/cars/${car.id}">Show</a>
						<a href="/cars/${car.id}/edit">Edit</a>
						<form style="display:inline-block;" action="/cars/${car.id }" method="POST">
							<input type="hidden" name="_method" value="delete" />
							<input type="submit" value="Delete" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>
	<a href="/cars/new">New Car</a>
	
</body>
</html>