<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1" session="true" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/res/css/Style.css"
	type="text/css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/res/css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/res/css/mdb.min.css"
	type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/res/Javascript/jquery.min.js">
	;
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/res/Javascript/bootstrap.min.js">
	;
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/res/Javascript/mdb.min.js">
	;
</script>


<link rel="StyleSheet"
	href="${pageContext.request.contextPath}/res/mc.css" type="text/css"
	title="cse4413" media="screen, print" />












</head>
<body>

	<!-- Navigation -->
	<nav class="navbar navbar-light bg-light">
		<div class="container">
			<a class="btn btn-primary" href="mainPage.jsp"
				style="border-radius: 26px; background-color: #002EFF !important;">Home</a>
			<a class="btn btn-primary"
				href="${pageContext.request.contextPath}/CtrlCart?cart=view"
				style="border-radius: 26px; background-color: #002EFF !important;">shopping
				cart</a> <a class="btn btn-primary" href="${pageContext.request.contextPath}/UserCtrl?logout=true"
				style="border-radius: 26px; background-color: #002EFF !important;">Logout</a>
		</div>
	</nav>




	<h2>Register</h2>
	<p>${error}</p>
	<form action='UserCtrl' method='POST'>
		<fieldset>
			<legend> Register </legend>
			<br />


			<div class="Osap_form">

				<label for="user_name">UserName: </label> <input name="new_username"
					id="new_username" type="string" /> <br /> <label for="email">Email:
				</label> <input name="email" id="email" type="string" /> <br /> <label
					for="new_password">Password: </label> <input name="new_password"
					id="new_password" type="String" /> <br /> <br /> <label
					for="name">Name: </label> <br /> <input name="firstname"
					id="firstname" placeholder="First Name" type="string" /> <br /> <input
					name="lastname" id="lastname" placeholder="Last Name" type="string" />
				<br /> <label for="streetname">Street Address: </label> <br /> 
				<input name="streetname" id="streetname" type="string" /> <br />
				<label for="province">Province: </label> <input name="province" id="province" type="string" /> <br />
				<label for="country">country: </label> <input name="country" id="country" type="string" /> <br />
				<label for="postal">Postal: </label> <input name="postal" id="postal" type="string" /> <br />
				<label for="phone">Phone: </label> <input name="phone" id="phone" type="string" /> <br /> <br />
				


				<button class="button2" type="submit" name="register" value="submit">Register</button>




			</div>
		</fieldset>




	</form>






</body>
	</html>
</jsp:root>