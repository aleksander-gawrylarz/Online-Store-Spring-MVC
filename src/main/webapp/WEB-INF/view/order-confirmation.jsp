<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title>Checkout</title>
	
	<link href="/css/main.css" rel="stylesheet"/>
	
</head>

<body>

	<header>
		<p>Welcome to myStore.pl</p>
	</header>

	<div id="sidenav">
		<a id="styleLink" href="/cart-empty">Continue shopping</a>
		
	</div>
	
	<div id="right-column">
		
	</div>
	
	<div id="main-column">
	
		<h2>Thank you for your purchase</h2>
		<h3>We will ship your products based on below shipping information</h3>
		<br>
		<i>First Name:</i> ${shippingForm.firstName}
		<br>
		<i>Last Name:</i> ${shippingForm.lastName}
		<br>
		<i>Email:</i> ${shippingForm.email}
		<br>
		<i>Phone Number:</i> ${shippingForm.phoneNumber}
		<br>
		<i>Street Address:</i> ${shippingForm.streetAddress}
		<br>	
		<i>City:</i> ${shippingForm.city}
		<br>
		<i>Postal Code:</i> ${shippingForm.postalCode}
		<br>
		<br>
		
		<h2> Order Summary </h2>
	
		<table>
			<tr>
				<th>Brand</th>
				<th>Model</th>
				<th>Price</th>
			</tr>
			
			<c:forEach var="varItem" items="${cartItems}"> 
				<tr>
					<td>${varItem.brand}</td>
					<td>${varItem.model}</td>
					<td>${varItem.price} PLN</td>
					
				</tr>
			</c:forEach>
			
		</table>
		
		<br>
		<p style="font-size: large"> Total price:  ${totalPrice} PLN </p>
			
	</div>
	
	<footer>
		<p>&copy; 2018 Aleksander</p>
	</footer>

</body>

</html>
