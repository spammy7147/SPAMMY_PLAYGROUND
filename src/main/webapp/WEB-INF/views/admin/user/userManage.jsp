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
	<jsp:include page="../adminHeader.jsp" />
	<form action="#">
	 
		<input type="text" id="userSearch">
		<input type="submit" value="검색">
		
		<div>
		<h1 style="text-align: center;">회 원 정 보</h1>
		<table>
			<tr>
				<th>아이디</th> <th>이름</th> <th>가입날짜</th> 
			</tr>
			
			<c:forEach var="dto" items="${userList }">
				<tr>
					<td>
						<a href="<%=request.getContextPath() %>/admin/user/userInfo?member_id=${dto.member_id }">${dto.email }</a>
					</td>
					<td>${dto.name }</td>
					<td>${dto.regdate }</td> 
				</tr>
			</c:forEach>
		</table>
		</div>
		
	 
	</form>
</body>
</html>