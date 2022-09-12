<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


<h2>Request 컨트롤러를 이용한 요청처리 작업</h2>
<p>
request 컨트롤러를 사용하는 테스트중
</p>

<form action="/web/request/basic01" method="get">
	<p><input type="submit" value="GET요청!!"></p>
</form>

<form action="/web/request/basic01" method="post">
<p><input type="submit" value="POST요청!!"></p>
</form>
</body>
</html>