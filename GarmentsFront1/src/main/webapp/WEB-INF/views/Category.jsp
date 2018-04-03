<%@include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>

<h3 align="center">Category Page</h3>
<body background="http://orig11.deviantart.net/20eb/f/2015/030/6/f/_minflat__dark_material_design_wallpaper__4k__by_dakoder-d8fjqzu.jpg"><div class="container"></div>
<form action="InsertCategory" method="post">
	<table align="center">
		<tr>
			<td>Category Name</td>
			<td><input type="text" id="catname" name="catname" /></td>
		</tr>
		<td>Category Description</td>
		<td><input type="text" id="catdesc" name="catdesc" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="SUBMIT" /> <input
				type="reset" value="RESET" /></td>
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
			<td><a
				href="<c:url value="/updateCategory/${category.categoryId}"/>">Update</a>/
				<a href="<c:url value="/deleteCategory/${category.categoryId}"/>">Delete</a>
			</td>
		</tr>
	</c:forEach>

</table>

</body>
</html>

