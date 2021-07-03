<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglib.jsp"%>


<html>
<head>
    <title>AirBnD - 숙소 수정 </title>
    <c:import url="../../include/header.jsp" />
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=72674637f140df9a7167e5cf81c5912b&libraries=services"></script>
    <script defer src="${contextPath}/js/accommodationPhoto.js"></script>

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
                    <input type="submit" style="display: none;" value="다음">
                </form>
            </div>
        </div>
        <div class="col-lg-8">
            <div class="m-auto" id="map" style="width:600px;height:600px;"></div>
            <script src="${contextPath}/js/address.js"></script>
        </div>
        <div class="row mt-3">
            <button class="d-none d-sm-inline-block btn btn-outline-primary">주소 변경</button>
        </div>


    </div>
    <hr class="my-4">
    <div class="row justify-content-center">
        <div class="col-xl-12 m-auto">
            <div class="card-body">
                <form action="${contextPath}/hosting/house" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    숙소 이름
                    <input type="text" class="form-control mb-3" name="name" placeholder="숙소 이름">
                    숙소의 건물 유형을 선택해주세요. <br>
                    <select class="form-control mb-3" name="type">
                        <option id="apt" value="아파트">아파트</option>
                        <option id="house" value="주택">주택</option>
                        <option id="company" value="전문 숙박">전문 숙박</option>
                    </select>
                    최대 숙박 인원
                    <input type="text" class="form-control mb-3" name="maxNumberOfGuest" value="${accommodation.maxNumberOfGuest}" placeholder="최대 숙박 인원">
                    게스트가 사용할 수 있는 침실은 몇 개인가요?
                    <input type="text" class="form-control mb-3" name="numberOfBedroom" value="${accommodation.numberOfBedroom}" placeholder="침실 갯수">
                    게스트가 사용할 수 있는 침대는 몇 개인가요?
                    <input type="text" class="form-control mb-3" name="numberOfBed" value="${accommodation.numberOfBed}" placeholder="침대 갯수">
                    게스트가 사용할 수 있는 욕실은 몇 개인가요?
                    <input type="text" class="form-control mb-3" name="numberOfBathroom" value="${accommodation.numberOfBathroom}" placeholder="욕실 갯수">
                    호스트 연락처
                    <input type="text" class="form-control mb-3" name="contactNumber" value="${accommodation.contactNumber}" placeholder="연락처">
                    가격
                    <input type="text" class="form-control mb-3" name="price" value="${accommodation.price}" placeholder="가격">
                    숙소 설명
                    <input type="text" class="form-control mb-3" name="description" value="${accommodation.description}" placeholder="세부 정보">
                    <input style="display: none;" type="submit" value="다음">
                </form>
            </div>
        </div>
        <div class="row mt-3">
            <button class="d-none d-sm-inline-block btn btn-outline-primary">주소 변경</button>
        </div>
    </div>

    <hr class="my-4">
    <div class="row justify-content-center">
        <div class="col-xl-6 m-auto">
            <div class="card-body">
                <form action="/hosting/photo?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
                    <input style="display: none;" type="file" name="file" class="form-control-file mb-3" id="imgFile" accept="image/*" onchange="setThumbnail(event);" multiple/>
                    <div class="row justify-content-center">
                        <button type="button" class="d-none d-sm-inline-block btn btn-warning col-xl-6" id="imgFileBtn">사진 추가</button>
                    </div>
                    <div class="row justify-content-center">
                        <button type="submit" class="d-none d-sm-inline-block btn btn-outline-primary col-xl-6" id="upload">사진 업로드</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-xl-12 m-auto">
            <div class="card-body m-auto">
                <div class="container-fluid justify-content-center card-group" id="image_container"></div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
