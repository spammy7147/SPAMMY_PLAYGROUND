<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglib.jsp"%>

<html>
<head>
	<title>AirBnD - 관리자 예약관리</title>
	<c:import url="../../include/header.jsp" />
	
	<script type="text/javascript">
	function readURL(input){
		var file = input.files[0]
		console.log(file)
		if(file != ''){
			var reader = new FileReader();
			reader.readAsDataURL(file)
			reader.onload = function(e){
				console.log(e.target.result)
				$("#preview").attr("src",e.target.result)
			}
		}
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
				
				
				<form method="post" action="/admin/boardmodify?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
					<input type="hidden" name="writeNo" value="${contentData.writeNo }">
					<input type="hidden" name="originFileName" value="${contentData.fileName}">
				<b>작성자</b><br>
					<input type="text" name="writer" size="30" value="${contentData.writer }" readonly><br>
				<b>제목</b><br>
					<input type="text" size="30" name="title" value="${contentData.title }"><br>	
				<b>내용</b><br>
					<textarea rows="10" cols="50" name="content" >${contentData.content }</textarea>
				<hr>
				<b>이미지파일 첨부 : ${contentData.fileName}</b><br>
					<c:if test="${contentData.fileName != 'nan' }">
						<img width="100px" height="100px" id="preview"
							 src="${contextPath }/admin/boarddownload?fileName=${contentData.fileName}">
					</c:if>
					<input type="file" name="newFileName" onchange="readURL(this)"><br>
					<hr>
					<input type="submit" class="btn btn-primary" value="수정">
					<input type="button" class="btn btn-secondary" value="목록이동" onclick="location.href='${contextPath}/admin/boardalllist'">
					
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