<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/taglib.jsp"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>


<html>
<head>
	<title>AirBnD - 관리자 숙소 검색</title>
	<c:import url="../include/header.jsp" />
	<!-- 고객센터 / 자주하는 질문 -->
	<style type="text/css">
		
		ul{
			list-style:none;
			width:100%;
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
<c:import url="../include/navbar.jsp" />
<c:import url="customerSubMenu.jsp" />


<!-- Page Wrapper -->
<div id="wrapper">
	


	<!-- Content Wrapper -->
	<div id="content-wrapper">

		<!-- Main Content -->
		<div id="content">

			

			<!-- Begin Page Content -->
			<div class="container-fluid">
			
			
				<h1 align="center"> 자주하는 질문 </h1> 
				
				<ul id="accordionSidebar">
				<c:choose>
					<c:when test="${faqList.size() != 0}">
						<c:forEach var="dto" items="${faqList }" varStatus="vs">
						
						
						<li class="nav-item">
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
									</div>
								</div>
							</div>
						        
							</div>
					    </li>
						
						</c:forEach>
						
						
					</c:when>
					<c:otherwise>
						<h1>등록된 질문이 없습니다.</h1>
					</c:otherwise>
				</c:choose>




				</ul>


				<hr>


				
				
				
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- End of Main Content -->

		<c:import url="../include/footer.jsp"/>
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