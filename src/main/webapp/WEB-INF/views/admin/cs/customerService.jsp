<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 고객센터 / 자주하는 질문 -->
	<style type="text/css">
		input[id*="answer"]{
			display:none;
		}
		input[id*="answer"] + label{
			width : 500px;
			display: block;
			padding :20px;
			border :1px solid white;
			border-bottom: 0;
			color : #fff;
			font-weight: 900;
			background: black;
			cursor: pointer;
		}
		input[id*="answer"] + label + div{
			max-height: 0;
			transition: all .35s;
			overflow: hidden;
			background: white;
			font-size: 11px;
		}
		input[id*="answer"] + label + div p{
			display: inline-block;
			padding: 20px;
		}
		input[id*="answer"]:checked + label + div {
			max-height: 100px;
		}
	</style>
</head>
<body>
	
	<jsp:include page="../adminHeader.jsp" />
		
		<div class="grid">
			<jsp:include page="customerSubMenu.jsp" />
			
			<div class="grid-item notice">
				<h3> 자주하는 질문 </h3>
				
				<c:choose>
					<c:when test="${faqList.size() != 0}">
						<c:forEach var="dto" items="${faqList }" varStatus="vs">
							<div class="accordion">
								<input type="radio" name="accordion" id="answer${vs.index}">
								<label for="answer${vs.index}">${dto.question }</label>
								<div><p>${dto.answer }</p></div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<h1>등록된 질문이 없습니다.</h1>
					</c:otherwise>
				</c:choose>
			
				<hr>
				<input type="button" value="등록" onclick="#">
				
			</div>
			
		</div>
		
</body>
</html>