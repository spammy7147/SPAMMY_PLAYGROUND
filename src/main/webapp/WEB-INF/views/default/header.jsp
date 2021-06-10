<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0;
}
nav ul {
	list-style: none;
	display: flex;
	justify-content: flex-end;
}
.wrap {
	width: 1000px;
	margin: auto;
}
</style>
</head>
<body>
	<div>
	<hr>
		<nav>
			<ul>
				<li><a href="${contextPath}/">HOME</a></li>&nbsp;&nbsp;&nbsp;				
				<li><a href="${contextPath}/user/login">LOGIN</a></li>		
			</ul>
			
		</nav>
	<hr>
	</div>
</body>
</html>
