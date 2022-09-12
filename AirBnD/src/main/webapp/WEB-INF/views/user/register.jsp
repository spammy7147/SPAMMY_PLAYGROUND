<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/taglib.jsp"%>

<html>
<head>
	<title>회원가입 - AirBnD</title>
	<c:import url="../include/header.jsp" />
</head>
<body>
<c:import url="../include/navbar.jsp" />
<div class="container p-5 m-auto">
	<div class="row justify-content-center">
		<div class="col-xl-auto m-auto">
			<div class="card-body">
				<form action="${contextPath}/user/register" method="post">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<input type="text" class="form-control mb-3" name="email" placeholder="email">
					<input type="password" class="form-control mb-3" name="password" placeholder="password">
					<input type="text" class="form-control mb-3" name="name" placeholder="name">
					<input type="date" class="form-control mb-3" name="birth" placeholder="birth">
					<input type="text" class="form-control mb-3" name="phone" placeholder="phone">
					<input type="submit" class="form-control mb-3" value="회원가입">
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>
