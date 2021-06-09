<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원가입창 입니다.</h3>
<div>
	<form action="#" method="post">
		<input type="text" name="id" placeholder="id(email)"><br>
		<input type="password" name="pwd" placeholder="pwd"><br>
		<input type="text" name="name" placeholder="name"><br>
		<input type="date" name="birth" placeholder="birth"><br>
		<input type="text" name="phone" placeholder="phone"><br>
		<input type="submit" value="회원가입">
	</form>
</div>
</body>
</html>