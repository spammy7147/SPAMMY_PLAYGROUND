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


<body id="page-top">


    <jsp:include page="../adminNav.jsp"/>

		<!-- Begin Page Content -->
		<div>
		<h1 style="text-align: center;">검 색 결 과</h1>
		
		<form action="${contextPath }/admin/user/usersearch" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<select name="choice">
				<option value="1">이메일
				<option value="2">이름
			</select>
			<input type="text" name="userSearch">
			<input type="submit" value="검색">
		</form>
		
		<table border="1">
			<tr>
				<th>이메일</th> <th>이름</th> <th>가입날짜</th> 
			</tr>
			
			<c:choose>
				<c:when test="${userSearchList.size() != 0 }">
					<c:forEach var="dto" items="${userSearchList }">
						<tr>
							<td>
								<a href="${contextPath }/admin/user/userInfo?userId=${dto.userId }">${dto.email }</a>
							</td>
							<td>${dto.name }</td>
							<td>${dto.regDate }</td> 
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<th colspan="3"> 조건에 해당하는 유저가 없습니다.</th>
					<tr>
				</c:otherwise>
			</c:choose>
			
			<tr>
				<td colspan="3">
				
					<c:forEach var="pageNum" begin="1" end="${allPage }">
					<a href="${contextPath }/admin/usermanage?pageNum=${pageNum}">${pageNum } &nbsp;</a>
					</c:forEach>
					<a href="${contextPath }/admin/usermanage">목록으로</a>
				
				
				</td>
			</tr>
			
			
			
		</table>
		</div>
		<!-- /.container-fluid -->

	<jsp:include page="../adminFooter.jsp"/>
	
	
</body>
</html>