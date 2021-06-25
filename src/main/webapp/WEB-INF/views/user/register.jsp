<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/taglib.jsp"%>

<html>
<head>
	<title>회원가입 - AirBnD</title>
	<c:import url="../include/header.jsp" />
</head>
<body>

<c:import url="../include/navbar.jsp" />

<div>
	<form action="${contextPath}/user/register" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="text" name="email" placeholder="email"><br>
		<input type="password" name="password" placeholder="password"><br>
		<input type="text" name="name" placeholder="name"><br>
		<input type="date" name="birth" placeholder="birth"><br>
		<input type="text" name="phone" placeholder="phone"><br>
		<input type="submit" value="회원가입">
	</form>
</div>

</body>
</html>
