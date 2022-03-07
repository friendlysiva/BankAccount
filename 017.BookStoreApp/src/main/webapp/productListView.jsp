<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%@page import="java.util.*"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="menu.jsp"></jsp:include>

    <h3>Product List</h3>

    <p style="color: red;">${errorString}</p>

   
       <% 
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con=null;
       ResultSet rs=null;
       Statement st=null;
       try{
    	   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","sivakumar");
    	   st=con.createStatement();
    	   rs=st.executeQuery("select * from product1");
       }catch(Exception e){
    	   System.out.println(e.getMessage());
       }
       
       
       %>
       
        <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Code</th>
          <th>Name</th>
          <th>Price</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <%
       int i=1;
       while(rs.next()){
    	   String code=rs.getString(1);
    	   String name=rs.getString(2);
    	   float price=rs.getFloat(3);
       
       %>
       
           <tr> 
           <td width="10%" class="loginhead1" align="center"><%=code%></td>
       <td width="19%" class="loginhead1" align="center"><%=name%></td>
       <td width="10%" class="loginhead1" align="center"><%=price%></td>
       <td>
                <a href="createProductview.jsp?code=<%=code %>">Edit</a>
             </td>
             <td>
                <a href="deleteProduct?code=${product.code}">Delete</a>
             </td>
       </tr>
      <% i++;
      }
      rs.close();
      st.close();
      con.close();
      
      %>
    </table>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>