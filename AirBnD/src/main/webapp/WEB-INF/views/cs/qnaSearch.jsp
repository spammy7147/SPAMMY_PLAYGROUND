<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/taglib.jsp"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
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
									<th>번호</th><th>작성자</th><th width="40%" style="color:#4e73df;">제목</th><th>날짜</th>
									<th>조회수</th><th>Image File</th>
								</tr>
								</thead>
								<tfoot>
								<tr>								
									<th colspan="6">
										<c:forEach var="pageNum" begin="1" end="${repeat }">
											<a href="${contextPath }/admin/customerqna?pageNum=${pageNum}">${pageNum } &nbsp;</a>
										</c:forEach>
									</th>
								</tr>
								</tfoot>
								<tbody>

								<c:choose>
								<c:when test="${searchList.size() != 0 }">
									<c:forEach var="dto" items="${searchList }">
										<tr>
											<td>${dto.qnaNo }</td> <td>${dto.email }</td>
											<td>
												<s:authorize access="isAuthenticated()">
													<a href="${contextPath }/cs/qnaview?qnaNo=${dto.qnaNo }">${dto.title }</a>
												</s:authorize>
												<s:authorize access="isAnonymous()">
												<a href="void(0);" onclick="alert('로그인이 필요합니다.');return false;">${dto.title }</a>
												</s:authorize>
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
				
				
				<table width="100%">
				<tr>
					<th>
					
					<form action="${contextPath }/cs/qnaSearch" method="post">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<div class="form-row align-items-center">
						    <div class="col-auto my-1">
								<label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">검색옵션</label>
								<select class="custom-select mr-sm-2" id="inlineFormCustomSelect"  name="choice">
									<option value="1">제목
									<option value="2">작성자
						      	</select>
						      	
						    </div>
						    <div class="col-auto my-1">
							    <div class="custom-control custom-checkbox mr-sm-2">
							        <input class="form-control" type="text" name="boardSearch">
							    </div>
						    </div>
						    <div class="col-auto my-1">
						      	<button type="submit" class="btn btn-primary">검색</button>
						    </div>
						    
						    
						    
						</div>
					</form>
					
					</th>
					<th align="right">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<a class="btn btn-primary" href="${contextPath }/cs/customerqna">목록으로</a>
					</th>
				</tr>
			</table>
			
			
				
				
				
				
				
				
				
				
			
			
			
			
				
				
				
				
				
				
				
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