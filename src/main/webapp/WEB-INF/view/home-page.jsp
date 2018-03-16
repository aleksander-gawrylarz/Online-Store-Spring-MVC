<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title>Home-Page</title>
	
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
	
</head>

<body>

	<header>
		<h2>Welcome to myStore.pl</h2>
	</header>
	
	<div id="sidenav">
	
		<h2>Category</h2>
	
		<nav>
			<ul>
				<li> <a href="/category/laptops">Laptops</a> </li>
				<li> <a href="/category/smartphones">Smartphones</a> </li>
			</ul>
		</nav>
	</div>
	
	<div id="right-column">
		<h3>My Cart</h3>
		<p> In my Cart: ${inMyCart.size()} </p>
		<a href="/cart/list">My Cart</a>
	</div>
	
	<div id="main-column">
	
	
		<table id="featured-products">
		
			<tr>
				<th><font size="10">Featured Products</font></th>
			</tr>
			
			<c:forEach var="varItem" items="${articles}">
			
					<!-- construct "Add to Cart" link with Article id -->
					<c:url var="addToCartLink" value="/cart-add">
						<c:param name="ArticleId" value="${varItem.id}" />
					</c:url>
				<tr>
					<td>${varItem.brand} ${varItem.model}<br>Price ${varItem.price} PLN<br><a href="${addToCartLink}">Add to Cart</a></td>
				</tr>
			</c:forEach>
			
		</table>
	
	</div>
	
	<footer>
		<p>&copy; 2018 Aleksander</p>
	</footer>

</body>

</html>