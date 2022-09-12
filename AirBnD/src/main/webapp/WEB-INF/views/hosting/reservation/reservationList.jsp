<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglib.jsp"%>

<html>
<head>
  <title>AirBnD - 전체 예약 확인 </title>
  <c:import url="../../include/header.jsp" />
</head>
<body>
<c:import url="../../include/navbar.jsp"/>


<div class="container p-5 m-auto">
  <div class="row justify-content-center">
    <div class="col-xl-8 m-auto">
      <div class="card-body">
        <table class="table table-bordered text-center" id="dataTable" width="100%" cellspacing="0">

          <c:forEach var="r" items="${reservation}">
            <tr>
              <td>
                <div class="row no-gutters align-items-center">
                  <div class="col-10">
                    <a href="${contextPath}/reservation/${r.reservationId}" class="text-decoration-none">${r.name}</a>
                  </div>
                  <div class="col-1">
                    <a href="${contextPath}/reservation/update/${r.reservationId}" class="bi bi-pencil-square btn btn-trans"></a>
                  </div>
                  <div class="col-1">
                    <a href="${contextPath}/reservation/delete/${r.reservationId}" class="bi bi-x-lg btn btn-trans"></a>
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
              <a class="page-link" href="${contextPath}/reservation/home?page=${pc.beginPage-1}">이전</a>
            </li>
          </c:if>
          <!--  페이지 버튼  -->
          <c:forEach var="pageNum" begin="${pc.beginPage }" end="${pc.endPage }">
            <li class="page-item ${(pc.paging.page == pageNum) ? 'active' : '' }">
              <a href="${contextPath}/reservation/home?page=${pageNum}" class="page-link">${pageNum}</a>
            </li>
          </c:forEach>
          <!--  다음  -->
          <c:if test="${pc.next }">
            <li class="page-item">
              <a class="page-link" href="${contextPath}/reservation/home?page=${pc.endPage+1}">다음</a>
            </li>
          </c:if>
        </ul>
        <!-- 페이징 처리 끝 -->
        <div class="d-sm-flex align-items-center justify-content-between mb-4 m-auto">
          <a href="${contextPath}/" class="d-none d-sm-inline-block btn btn-outline-primary m-auto">AirBnD 둘러보기</a>
        </div>

      </div>
    </div>
  </div>
</div>

<script>
  const result = '${result}'
  if(result == "success"){
    alert("삭제완료")
  }

</script>
</body>
</html>
