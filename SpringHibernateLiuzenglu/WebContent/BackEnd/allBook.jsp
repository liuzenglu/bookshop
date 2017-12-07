<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
   <c:set var="ctx" value="${pageContext.request.contextPath}" />
  			<table border="1">
    		<th>book_id</th><th>book_name</th><th>book_author</th>
    		<th>book_description</th><th>book_publisher</th><th>book_price</th><th>book_imgurl</th>
    		<th>bookType</th><th>bookState</th><th>删除</th><th>更新</th>
    			<c:forEach  items="${allbooklist}" var="booklist">
    			<tr>
    				<td>${booklist.book_id}</td>
    				<td>${booklist.book_name}</td>
    				<td>${booklist.book_author}</td>
    				<td>${booklist.book_description}</td>
    				<td>${booklist.book_publisher}</td>
    				<td>${booklist.book_price}</td>
    				<td><img  style="width: 50px;height: 50px;" alt="tupain" src="../${booklist.book_imgurl}"/></td>
    				<td>${booklist.bookType.type_name}</td>
    				<td>
    					<c:forEach items="${booklist.bookStateList}" var="bookState">
    						${bookState.book_State}
    					</c:forEach>
    				</td>
    				<td><a href="${ctx}/book/deleteOneBook.do?book_id=${booklist.book_id}">删除</a></td>
    				<td><a href="${ctx}/book/selectOneBookUpdate.do?book_id=${booklist.book_id}">更新</a></td>
    			</tr>
    			</c:forEach>
   			</table>
   			
   			<form name="f1" method="POST" action="${ctx}/book/booklist.do" >
            <table border="0" align="center" >
                <tr>
                    <td>第${pages}页 共${totalpages}页 <a href="${ctx}/book/allbooklist.do?pages=1">首页</a></td>
                    <td><a href="${ctx}/book/booklist.do?pages=${(pages<1)?pages:(pages-1)}"> 上一页</a></td>
                    <td><a href="${ctx}/book/booklist.do?pages=${(pages>=totalpages)?totalpages:(pages+1)}"> 下一页</a></td>
                    <td><a href="${ctx}/book/booklist.do?pages=${totalpages}">最后一页</a></td>
                    <td>转到第:<input type="text" name="pages" size="8">页<input type="submit" value="GO" name="cndok"></td>
                </tr>
            </table> 
 	  </form>