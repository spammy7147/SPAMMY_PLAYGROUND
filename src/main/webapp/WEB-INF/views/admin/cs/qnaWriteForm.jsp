<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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

<body id="page-top" onload="replyData()">


    <jsp:include page="../adminNav.jsp"/>

		<!-- Begin Page Content -->
		<div class="container-fluid">
		
		
		
			
		<form action="${contextPath }/admin/qnasave?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
		<!-- enctype="multipart/form-data" -->
			 
			<!-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> -->
			<b>작성자</b><br>
			<input type="text" name="email" size="50" value="${loginUser }" readonly>
			<hr>
			<b>제목</b><br>
			<input type="text" size="50" name="title" ><hr>
			<b>내용</b><br>
			<textarea rows="10" cols="50" name="content"></textarea>
			<hr>
			
			<b>이미지파일 첨부</b><br>
			<input type="file" name="imageFileName" onchange="readURL(this)">
			<img id="preview" src="#" width="100" height="100" alt="선택 이미지 없음">
			<hr>
			
			<input type="submit" value="글쓰기">
			<input type="button" value="목록이동"
				onclick="location.href='${contextPath}/admin/customerqna'">
		</form>
		
		
		
		</div>
		<!-- /.container-fluid -->

	<jsp:include page="../adminFooter.jsp"/>
	
	
</body>


</html>





