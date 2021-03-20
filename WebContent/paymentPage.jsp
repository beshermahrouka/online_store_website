<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:c="http://java.sun.com/jsp/jstl/core" 
xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1" 
		pageEncoding="ISO-8859-1" session="true"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
</head>
<title>main page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/Style.css" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/res/Javascript/Login.js">;</script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/mdb.min.css" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/res/Javascript/jquery.min.js">;</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/Javascript/bootstrap.min.js">;</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/Javascript/mdb.min.js">;</script>


<link rel="StyleSheet" href="${pageContext.request.contextPath}/res/mc.css" type="text/css" title="cse4413" media="screen, print" />
<body>

  <nav class="navbar navbar-light bg-light">
    <div class="container">
			<a class="btn btn-primary" href="mainPage.jsp" style="border-radius: 26px;background-color: #002EFF !important;">Home</a>
						
			<a class="btn btn-primary" href="${pageContext.request.contextPath}/CtrlCart?cart=view" style="border-radius: 26px;background-color: #002EFF !important;">shopping cart</a>	
			
			<a class="btn btn-primary" href="loginPage.jsp" style="border-radius: 26px;background-color: #002EFF !important;">Login</a>	
					
			<a class="btn btn-primary" href="${pageContext.request.contextPath}/UserCtrl?logout=true" style="border-radius: 26px;background-color: #002EFF !important;">Logout</a>			
    </div>
  </nav>







<c:if test="${not empty myAccount }">




 ${myAccount}
 <p>Billing and shipping addresses must be the same !!! </p>
	<h2>Login Page</h2>
	<br/>
	<p>${error2}</p>
	<br/>
	<h4>     ${paysuc}               </h4>
	<form action="PayCtrl" class="osapForm" method='POST'>
		 <fieldset>
        <legend> Payment </legend>
        <br/>
        
             
        <div class = "Osap_form">   
			
				 <label for="billing">billing address: </label>
				<input name="billing" id="billing" type="string" />
				
				 <label for="shipping">shipping address: </label>
				<input name="shipping" id="shipping" type="string" value= "${useraddress.addressToString()} "/>
			
			
			
				 <label for="credit" >credit card number: </label>
				 <input name="credit" id="credit" type="string"/> 
			
			
			  <input type="hidden" id="gopayment" name="gopayment" value=""/>
			  
			  <br/>
				
				<button class="button2" type="submit" name="pay" value="submit">pay!!</button>
				
		</div>		
	   </fieldset>		
	</form>



</c:if>






























 ${myAccount}
<c:if test="${ myAccount eq null }">

   <p>login before payment !! then go back to payment page</p>
	<h2>Login Page</h2>
	<br/>
	<p>${error}</p>
	<form action="UserCtrl" class="osapForm" method='POST'>
		 <fieldset>
        <legend> Login </legend>
        <br/>
        
             
        <div class = "Osap_form">   
			
				 <label for="username">Username: </label>
				<input name="username" id="username" type="string"/>
			
			
			
				 <label for="password" >Password: </label>
				 <input name="password" id="password" type="password"/> 
			
			
			  <br/>
				
				<button class="button2" type="submit" name="login" value="submit">Login</button>
				
		</div>		
	   </fieldset>		
	</form>
  
  <br/>
  
  <a href="registerPage.jsp" class="btn btn-primary"   style="border-radius: 26px;background-color: #002EFF !important;">Register </a>
  

</c:if>
















</body>
</html>
</jsp:root>