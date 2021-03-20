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
<script type="text/javascript" src="${pageContext.request.contextPath}/res/Javascript/Login.js">;</script>
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











<h4> Admin page </h4>

<TABLE>
<p>Top 10 sold books</p>
				   <TR>
					   
						
						<TH>bid </TH>
						
					</TR>
				
			<c:forEach items="${newUpdate}" var="key">
				<TR>
				   
				   
				    <TD><c:out value="${key}"/></TD>
				    
				</TR>
			</c:forEach>
</TABLE>



<br/>

 <form action="PayCtrl" method="POST"  class="sisForm" >
     <fieldset>
		<legend>
				<label for="legend">   System to get sold book report      </label>
		</legend>
		
		<div class = "sis_form"> 
		
	    <label for="TheMonth"> choose month: </label> <br/> 
	    <input id='TheMonth' name='TheMonth' type="text" style="width: 200px" ></input>
	   
	  
	   
	   
	    <br/>	    
		<button action='submit' name='soldmonth' label='report' value="true">Report</button>
		</div>
	</fieldset>
    
  </form>








  	<c:choose>
			<c:when test="${numberOfResultsSold gt -1}">
				There are ${numberOfResultsSold} entries.<br />
				<TABLE>
				   <TR>
					   
						<TH>month </TH>
						<TH>bid </TH>
						<TH>event type</TH>
					</TR>
				
			<c:forEach items="${result_sold}" var="key">
				<TR>
				   
				   <TD><c:out value="${m}" /></TD>
				    <TD><c:out value="${key.getBookBean().getBid()}" /></TD>
				    <TD><c:out value="PURCHASE" /></TD>
				</TR>
			</c:forEach>
			</TABLE>
			</c:when>
			<c:otherwise>
			</c:otherwise>
	</c:choose>

















</body>
</html>
</jsp:root>