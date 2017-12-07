<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 	<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="${ctx}/BookStore/style3.css" />

<div class="title"><span class="title_icon"><img src="${ctx}/BookStore/images/bullet1.gif" alt="" title="" /></span>我的购物车</div>
      <div class="feat_prod_box_details">
        <table class="cart_table">
          <tr class="cart_title">
            <td>图书图片</td>
            <td>图书名字</td>
            <td>图书价格</td>
            <td>图书数量</td>
            <td>总价</td>
            
          </tr>
          <c:forEach items="${orderDetailsSet}" var="orderDetailsSet">
          <tr>
            <td><a href="${ctx}/book/details.do?book_id=${orderDetailsSet.book.book_id}"><img style="width: 60px;height: 80px;"src="../${orderDetailsSet.book.book_imgurl}" alt="" title="" border="0" class="cart_thumb" /></a></td>
            <td>${orderDetailsSet.book.book_name}</td>
            <td>${orderDetailsSet.book.book_price}</td>
            <td>${orderDetailsSet.count}</td>
            <td>${orderDetailsSet.book.book_price * orderDetailsSet.count}</td>
           
          </tr>
          </c:forEach>
  
          <tr>
            <td colspan="4" class="cart_total"><span class="red">总价:</span></td>
            <td>${sum}</td>
          </tr>
        </table>
        <a href="${ctx}/order/deleteOneOrder.do?order_id=${order_id}" class="continue">&lt; 删除订单</a> <a href="${ctx}/order/pay.do?order_id=${order_id}" class="checkout">确认支付 &gt;</a> 
        </div>
      <div class="clear"></div>
      	
