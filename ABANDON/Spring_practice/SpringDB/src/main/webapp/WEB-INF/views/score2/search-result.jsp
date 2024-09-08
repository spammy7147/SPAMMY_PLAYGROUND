<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
# 이름 : ${score.stuName} &nbsp;
# 국어 : ${score.kor}	&nbsp;
# 영어 : ${score.eng}	&nbsp;
# 수학 : ${score.math}	&nbsp;
# 총점 : ${score.total}	&nbsp;
# 평균 : ${score.average}	&nbsp;

	<a href="/web/score/register">다른점수 등록하기</a>
	<a href="/web/score/list">점수 전체 조회</a>
	<a href="/web/score/search">점수 개별 조회</a>
</p>
</body>
</html>