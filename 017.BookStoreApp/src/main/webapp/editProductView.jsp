<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
      <jsp:include page="menu.jsp"></jsp:include>

      <h3>Edit Product</h3>

      <p style="color: red;">${errorString}</p>

      <c:if test="${not empty product}">
         <form method="POST" action="${pageContext.request.contextPath}/editProduct">
            <input type="hidden" name="code" value="${product.code}" />
            <table border="0">
               <tr>
                  <td>Code</td>
                  <td style="color:red;">${product.code}</td>
               </tr>
               <tr>
                  <td>Name</td>
                  <td><input type="text" name="name" value="${product.name}" /></td>
               </tr>
               <tr>
               <td>Edition</td>
               <td><input type="text" name="edition" value="${product.edition}" /></td>
            </tr>
            <tr>
               <td>Author</td>
               <td><input type="text" name="author" value="${product.author}" /></td>
            </tr>
            <tr>
               <td>Quantity</td>
               <td><input type="text" name="quantity" value="${product.quantity}" /></td>
            </tr>
               <tr>
                  <td>Price</td>
                  <td><input type="text" name="price" value="${product.price}" /></td>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/productList">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>

      <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>