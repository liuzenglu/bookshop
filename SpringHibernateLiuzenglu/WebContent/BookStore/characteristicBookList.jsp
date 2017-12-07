<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 	<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="${ctx}/BookStore/style3.css" />

      
      <c:forEach items="${characteristicBookList}" var="characteristicBookList">
		      <div class="feat_prod_box">
				       <div class="prod_img"><a href="${ctx}/book/details.do?book_id=${characteristicBookList.book_id}"><img style="width: 60px;height: 80px;"src="../${characteristicBookList.book_imgurl}" alt="图片" title="" border="0" /></a></div>
				       <div class="prod_det_box">
				       <div class="box_top"></div>
				       <div class="box_center">
				           <div class="prod_title">${characteristicBookList.book_name}</div>
				           <p class="details">${characteristicBookList.book_description}</p>
				           <a href="${ctx}/book/details.do?book_id=${characteristicBookList.book_id}" class="more">- 更多细节 -</a>
				           <div class="clear"></div>
				       </div>
				       <div class="box_bottom"></div>
				       </div>
				       <div class="clear"><a href="${ctx}/book/addCart.do?book_id=${characteristicBookList.book_id}">加入购物车</a></div>     	
		      </div>
      </c:forEach>
    
  
      
  
   <!--    <c:if test="${book != null}">
			<jsp:include page="details.jsp">
				<jsp:param name="details" value="${book}" />
				<jsp:param name="bookSet" value="${bookSet}" />
				
			</jsp:include>		
      </c:if>
 -->