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

<h2>학생들의 전체 성적 조회</h2>

<c:forEach var="s" items="${sList}" varStatus="stuNum">
<p>
#학번 : ${stuNum.index+1}, #이름 : ${s.stuName }, 국어 : ${s.kor}, 영어 : ${s.eng }, 
수학 : ${s.math }, 총점 : ${s.total } , 평균 : ${s.average }
&nbsp;
<a href="/web/score/delete?stuNum=${stuNum.index+1 }">[삭제]</a>

</p>
</c:forEach>

<a href="/web/score/register">다른점수 등록하기</a>

<script type="text/javascript">

const msg = "${msg }";
if (msg === "delSuccess"){
	alert("점수 삭제 완료!");
}
</script>
	

</body>
</html>