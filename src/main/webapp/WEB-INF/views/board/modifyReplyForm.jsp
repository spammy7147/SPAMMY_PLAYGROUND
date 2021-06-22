<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<s:authentication property="principal" var="user"/>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../include/header.jsp" />
<div align="center">
	<form action="${contextPath }/board/modifyReply" method="post">			
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="hidden" name="writeNo" value="${writeNo}">
		<input type="hidden" name="reply_num" value="${replyData.reply_num}">
		<h1> 수정 내용</h1>
		<hr>
		<textarea rows="10" cols="80px" name="content">${replyData.content }</textarea>
		<hr>
		<input value="수정" type="submit">
		<input value="취소" type="button" onclick="location.href='${contextPath }/board/contentView?writeNo=${writeNo }'">
	</form>	
</div>
</body>
</html>