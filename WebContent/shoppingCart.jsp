<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1" session="true" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
</head>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/res/css/Style.css"
	type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/res/Javascript/Login.js">
	;
</script>
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



<body>


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










${myAccount}
	<h2 >Shopping Cart</h2>

	<c:if test="${not empty list }">
	

			<p>Total price = $${cart_price}</p>




			<legend> Payment </legend>

			<a class="btn btn-primary" href="paymentPage.jsp"
				style="border-radius: 24px; background-color: #002EFF !important;">Payment</a>
			<br /> <br />




			<c:forEach var="item" items="${list}">
				<div >
					<ul >
						<li >${item.title}</li>
						<li class="list-group-item"><img src="${item.coverart}" width="160"
							height="210" style="padding: 10px;" /> <br />
							<p>price = $${item.price}</p> <br />
							<p>quantity = ${item.quantity}</p></li>
							<br/>
						<li><a
							href="${pageContext.request.contextPath}/BookGet?book=${item.bid}"
							class="btn btn-primary" style="border-radius: 26px; background-color: #002EFF !important;">Details</a></li>
						<br></br>
						<br></br>
						<li><a
							href="${pageContext.request.contextPath}/CtrlCart?book=${item.bid}&amp;cart=remove"
							class="btn btn-primary" style="border-radius: 26px; background-color: #002EFF !important;">Remove</a></li>
						<br></br>
						<br></br>
						<li><a
							href="${pageContext.request.contextPath}/CtrlCart?book=${item.bid}&amp;cart=increment"
							class="btn btn-primary" style="border-radius: 26px; background-color: #002EFF !important;">Increment</a></li>
						<br></br>
						<br></br>
						<li><a
							href="${pageContext.request.contextPath}/CtrlCart?book=${item.bid}&amp;cart=decrement"
							class="btn btn-primary" style="border-radius: 26px; background-color: #002EFF !important;">Decrement</a></li>
						<br></br>
						<br></br>
					</ul>
				</div>
			</c:forEach>


		
	</c:if>


























</body>
	</html>
</jsp:root>