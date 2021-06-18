<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
		
		#modal_wrap{
			display:none;
			position: fixed; z-index: 9; margin: 0 auto; 
			top:0; left: 0; right: 0; width: 100%; height: 100%;
			background-color: rgba(0, 0, 0, 0.4);
		}
		#first{
			display:none;
			position: fixed; z-index: 10; margin: 0 auto;
			top:30px; left: 0; right: 0; width: 350px; height: 470px;
			background-color: rgba(148, 185, 248, 0.9);
		}
	</style>
	
	<script type="text/javascript">
		function slideClick(){
			$("#first").slideDown("slow");
			$("#modal_wrap").show();
		}
		function slide_hide(){
			$("#first").slideUp("fast"); $("#modal_wrap").hide();
		}
		function submit(){
			document.getElementById("frm").submit();
			$("#first").slideUp("fast"); $("#modal_wrap").hide();
		}
	
	</script>
</head>
<body>
	
	<jsp:include page="../include/header.jsp" />
		
		<div class="grid">
			<jsp:include page="customerSubMenu.jsp" />
			
			<div class="grid-item notice">
				<h3> 자주하는 질문 </h3>
				
				<c:choose>
					<c:when test="${faqList.size() != 0}">
						<c:forEach var="dto" items="${faqList }" varStatus="vs">
						<form action="${contextPath }/delFaq" method="post">
							<div class="accordion">
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
									<input type="hidden" name="faqNum" value="${dto.faqNum} ">
									
									<input type="radio" name="accordion" id="answer${vs.index}">
									<label for="answer${vs.index}">
										${dto.question }
										<s:authorize access="hasRole('ROLE_ADMIN')">
											<button type="submit">삭제</button>
										</s:authorize>
									</label>
									<div><p>${dto.answer }</p></div>
							</div>
						</form>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<h1>등록된 질문이 없습니다.</h1>
					</c:otherwise>
				</c:choose>
			
				<hr>
				
				<s:authorize access="hasRole('ROLE_ADMIN')">
					<button type="button" onclick="slideClick()">등록</button>
				</s:authorize>
				
				
				<div id="modal_wrap">
				<div id="first">
					<div style="width:250px; margin: 0 auto; padding-top: 20px;">
						<form id="frm" action="${contextPath }/addFaq" method="post">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							<b>자주하는 질문 추가 페이지</b><hr>
							<b>제목</b> <br> <input type="text" id="title" size="25" name="title"><hr>
							<b>내용</b> <br> <textarea rows="5" cols="30" id="content" name="content"></textarea>
							<hr>
							<button type="button" onclick="submit()" class="btn btn-outline-secondary">등록</button>
							<button type="button" onclick="slide_hide()" class="btn btn-outline-success">취소</button>
						</form>
					</div>
				</div>
				</div>
				
				
				
				
				
			</div>
			
		</div>
		
		<jsp:include page="../include/footer.jsp" />
</body>
</html>