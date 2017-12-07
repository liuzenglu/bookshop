<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
   <c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!--  <script src="${ctx}/BookStore/js/jquery-2.2.2(1).js" type="text/javascript"></script>
<script type="text/javascript">
function index(){
	
	var a = 4 ; 
	$.ajax({
		type:"post",
		url:"${ctx}/book/commendBookList.do",
		data:{bookState_id:a},
		success:function(data){
			var data1 =  JSON.parse(data);
			var arr="";
			for(var i = 0; i<data1.length;i++){
			arr = arr+""+data1[i].book_name+data1[i].book_imgurl;
			}
			console.log(arr);
			window.location.href="BookStore/index.jsp#"+arr;
		}
	})
	
}
</script>-->
<body>
<!--  <a href="#" id="a1" onclick="index()">前台</a>-->
<a href="${ctx}/book/someBooklist.do" >前台</a>
<br/>
<a href="AdminLogin/index.html">后台</a>

</body>
</html>
