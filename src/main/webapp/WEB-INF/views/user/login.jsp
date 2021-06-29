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
	<div class="row">
		<div class="col-xl-auto m-auto">
			<div class="card-body">
				<form action="${contextPath}/user/login" method="post">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<input type="text" class="form-control mb-3" name="email" placeholder="input id">
					<input type="password" class="form-control mb-3" name="password" placeholder="input pwd">
					<div class="row justify-content-center">
						<div class="col-xl-7">자동 로그인 :</div>
						<input type="checkbox" class="form-control mb-3 pr-5 col-xl-5" name="auto-login"/>
					</div>
					<input type="submit" class="form-control mb-3" value="login">
				</form>
				${requestScope.loginFailMsg}
				<a href="../user/register">회원가입</a>&nbsp;&nbsp;
			</div>
		</div>
	</div>
</div>
</body>
</html>
