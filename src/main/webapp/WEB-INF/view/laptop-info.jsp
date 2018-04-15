<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title>Laptop</title>
	
	<link href="/css/main.css" rel="stylesheet"/>
	
</head>

<body>

	<header>
		<p>Welcome to myStore.pl</p>
	</header>

	<div id="sidenav">
		<a id="styleLink" href="/category/laptops">Back to laptops page</a>
		
	</div>
	
	<div id="right-column">
		
	</div>
	
	<div id="main-column">
	
		<h2>Specification</h2>

		<table>

			<tr>
				<td><b>Brand</b></td>
				<td>${laptop.brand}</td>
			</tr>
			<tr>
				<td><b>Model</b></td>
				<td>${laptop.model}</td>
			</tr>
			<tr>
				<td><b>Memory</b></td>
				<td>${laptop.memory} GB</td>
			</tr>
			<tr>
				<td><b>Screen size</b></td>
				<td>${laptop.screenSize}"</td>
			</tr>
			<tr>
				<td><b>Graphic card</b></td>
				<td>${laptop.graphicCard}</td>
			</tr>
			<tr>
				<td><b>Processor</b></td>
				<td>${laptop.processor}</td>
			</tr>
			<tr>
				<td><b>Price</b></td>
				<td>${laptop.price} PLN</td>
			</tr>

		</table>
		
		<br>
		
		<!-- construct "Add to Cart" link with Article id -->
		<c:url var="addToCartLink" value="/cart-add">
			<c:param name="ArticleId" value="${laptop.id}" />
		</c:url>
	
		<a id="styleAddToCartLink" href="${addToCartLink}">Add to Cart</a>

	</div>
	
	<footer>
		<p>&copy; 2018 Aleksander</p>
	</footer>

</body>

</html>
