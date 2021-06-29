  
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/taglib.jsp"%>

<html>
<head>
	<title>AirBnD - 관리자 고객센터 수정</title>
	<c:import url="../include/header.jsp" />

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
				<div style="width:300px; margin: 0 auto;">
					<form action="${contextPath }/cs/modify?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" method="post">
						<input type="hidden" name="qnaNo" value="${qnaData.qnaNo }">
						<input type="hidden" name="originFileName" value="${qnaData.imageFileName }">
						제목 <input type="text" size="30" name="title" value="${qnaData.title}"><hr>
						내용 <textarea rows="5" cols="30" name="content">${qnaData.content}</textarea>
						<hr>
						<c:if test="${qnaData.imageFileName != 'nan' }">
							<img width="100px" height="100px" id="preview"
								 src="${contextPath }/cs/download?imageFileName=${qnaData.imageFileName}">
						</c:if>
						<input type="file" name="imageFileName" onchange="readURL(this)"><hr>
						<input type="submit" value="수정">
						<input type="button" onclick="history.back()" value="돌아가기">
					</form>
				</div>
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- End of Main Content -->
		<c:import url="../include/footer.jsp"/>
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