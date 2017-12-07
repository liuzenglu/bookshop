<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 	<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="${ctx}/BookStore/style3.css" />
<link rel="stylesheet" href="${ctx}/BookStore/lightbox.css" type="text/css" media="screen" />
<script src="${ctx}/BookStore/js/prototype.js" type="text/javascript"></script>
<script src="${ctx}/BookStore/js/scriptaculous.js?load=effects" type="text/javascript"></script>
<script src="${ctx}/BookStore/js/lightbox.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/BookStore/js/java.js"></script>

      <div class="crumb_nav"> <a href="${ctx}/book/someBooklist.do">首页</a> &gt;&gt; ${book.book_name} </div>
      <div class="title"><span class="title_icon"><img src="${ctx}/BookStore/images/bullet1.gif" alt="" title="" /></span>${book.book_name}</div>
      <div class="feat_prod_box_details">
        <div class="prod_img"><img style="width: 60px;height: 80px;" src="../${book.book_imgurl}" alt="" title="" border="0" /> <br />
          <br />
          <a href="../${book.book_imgurl}" rel="lightbox"><img src="${ctx}/BookStore/images/zoom.gif" alt="" title="" border="0" /></a> </div>
        <div class="prod_det_box">
          <div class="box_top"></div>
          <div class="box_center">
            <div class="prod_title">介绍</div>
            <p class="details">${book.book_description}</p>
            <div class="price"><strong>作者:</strong> <span class="red">${book.book_author}</span></div>
            <div class="price"><strong>价格:</strong> <span class="red">${book.book_price}</span></div>
            <a href="${ctx}/book/addCart.do?book_id=${book.book_id}" class="more"><img src="${ctx}/BookStore/images/order_now.gif" alt="" title="" border="0" /></a>
            <div class="clear"></div>
          </div>
          <div class="box_bottom"></div>
        </div>
        <div class="clear"></div>
      </div>
      <div id="demo" class="demolayout">
        <ul id="demo-nav" class="demolayout">        
          <li><a class="" href="#tab2">相关书籍</a></li>
        </ul>
        <div class="tabs-container">
         
          <div  class="tab" id="tab2">
          <c:forEach items="${bookSet}" var="bookSet">
            <div class="new_prod_box"> <a href="${ctx}/book/details.do?book_id=${bookSet.book_id}">${bookSet.book_name}</a>
              <div class="new_prod_bg"> <a href="${ctx}/book/details.do?book_id=${bookSet.book_id}"><img  style="width: 60px;height: 80px;" src="../${bookSet.book_imgurl}" alt="" title="" class="thumb" border="0" /></a> </div>
            </div>
            </c:forEach>
            
            <div class="clear"></div>
          </div>
        </div>
      </div>
      <div class="clear"></div>

