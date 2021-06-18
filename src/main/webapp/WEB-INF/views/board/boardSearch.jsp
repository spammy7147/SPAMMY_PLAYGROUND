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
	
	<form action="${contextPath }/board/boardSearch" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<select name="choice">
			<option value="1">제목
			<option value="2">작성자
		</select>
		<input type="text" name="boardSearch">
		<input type="submit" value="검색">
	</form>
	
	<table>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>날짜</th>
			<th>조회수</th>				
		</tr>
		<c:if test="${searchList.size() == 0 }">
		<tr>
	 		<th colspan="5">데이터 없음</th>
		</tr>
		</c:if>		
		<c:forEach var="dto" items="${searchList }">
		<tr>
			<td>${dto.writeNo }</td>
			<td>${dto.writer }</td>
			<td>
				<a href="${contextPath }/board/contentView?writeNo=${dto.writeNo }">${dto.title }</a>
			</td>
			<td>${dto.saveDate }</td>
			<td>${dto.hit }</td>
		</tr>
		</c:forEach>
	</table>
		
		<c:forEach var="num" begin="1" end="${repeat }">
			<a href="${contextPath }/board/boardSearch?num=${num}">${num } &nbsp;</a>
		</c:forEach>
		
		<a href="${contextPath }/board/writeForm">글작성</a>
		<a href="${contextPath }/board/boardAllList">목록으로</a><br>
	
</div>
</body>
</html>