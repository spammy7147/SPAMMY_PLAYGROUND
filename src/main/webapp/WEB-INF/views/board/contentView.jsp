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
contentView

 
<div>
	<table border="1" class="table">
		<tr>
			<th>글 번호</th><th>${contentData.writeNo }</th>
		</tr>
		<tr>
			<th>작성자</th><th>${contentData.writer }</th>
		</tr>
		<tr>
			<th>제 목</th><th>${contentData.title }</th>
		</tr>
		<tr>
			<th>작성일</th><th>${contentData.saveDate }</th>
		</tr>	
		<tr>
			<th>내 용</th><th>${contentData.content }</th>
		</tr>		
	</table>
		<a href="${contextPath }/board/boardAllList">목록보기</a>
		<input value="수정" type="button" onclick="location.href='${contextPath }/board/modifyForm?writeNo=${contentData.writeNo }'">
		<input value="삭제" type="button" onclick="location.href='${contextPath }/board/delete?writeNo=${contentData.writeNo }'">
</div>

</body>
</html>