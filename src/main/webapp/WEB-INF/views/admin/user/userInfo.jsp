<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script type="text/javascript">
		function inputActive(){
			const target1 = document.getElementById("infoInput1");
			const target2 = document.getElementById("infoInput2");
			const target3 = document.getElementById("infoInput3");
			const target4 = document.getElementById("modButton");
			const target5 = document.getElementById("saveButton");
			target1.disabled = false;
			target2.disabled = false;
			target3.disabled = false;
			target4.disabled = true;
			target5.disabled = false;
		}
	</script>

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	
	<form action="modifyUserInfo" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="hidden" name="userId" value="${userInfo.userId }">
		
		<div style="width:300px; margin: 0 auto;">
			<table border="1" style="width:300px;">
				<tr>
					<th>email</th>
					<td><input readonly type="text" name="email" value="${userInfo.email }"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input readonly type="text" name="password" value="${userInfo.password }"></td>
				</tr>
				<tr>
					<th>이   름</th>
					<td><input id = "infoInput1" disabled="disabled" type="text" name="name" value="${userInfo.name }"></td>
				</tr>
				<tr>
					<th>생   일</th>
					<td><input id = "infoInput2" disabled="disabled" type="date" name="birth" value="${userInfo.birth }"></td>
				</tr>
				<tr>
					<th>핸드폰</th>
					<td><input id = "infoInput3" disabled="disabled" type="text" name="phone" value="${userInfo.phone }"></td>
				</tr>
			</table>	
		</div>
			<input type="button" id = "modButton" value="수정" onclick="inputActive()">
			<input type="submit" disabled="disabled" id="saveButton" value="저장">
			<input type="button" onclick="location.href='${contextPath }/admin/usermanage'" value="리스트로 돌아가기">
	</form>

	<jsp:include page="../../include/footer.jsp" />
</body>
</html>