<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../include/header.jsp"/>



<div class="container p-5 m-auto">
    <div class="row justify-content-center">
        <div class="col-xl-auto m-auto">
            <div class="card-body">
                <form action="#" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    숙소의 건물 유형을 선택해주세요. <br>
                    <select class="form-select mb-3" name="houseType">
                        <option value="apt">아파트</option>
                        <option value="house">주택</option>
                        <option value="company">전문 숙박</option>
                    </select>
                    최대 숙박 인원
                    <input type="text" class="form-control mb-3" id="country" name="maxNumberOfGuest" placeholder="최대 숙박 인원">
                    게스트가 사용할 수 있는 침실은 몇 개인가요?
                    <input type="text" class="form-control mb-3" id="city" name="numberofBedroom" placeholder="침실 갯수">
                    게스트가 사용할 수 있는 침대는 몇 개인가요?
                    <input type="text" class="form-control mb-3" id="district" name="numberOfBed" placeholder="침대 갯수">
                    게스트가 사용할 수 있는 침대 종류는 무엇인가요?
                    <select class="form-select mb-3" name="bedType">
                        <option value="king">킹</option>
                        <option value="queen">퀸</option>
                        <option value="double">더블</option>
                        <option value="single">싱글</option>
                    </select>
                    게스트가 사용할 수 있는 욕실은 몇 개인가요?
                    <input type="text" class="form-control mb-3" id="room" name="numberOfBathroom" placeholder="욕실 갯수">
                    <input type="submit" value="다음">
                </form>
            </div>
        </div>
    </div>
</div>
