<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/taglib.jsp"%>

<html>
<head>
    <title>AirBnD - 호스팅 </title>
    <c:import url="../include/header.jsp" />
</head>
<body>
<c:import url="../include/navbar.jsp"/>

<div class="container-fluid">
<%--    row 1 --%>
    <div class="row justify-content-center">
        <img src="" alt="가져온이미지 추가">
    </div>
    <div class="row justify-content-center">
        <div class="col-xl-7 col-md-6 mb-4">
            <div class="card h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1 text-center">숙소 이름</div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">안녕나는숙소이름</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <hr class="my-4">
    <%--    row 2 --%>

    <div class="row justify-content-center">
        <div class="col-xl-2 col-md-6 mb-4">
            <div class="card h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1 text-center">시작날짜</div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">6월 20일</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-2 col-md-6 mb-4">
            <div class="card h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1 text-center">끝날짜</div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">6월 30일</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--    row 3 --%>
    <div class="row justify-content-center">
        <div class="col-xl-2 col-md-6 mb-4">
            <div class="card h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1 text-center">욕실</div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">1개</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-2 col-md-6 mb-4">
            <div class="card h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1 text-center">침실</div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">3개</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-2 col-md-6 mb-4">
            <div class="card h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1 text-center">침대</div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">2개</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
