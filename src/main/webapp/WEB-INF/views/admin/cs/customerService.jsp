<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">




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
<body id="page-top">


    <jsp:include page="../../include/header.jsp"/>
    <jsp:include page="../sidebar.jsp"/>

		<!-- Begin Page Content -->
		<div class="container-fluid">
		
		
		
			
		<h3> 자주하는 질문 </h3>
				
				<c:choose>
				
					<c:when test="${faqList.size() != 0}">
					
						<c:forEach var="dto" items="${faqList }" varStatus="vs">
						
						
						<form action="${contextPath }/admin/delFaq" method="post">
							<div class="accordion">
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
									<input type="hidden" name="faqNum" value="${dto.faqNum} ">
									
									<input type="radio" name="accordion" id="answer${vs.index}">
									<label for="answer${vs.index}">
										
										${dto.question }
										<button class="btn btn-secondary" type="submit" data-dismiss="modal">삭제</button>
											
									</label>
									<div><p>${dto.answer }</p></div>
							</div>
						</form>
						
						
						
						
						
						
						
						<div class="container-fluid" style="min-height: calc(100vh - 136px);">
							<!-- 그룹 태그로 role과 aria-multiselectable를 설정한다. -->
							<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
								<!-- 하나의 item입니다. data-parent 설청과 href 설정만 제대로 하면 문제없이 작동합니다. -->
								<div class="panel panel-default">
									<div class="panel-heading" role="tab">
									<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse1" aria-expanded="false">
									Item #1
									</a>
									</div>
									<div id="collapse1" class="panel-collapse collapse" role="tabpanel">
										<div class="panel-body">
										Hello world1
										</div>
									</div>
								</div>
								<!-- -->
								
								<!-- 하나의 item입니다. -->
								<div class="panel panel-default">
									<div class="panel-heading" role="tab">
									<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse2" aria-expanded="false">
									Item #2
									</a>
									</div>
									<div id="collapse2" class="panel-collapse collapse" role="tabpanel">
									<div class="panel-body">
									Hello world2
									</div>
									</div>
								</div>
								
								<div class="panel panel-default">
									<div class="panel-heading" role="tab">
									<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse3" aria-expanded="false">
									Item #3
									</a>
									</div>
									<div id="collapse3" class="panel-collapse collapse" role="tabpanel">
									<div class="panel-body">
									Hello world3
									</div>
									</div>
								</div>
							</div>
						</div>

						
						
						
						</c:forEach>
						
					</c:when>
					
					
					<c:otherwise>
						<h1>등록된 질문이 없습니다.</h1>
					</c:otherwise>
				</c:choose>
			
				<hr>
				
				
				<a class="btn btn-primary" onclick="slideClick()">등록</a>
				
				
				<div id="modal_wrap">
				<div id="first">
					<div style="width:250px; margin: 0 auto; padding-top: 20px;">
						<form id="frm" action="${contextPath }/admin/addFaq" method="post">
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
		<!-- /.container-fluid -->

	<jsp:include page="../../include/footer.jsp"/>
	
	
</body>

</html>