<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglib.jsp"%>

<html>
<head>
    <title>AirBnD - 예약 변경 </title>
    <c:import url="../../include/header.jsp" />
</head>
<body>
<c:import url="../../include/navbar.jsp"/>
<div class="row">
    <div class="col-xl-6 col-lg-5 m-auto">
        <div class="card shadow h-100 py-2">
            <div class="card-body">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <form action="${contextPath}/reservation/update/${reservation.reservationId}" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            <input type="hidden" name="reservationId" value="${reservation.reservationId}" />
                            <input type="date" class="form-control mb-3" name="checkIn" value="${reservation.checkIn}" placeholder="체크인">
                            <input type="date" class="form-control mb-3" name="checkOut" value="${reservation.checkOut}" placeholder="체크아웃">
                            <input type="text" class="form-control mb-3" id="guest" name="numberOfGuest" value="${reservation.numberOfGuest}" placeholder="게스트">
                            <input type="submit" class="btn btn-outline-primary" value="예약하러 가기">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
