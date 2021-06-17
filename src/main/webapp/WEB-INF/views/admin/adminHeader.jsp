<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	* {margin: 0; padding: 0;}
	.hd {background: white;}
</style>

</head>
<body>
	<header class = "hd">
	<a href="${contextPath}/jong/admin/usermanage">유저관리</a>  
	<a href="housemanage">숙소관리</a>  
	<a href="bookingmanage">예약관리</a>  
	<a href="board">게시판</a>  
	<a href="${contextPath}/jong/admin/customerservice">고객센터</a>  
	
	<hr>
	</header>
</body>
</html>