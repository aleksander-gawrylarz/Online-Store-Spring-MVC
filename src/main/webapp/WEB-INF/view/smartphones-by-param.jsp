<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title>Smartphones</title>
	
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

</head>

<body>

	<header>
		<h2>Welcome to myStore.pl</h2>
	</header>

	<div id="sidenav">
	
		<h2>Smartphones</h2>
		
		<nav>
			<ul>
				<li> <a href="/category/smartphones">All Smartphones</a> </li>
			</ul>
		</nav>
		
		<h3>Screen Size</h3>
		
		<nav>
			<ul>
				<c:forEach var="varItem" items="${screenSizeList}"> 
				
					<c:url var="screenLink" value="/category/smartphones-by-screen-size">
						<c:param name="screenSize" value="${varItem}" />
					</c:url>
				
					<li> <a href="${screenLink}">${varItem}</a> </li>
					
				</c:forEach>
			</ul>
		</nav>
		
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
				<th>Screen Size</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
			
			<c:forEach var="varItem" items="${smartphones}"> 
			
					<!-- construct "Add to Cart" link with Article id -->
					<c:url var="addToCartLink" value="/cart-add">
						<c:param name="ArticleId" value="${varItem.id}" />
					</c:url>
			
				<tr>
					<td>${varItem.id}</td>
					<td>${varItem.brand}</td>
					<td>${varItem.model}</td>
					<td>${varItem.screenSize}</td>
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