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
			
				
				<div align="center">
				<form action="${contextPath }/board/boardmodifyreply" method="post">			
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<input type="hidden" name="writeNo" value="${writeNo}">
					<input type="hidden" name="reply_num" value="${replyData.reply_num}">
					<h1> 수정 내용</h1>
					<hr>
					<textarea rows="10" cols="80px" name="content">${replyData.content }</textarea>
					<hr>
					<input class="btn btn-primary" value="수정" type="submit">
					<input class="btn btn-secondary" value="취소" type="button" onclick="history.back()">
				</form>	
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