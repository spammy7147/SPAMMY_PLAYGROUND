<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/taglib.jsp"%>

<html>
<head>
	<title>AirBnD - 관리자 고객센터 문의하기</title>
	<c:import url="../include/header.jsp" />



</head>
<body id="page-top">
<c:import url="../include/navbar.jsp" />
<c:import url="customerSubMenu.jsp" />
<!-- Page Wrapper -->
<div id="wrapper">
	


	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">

		<!-- Main Content -->
		<div id="content">

			

			<!-- Begin Page Content -->
			<div class="container-fluid">
			
			
			<h1 style="text-align: center;">문 의 하 기</h1>


				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Q&A DataTable</h6>
					</div>
					<div class="card-body">
						<div class="table-responsive">

							<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
								<thead>
								<tr>
									<th>번호</th><th>id</th><th width="40%" style="color:#4e73df;">제목</th><th>날짜</th>
									<th>조회수</th><th>Image File</th>
								</tr>
								</thead>
								<tfoot>
								<tr>								
									<th colspan="6">
										<c:forEach var="pageNum" begin="1" end="${allPage }">
											<a href="${contextPath }/admin/customerqna?pageNum=${pageNum}">${pageNum } &nbsp;</a>
										</c:forEach>
									</th>
								</tr>
								</tfoot>
								<tbody>

								<c:choose>
								<c:when test="${userList.size() != 0 }">
									<c:forEach var="dto" items="${qnaList }">
										<tr>
											<td>${dto.qnaNo }</td> <td>${dto.email }</td>
											<td>
												<a href="${contextPath }/cs/qnaview?qnaNo=${dto.qnaNo }">${dto.title }</a>
											</td>
											<td>${dto.saveDate }</td> <td>${dto.hit }</td> <td>${dto.imageFileName }</td>
				
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
								<tr>
									<th colspan="6">저장 데이터 없음</th>
								<tr>
									</c:otherwise>
									</c:choose>

								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->

				<form action="${contextPath }/cs/qnawriteform">
					<div align="right">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<input type="submit" class="btn btn-primary" value="글작성">
					</div>
				</form>
				
				
				
				
				
				
				
			
			
			
			
				
				
				
				
				
				
				
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