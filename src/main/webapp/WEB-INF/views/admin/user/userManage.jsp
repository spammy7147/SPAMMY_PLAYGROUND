<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglib.jsp"%>


<html>
<head>
	<title>AirBnD - 사용자 관리</title>
	<c:import url="../../include/header.jsp" />

<script type="text/javascript">
	function formSubmit(){
		document.getElementById('frm').submit();
	}
</script>

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">
	<c:import url="../sidebar.jsp" />


	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">

		<!-- Main Content -->
		<div id="content">

			<c:import url="../../include/navbar.jsp" />

			<!-- Begin Page Content -->
			<div class="container-fluid">







				<h1 style="text-align: center;">회 원 정 보</h1>


				<form action="${contextPath }/admin/user/usersearch">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<select name="choice">
						<option value="1">이메일
						<option value="2">이름
					</select>
					<input type="text" name="userSearch">
					<input type="submit" value="검색">
				</form>


				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">User DataTable</h6>
					</div>
					<div class="card-body">
						<div class="table-responsive">

							<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
								<thead>
								<tr>
									<th width="40%">Email</th>
									<th>Name</th>
									<th>Register Date</th>
								</tr>
								</thead>
								<tfoot>
								<tr>
									<th colspan="3">
										<c:forEach var="pageNum" begin="1" end="${allPage }">
											<a href="${contextPath }/admin/usermanage?pageNum=${pageNum}">${pageNum } </a>
										</c:forEach>
									</th>
								</tr>
								</tfoot>
								<tbody>

								<c:choose>
								<c:when test="${userList.size() != 0 }">
									<c:forEach var="dto" items="${userList }">
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
									<th colspan="3"> 등록된 유저가 없습니다.</th>
								<tr>
									</c:otherwise>
									</c:choose>

								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->

				<form action="${contextPath }/user/register" id="frm">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<a class="btn btn-primary" onclick="formSubmit()">유저추가</a>
				</form>







			</div>
		<!-- End of Main Content -->

		<c:import url="../../include/footer.jsp"/>
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
</body>
</html>