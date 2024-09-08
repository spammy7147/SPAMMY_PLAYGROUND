<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/taglib.jsp"%>


<html>
<head>
	<title>AirBnD</title>
	<c:import url="include/header.jsp" />
</head>
<body>

<c:import url="include/navbar.jsp" />
<div class="row">
	<div class="col-xl-6 col-lg-5 m-auto">
		<div class="card-body">
			<form action="${contextPath}/hosting/search" method="get">
				<div class="row">
					<div class="form-group col-sm-3 p-0">
						<select id="condition" class="form-control" name="condition">
							<option value="address" ${param.condition == 'address' ? 'selected' : '' }>주소</option>
							<option value="name" ${param.condition == 'name' ? 'selected' : '' }>숙소명</option>
						</select>
					</div>
					<div class="form-group col-sm-6 p-0">
						<input type="text" class="form-control" name="keyword" placeholder="숙소 검색">
					</div>
					<div class="form-group col-sm-3 p-0">
						<input type="submit" class="form-control" value="검색">
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

</body>
</html>

