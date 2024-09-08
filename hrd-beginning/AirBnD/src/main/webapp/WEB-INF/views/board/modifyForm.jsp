<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/taglib.jsp"%>

<html>
<head>
	<title>AirBnD - 고객 게시글</title>
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
<!-- Page Wrapper -->
<div id="wrapper">
	


	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">

		<!-- Main Content -->
		<div id="content">

			

			<!-- Begin Page Content -->
			<div class="container-fluid">
			
				
				
				
				
				
				<div style="width:300px; margin: 0 auto;">
				
				<form method="post" action="/board/boardmodify?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
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
					<img id="preview" src="#" width="100" height="100" alt="선택 이미지 없음">
					<input type="file" name="newFileName" onchange="readURL(this)">
					<hr>
					<input type="submit" class="btn btn-primary" value="수정">
					<input type="button" class="btn btn-secondary" value="돌아가기" onclick="history.back()">
					
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