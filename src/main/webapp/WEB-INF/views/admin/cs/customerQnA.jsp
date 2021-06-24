<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 고객센터 / 문의하기 -->

</head>

<body id="page-top">


    <jsp:include page="../adminNav.jsp"/>

		<!-- Begin Page Content -->
		<div class="container-fluid">
		
		
		
			
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
								<a href="${contextPath }/admin/qnaview?qnaNo=${dto.qnaNo }">${dto.title }</a>
							</td>
							<td>${dto.saveDate }</td> <td>${dto.hit }</td> <td>${dto.imageFileName }</td>
							
						</tr>
					</c:forEach>
					<tr>
						<td colspan="6">
							<c:forEach var="pageNum" begin="1" end="${allPage }">
						<a href="${contextPath }/admin/customerqna?pageNum=${pageNum}">${pageNum } &nbsp;</a>
							</c:forEach>
							<a href="${contextPath }/admin/qnawriteform">글작성</a>
						</td>
					</tr>
					
					
				</table>
		
		
		
		</div>
		<!-- /.container-fluid -->

	<jsp:include page="../adminFooter.jsp"/>
	
	
</body>







</html>