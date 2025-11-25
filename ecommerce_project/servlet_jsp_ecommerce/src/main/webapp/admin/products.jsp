<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><head><title>Admin - Products</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head><body><div class="container mt-4">
<h2>Products (Admin)</h2>
<a class="btn btn-primary mb-2" href="${pageContext.request.contextPath}/admin/product-form">Add product</a>
<table class="table"><thead><tr><th>ID</th><th>Name</th><th>Price</th><th>Stock</th><th>Actions</th></tr></thead><tbody>
  <c:forEach var="p" items="${products}">
    <tr>
      <td>${p.id}</td>
      <td>${p.name}</td>
      <td>₹ ${p.price}</td>
      <td>${p.stock}</td>
      <td>
        <a class="btn btn-sm btn-secondary" href="${pageContext.request.contextPath}/admin/product-form?id=${p.id}">Edit</a>
        <a class="btn btn-sm btn-danger" href="${pageContext.request.contextPath}/admin/product-delete?id=${p.id}">Delete</a>
      </td>
    </tr>
  </c:forEach>
</tbody></table>
</div></body></html>
