<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
   <c:set var="ctx" value="${pageContext.request.contextPath}" />
   <link rel="stylesheet" type="text/css" href="${ctx}/BookStore/style3.css" />
   
   <div class="title"><span class="title_icon"><img src="${ctx}/BookStore/images/bullet1.gif" alt="图片" title="" /></span>${oneBookType}类</div>
  	 <c:forEach items="${oneBookTypeBook}" var="oneBookTypeBook">
		      <div class="feat_prod_box">
				       <div class="prod_img"><a href="${ctx}/book/details.do?book_id=${oneBookTypeBook.book_id}"><img style="width: 60px;height: 80px;"src="../${oneBookTypeBook.book_imgurl}" alt="图片" title="" border="0" /></a></div>
				       <div class="prod_det_box">
				       <div class="box_top"></div>
				       <div class="box_center">
				           <div class="prod_title">${oneBookTypeBook.book_name}</div>
				           <p class="details">${oneBookTypeBook.book_description}</p>
				           <a href="${ctx}/book/details.do?book_id=${oneBookTypeBook.book_id}" class="more">- 更多细节 -</a>
				           <div class="clear"></div>
				       </div>
			       <div class="box_bottom"></div>
				       </div>
				       <div class="clear"><a href="${ctx}/book/addCart.do?book_id=${oneBookTypeBook.book_id}">加入购物车</a></div>     	
		      </div>
      </c:forEach>