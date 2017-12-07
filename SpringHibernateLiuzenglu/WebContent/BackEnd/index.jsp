<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
   <c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台模板管理系统</title>
<link type="text/css" rel="stylesheet" href="${ctx}/BackEnd/css/style.css" />
<script type="text/javascript" src="${ctx}/BackEnd/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/BackEnd/js/menu.js"></script>
</head>

<body>
<div class="top"></div>
<div id="header">
	<div class="logo">Shop后台管理系统</div>
	<div class="navigation">
		<ul>
		 	<li>欢迎您！${admin.admin_username}</li>
			<li><a href="${ctx}/admin/updatePasswordAddAttribute.do">修改密码</a></li>
			<li><a href="">设置</a></li>
			<li><a href="">退出</a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div class="left_menu">
				<ul id="nav_dot">
      <li>
          <h4 class="M1"><span></span>管理员设置</h4>
          <div class="list-item none">
            <a href='${ctx}/admin/allAdminlist.do'>所有管理员</a>
            <a href=''>系统公告2</a>
            <a href=''>系统公告3</a>
            <a href=''>系统公告4</a>
          </div>
        </li>
        <li>
          <h4 class="M2"><span></span>用户管理</h4>
          <div class="list-item none">
            <a href='${ctx}/user/userlist.do'>所有用户</a>
            <a href=''>工单处理2</a>
            <a href=''>工单处理3</a>
            <a href=''>工单处理4</a>
            <a href=''>工单处理5</a>          
           </div>
        </li>
        <li>
          <h4 class="M3"><span></span>商品管理</h4>
          <div class="list-item none">
            <a href='${ctx}/book/booklist.do?pages=1'>所有图书</a>
            <a href='${ctx}/book/addBookAddAttribute.do'>增加图书</a>
            <a href='${ctx}/bookType/addBookTypeAddAttribute.do'>增加图书的类型</a>
          </div>
        </li>
				<li>
          <h4 class="M4"><span></span>订单管理</h4>
          <div class="list-item none">
            <a href='${ctx}/order/orderlist.do'>所有订单</a>
            <a href=''>评论管理2</a>
            <a href=''>评论管理3</a>
          </div>
        </li>
				<li>
          <h4 class="M5"><span></span>调研问卷</h4>
          <div class="list-item none">
            <a href=''>调研问卷1</a>
            <a href=''>调研问卷2</a>
            <a href=''>调研问卷3</a>
          </div>
        </li>
				<li>
          <h4  class="M6"><span></span>数据统计</h4>
          <div class="list-item none">
            <a href=''>数据统计1</a>
            <a href=''>数据统计2</a>
            <a href=''>数据统计3</a>
          </div>
        </li>
				<li>
          <h4  class="M7"><span></span>奖励管理</h4>
          <div class="list-item none">
            <a href=''>奖励管理1</a>
            <a href=''>奖励管理2</a>
            <a href=''>奖励管理3</a>
          </div>
        </li>
				<li>
          <h4   class="M8"><span></span>字典维护</h4>
          <div class="list-item none">
            <a href=''>字典维护1</a>
            <a href=''>字典维护2</a>
            <a href=''>字典维护3</a>
						<a href=''>字典维护4</a>
            <a href=''>字典维护5</a>
            <a href=''>字典维护6</a>
						<a href=''>字典维护7</a>
            <a href=''>字典维护8</a>
            <a href=''>字典维护9</a>
						<a href=''>字典维护4</a>
            <a href=''>字典维护5</a>
            <a href=''>字典维护6</a>
						<a href=''>字典维护7</a>
            <a href=''>字典维护8</a>
            <a href=''>字典维护9</a>
          </div>
        </li>
				<li>
          <h4  class="M9"><span></span>内容管理</h4>
          <div class="list-item none">
            <a href=''>内容管理1</a>
            <a href=''>内容管理2</a>
            <a href=''>内容管理3</a>
          </div>
        </li>
				<li>
          <h4   class="M10"><span></span>系统管理</h4>
          <div class="list-item none">
            <a href=''>系统管理1</a>
            <a href=''>系统管理2</a>
            <a href=''>系统管理3</a>
          </div>
        </li>
  </ul>
		</div>
		<div class="m-right">
			<div class="right-nav">
				-------------------------------------------------------------------
			</div>
			<div class="main">
			<!-- ============================================== -->
			<c:if test="${adminList != null }">
				<h1>管理</h1>
					<jsp:include page="allAdmin.jsp">
						<jsp:param name="allAdmin" value="${adminList}" />
					</jsp:include>
			
			</c:if>
			<!-- ============================================== -->
				<c:if test="${updatePassword =='admin'}">
				<h1>修改密码</h1>
					<form action="../admin/updatePassword.do">
						管理员:${admin.admin_username}
						密码:<input type="password" name="password"/>
						<input type="submit" value="修改"/>
					</form>
				</c:if>
				<c:if test="${updatetrue != null}">
				<h1>更新密码成功</h1>
					${updatetrue}
				</c:if>
			<!-- =================================================== -->
				<c:if test="${userlist != null}">
					<h1>用户</h1>
					<jsp:include page="allUser.jsp">
						<jsp:param name="allUser" value="${userlist}" />
					</jsp:include>
				</c:if>
			<!-- ============================================== -->
			<c:if test="${allbooklist != null}">
					<h1>所有图书</h1>
					<jsp:include page="allBook.jsp">
						<jsp:param name="allbooklist" value="${allbooklist}" />
						<jsp:param name="bookStateName" value="${bookStateName}" />
						<jsp:param name="totalpages" value="${totalpages}" />
						<jsp:param name="pages" value="${pages}" />
					</jsp:include>
				</c:if>
			<!-- ============================================== -->
				<c:if test="${addBookAndDisplayBookType != null}">
				<h1>增加图书</h1>
					<jsp:include page="addBook.jsp">
						<jsp:param name="addBook" value="${addBookAndDisplayBookType}" />
						<jsp:param name="addBook" value="${addBookAndDisplayBookState}" />						
					</jsp:include>
				</c:if>
				<c:if test="${addBooktrue != null}">
				<h1>增加图书成功</h1>
					${addBooktrue}
				</c:if>
			<!-- ===================================================== -->
				<c:if test="${book != null}">
					<jsp:include page="updateBook.jsp">
						<jsp:param name="updateBook" value="${book}" />
						<jsp:param name="bookTypelist" value="${bookTypelist}" />
						<jsp:param name="bookState2" value="${bookState2}" />
						
						<jsp:param name="bookState" value="${bookState1}" />
					</jsp:include>
				</c:if>
				<c:if test="${updateBooktrue != null}">
				<h1>更新图书成功</h1>
					${updateBooktrue}
				</c:if>
			<!-- ===================================================== -->	
			<c:if test="${orderlist != null}">
					<form action="${ctx}/user/selectUser.do" method="post">
						<input type="text" value="输入用户名查询订单" name="user"/>
						<input type="submit" value="搜索"/>					
					</form>
					<h1>所有订单</h1>
					<jsp:include page="allOrder.jsp">
						<jsp:param name="allOrder" value="${orderlist}" />
					</jsp:include>
				</c:if>
				
			<!-- ============================================== -->
			
			<c:if test="${orderDetaillist != null}">
					<h1>订单明细</h1>
					<jsp:include page="orderDetail.jsp">
						<jsp:param name="orderDetail" value="${orderDetaillist}" />
					</jsp:include>
				</c:if>
			<!-- ===================================================================== -->	
			
			<c:if test="${bookTypeListEnd != null}">
					<h1>增加图书类型</h1>
					<jsp:include page="addbookType.jsp">
						<jsp:param name="addbookType" value="${bookTypeListEnd}" />
					</jsp:include>
				</c:if>
				<!-- ============================================================== -->
				<!-- 末尾============================================================== -->
			</div>
		</div>
</div>
<div class="bottom"></div>
<div id="footer"><p>Copyright©  2015 版权所有 京ICP备05019125号-10  来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p></div>
<script>navList(12);</script>
</body>
</html>
