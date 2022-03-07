<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<div style="background: coral; height: 55px; padding: 5px;">
  <div style="float: left">
     <h3 style="color:white">Find the rarest ones here</h3>
  </div>
 <marquee width="60%" direction="right" height="20px" style="color:white"> Have a book and hold your dream <b></b></marquee>
  <div style="float: right; padding: 10px; text-align: right;">

     <!-- User store in session with attribute: loginedUser -->
    <b>${loginedUser.userName}</b>
   <br/>
     Search <input name="search">

  </div>

</div>