<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="../adminHeader.jsp" />
	
	<div>
		<div style="width:300px; margin: 0 auto;">
			<table border="1" style="width:300px;">
				<tr>
					<th>email</th><td>${userInfo.email }</td>
				</tr>
				<tr>
					<th>비밀번호</th><td>${userInfo.password }</td>
				</tr>
				<tr>
					<th>이   름</th><td>${userInfo.name }</td>
				</tr>
				<tr>
					<th>생   일</th><td>${userInfo.birth }</td>
				</tr>
				<tr>
					<th>핸드폰</th><td>${userInfo.phone }</td>
				</tr>
			</table>
		</div>
		<input type="submit" value="수정"><input type="button" value="취소" onclick="admin/usermanage">
	</div>

</body>
</html>