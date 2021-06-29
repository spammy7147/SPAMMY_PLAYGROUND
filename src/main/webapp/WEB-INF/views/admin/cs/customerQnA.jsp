<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglib.jsp"%>

<html>
<head>
	<title>AirBnD - 관리자 고객센터 문의하기</title>
	<c:import url="../../include/header.jsp" />

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
		</div>
		<!-- End of Main Content -->

		<c:import url="../../include/footer.jsp"/>
		<!-- End of Footer -->
	</div>
	<!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
	<i class="fas fa-angle-up"></i>
</a>

</body>
</html>