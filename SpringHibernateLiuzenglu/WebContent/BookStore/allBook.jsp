<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
   <c:set var="ctx" value="${pageContext.request.contextPath}" />
   <link rel="stylesheet" type="text/css" href="${ctx}/BookStore/style3.css" />
  	 <c:forEach items="${allbooklist}" var="allbooklist">
		      <div class="feat_prod_box">
				       <div class="prod_img"><a href="${ctx}/book/details.do?book_id=${allbooklist.book_id}"><img style="width: 60px;height: 80px;"src="../${allbooklist.book_imgurl}" alt="图片" title="" border="0" /></a></div>
				       <div class="prod_det_box">
				       <div class="box_top"></div>
				       <div class="box_center">
				           <div class="prod_title">${allbooklist.book_name}</div>
				           <p class="details">${allbooklist.book_description}</p>
				           <a href="${ctx}/book/details.do?book_id=${allbooklist.book_id}" class="more">- 更多细节 -</a>
				           <div class="clear"></div>
				       </div>
			       <div class="box_bottom"></div>
				       </div>
				       <div class="clear"><a href="${ctx}/book/addCart.do?book_id=${allbooklist.book_id}">加入购物车</a></div>     	
		      </div>
      </c:forEach>
      <form name="f1" method="POST" action="${ctx}/book/allbooklist.do" >
            <table border="0" align="center" >
                <tr>
                    <td>第${pages}页 共${totalpages}页 <a href="${ctx}/book/allbooklist.do?pages=1">首页</a></td>
                    <td><a href="${ctx}/book/allbooklist.do?pages=${(pages<1)?pages:(pages-1)}"> 上一页</a></td>
                    <td><a href="${ctx}/book/allbooklist.do?pages=${(pages>=totalpages)?totalpages:(pages+1)}"> 下一页</a></td>
                    <td><a href="${ctx}/book/allbooklist.do?pages=${totalpages}">最后一页</a></td>
                    <td>转到第:<input type="text" name="pages" size="8">页<input type="submit" value="GO" name="cndok"></td>
                </tr>
            </table> 
 	  </form>