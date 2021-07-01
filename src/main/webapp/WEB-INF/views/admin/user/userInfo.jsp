<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglib.jsp"%>

<html>
<head>
	<title>AirBnD - 관리자 사용자 정보</title>
	<c:import url="../../include/header.jsp" />
	<script type="text/javascript">
		function inputActive(){
			const target1 = document.getElementById("infoInput1");
			const target2 = document.getElementById("infoInput2");
			const target3 = document.getElementById("infoInput3");
			const target4 = document.getElementById("modButton");
			const target5 = document.getElementById("saveButton");
			target1.disabled = false;
			target2.disabled = false;
			target3.disabled = false;
			target4.disabled = true;
			target5.disabled = false;
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

			<h1 style="text-align: center;">유 저 정 보</h1>


				<form action="modifyUserInfo" method="post">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<input type="hidden" name="userId" value="${userInfo.userId }">

					<div style="width:300px; margin: 0 auto;">
						<table border="1" style="width:300px;">
							<tr>
								<th>email</th>
								<td><input readonly type="text" name="email" value="${userInfo.email }"></td>
							</tr>
							<tr>
								<th>비밀번호</th>
								<td><input readonly type="text" name="password" value="${userInfo.password }"></td>
							</tr>
							<tr>
								<th>이   름</th>
								<td><input id = "infoInput1" disabled="disabled" type="text" name="name" value="${userInfo.name }"></td>
							</tr>
							<tr>
								<th>생   일</th>
								<td><input id = "infoInput2" disabled="disabled" type="date" name="birth" value="${userInfo.birth }"></td>
							</tr>
							<tr>
								<th>핸드폰</th>
								<td><input id = "infoInput3" disabled="disabled" type="text" name="phone" value="${userInfo.phone }"></td>
							</tr>
						</table>
					
					<hr>
					
					<input type="button" class="btn btn-primary" id = "modButton" value="수정" onclick="inputActive()">
					<input type="submit" class="btn btn-primary" disabled="disabled" id="saveButton" value="저장">
					<input type="button" class="btn btn-secondary" onclick="location.href='${contextPath }/admin/usermanage'" value="리스트로 돌아가기">
				
				</div>
				</form>
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