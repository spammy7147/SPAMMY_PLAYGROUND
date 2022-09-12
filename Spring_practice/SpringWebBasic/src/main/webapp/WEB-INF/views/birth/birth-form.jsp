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


<form action="<c:url value='/birth/birth-result'/>" method ="post">
<fieldset>
	<legend> 생일 등록 양식</legend>
	<p>
	# 생년월일:
	<input type="text" name="year" size="6" maxlength="4" placeholder="연도(4자리)">
	<select name ="month">
		<c:forEach var="m" begin="1" end="12">
			<option value="${m}">${m}월</option> <!-- 옵션 value 값을 지정하면 value 값만 서버로 넘어감 -->
		</c:forEach>
	</select>
	<input type="text" name="day" maxlength="2" size="4" placeholder="일(1~31)">
	<input type="submit" value="확인">
</fieldset>


</form>

</body>
</html>