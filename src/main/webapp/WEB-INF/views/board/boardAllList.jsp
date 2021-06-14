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
<div align="center">
	<table>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>날짜</th>
			<th>조회수</th>				
		</tr>
		<c:if test="${boardList.size() == 0 }">
		<tr>
	 		<th colspan="5">데이터 없음</th>
		</tr>
		</c:if>		
		<c:forEach var="dto" items="${boardList }">
		<tr>
			<td>${dto.writeNo }</td>
			<td>${dto.writer }</td>
			<td>${dto.title }</td>
			<td>${dto.saveDate }</td>
			<td>${dto.hit }</td>
		</tr>
		</c:forEach>
	</table>
	<a href="${contextPath }/board/writeForm">글작성</a>
</div>
</body>
</html>