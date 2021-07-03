<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglib.jsp"%>


<html>
<head>
  <title>AirBnD - 숙소 정보 </title>
  <c:import url="../../include/header.jsp" />
  <script defer src="${contextPath}/js/accommodationPhoto.js"></script>

</head>
<body>
<c:import url="../../include/navbar.jsp"/>

<div class="container p-5 m-auto">
  <div class="row">
    <div class="col-xl-12">
      <form action="/hosting/photo?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
        <input style="display: none;" type="file" name="file" class="form-control-file mb-3" id="imgFile" accept="image/*" onchange="setThumbnail(event);" multiple/>
        <button type="button" class="btn-block" id="imgFileBtn">사진업로드</button>
        <button type="submit" class="btn-outline-dark" id="upload">다음</button>
      </form>
      <div class="container-fluid justify-content-center card-group" id="image_container"></div>
    </div>
  </div>
</div>
</body>
</html>