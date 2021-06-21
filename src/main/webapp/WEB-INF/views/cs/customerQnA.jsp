<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 고객센터 / 문의하기 -->

</head>
<body>
	
	<jsp:include page="../include/header.jsp" />
		
		<div class="grid">
			<jsp:include page="customerSubMenu.jsp" />
			
			<div class="grid-item qna">
				<h3> 문의하기 </h3>
				<table border="1">
					<tr>
						<td>사용자 문의 게시글</td>
					</tr>
					<tr>
						<td>관리자 답글</td>
					</tr>
				</table>
			</div>
			
		</div>
		
	<jsp:include page="../include/footer.jsp" />
		
</body>
</html>