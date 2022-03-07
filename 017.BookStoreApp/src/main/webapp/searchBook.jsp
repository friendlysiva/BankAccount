<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.sql.*"%>

<html>
    <head>
        
        <title>JSP Page</title>
    </head>
    <body><center>
       <%
       //int id=Integer.parseInt(request.getParameter("id"));
       String id=request.getParameter("code");

         Connection con=null;
         Statement stmt=null;
         ResultSet rs=null;
         try
         {
             Class.forName("com.mysql.cj.jdbc.Driver");
             //System.out.println("driver loaded");
         }catch(ClassNotFoundException cnfe){ out.print(cnfe.getMessage());}
         
         try
         {
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","sivakumar");
             stmt=con.createStatement();
             rs=stmt.executeQuery("select * from product1 where code="+id);
            %>
             <table border='2' bgcolor='cyan' bordercolor='pink' cellspacing='5' cellpadding='5'>
                 <tr><th>Emp Id</th><th>First Name</th><th>Last Name</th><th>Address</th>
                <th>Action1</th><th>Action2</th>
                 
             <%
              String mid;
             while(rs.next())
             {   mid=rs.getString(1);  %>
                <tr><td><%=mid %>></td><td><%=rs.getString(2)%></td><td><%=rs.getString(3)%></td><td><%=rs.getString(4)%></td>
                
                <td><a href="Modify.jsp?empid=<%=mid%>" >Modify</a></td>
                <td><a href="Delete.jsp?empid=<%=mid%>" >Remove</a></td>
             
             
                </tr>
                             <%   
             }%>
             <tr><td colspan="7" align="center"><a href="Addition.jsp">Add New Record</a></td></tr>  
        <!--   <tr><td colspan="7" align="center"><a href="UploadExcelFile.jsp">Add New Records By Excel File</a></td></tr> -->  
          <tr><td colspan="7" align="center"><input type='button' value='Exit' onClick='window.close();'></td></tr>
        <% }catch(Exception e){ out.print(e.getMessage());}
%>
    </center></table></body>
</html>
