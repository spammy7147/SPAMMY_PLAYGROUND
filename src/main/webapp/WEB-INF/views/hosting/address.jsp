<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../include/header.jsp"/>


<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=72674637f140df9a7167e5cf81c5912b&libraries=services"></script>
<script defer src="${contextPath}/js/address.js"></script>


<div class="test">
    <form action="<c:url value='/hosting/address'/>" method="post">
        <input type="text" name="country" placeholder="국가"><br>
        <input type="text" name="city" placeholder="시/도"><br>
        <input type="text" name="district" placeholder="시/군"><br>
        <input type="text" name="road" placeholder="상세주소"><br>
        <input type="text" name="room" placeholder="동/호수"><br>
        <div id="map" style="width:500px;height:400px;"></div>
        <input type="submit" value="다음">
    </form>
</div>
