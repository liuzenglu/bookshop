<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
   <c:set var="ctx" value="${pageContext.request.contextPath}" />
  <table border="1">
    		<th>admin_id</th><th>admin_username</th><th>admin_realname</th>
    		<c:forEach  items="${adminList}" var="adminList">
    			<tr>
    				<td>${adminList.admin_id}</td>
    				<td>${adminList.admin_username}</td>
    				<td>${adminList.admin_realname}</td>
    			</tr>
    			</c:forEach>
   			</table>