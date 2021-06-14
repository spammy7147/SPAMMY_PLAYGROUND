<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="./include/header.jsp" />
<div>
	<div>
		<form action="#">
			<input type="text" name="search" placeholder="숙소 검색">
			<input type="submit" value="검색">
		</form>
	</div>
</div>
</body>
</html>