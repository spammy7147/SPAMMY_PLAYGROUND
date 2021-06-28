<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

<body id="page-top">


    <jsp:include page="../sidebar.jsp"/>

		<!-- Begin Page Content -->
		<div class="container-fluid">
		
		
		
			
		<div style="width:300px; margin: 0 auto;">
			<form action="${contextPath }/admin/modify?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" method="post">
				<input type="hidden" name="qnaNo" value="${qnaData.qnaNo }">
				<input type="hidden" name="originFileName" value="${qnaData.imageFileName }">
				제목 <input type="text" size="30" name="title" value="${qnaData.title}"><hr>
				내용 <textarea rows="5" cols="30" name="content">${qnaData.content}</textarea>
				<hr>
				<c:if test="${qnaData.imageFileName != 'nan' }">
					<img width="100px" height="100px" id="preview"
						src="${contextPath }/admin/download?imageFileName=${qnaData.imageFileName}">
				</c:if>
				<input type="file" name="imageFileName" onchange="readURL(this)"><hr>
				<input type="submit" value="수정">
				<input type="button" onclick="history.back()" value="돌아가기">
			</form>	
		</div>
		
		
		
		</div>
		<!-- /.container-fluid -->

	<jsp:include page="../../include/footer.jsp"/>
	
	
</body>

</html>







