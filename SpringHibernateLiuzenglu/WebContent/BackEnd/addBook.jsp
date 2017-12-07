<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
   	<c:set var="ctx" value="${pageContext.request.contextPath}" />
       <form method="post"  action="${ctx}/book/addBook.do" enctype="multipart/form-data">
			      	书名:<input name="book_name" type="text"><br/>
					作者:<input name="book_author" type="text"><br/>
					描述:<input name="book_description" type="text"><br/>
					出版社:<input name="book_publisher" type="text"><br/>
					价格:<input name="book_price" type="text"><br/>
					图片:<input type="file" name="book_imgurl"/><br/>
					类型:	<select name="type_name">
								<c:forEach  items="${addBookAndDisplayBookType}" var="addBookAndDisplayBookType">
									<option>${addBookAndDisplayBookType.type_name}</option>
								</c:forEach>
							</select><br/>
					状态: 	<c:forEach  items="${addBookAndDisplayBookState}" var="addBookAndDisplayBookState">
								<label><input name="bookState_name" type="checkbox" value="${addBookAndDisplayBookState.book_State}" />${addBookAndDisplayBookState.book_State} </label>
							</c:forEach>
							<br/>
					
					<input type="submit" value="增加"><br/>
		</form> 			
   		