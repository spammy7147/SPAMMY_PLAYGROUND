<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglib.jsp"%>


<html>
<head>
    <title>AirBnD - 주소 </title>
    <c:import url="../../include/header.jsp" />


    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=72674637f140df9a7167e5cf81c5912b&libraries=services"></script>


</head>
<body>
<c:import url="../../include/navbar.jsp"/>


<div class="container p-5 m-auto">
    <div class="row justify-content-center">
        <div class="col-xl-4 m-auto">
            <div class="card-body">
                <form action="${contextPath}/hosting/address" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <input type="text" class="form-control mb-3" id="country" name="country" placeholder="국가">
                    <input type="text" class="form-control mb-3" id="city" name="city" placeholder="시/도">
                    <input type="text" class="form-control mb-3" id="district" name="district" placeholder="시/군">
                    <input type="text" class="form-control mb-3" id="road" name="road" placeholder="상세주소">
                    <input type="text" class="form-control mb-3" id="room" name="room" placeholder="동/호수">
                    <input type="submit" value="다음">
                </form>
                <button class="d-none d-sm-inline-block btn btn-outline-primary" id="addressCheck">주소 확인</button>
            </div>
        </div>
        <div class="col-lg-8">
            <div class="m-auto" id="map" style="width:600px;height:600px;"></div>
            <script src="${contextPath}/js/address.js"></script>
        </div>
    </div>
</div>
</body>
</html>
