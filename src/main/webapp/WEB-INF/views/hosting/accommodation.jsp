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
<%--    이미지 --%>
    <div class="row justify-content-center">
        <img src="" alt="가져온이미지 추가">
    </div>
    <div class="row justify-content-center">
        <%--    숙소 이름 --%>
        <div class="col-xl-12 col-md-6 mb-4">
            <div class="card h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">안녕나는숙소이름</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <hr class="my-4">
    <div class="row">
        <div class="col-xl-8 col-lg-7">
            <%--    row 2 --%>
            <div class="row justify-content-center">
                <div class="col-xl-8 col-md-6 mb-4">
                    <div class="card h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-primary text-uppercase mb-1 text-center">타입</div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">아파트</div>
                                </div>
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-primary text-uppercase mb-1 text-center">욕실</div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">1</div>
                                </div>
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-primary text-uppercase mb-1 text-center">침실</div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">3</div>
                                </div>
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-primary text-uppercase mb-1 text-center">침대</div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">2</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <hr class="my-4">
            <div class="row justify-content-center">
                <div class="col-xl-8 col-md-6 mb-4">
                    <div class="card h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-4 col-lg-5">
            <div class="card shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <form action="#" method="post">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                <input type="date" class="form-control mb-3" name="checkIn" placeholder="체크인">
                                <input type="date" class="form-control mb-3" name="checkOut" placeholder="체크아웃">
                                <input type="text" class="form-control mb-3" id="guest" name="guest" placeholder="게스트">
                                <input type="submit" class="btn btn-outline-primary" value="예약하러 가기">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


</div>
</body>
</html>
