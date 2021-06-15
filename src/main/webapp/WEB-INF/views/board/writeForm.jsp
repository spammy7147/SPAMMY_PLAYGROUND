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
<c:import url="../include/header.jsp" />
<div>
	<div>
	<form action="writeSave" method="post">
		<b>작성자</b><br>
			<input type="text" name="writer" size="30" value="#" readonly><br>
		<b>제목</b><br>
			<input type="text" size="30" name="title" ><br>	
		<b>내용</b><br>
			<textarea rows="10" cols="50" name="content"></textarea>
		<hr>
			<input type="submit" value="글쓰기">
			<input type="button" value="목록이동" onclick="location.href='${contextPath}/board/boardAllList'">
	</form>
	</div>
</div>
</body>
</html>