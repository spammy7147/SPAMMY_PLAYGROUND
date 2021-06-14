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
	
	<jsp:include page="../adminHeader.jsp" />
	<form action="<%=request.getContextPath() %>/admin/user/usersearch">
		<select name="choice">
			<option value="1">아이디
			<option value="2">이름
		</select>
		<input type="text" id="userSearch">
		<input type="submit" value="검색">
	</form>
		
		<div>
		<h1 style="text-align: center;">회 원 정 보</h1>
		<table>
			<tr>
				<th>아이디</th> <th>이름</th> <th>가입날짜</th> 
			</tr>
			<c:choose>
				<c:when test="${userList.size() != 0 }">
					<c:forEach var="dto" items="${userList }">
						<tr>
							<td>
								<a href="<%=request.getContextPath() %>/admin/user/userInfo?member_id=${dto.member_id }">${dto.email }</a>
							</td>
							<td>${dto.name }</td>
							<td>${dto.regdate }</td> 
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<th colspan="3"> 조건에 해당되는 유저가 없습니다.</th>
					<tr>
				</c:otherwise>
			</c:choose>
			
		</table>
		</div>
</body>
</html>