<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/taglib.jsp"%>

<html>
<head>
    <title>AirBnD - 호스트 시작하기 </title>
    <c:import url="../include/header.jsp" />
</head>
<body>
<c:import url="../include/navbar.jsp"/>


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
                                    <div class="col-2 pl-5">
                                        <a href="${contextPath}/hosting/accommodation/delete/${a.accommodationId}" class="bi bi-x-lg btn btn-trans"></a>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>


                </table>
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <div></div>
                    <a href="${contextPath}/hosting/address" class="d-none d-sm-inline-block btn btn-outline-primary">숙소 추가</a>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
