<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
		
		.container-fluid
		{
		background-color:yellow;
		}
	</style>
</head>
<body>

<center>
<!-- <a href="login">Login</a>&nbsp;&nbsp;|&nbsp;&nbsp;
<a href="aboutus">About Us</a>&nbsp;&nbsp;|&nbsp;&nbsp;
<a href="contactus">Contact Us</a>&nbsp;&nbsp;|&nbsp;&nbsp;
<a href="all/registrationform">SignUp</a>&nbsp;&nbsp;|&nbsp;&nbsp;
<a href="category">Category</a>&nbsp;&nbsp;|&nbsp;&nbsp;
<a href="product">Product</a>&nbsp;&nbsp;|&nbsp;&nbsp; -->
<li> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>      
       <%-- <c:forEach items="${categories}" var="c">
      <c:url value="all/viewallproducts?searchCondition=${c.categoryId}" var="url"></c:url>
      <li>
      <a href="${url}" >${c.categoryName } </a>
       </li>
       </c:forEach> --%>
       <ul class="nav navbar-nav navbar-right">
       <c:forEach items="${categories}" var="c">
      <c:url value="all/viewallproducts?searchCondition=${c.categoryId}" var="url"></c:url>
      <li>
      <a href="${url}" >${c.categoryName } </a>
       </li>
       </c:forEach>
       
       
      		<c:url value="/cart/getcart" var="cart"></c:url>
	      	<security:authorize access="hasRole('ROLE_USER')">
	      	
	      <ul class="nav navbar-nav navbar-right">
      		<li><a href=${cart}><span class="glyphicon glyphicon-shopping-cart"></span>Cart</a></li>
      		</ul>
			</security:authorize>
			 <c:url value="/admin/category" var="category"></c:url>
			<c:url value="/admin/add" var="product"></c:url>
			<security:authorize access="hasRole('ROLE_ADMIN')">
			<ul class="nav navbar-nav navbar-right">
			<li><a href=${category}><span class="glyphicon glyphicon-th-list">Category</span></a></li>
			<li><a href=${product}><span class="glyphicon glyphicon-th">Product</span></a></li> 
			
			</ul>     		
	         </security:authorize> 
			<c:if test="${pageContext.request.userPrincipal.name==null }">
			<li><a href="login"> <span class="glyphicon glyphicon-log-in"> </span> Login</a></li> 
			<li><a href="all/registrationform"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
			</c:if>
			<c:if test="${pageContext.request.userPrincipal.name!=null }">
			<li><a href="">Welcome ${pageContext.request.userPrincipal.name}</a></li>
			<li><a href="<c:url value='/j_spring_security_logout'></c:url>"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</c:if>			
			</ul>
 
</center>
</body>

</body>
</html>