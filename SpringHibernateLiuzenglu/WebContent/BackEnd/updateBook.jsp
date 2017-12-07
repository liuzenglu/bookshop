<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
   <c:set var="ctx" value="${pageContext.request.contextPath}" />
  		
		</br>===========================================================================
   	<form:form modelAttribute="book" action="${ctx}/book/updateBook.do?book_id=${book.book_id}" method="post" enctype="multipart/form-data">
			 <form:hidden path="book_id"/>
		图书名：<form:input path="book_name"/><br/>
		作者：<form:input path="book_author"/><br/>
		描述：<form:input path="book_description"/><br/>
		出版社：<form:input path="book_publisher"/><br/>
		价格：<form:input path="book_price"/><br/>
		图片：<img  style="width: 50px;height: 50px;" alt="tupain" src="../${book.book_imgurl}"/>
			<input type="file" name="book_imgurl"/><br/>
		类型：<form:radiobuttons path="bookType.type_name" items="${bookTypelist}"/><br/>
	
		状态：
			<c:forEach  items="${allbookState2}" var="allbookState2" varStatus="status2">
				<c:set var="flg" value="false"/>
				<c:forEach items="${onebookState1}" var="bookState1" varStatus="status">
					<c:if test="${status.current.bookState_id == status2.current.bookState_id}"> 
					<c:set var="flg" value="true"/>
					</c:if>
				</c:forEach>
				<c:if test="${flg==true}">
					<label><input name="bookState_id"  type="checkbox" checked="checked" value="${status2.current.bookState_id}" />${status2.current.book_State}</label>
				</c:if>
					
				<c:if test="${flg==false}">
					<label><input name="bookState_id"  type="checkbox"  value="${status2.current.bookState_id}" />${status2.current.book_State}</label>
				</c:if>
			</c:forEach>
		<input type="submit" value="修改"/>
	</form:form>