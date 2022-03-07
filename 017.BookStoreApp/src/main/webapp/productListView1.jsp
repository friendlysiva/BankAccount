<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <style>
table, th, td {
  border: 1px solid white;
  border-collapse: collapse;
}
th, td {
border-color: black;
  background-color: #96D4D4;
}
</style>
 </head>
 <body>

    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="menu.jsp"></jsp:include>

    <h3>Product List</h3>

    <p style="color: red;">${errorString}</p>

    <table >
       <tr>
          <th>Code</th>
          <th>Name</th>    
          <th>Edition</th>
          <th>Author</th>
          <th>Quantity</th>
          <th>Price</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${product}" var="product" >
          <tr>
             <td>${product.code}</td>
             <td>${product.name}</td>
             <td>${product.edition}</td>
             <td>${product.author}</td>
             <td>${product.quantity}</td>
             <td>${product.price}</td>
             <td>
                <a href="editProduct?code=${product.code}">Edit</a>
             </td>
             <td>
                <a href="deleteProduct?code=${product.code}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>

    <a href="createProduct" >Create Product</a>

    <jsp:include page="footer.jsp"></jsp:include>

 </body>
</html>