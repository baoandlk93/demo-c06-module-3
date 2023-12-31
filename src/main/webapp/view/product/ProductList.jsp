<%--
  Created by IntelliJ IDEA.
  User: AN HA
  Date: 10/3/2023
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
</head>
<body>
<h1 class="text-center">Product List</h1>
<a href="${pageContext.request.contextPath}/products?action=create" class="btn btn-info">Create Product</a>
<table class="table table-striped-columns">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
        <th scope="col">Description</th>
        <th scope="col">image</th>
        <th scope="col">Category</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach varStatus="status" var="product" items="${products}">
        <tr>
            <th scope="col">${status.count}</th>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>${product.image}</td>
            <c:forEach varStatus="status" var="category" items="${categories}">
                <c:if test="${product.subCategoryId == category.id}">
                    <td>${category.name}</td>
                </c:if>
            </c:forEach>
            <td class="text-center">
                <a href="${pageContext.request.contextPath}/products?action=edit&id=${product.id}">
                    <span class="fa-solid fa-user-pen text-primary h4 m-auto"></span>
                </a>
            </td>
            <td>
                <a class="btn btn-danger" href="${pageContext.request.contextPath}/products?action=delete&id=${product.id}">
                    <i class="fa-solid fa-trash-can"></i>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
