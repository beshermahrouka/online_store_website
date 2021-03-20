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

<link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/Style.css" type="text/css" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/mdb.min.css" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/res/Javascript/jquery.min.js">;</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/Javascript/bootstrap.min.js">;</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/res/Javascript/mdb.min.js">;</script>



<body>


  <nav class="navbar navbar-light bg-light">
    <div class="container">
			<a class="btn btn-primary" href="mainPage.jsp" style="border-radius: 26px;background-color: #002EFF !important;">Home</a>
			<a class="btn btn-primary" href="${pageContext.request.contextPath}/CtrlCart?cart=view" style="border-radius: 26px;background-color: #002EFF !important;">shopping cart</a>			
			<a class="btn btn-primary" href="loginPage.jsp" style="border-radius: 26px;background-color: #002EFF !important;">Login</a>	
					
			<a class="btn btn-primary" href="${pageContext.request.contextPath}/UserCtrl?logout=true" style="border-radius: 26px;background-color: #002EFF !important;">Logout</a>			
    </div>
  </nav>




  <P>${myAccount}</P> 






 <h2 style="text-align: center">Book Details</h2>
	
	
	
	
	
	<form action='BookGet' method="POST" >
		 <fieldset>
        <legend> Book details </legend>
        <br/>          
        <div class = "Osap_form"> 
	
	
	
	
	
	
	
	
	
	
		<c:if test="${not empty book }">
			
			
				<p>${myAccount} </p>
			
						
			
			<c:forEach var="item" items="${book.values()}">
				<div >
					<ul >
						<li >${item.title}</li>
						<li class="list-group-item">
							<img src="${item.coverart}" width="160" height="210" style="padding:10px;"/>
							<br/>
							<p>  Author = ${item.author}</p>
							<br/>
						    <p> Category = ${item.category} </p>
						    <br/>
						    <p> Rate = ${reviewAvg} </p>
						    <br/>
						   <input type="hidden" id="reviewBookId" name="reviewBookId" value="${item.bid}"/>
						    <p> Price = $${item.price} </p>
						    <br/>
						    <p> description = ${item.description} </p> 
						</li>
						<br/>
						<a href="${pageContext.request.contextPath}/CtrlCart?book=${item.bid}&amp;cart=add"  class="btn btn-primary" style="border-radius: 25px;background-color: #002EFF !important;">Add to Cart</a>
						   <br></br>
                           <br></br>      
					
					</ul>
				</div>
			</c:forEach>
			
		
			
			<table>
				<tr><td><h1><b>Reviews</b></h1></td></tr>
				
				   <c:forEach var="reviewItem" items="${review.values()}">
				    	<tr>
				    	
						<td><h2><b>${reviewItem.rating}/5</b> by <br/> ${reviewItem.username}</h2></td>
						
						
						<td><p>${reviewItem.reviewdesc}</p></td>
					 </tr>
				</c:forEach>
				
			</table>
		




<br/>
              <c:if test="${not empty myAccount }">     
				<label for="rating">Rate the book: </label>
				
				<select id="reviewRating" name="reviewRating">
				  <option value="1">1</option>
				  
				  <option value="2">2</option>
				  
				  <option value="3">3</option>
				  <option value="4">4</option>
				  
				  <option value="5">5</option>
				</select>
				<br/><br/>



	       <p> write your review </p>
			<input id="myreview" name="myreview"/>
			<br/>
			<button class="button2" type="submit" name="addreview" value="true">add review</button>
</c:if>

<br/>
<br/>


	
			
</c:if>
</div>
</fieldset>
</form>




















</body>
</html>
</jsp:root>