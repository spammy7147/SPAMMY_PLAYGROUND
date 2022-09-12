<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglib.jsp"%>

<html>
<head>
    <title>AirBnD - 숙소 검색 </title>
    <c:import url="../../include/header.jsp" />
</head>
<body>
<c:import url="../../include/navbar.jsp"/>

<div class="row">
    <div class="col-xl-6 col-lg-5 m-auto">
        <div class="card-body">
            <form action="${contextPath}/hosting/search" method="get">
                <div class="row">
                    <div class="form-group col-sm-2 p-0">
                        <select id="condition" class="form-control" name="condition">
                            <option value="address" ${param.condition == 'address' ? 'selected' : '' }>주소</option>
                            <option value="name" ${param.condition == 'name' ? 'selected' : '' }>숙소명</option>
                        </select>
                    </div>
                    <div class="form-group col-sm-6 p-0">
                        <input type="text" class="form-control" name="keyword" placeholder="숙소 검색">
                    </div>
                    <div class="form-group col-sm-2 p-0">
                        <input type="submit" class="form-control" value="검색">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>


<!-- Section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">


            <c:forEach var="a" items="${accommodations}">
                <div class="col mb-5">
                    <div class="card h-100">
                        <!-- Product image-->
                        <img class="card-img-top wh450300" src="${contextPath}/hosting/file/${a.accommodationId}" alt="" />


                        <!-- Product details-->
                        <div class="card-body p-4">
                            <div class="text-center">
                                <!-- Product name-->
                                <h5 class="fw-bolder">${a.name}</h5>
                            </div>
                        </div>
                        <!-- Product actions-->
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                            <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="${contextPath}/hosting/accommodation/${a.accommodationId}">예약</a></div>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</section>

<!-- 페이징 처리 부분  -->
<ul class="pagination justify-content-center">

    <!--  이전  -->
    <c:if test="${pc.prev }">
        <li class="page-item">
            <a class="page-link" href="${contextPath}/hosting/search${pc.makeURI(pc.beginPage-1) }">이전</a>
        </li>
    </c:if>
    <!--  페이지 버튼  -->
    <c:forEach var="pageNum" begin="${pc.beginPage }" end="${pc.endPage }">
        <li class="page-item ${(pc.paging.page == pageNum) ? 'active' : '' }">
            <a href="${contextPath}/hosting/search${pc.makeURI(pageNum)}" class="page-link">${pageNum}</a>
        </li>
    </c:forEach>
    <!--  다음  -->
    <c:if test="${pc.next }">
        <li class="page-item">
            <a class="page-link" href="${contextPath}/hosting/search${pc.makeURI(pc.beginPage-1) }">다음</a>
        </li>
    </c:if>
</ul>
<!-- 페이징 처리 끝 -->
</body>
</html>
