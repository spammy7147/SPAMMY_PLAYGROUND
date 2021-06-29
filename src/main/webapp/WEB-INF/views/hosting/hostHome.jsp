<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/taglib.jsp"%>

<html>
<head>
    <title>AirBnD - 호스트 시작하기 </title>
    <c:import url="../include/header.jsp" />
</head>
<body>
<c:import url="../include/navbar.jsp"/>

<table>
    <tr>
        <th>이름</th>
        <th>가격</th>
    </tr>
</table>
<br>
<button class="btn"><a href="${contextPath}/hosting/address" class="page-link">숙소 시작하기</a></button>
</body>
</html>
