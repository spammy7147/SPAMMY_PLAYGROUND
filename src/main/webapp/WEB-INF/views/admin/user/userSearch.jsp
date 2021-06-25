<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript">
	function formSubmit(){
		document.getElementById('frm').submit();
	}
</script>

</head>

<body id="page-top">


    <jsp:include page="../adminNav.jsp"/>

		<!-- Begin Page Content -->
		<div class="container-fluid">
		
		
		<h1 style="text-align: center;">검 색 결 과</h1>
		
		<form action="${contextPath }/admin/user/usersearch">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<select name="choice">
				<option value="1">이메일
				<option value="2">이름
			</select>
			<input type="text" name="userSearch">
			<input type="submit" value="검색">
		</form>
		
		
		
		
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">User DataTable</h6>
 			</div>
			<div class="card-body">
				<div class="table-responsive">
				
					<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
 						<thead>
							<tr>
								<th>Email</th>
								<th>Name</th>
								<th>Register Date</th>
							</tr>
 						</thead>
 						<tfoot>
 							<tr>
								<th colspan="3">
									<c:forEach var="pageNum" begin="1" end="${allPage }">
										<a href="${contextPath }/admin/user/usersearch?pageNum=${pageNum}&choice=${choice}&userSearch=${userSearch}">${pageNum } </a>
									</c:forEach>
								</th>
							</tr>
						</tfoot>
						<tbody>
 							
 							<c:choose>
							<c:when test="${userSearchList.size() != 0 }">
								<c:forEach var="dto" items="${userSearchList }">
									<tr>
										<td>
											<a href="${contextPath }/admin/user/userInfo?userId=${dto.userId }">${dto.email }</a>
										</td>
										<td>${dto.name }</td>
										<td>${dto.regDate }</td> 
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<th colspan="3"> 조건에 해당하는 유저가 없습니다.</th>
								<tr>
							</c:otherwise>
						</c:choose>
								
						</tbody>
					</table>
				</div>
			</div>
		
		
		
		
		
		
		
		
		
		</div>
		<!-- /.container-fluid -->
		
		
		<form action="${contextPath }/admin/usermanage" id="frm">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<a class="btn btn-primary" onclick="formSubmit()">목록으로</a>
		</form>

	<jsp:include page="../adminFooter.jsp"/>
	
	
</body>
</html>