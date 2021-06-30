<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/taglib.jsp"%>

<html>
<head>
	<title>AirBnD - 고객 게시글</title>
	<c:import url="../include/header.jsp" />



</head>
<body id="page-top">
<c:import url="../include/navbar.jsp" />
<!-- Page Wrapper -->
<div id="wrapper">
	


	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">

		<!-- Main Content -->
		<div id="content">

			

			<!-- Begin Page Content -->
			<div class="container-fluid">
			
				
				
				
				
				
				
				<div align="right">
					
					<input class="btn btn-primary" value="수정" type="button" onclick="location.href='${contextPath }/board/boardmodifyform?writeNo=${contentData.writeNo }'">
					<input class="btn btn-primary" value="삭제" type="button" onclick="location.href='${contextPath }/board/boarddelete?writeNo=${contentData.writeNo }&fileName=${contentData.fileName }'">
					<a class="btn btn-secondary" href="${contextPath}/board/boardalllist">목록보기</a>	<hr>
					
				</div>
				
				
				<div>
					<table border="1" class="table">
						<tr>
							<th>글 번호</th><td>${contentData.writeNo }</td>
						</tr>
						<tr>
							<th>작성자</th><td>${contentData.writer }</td>
						</tr>
						<tr>
							<th>제 목</th><td>${contentData.title }</td>
						</tr>
						<tr>
							<th>작성일</th><td>${contentData.saveDate }</td>
						</tr>	
						<tr>
							<c:if test="${contentData.fileName != 'nan' }">
								<th>파일</th>
								<td>
									<img src="${contextPath }/board/boarddownload?fileName=${contentData.fileName}">
								</td>
							</c:if>
						</tr>		
						<tr>
							<th>내 용</th><td height="300px" >${contentData.content }</td>
						</tr>		
					</table>
						
				</div>
				<br>
				
				<hr>
				<b>Comment</b>
				<form action="${contextPath }/board/addreply" method="post">			
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<input type="hidden" name="writeNo" value="${contentData.writeNo}">
					<input type="hidden" name="writer" value="${user.user.email }">
					<textarea rows="5" style="width:90%;" id="content" name="content"></textarea>
					<input class="btn btn-outline-secondary" type="submit" value="등록">
				</form>
				
				<div>
				
					<c:forEach var="rep" items="${replyList }">
						<table>
							<tr>
								<td>${rep.writer }</td> <td>${rep.write_date }</td> 
								<td><input class="btn btn-info btn-circle btn-sm" value="수정" type="button" onclick="location.href='${contextPath }/board/boardmodifyreplyform?reply_num=${rep.reply_num }&writeNo=${contentData.writeNo }'"></td>
								<td><input class="btn btn-danger btn-circle btn-sm" value="삭제" type="button" onclick="location.href='${contextPath }/board/replydelete?reply_num=${rep.reply_num }&writeNo=${contentData.writeNo }'"></td>
												
							</tr>
							<tr>
								<td colspan="4">${rep.content} </td>
							</tr>
						</table>
						<hr>
					</c:forEach>
				</div>
			
			
				
				
				
				
				
				
				
			</div>
		<!-- End of Main Content -->

		<c:import url="../include/footer.jsp"/>
		<!-- End of Footer -->
	</div>
	<!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->
</div>

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
	<i class="fas fa-angle-up"></i>
</a>