<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglib.jsp"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>AirBnD - 관리자 QNA 보기</title>
	<c:import url="../../include/header.jsp" />

<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>

<script type="text/javascript">
	const header = $("meta[name='_csrf_header']").attr('content');
	const token = $("meta[name='_csrf']").attr('content');
	
	function rep(){
		let form={}; let arr = $("#frm").serializeArray();
		for(i=0 ; i<arr.length ; i++){ form[arr[i].name] = arr[i].value }
		
		$.ajax({
			url: "addReply", type: "POST", data: JSON.stringify(form),
			contentType: "application/json; charset=utf-8",
			beforeSend: function(xhr){
		        xhr.setRequestHeader(header, token);
		    },
			success: function(){
				alert("성공적으로 답글이 달렸습니다");
				replyData();
			}, error: function(){
				alert("문제 발생!!!");
			}
		})
	}
	
	function replyData(){
		
		$.ajax({
			url:"replyData/"+${qnaData.qnaNo}, type:"POST", 
			dataType:"json",
			beforeSend: function(xhr){
		        xhr.setRequestHeader(header, token);
		    },
			success: function(rep){
				let html = ""
				rep.forEach(function(data){
					let date = new Date(data.write_date)
					let writeDate = date.getFullYear()+"년"+(date.getMonth()+1)+"월"
					writeDate += date.getDate()+"일"+date.getHours()+"시"
					writeDate += date.getMinutes()+"분"+date.getSeconds()+"초"
					html += "<div align='left'><b>아이디 : </b>"+data.email+"님 / ";
					html += "<b>작성일</b> : "+writeDate+"<br>"
					html += "<b>내용</b> : "+data.content+"<hr></div>"
				})
				$("#reply").html(html)
			},error:function(){
				alert('데이터를 가져올 수 없습니다')
			}
		})
	}
	
</script>

</head>

<body id="page-top" onload="replyData()">

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
				<table class="table table-bordered">
					<tr>
						<th>글 번호</th><td>${qnaData.qnaNo }</td>
						<th>작성자</th><td>${qnaData.email }</td>
					</tr>
					<tr>
						<th>제 목</th><td>${qnaData.title }</td>
						<th>작성일</th><td>${qnaData.saveDate }</td>
					</tr>

					<tr>
						<th>내 용</th><td  colspan="3">${qnaData.content }</td>
					</tr>
					<c:if test="${qnaData.imageFileName != 'nan' }">
						<tr>
							<th colspan="4">
								<img width="100px" height="100px"
									 src="${contextPath }/admin/download?imageFileName=${qnaData.imageFileName}">
							</th>
						</tr>
					</c:if>
					<tr>
						<td colspan="4" align="center">

							<s:authorize access="hasRole('ROLE_ADMIN')">
								<input type="button" class="btn btn-outline-info" onclick=
										"location.href='${contextPath }/admin/modifyqna?qnaNo=${qnaData.qnaNo }'" value="수정하기">

								<input type="button" class="btn btn-outline-danger" onclick=
										"location.href='${contextPath }/admin/deleteqna?qnaNo=${qnaData.qnaNo }&imageFileName=${qnaData.imageFileName }'" value="삭제하기">

								<form id="frm">
									<hr>
									<input type="hidden" id="qna_no" name="qna_no" value="${qnaData.qnaNo }">
									<b>작성자 : ${loginUser }</b><br>
									<textarea rows="5" cols="30" id="content" name="content"></textarea>
									<button type="button" onclick="rep()" class="btn btn-outline-secondary">답글</button>
									<hr>
								</form>
							</s:authorize>


							<div id="reply"></div>

							<input type="button" class="btn btn-outline-success" onclick="location.href='${contextPath }/admin/customerqna'" value="리스트로 돌아가기">
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























