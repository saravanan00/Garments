<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Product Information</h2>
      <%-- <form:form  action = "addpro" method="POST">
         <table>
            <tr>
               <td><form:label path = "productName">ProductName</form:label></td>
               <td><form:input path = "productName" /></td>
            </tr>
            <tr>
               <td><form:label path = "price">Price</form:label></td>
               <td><form:input path = "price" /></td>
            </tr>
            <tr>
               <td><form:label path = "stock">Stock</form:label></td>
               <td><form:input path = "stock" /></td>
            </tr>
             <tr>
               <td><form:label path = "productDesc">Product Description</form:label></td>
               <td><form:input path = "productDesc" /></td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
            </table>
            </form:form> --%>
            
      <form action="<c:url value="/UpdateProduct"/>" method="post">
	<table align="center">
	<tr>
			<td>Product Id</td>
			<td><input type="text" readonly id="proid" name="proid" value="${productInfo.productId}" /></td>
		</tr>
		<tr>
			<td>Product Name</td>
			<td><input type="text" id="proname" name="proname" value="${productInfo.productName}" /></td>
		</tr><tr>
		<td>Product Desc</td>
		<td><input type="text" id="prodesc" name="prodesc" value="${productInfo.prodDesc}" /></td>
		</tr>
		<tr>
		<td>Product Cost</td>
		<td><input type="text" id="procost" name="procost" value="${productInfo.price}"/></td>
		</tr><tr>
		<td>Product Stock</td>
		<td><input type="text" id="stock" name="stock" value="${productInfo.stock}"/></td>
		</tr>
		
		
				
		<tr>
			<td colspan="2"><input type="submit" value="SUBMIT" /> <input
				type="reset" value="RESET" /></td>
		</tr>
	</table>
</form>      
            
        <table align="center">
	<tr>
		<td>product ID</td>
		<td>product Name</td>
		<td>product Desc</td>
		<td>product cost</td>
		<td>product stock</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${listProducts}" var="product">
		<tr>
			<td>${product.productId}</td>
			<td>${product.productName}</td>
			<td>${product.prodDesc}</td>
			<td>${product.price}</td>
			<td>${product.stock}</td>
			
			<td><a
				href="<c:url value="/updateProduct/${product.productId}"/>">Update</a>/
				<a href="<c:url value="/deleteProduct/${product.productId}"/>">Delete</a>
			</td>
		</tr>
	</c:forEach>
	
</table>      
      
</body>
</html>