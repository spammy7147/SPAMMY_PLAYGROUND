<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	
	function reply(){
		let form={}; let arr = $("#replyForm").serializeArray();
        for(i=0 ; i<arr.length ; i++){
                form[arr[i].name] = arr[i].value
        }
        $.ajax({
			url: "addReply", type: "POST",
			data : JSON.stringify(form),
			contentType: "application/json; charset=utf-8",
			success: function(list){
				alert("성공적으로 답글이 달렸습니다"); slide_hide();
				replyData();
			}, error: function(){
				alert("문제 발생!!!");
			}
		})
	}
</script>

</head>
<body>
<c:import url="../include/header.jsp" />
contentView

 
<div>
	<table border="1" class="table">
		<tr>
			<th>글 번호</th><th>${contentData.writeNo }</th>
		</tr>
		<tr>
			<th>작성자</th><th>${contentData.writer }</th>
		</tr>
		<tr>
			<th>제 목</th><th>${contentData.title }</th>
		</tr>
		<tr>
			<th>작성일</th><th>${contentData.saveDate }</th>
		</tr>	
		<tr>
			<th>내 용</th><th>${contentData.content }</th>
		</tr>		
	</table>
		<a href="${contextPath }/board/boardAllList">목록보기</a>
		<input value="수정" type="button" onclick="location.href='${contextPath }/board/modifyForm?writeNo=${contentData.writeNo }'">
		<input value="삭제" type="button" onclick="location.href='${contextPath }/board/delete?writeNo=${contentData.writeNo }'">
</div>
<br>
<div>
<hr>
<b>Comment</b>
	<form id="replyForm">		
		<input type="hidden" name="write_no" value="${contentData.writeNo }">
		<input type="hidden" name="writer" value="#">
		<textarea rows="5" cols="100" id="content" name="content"></textarea>
		<input type="button" value="등록" onclick="reply()">
	</form>
</div>	
</body>
</html>







