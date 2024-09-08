<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglib.jsp"%>


<html>
<head>
    <title>AirBnD - 숙소 정보 </title>
    <c:import url="../../include/header.jsp" />


</head>
<body>
<c:import url="../../include/navbar.jsp"/>



<div class="container p-5 m-auto">
    <div class="row justify-content-center">
        <div class="col-xl-auto m-auto">
            <div class="card-body">
                <form action="${contextPath}/hosting/house" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    숙소 이름
                    <input type="text" class="form-control mb-3" name="name" placeholder="숙소 이름">
                    숙소의 건물 유형을 선택해주세요. <br>
                    <select class="form-control mb-3" name="type">
                        <option value="아파트">아파트</option>
                        <option value="주택">주택</option>
                        <option value="전문 숙박">전문 숙박</option>
                    </select>
                    최대 숙박 인원
                    <input type="text" class="form-control mb-3" name="maxNumberOfGuest" placeholder="최대 숙박 인원">
                    게스트가 사용할 수 있는 침실은 몇 개인가요?
                    <input type="text" class="form-control mb-3" name="numberOfBedroom" placeholder="침실 갯수">
                    게스트가 사용할 수 있는 침대는 몇 개인가요?
                    <input type="text" class="form-control mb-3" name="numberOfBed" placeholder="침대 갯수">
                    게스트가 사용할 수 있는 욕실은 몇 개인가요?
                    <input type="text" class="form-control mb-3" name="numberOfBathroom" placeholder="욕실 갯수">
                    호스트 연락처
                    <input type="text" class="form-control mb-3" name="contactNumber" placeholder="연락처">
                    가격
                    <input type="text" class="form-control mb-3" name="price" placeholder="가격">
                    숙소 설명
                    <input type="text" class="form-control mb-3" name="description" placeholder="세부 정보">
                    <input type="submit" value="다음">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>