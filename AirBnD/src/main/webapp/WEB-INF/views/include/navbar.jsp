<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!-- Topbar -->
<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

    <!-- Sidebar Toggle (Topbar) -->
    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
        <i class="fa fa-bars"></i>
    </button>

    <!-- Topbar Navbar -->
    <ul class="navbar-nav container px-4 px-lg-5">
        <li class="nav-item">
            <a class="navbar-brand" href="${contextPath }/"><i class="bi bi-house"></i></a>
        </li>
        <li class="nav-item"></li>

        <!-- Nav Item - User Information -->
        <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small"></span>
                <img class="img-profile rounded-circle"
                     src="${contextPath}/img/account_default.png">
            </a>


            <!-- Dropdown - User Information -->
            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                 aria-labelledby="userDropdown">
                <s:authorize access="isAnonymous()">
                    <a class="dropdown-item" href="${contextPath }/user/login">로그인</a>
                    <a class="dropdown-item" href="${contextPath }/user/register">회원가입</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="${contextPath}/cs/customerservice">고객센터</a>
                </s:authorize>
                <s:authorize access="hasRole('ROLE_ADMIN')">
                    <a class="dropdown-item" href="${contextPath}/admin/home">관리자모드</a>
                    <div class="dropdown-divider"></div>
                </s:authorize>
                <s:authorize access="isAuthenticated()">
                    <a class="dropdown-item" href="${contextPath}/reservation/home">여행</a> <!-- 임시로 만들어뒀습니다. -->
                    <a class="dropdown-item" href="${contextPath}/hosting/home">호스트 되기</a>
                    <a class="dropdown-item" href="${contextPath }/board/boardalllist">게시판</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="${contextPath}/cs/customerservice">고객센터</a>
                    <f:form class="m-0" action="${contextPath }/user/logout" method="POST">
                        <input type="submit" class="dropdown-item" value="로그아웃"/>
                    </f:form>
                </s:authorize>

            </div>
        </li>

    </ul>

</nav>
<!-- End of Topbar -->

