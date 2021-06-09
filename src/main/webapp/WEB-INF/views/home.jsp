<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script defer src="<c:url value='/bootstrap/js/bootstrap.bundle.js'/>"></script>
    <link rel="stylesheet" href="<c:url value='/bootstrap/css/bootstrap.min.css'/>"/>
    <script defer src="<c:url value='/js/nav.js'/>"></script>
    <link rel="stylesheet" href="<c:url value='/css/nav.css'/>">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col">
                Column
            </div>
            <div class="col">
                Column
            </div>
            <div class="col">
                <nav class="navbar navbar-light">
                    <div class="container-fluid col-auto">
                        <button class="navbar-toggler" type="button" style="border-radius: 30px;">
                            <span class="navbar-toggler-icon"></span>
                            <img src="<c:url value='/img/account_default.png'/>" alt="">
                        </button>
                    </div>
                </nav>
                <div class="collapse" id="collapse">
                    <div class="bg-white p-4">
                        <ul class="list-group">
                            <a href="/hello" class="list-group-item list-group-item-action">메시지</a>
                            <a href="#" class="list-group-item list-group-item-action">알림</a>
                            <a href="#" class="list-group-item list-group-item-action">여행</a>
                            <a href="#" class="list-group-item list-group-item-action">위시리스트</a>
                            <a href="#" class="list-group-item list-group-item-action" style="border-top: 1px; border-style: solid; border-color: rgba(0, 0, 0, 0.1);">계정</a>
                            <a href="#" class="list-group-item list-group-item-action">로그아웃</a>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
