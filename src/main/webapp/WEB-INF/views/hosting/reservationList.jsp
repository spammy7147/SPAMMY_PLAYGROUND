<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/taglib.jsp"%>

<html>
<head>
  <title>AirBnD - 예약 관리 </title>
  <c:import url="../include/header.jsp" />
</head>
<body>
<c:import url="../include/navbar.jsp"/>


<div class="container p-5 m-auto">
  <div class="row justify-content-center">
    <div class="col-xl-8 m-auto">
      <div class="card-body">
        <table class="table table-bordered text-center" id="dataTable" width="100%" cellspacing="0">

          <c:forEach var="r" items="${reservation}">
            <tr>
              <td><a href="${contextPath}/reservation/${r.reservationId}" class="text-decoration-none">${r.name}</a></td>
            </tr>
          </c:forEach>

        </table>
        <div class="d-sm-flex align-items-center justify-content-between mb-4">
          <div></div>
          <a href="${contextPath}/" class="d-none d-sm-inline-block btn btn-outline-primary">AirBnD 둘러보기</a>
        </div>

      </div>
    </div>
  </div>
</div>
</body>
</html>
