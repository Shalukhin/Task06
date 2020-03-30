<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- <link rel="stylesheet" -->
<!-- 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"> -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto&display=swap">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Alfa+Slab+One|Sen&display=swap">

<style>
	<%@ include file="css/bootstrap.min.css"%>
	<%@ include file="css/styles.css"%>
</style>

</head>


<body>
	<table class="table table-bordered text-center">
		<thead>
			<tr>
				<th scope="col">Device</th>
				<th scope="col">Model</th>
				<th scope="col">Origin</th>
				<th scope="col">Price</th>				
			</tr>
		</thead>
		<tbody>
		
			<c:forEach var="flower" items="${flowers }">
			<tr>
				<td><c:out value="${device.name }" /></td>
				<td><c:out value="${device.model }" /></td>
				<td><c:out value="${device.origin }" /></td>
				<td><c:out value="${device.price }" /></td>
			
					</tr>
			</c:forEach>
			
		</tbody>
	</table>
	
		<script>
	<%@ include file="js/jquery-3.3.1.min.js"%>
		
	<%@ include file="js/bootstrap.min.js"%>
		
	<%@ include file="js/popper.min.js"%>
	
	<%@ include file="js/main.js"%>
	
	</script>
</body>
</html>
