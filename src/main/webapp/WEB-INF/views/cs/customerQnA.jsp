<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 고객센터 / 문의하기 -->

</head>
<body>
	
	<jsp:include page="../include/header.jsp" />
		
		<div class="grid">
			<jsp:include page="customerSubMenu.jsp" />
			
			<div class="grid-item qna">
			
				<h3> 문의하기 </h3>
				<table border="1">
				
					<tr>
						<th>번호</th><th>id</th><th>제목</th><th>날짜</th>
						<th>조회수</th><th>image_file_name</th>
					</tr>
					
					<c:if test="${qnaList.size() == 0 }">
						<tr> <th colspan="6">저장 데이터 없음</th> </tr>
					</c:if>
					<c:forEach var="dto" items="${qnaList }">
						<tr>
							<td>${dto.qnaNo }</td> <td>${dto.email }</td> 
							<td>
								<a href="${contextPath }/cs/qnaview?qnaNo=${dto.qnaNo }">${dto.title }</a>
							</td>
							<td>${dto.saveDate }</td> <td>${dto.hit }</td> <td>${dto.imageFileName }</td>
							
						</tr>
					</c:forEach>
					<tr>
						<td colspan="6">
							<c:forEach var="pageNum" begin="1" end="${allPage }">
						<a href="${contextPath }/cs/customerqna?pageNum=${pageNum}">${pageNum } &nbsp;</a>
							</c:forEach>
							<a href="${contextPath }/cs/qnawriteform">글작성</a>
						</td>
					</tr>
					
					
				</table>
				
				
				
				
				
				
			</div>
			
		</div>
		
	<jsp:include page="../include/footer.jsp" />
		
</body>
</html>