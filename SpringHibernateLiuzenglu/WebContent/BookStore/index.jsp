<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 	<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Store</title>
<link rel="stylesheet" type="text/css" href="${ctx}/BookStore/style.css" />
<link rel="stylesheet" href="${ctx}/BookStore/lightbox.css" type="text/css" media="screen" />
<script src="${ctx}/BookStore/js/prototype.js" type="text/javascript"></script>
<script src="${ctx}/BookStore/js/scriptaculous.js?load=effects" type="text/javascript"></script>
<script src="${ctx}/BookStore/js/lightbox.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/BookStore/js/java.js"></script>
<script src="${ctx}/BookStore/js/jquery-2.2.2(1).js" type="text/javascript"></script>
<!--  <script type="text/javascript">
	var book_name1 = location.hash.substring(1);
	console.log(book_name1);
	var Rex = //gi;
	$.ajax({
		type:"post",
		url:"${ctx}/book/commendBookList.do",
		data:{book_name:book_name1},
		success:function(data){
			var data1 =  JSON.parse(data);
			console.log(data1[0].book_name);
			window.location.href="BookStore/index.jsp#"+data1[0].book_name;
		}
    })

</script>-->
</head>
<body>
<div id="wrap">
  <div class="header">
    <div class="logo"><a href="index.htm"><img src="${ctx}/BookStore/images/logo.gif" alt="" title="" border="0" /></a></div>
    <div id="menu">
      <ul>
        <li class="selected"><a href="${ctx}/book/someBooklist.do" >首页</a></li>
        <li><a href="${ctx}/BookStore/about.jsp" >关于我们</a></li>
        <li><a href="${ctx}/book/allbooklist.do?pages=1" >所有图书</a></li>
        <li><a href="${ctx}/book/characteristicBookList.do" >特色图书</a></li>
        <li><a href="${ctx}/BookStore/myaccount.jsp" >我的账户</a></li>
        <li><a href="${ctx}/BookStore/register.jsp" >注册</a></li>
        <li><a href="${ctx}/BookStore/myaccount.jsp">${user.user_username}</a></li>
      </ul>
    </div>
  </div>
  <div class="center_content">
  
  
    <div class="left_content">
			
      	<c:if test="${characteristicBookList != null && newBookList != null}">
			<jsp:include page="main.jsp">
				<jsp:param name="characteristicBookList" value="${characteristicBookList}" />
				<jsp:param name="newBookList" value="${newBookList}" />
				
			</jsp:include>
		</c:if>
		
		<c:if test="${characteristicBookList != null && onclick == 'onclick'}">
			<jsp:include page="characteristicBookList.jsp">
				<jsp:param name="characteristicBookList" value="${characteristicBookList}" />			
			</jsp:include>
		</c:if>
			<c:if test="${allbooklist != null}">
			<jsp:include page="allBook.jsp">
				<jsp:param name="allbooklist" value="${allbooklist}" />
			</jsp:include>
		</c:if>
		<c:if test="${book != null}">
			<jsp:include page="details.jsp">
				<jsp:param name="details" value="${book}" />
				<jsp:param name="bookSet" value="${bookSet}" />
				
			</jsp:include>		
      	</c:if>
      	
		<c:if test="${orderDetailsSet != null}">
			<jsp:include page="cartDetail.jsp">
				<jsp:param name="orderDetailsSet" value="${orderDetailsSet}" />
			</jsp:include>		
      	</c:if>
      	
      	<c:if test="${summony != null}">
			<jsp:include page="paysuccess.jsp">
				<jsp:param name="summony" value="${summony}" />
			</jsp:include>		
      	</c:if>
      	<c:if test="${oneBookTypeBook != null}">
			<jsp:include page="oneBookTypeBook.jsp">
				<jsp:param name="oneBookTypeBook" value="${oneBookTypeBook}" />
				<jsp:param name="oneBookType" value="${oneBookType}" />
				
			</jsp:include>		
      	</c:if>
      	
    </div>
    <!--end of left content-->
    <div class="right_content">
     <div class="cart">
        <div class="title"><span class="title_icon"><img src="${ctx}/BookStore/images/cart.gif" alt="" title="" /></span>我的车</div>
        <div class="home_cart_content"> ${count}本书 | <span class="red">总价: ￥ ${sum}</span> </div>
        <a href="${ctx}/order/cart.do" class="view_cart">查看购物车</a> </div>
      <div class="title"><span class="title_icon"><img src="${ctx}/BookStore/images/bullet3.gif" alt="" title="" /></span>关于我们的书店</div>
      <div class="about">
        <p> <img src="${ctx}/BookStore/images/about.gif" alt="" title="" class="right" /> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud. </p>
      </div>
      <div class="right_box">
        <div class="title"><span class="title_icon"><img src="${ctx}/BookStore/images/bullet4.gif" alt="" title="" /></span>推荐书籍</div>
        
        
        <c:if test="${sessionScope.commendBookList != null}">
			<jsp:include page="commendBookList.jsp">
				<jsp:param name="commendBookList" value="${commendBookList}" />
			</jsp:include>
		</c:if>
        
      </div>
      <div class="right_box">
        <div class="title"><span class="title_icon"><img src="${ctx}/BookStore/images/bullet5.gif" alt="" title="" /></span>图书分类</div>
        <ul class="list">
        	<c:forEach items="${bookTypeList}" var="bookTypeList">
		          <li><a href="${ctx}/bookType/someOneBookType.do?type_id=${bookTypeList.type_id}">${bookTypeList.type_name}</a></li>
        	</c:forEach>
        </ul>
        <div class="title"><span class="title_icon"><img src="${ctx}/BookStore/images/bullet6.gif" alt="" title="" /></span>赞助商</div>
        <ul class="list">
          <li><a href="#">腾讯阿发</a></li>
          <li><a href="#">books gifts</a></li>
          <li><a href="#">specials</a></li>
          <li><a href="#">hollidays gifts</a></li>
          <li><a href="#">accesories</a></li>
          <li><a href="#">books gifts</a></li>
          <li><a href="#">specials</a></li>
          <li><a href="#">hollidays gifts</a></li>
          <li><a href="#">accesories</a></li>
        </ul>
      </div>
    </div>
    <!--end of right content-->
    <div class="clear"></div>
  </div>
  <!--end of center content-->
  <div class="footer">
    <div class="left_footer"><img src="images/footer_logo.gif" alt="" title="" /><br />
      </div>
    <div class="right_footer"> <a href="#">首页</a> <a href="#">关于我们</a> <a href="#">服务</a> <a href="#">隐私政策</a> <a href="#">联系我们</a> </div>
  </div>
</div>
<div style="text-align:center;">
<p>&#26469;&#28304;:<a href="http://www.mycodes.net/" target="_blank">&#28304;&#30721;&#20043;&#23478;</a></p>
</div>
</body>
</html>

