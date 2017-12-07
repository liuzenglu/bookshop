<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
   <c:set var="ctx" value="${pageContext.request.contextPath}" />
  <table border="1">
    		<th>user_id</th><th>user_username</th><th>user_email</th>
    		<th>user_telephone</th><th>user_address</th><th>posttime</th>
    		<th>删除</th>
    			<c:forEach  items="${userlist}" var="userlist">
    			<tr>
    				<td>${userlist.user_id}</td>
    				<td>${userlist.user_username}</td>
    				<td>${userlist.user_email}</td>
    				<td>${userlist.user_telephone}</td>
    				<td>${userlist.user_address}</td>
    				<td>${userlist.posttime}</td>
    				<td><a href="${ctx}/user/deleteUser.do?user_id=${userlist.user_id}">删除</a></td>
    			</tr>
    			</c:forEach>
   			</table>