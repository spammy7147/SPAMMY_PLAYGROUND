<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>Shop Homepage - Start Bootstrap Template</title>
	<!-- Favicon-->
	<link rel="icon" type="image/x-icon" href="${contextPath}/img/favicon.svg"/>
	<!-- Bootstrap icons-->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />

	<link href="${contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
	<script src="${contextPath}/bootstrap/js/bootstrap.bundle.js"></script>

	<!-- Core theme CSS (includes Bootstrap)-->
	<link href="${contextPath}/css/header.css" rel="stylesheet"/>
</head>
<body>
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="#!"><i class="bi bi-house"></i></a>
			<div class="nav-item dropdown">
				<button class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"></button>
				<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="${contextPath }/user/login">로그인</a></li>
					<li><a class="dropdown-item" href="${contextPath }/user/register">회원가입</a></li>
					<li><hr class="dropdown-divider" /></li>
					<li><a class="dropdown-item" href="#!">도움말</a></li>

					<li><a class="dropdown-item" href="#!">여행</a></li>
					<li><a class="dropdown-item" href="#!">위시리스트</a></li>
					<li><hr class="dropdown-divider" /></li>
					<li><a class="dropdown-item" href="#!">도움말</a></li>
					<li><a class="dropdown-item" href="#!">로그아웃</a></li>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>
