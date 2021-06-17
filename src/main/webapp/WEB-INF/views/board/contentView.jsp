<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
    
<!DOCTYPE html>
<html>
<head>
 
<meta name="_csrf_header" th:content="${_csrf.headerName}">
<meta name="_csrf" th:content="${_csrf.token}">

<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	
	function replyData(){
		$.ajax({
			url:"replyData/"+${contentData.writeNo}, type:"GET", 
			dataType:"json",
			success: function(rep){
				let html = ""
				rep.forEach(function(data){
					let date = new Date(data.write_date)
					let writeDate = date.getFullYear()+"-"+(date.getMonth()+1)+"-"
					writeDate += date.getDate()+"-"+date.getHours()+"-"
					writeDate += date.getMinutes()+"-"+date.getSeconds()+""
					html += "<div align='left'><b>아이디 : </b>"+data.writer+"님 / ";
					html += "<b>작성일</b> : "+writeDate+"<br>"
					html += "<b>내용</b> : "+data.content+"<hr></div>"
				})
				$("#replyList").html(html)
			},
			error:function(){
				alert('데이터를 가져올 수 없습니다')
			}
		})
	}
</script>

</head>
<body onload="replyData()">
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
	<form action="${contextPath }/board/addReply" method="post">			
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />S	
		<input type="hidden" name="writeNo" value="${contentData.writeNo}">
		<input type="hidden" name="writer" value="#">
		<textarea rows="5" cols="100" id="content" name="content"></textarea>
		<input type="submit" value="등록">
	</form>
	<div id="replyList"></div>
	
</div>	
</body>
</html>







