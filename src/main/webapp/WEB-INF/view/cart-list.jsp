<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title>Cart-Info</title>
	
	<link href="/css/main.css" rel="stylesheet"/>
	
</head>

<body>

	<header>
		<p>Welcome to myStore.pl</p>
	</header>

	<div id="sidenav">
		<a id="styleLink" href="/">Back to home page</a>
	</div>
	
	<div id="right-column">
		<h3>My Cart</h3>
		<p style="font-size: large"> Total price: </p>
		<p style="font-size: large"> ${totalPrice} PLN </p>
		<br>
		<button type="button" id="button" onclick="window.location.href='/checkout'">Checkout</button>
	</div>
	
	<div id="main-column">
	
		<h2> Items in your cart </h2>
	
		<table>
		
			<tr>
				<th>Category</th>
				<th>Brand</th>
				<th>Model</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
			
			<c:forEach var="varItem" items="${cartItems}"> 
			
					<!-- construct "Delete" link with Article id -->
					<c:url var="deleteLink" value="/cart-delete">
						<c:param name="ArticleId" value="${varItem.id}" />
					</c:url>
			
				<tr>
					<td>${varItem.category}</td>
					<td>${varItem.brand}</td>
					<td>${varItem.model}</td>
					<td>${varItem.price} PLN</td>
					<td><a id="x-smallStyleDeleteLink" href="${deleteLink}">Delete</a>
				</tr>
			</c:forEach>
			
		</table>
		
	</div>
	
	<footer>
		<p>&copy; 2018 Aleksander</p>
	</footer>

</body>

</html>
