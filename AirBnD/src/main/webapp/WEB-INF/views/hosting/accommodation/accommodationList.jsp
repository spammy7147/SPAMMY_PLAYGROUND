<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglib.jsp"%>

<html>
<head>
    <title>AirBnD - 호스트 시작하기 </title>
    <c:import url="../../include/header.jsp" />
</head>
<body>
<c:import url="../../include/navbar.jsp"/>


<div class="container p-5 m-auto">
    <div class="row justify-content-center">
        <div class="col-xl-8 m-auto">
            <div class="card-body">
                <table class="table table-bordered text-center" id="dataTable" width="100%" cellspacing="0">

                    <c:forEach var="a" items="${accommodations}">
                        <tr>
                            <td>
                                <div class="row no-gutters align-items-center">
                                    <div class="col-10">
                                        <a href="${contextPath}/hosting/accommodation/${a.accommodationId}" class="text-decoration-none">${a.name}</a>
                                    </div>
                                    <div class="col-1">
                                        <a href="${contextPath}/hosting/accommodation/update/${a.accommodationId}" class="bi bi-pencil-square btn btn-trans"></a>
                                    </div>
                                    <div class="col-1">
                                        <a href="${contextPath}/hosting/accommodation/delete/${a.accommodationId}" class="bi bi-x-lg btn btn-trans"></a>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <!-- 페이징 처리 부분  -->
                <ul class="pagination justify-content-center">
                    <!--  이전  -->
                    <c:if test="${pc.prev }">
                        <li class="page-item">
                            <a class="page-link" href="${contextPath}/hosting/home?page=${pc.beginPage-1}">이전</a>
                        </li>
                    </c:if>
                    <!--  페이지 버튼  -->
                    <c:forEach var="pageNum" begin="${pc.beginPage }" end="${pc.endPage }">
                        <li class="page-item ${(pc.paging.page == pageNum) ? 'active' : '' }">
                            <a href="${contextPath}/hosting/home?page=${pageNum}" class="page-link">${pageNum}</a>
                        </li>
                    </c:forEach>
                    <!--  다음  -->
                    <c:if test="${pc.next }">
                        <li class="page-item">
                            <a class="page-link" href="${contextPath}/hosting/home?page=${pc.endPage+1}">다음</a>
                        </li>
                    </c:if>
                </ul>
                <!-- 페이징 처리 끝 -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4 m-auto">
                    <a href="${contextPath}/hosting/address" class="d-none d-sm-inline-block btn btn-outline-primary">숙소 추가</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
