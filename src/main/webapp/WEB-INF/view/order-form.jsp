<%@  taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>

	<title>Checkout</title>
	
	<link href="/css/main.css" rel="stylesheet"/>
	
	<style>
		.error {color:red}
	</style>
	
</head>

<body>

	<header>
		<p>Welcome to myStore.pl</p>
	</header>

	<div id="sidenav">
		<a id="styleLink" href="/">Back to home page</a>
		
	</div>
	
	<div id="right-column">
		
	</div>
	
	<div id="main-column">
	
		<h2>Please fill below shipping form</h2>
	
		<form:form action="/confirmation" modelAttribute="shippingForm">
		
			First Name
			<br>
			<form:input type="text" id="text-field" path="firstName" size="50" placeholder=" First Name"/>
			<form:errors path="firstName" cssClass="error" />
			<br>
			Last Name
			<br>
			<form:input type="text" id="text-field" path="lastName" size="50" placeholder=" Last Name"/>
			<form:errors path="lastName" cssClass="error" />
			<br>
			Email
			<br>
			<form:input type="text" id="text-field" path="email" size="50" placeholder=" Email"/>
			<form:errors path="email" cssClass="error" />
			<br>
			Phone Number
			<br>
			<form:input type="text" id="text-field" path="phoneNumber" size="50" placeholder=" 111222333"/>
			<form:errors path="phoneNumber" cssClass="error" />
			<br>
			Street Address
			<br>
			<form:input type="text" id="text-field" path="streetAddress" size="50" placeholder=" Street Address"/>
			<form:errors path="streetAddress" cssClass="error" />
			<br>
			City
			<br>
			<form:input type="text" id="text-field" path="city" size="50" placeholder=" City"/>
			<form:errors path="city" cssClass="error" />
			<br>
			Postal Code
			<br>
			<form:input type="text" id="text-field" path="postalCode" size="50" placeholder=" Postal Code"/>
			<form:errors path="postalCode" cssClass="error" />
			
			<br><br>
			<input type="submit" id="button" value="Submit">
		</form:form>
		
	</div>
	
	<footer>
		<p>&copy; 2018 Aleksander</p>
	</footer>

</body>

</html>
