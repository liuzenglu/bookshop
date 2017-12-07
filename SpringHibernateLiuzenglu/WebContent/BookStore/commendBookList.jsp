<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 	<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="${ctx}/BookStore/style3.css" />

 <c:forEach items="${commendBookList}" var="commendBookList">
	        <div class="new_prod_box"> <a href="${ctx}/book/details.do?book_id=${commendBookList.book_id}">${commendBookList.book_name}</a>
	          <div class="new_prod_bg"> <span class="new_icon"></span> <a href="${ctx}/book/details.do?book_id=${commendBookList.book_id}"><img style="width: 60px;height: 80px;" src="../${commendBookList.book_imgurl}" alt="图片" title="" class="thumb" border="0" /></a> </div>
	        </div>
        </c:forEach>