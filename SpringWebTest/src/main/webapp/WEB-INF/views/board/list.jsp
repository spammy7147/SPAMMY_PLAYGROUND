<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2> 게시글 목록 </h2>

<table boarder="1">
	<tr>
		<td>번호</td>
		<td>작성자</td>
		<td>제목</td>
		<td>비고</td>	
	</tr>
	<!--  컨트롤러가 가져온 게시글을 데이터 반복 출력 -->
	<!--  게시물 개수가 0개일 경우 목록대신 "게시물이 존재하지 않습니다" -->
	<tr>
		<td>번호</td>
		<td>작성자</td>
		<td>
			<a href="#">제목링크</a>
		</td>
		<td>
			<a href="#">[삭제]</a>
		</td>	
	</tr>

</table>


	<p>
		<a href="#">게시글 쓰기 </a>
	</p>



</body>
</html>