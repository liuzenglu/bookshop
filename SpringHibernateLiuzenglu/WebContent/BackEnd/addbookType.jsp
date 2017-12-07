<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
   <c:set var="ctx" value="${pageContext.request.contextPath}" />
  			<table border="1">
    		<th>图书类型</th>
    			<c:forEach  items="${bookTypeListEnd}" var="bookTypeList">
    			<tr>
    				<td>${bookTypeList.type_name}</td>
    			</tr>
    			</c:forEach>
   			</table>
   			<div>
   			<h4>增加图书类型</h4>
   				<form action="${ctx}/bookType/addBookType.do">
					<input type="text" name="book_type_name" />
					<input type="submit" value="增加"/>   				
   				</form>
   			</div>