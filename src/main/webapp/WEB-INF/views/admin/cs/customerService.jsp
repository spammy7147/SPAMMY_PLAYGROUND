<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglib.jsp"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>


<html>
<head>
	<title>AirBnD - 관리자 숙소 검색</title>
	<c:import url="../../include/header.jsp" />
	<!-- 고객센터 / 자주하는 질문 -->
	<style type="text/css">
		
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
			color: white;
			background-color: rgba(78, 115, 223, 0.9);
		}
		
		
		ul{
			list-style:none;
			width:100%;
			padding-left:0px;
		}
		
		.QnaStyle {
			background-color: white;
			border-radius:20px; 
		}
		
		.QnaTitle {
			display: inline-block;
			padding:20px;
			border-radius:20px;
			background-color: #858796; 
			color:white; width:100%;
		}
		
		.collapse-item {
			padding:30;
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
			
			
			
			
				<h1 > 자주하는 질문 </h1> 
				
				<ul>
				<c:choose>
					<c:when test="${faqList.size() != 0}">
						<c:forEach var="dto" items="${faqList }" varStatus="vs">
						
						
						<li class="nav-item">
							<form action="${contextPath }/admin/delFaq" method="post">
								<div class="QnaStyle">
								
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								<input type="hidden" name="faqNum" value="${dto.faqNum} ">
							
						        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapse${vs.index}"
						           aria-expanded="true" aria-controls="collapse${vs.index}">
						            <span class="QnaTitle" >
										${dto.question }
						            </span>
						        </a>
						        
						        <div id="collapse${vs.index}" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
						            <div class="bg-white py-2 collapse-inner rounded">
						            	<div class="collapse-item" >
											${dto.answer }
											<div align="right">
												<input type="submit" class="btn btn-secondary" value="삭제">
											</div>
						            	</div>
						            	
						            </div>
						        </div>
						        
						        </div>
					        </form>
					    </li>
						
						</c:forEach>
						
						
					</c:when>
					<c:otherwise>
						<h1>등록된 질문이 없습니다.</h1>
					</c:otherwise>
				</c:choose>




				</ul>


				<hr>
				<div align="right">
				<button type="button" class="btn btn-primary" onclick="slideClick()">등록</button>
				</div>


				<div id="modal_wrap">
					<div id="first">
						<div style="width:250px; margin: 0 auto; padding-top: 20px;">
							<form id="frm" action="${contextPath }/admin/addFaq" method="post">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								<b>자주하는 질문 추가 페이지</b><hr>
								<b>제목</b> <br> <input type="text" id="title" size="25" name="title"><hr>
								<b>내용</b> <br> <textarea rows="5" cols="30" id="content" name="content"></textarea>
								<hr>
								<div align="center">
									<button type="button" onclick="submit()" class="btn btn-secondary">등록</button>
									<button type="button" onclick="slide_hide()" class="btn btn-secondary">취소</button>
								</div>
							</form>
						</div>
					</div>
				</div>
				
				
				
				
				
				
				
				
				
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