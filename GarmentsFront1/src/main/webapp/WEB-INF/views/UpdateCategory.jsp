<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<h3 align="center">Category Page</h3>

<form action="<c:url value="/UpdateCategory"/>" method="post">
<table align="center">
<tr bgcolor="pink">
<td colspan="2">Update Category</td>
</tr>
<tr bgcolor="cyan">
	<td>Category ID</td>
	<td><input type="text" readonly id="catid" name="catid" value="${categoryInfo.categoryId}"/></td>
</tr>
<tr bgcolor="cyan">
	<td>Category Name</td>
	<td><input type="text" id="catname" name="catname" value="${categoryInfo.categoryName}"/></td>
</tr>
	<td>Category Description</td>
	<td><input type="text" id="catdesc" name="catdesc" value="${categoryInfo.categoryDescription}"/></td>
</tr>
<tr bgcolor="cyan">
	<td colspan="2"><center>
	<input type="submit" value="Update"/>
	<input type="reset" value="RESET"/>
	</center></td>
</tr>
</table>
</form>

<table align="center">
	<tr>
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Description</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${listCategories}" var="category">
	<tr>
		<td>${category.categoryId}</td>
		<td>${category.categoryName}</td>
		<td>${category.categoryDescription}</td>
		<td>
		<a href="<c:url value="/updateCategory/${category.categoryId}"/>">Update</a>/
		<a href="<c:url value="/deleteCategory/${category.categoryId}"/>">Delete</a>
		</td>
	</tr>
	</c:forEach>
	
</table>

</body>
</html>
