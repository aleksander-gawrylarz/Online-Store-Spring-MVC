<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title>Laptops</title>
	
	<link href="/css/main.css" rel="stylesheet"/>

</head>

<body>

	<header>
		<h2>Welcome to myStore.pl</h2>
	</header>

	<div id="sidenav">
	
		<h2>Laptops</h2>
		
		<nav>
			<ul>
				<li> <a href="/category/laptops">All Laptops</a> </li>
			</ul>
		</nav>
		
		<h3>Brand</h3>
		
		<nav>
			<ul>
				<c:forEach var="varItem" items="${brands}"> 
				
					<c:url var="brandLink" value="/category/laptops-by-brand">
						<c:param name="brand" value="${varItem}" />
					</c:url>
				
					<li> <a href="${brandLink}">${varItem}</a> </li>
					
				</c:forEach>
			</ul>
		</nav>
		
		<h3>Price</h3>

		<form action="/category/laptops-by-price">
			<input type="text" name="minPrice" size="8" placeholder="min">
			<input type="text" name="maxPrice" size="8" placeholder="max">
			<input type="submit" value="Search">
		</form>

		<br>
		<br>
		<a href="/">Back to home page</a>
		
	</div>
	
	<div id="right-column">
		<h3>My Cart</h3>
		<p> In my Cart: ${inMyCart.size()} </p>
		<a href="/cart/list">My Cart</a>
	</div>
	
	<div id="main-column">

		<table>
		
			<tr>
				<th>id</th>
				<th>Brand</th>
				<th>Model</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
			
			<c:forEach var="varItem" items="${laptops}"> 
			
					<!-- construct "Add to Cart" link with Article id -->
					<c:url var="addToCartLink" value="/cart-add">
						<c:param name="ArticleId" value="${varItem.id}" />
					</c:url>
			
				<tr>
					<td>${varItem.id}</td>
					<td>${varItem.brand}</td>
					<td>${varItem.model}</td>
					<td>${varItem.price}</td>
					<td><a href="${addToCartLink}">Add to Cart</a></td>
				</tr>
				
			</c:forEach>
			
		</table>
	
	</div>
	
	<footer>
		<p>&copy; 2018 Aleksander</p>
	</footer>

</body>

</html>
