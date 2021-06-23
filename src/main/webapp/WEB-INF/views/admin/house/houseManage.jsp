<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="../../include/header.jsp" />
		
		<div>
		<h1 style="text-align: center;">숙 소 정 보</h1>
		
		
		<form action="${contextPath }/admin/house/housesearch" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<select name="choice">
				<option value="1">숙소명
				<option value="2">호스트명
				<option value="3">타입
			</select>
			<input type="text" name="houseSearch">
			<input type="submit" value="검색">
		</form>
		
		<table border="1">
			<tr>
				<th>숙소명</th> <th>호스트</th> <th>타입</th> 
			</tr>
			
			<c:choose>
				<c:when test="${houseList.size() != 0 }">
					<c:forEach var="dto" items="${houseList }">
						<tr>
							<td>
								<a href="#">${dto.houseName }</a>
							</td>
							<td>${dto.userId }</td>
							<td>${dto.type }</td> 
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<th colspan="3"> 등록된 숙소가 없습니다.</th>
					<tr>
				</c:otherwise>
			</c:choose>
			
			<tr>
				<td colspan="3">
				
					<c:forEach var="pageNum" begin="1" end="${allPage }">
					<a href="${contextPath }/admin/usermanage?pageNum=${pageNum}">${pageNum } &nbsp;</a>
					</c:forEach>
				
				
				</td>
			</tr>
			
			
			
		</table>
		</div>
		
	 <jsp:include page="../../include/footer.jsp" />

</body>
</html>