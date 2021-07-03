<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglib.jsp"%>

<html>
<head>
    <title>AirBnD - 호스팅 </title>
    <c:import url="../../include/header.jsp" />
</head>
<body>
<c:import url="../../include/navbar.jsp"/>

<div class="container-fluid">
    <%--    이미지 --%>
    <div class="row justify-content-center">
        <c:forEach var="photo" items="${reservation.accommodation.photoURL}">
            <img class="img-thumbnail wh-300" src="${contextPath}/hosting/file/${reservation.accommodation.accommodationId}?url=${photo}" alt="가져온이미지 추가">
        </c:forEach>
    </div>
    <div class="row justify-content-center mt-5 p-2">
        <%--    숙소 이름 --%>
        <div class="col-xl-12 col-md-6 mb-4">
            <div class="card h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">${reservation.accommodation.name}</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <hr class="my-4">
    <div class="row">
        <div class="col-xl-12 col-lg-7">
            <%--    row 2 --%>
            <div class="row justify-content-center">
                <div class="col-xl-8 col-md-6 mb-4">
                    <div class="card h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-primary text-uppercase mb-1 text-center">타입</div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">${reservation.accommodation.type}</div>
                                </div>
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-primary text-uppercase mb-1 text-center">욕실</div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">${reservation.accommodation.numberOfBathroom}</div>
                                </div>
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-primary text-uppercase mb-1 text-center">침실</div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">${reservation.accommodation.numberOfBedroom}</div>
                                </div>
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-primary text-uppercase mb-1 text-center">침대</div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">${reservation.accommodation.numberOfBed}</div>
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
    </div>
</div>
</body>
</html>
