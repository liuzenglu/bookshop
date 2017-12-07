<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
   <c:set var="ctx" value="${pageContext.request.contextPath}" />
  			<table border="1">
    		<th>user_username</th><th>order_id</th><th>book_name</th><th>count</th><th>orderState</th>
    			<c:forEach  items="${orderDetaillist}" var="orderDetaillist">
    			<tr>
    				<td>${orderDetaillist.order.user.user_username}</td>
    				<td>${orderDetaillist.order.order_id}</td>
    				<td>${orderDetaillist.book.book_name}</td>
    				<td>${orderDetaillist.count}</td>
    				<td>${orderDetaillist.order.orderstate.order_State}</td>
    			</tr>
    			</c:forEach>
   			</table>