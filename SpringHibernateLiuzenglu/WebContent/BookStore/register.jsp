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
<script type="text/javascript" src="${ctx}/BookStore/js/jquery-2.2.2(1).js">
	$(function(){
		$(":input[name='user_username']").change(function(){
			var val =$(this).val();
			val = $.trim(val);
			if(val != ""){
				var url= "user/loginUsername.do";
				var args ={"user_username":val}
				$.post(url,args,function(data){
					$("message").html(data);
				})
			}
		})
	})
</script>
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
	<c:if test="${registeruser == null }">
      <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>注册</div>
      <div class="feat_prod_box_details">
        <p class="details"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud. </p>
        <div class="contact_form">
          <div class="form_subtitle">注册一个新账户</div>
          <form name="register" action="${ctx}/user/register.do">
            <div class="form_row">
              <label class="contact"><strong>用户名:</strong></label>
              <input type="text" name="user_username" class="contact_input" />
              <div id="message"></div>
            </div>
            <div class="form_row">
              <label class="contact"><strong>密码:</strong></label>
              <input type="text" name="user_password" class="contact_input" />
            </div>
            <div class="form_row">
              <label class="contact"><strong>Email:</strong></label>
              <input type="text" name="user_email" class="contact_input" />
            </div>
            <div class="form_row">
              <label class="contact"><strong>电话:</strong></label>
              <input type="text" name="user_telephone"class="contact_input" />
            </div>
            <div class="form_row">
              <label class="contact"><strong>地址:</strong></label>
              <input type="text" name="user_address"class="contact_input" />
            </div>
            <div class="form_row">
              <div class="terms">
                <input type="checkbox" name="terms" />
                I agree to the <a href="#">terms &amp; conditions</a> </div>
            </div>
            <div class="form_row">
              <input type="submit" class="register" value="register" />
            </div>
          </form>
        </div>
      </div>
      <div class="clear"></div>
      </c:if>
      <c:if test="${registeruser != null }">
      		<p>注册成功，用户名:${registeruser.user_username}
      			请<a href="${ctx}/BookStore/myaccount.jsp">去登入</a>
      		</p>
      
      </c:if>
  </div>
    <!--end of left content-->
    <div class="right_content">
     <div class="cart">
        <div class="title"><span class="title_icon"><img src="${ctx}/BookStore/images/cart.gif" alt="" title="" /></span>我的车</div>
        <div class="home_cart_content"> ${count}本书 | <span class="red">总价: ${sum}</span> </div>
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
          <li><a href="#">accesories</a></li>
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

 