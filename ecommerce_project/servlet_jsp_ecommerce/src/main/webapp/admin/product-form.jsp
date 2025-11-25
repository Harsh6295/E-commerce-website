<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><head><title>Product Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head><body><div class="container mt-4">
<h2><c:choose><c:when test='${not empty product}'>Edit</c:when><c:otherwise>Add</c:otherwise></c:choose> Product</h2>
<form method="post" action="${pageContext.request.contextPath}/admin/product-save">
  <input type="hidden" name="id" value="${product.id}" />
  <div class="mb-2"><label>Name</label><input class="form-control" name="name" value="${product.name}" required/></div>
  <div class="mb-2"><label>Description</label><textarea class="form-control" name="description">${product.description}</textarea></div>
  <div class="mb-2"><label>Price</label><input class="form-control" name="price" value="${product.price}" required/></div>
  <div class="mb-2"><label>Image URL</label><input class="form-control" name="imageUrl" value="${product.imageUrl}"/></div>
  <div class="mb-2"><label>Stock</label><input class="form-control" name="stock" value="${product.stock}" required/></div>
  <button class="btn btn-success">Save</button>
</form>
</div></body></html>
