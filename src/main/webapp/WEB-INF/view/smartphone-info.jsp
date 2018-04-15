<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title>Smartphone</title>
	
	<link href="/css/main.css" rel="stylesheet"/>
	
</head>

<body>

	<header>
		<p>Welcome to myStore.pl</p>
	</header>

	<div id="sidenav">
		<a id="styleLink" href="/category/smartphones">Back to smartphones page</a>
		
	</div>
	
	<div id="right-column">
		
	</div>
	
	<div id="main-column">
	
		<h2>Specification</h2>

		<table>

			<tr>
				<td><b>Brand</b></td>
				<td>${smartphone.brand}</td>
			</tr>
			<tr>
				<td><b>Model</b></td>
				<td>${smartphone.model}</td>
			</tr>	
			<tr>
				<td><b>Storage</b></td>
				<td>${smartphone.storage} GB</td>
			</tr>
			<tr>
				<td><b>Processor</b></td>
				<td>${smartphone.processor}</td>
			</tr>
			<tr>
				<td><b>Screen size</b></td>
				<td>${smartphone.screenSize}"</td>
			</tr>
			<tr>
				<td><b>Screen resolution</b></td>
				<td>${smartphone.screenResolution}</td>
			</tr>
			<tr>
				<td><b>Price</b></td>
				<td>${smartphone.price} PLN</td>
			</tr>				

		</table>
		
		<br>
		
		<!-- construct "Add to Cart" link with Article id -->
		<c:url var="addToCartLink" value="/cart-add">
			<c:param name="ArticleId" value="${smartphone.id}" />
		</c:url>
	
		<a id="styleAddToCartLink" href="${addToCartLink}">Add to Cart</a>
		
	</div>
	
	<footer>
		<p>&copy; 2018 Aleksander</p>
	</footer>

</body>

</html>
