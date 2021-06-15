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
	<form action="${contextPath }/board/modify" method="post">
			<input type="hidden" name="writeNo" value="${contentData.writeNo }">
		<b>작성자</b><br>
			<input type="text" name="writer" size="30" value="${contentData.writer }" readonly><br>
		<b>제목</b><br>
			<input type="text" size="30" name="title" value="${contentData.title }"><br>	
		<b>내용</b><br>
			<textarea rows="10" cols="50" name="content" >${contentData.content }</textarea>
		<hr>
			<input type="button" value="목록이동" onclick="location.href='${contextPath}/board/boardAllList'">
			<input type="submit" value="수정">
	</form>
	</div>
</div>
</body>
</html>