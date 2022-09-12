<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2> 게시글 목록 </h2>

<table border="1">
	<tr>
		<td>번호</td>
		<td>작성자</td>
		<td>제목</td>
		<td>비고</td>	
	</tr>
	<!--  컨트롤러가 가져온 게시글을 데이터 반복 출력 -->
	<!--  게시물 개수가 0개일 경우 목록대신 "게시물이 존재하지 않습니다" -->
	<c:forEach var="a" items="${articles}" varStatus="boardNum">
	<tr>
		<td>${boardNum.index+1}</td>
		<td>${a.writer }</td>
		<td>
			<a href="/hello/board/content?boardNum=${boardNum.index+1 }">${a.title }</a>
		</td>
		<td>
			<a href="/hello/board/delete?boardNum=${boardNum.index+1 }">[삭제]</a>
		</td>	
	</tr>
	</c:forEach>
</table>


	<p>
		<a href="/hello/board/write">게시글 쓰기 </a>
	</p>



</body>
</html>