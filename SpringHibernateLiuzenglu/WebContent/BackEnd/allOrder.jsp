<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
   <c:set var="ctx" value="${pageContext.request.contextPath}" />
  			<table border="1">
    		<th>user_username</th><th>order_time</th><th>orderState</th>
    		<th>删除</th><th>详情显示</th>
    			<c:forEach  items="${orderlist}" var="orderlist">
    			<tr>
    				<td>${orderlist.user.user_username}</td>
    				<td>${orderlist.order_time}</td>
    				<td>${orderlist.orderstate.order_State}</td>
    				<td><a href="${ctx}/order/deleteOrder.do?order_id=${orderlist.order_id}">删除</a></td>
    				<td><a href="${ctx}/orderdetail.do?order_id=${orderlist.order_id}">显示详情</a></td>
    			</tr>
    			</c:forEach>
   			</table>