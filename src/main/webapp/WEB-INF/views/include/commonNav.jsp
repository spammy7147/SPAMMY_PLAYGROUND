<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="${contextPath }/"><i class="bi bi-house"></i></a>
        <div class="nav-item dropdown">
            <button class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"></button>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <s:authorize access="isAnonymous()">
                    <li><a class="dropdown-item" href="${contextPath }/user/login">로그인</a></li>
                    <li><a class="dropdown-item" href="${contextPath }/user/register">회원가입</a></li>
                    <li><hr class="dropdown-divider" /></li>
                    <li><a class="dropdown-item" href="${contextPath}/cs/customerservice">고객센터</a></li>
                </s:authorize>
                <s:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a class="dropdown-item" href="${contextPath}/admin/home">관리자모드</a></li>
                    <li><hr class="dropdown-divider" /></li>
                </s:authorize>
                <s:authorize access="isAuthenticated()">
                    <f:form action="${contextPath }/user/logout" method="POST">
                        <li><a class="dropdown-item" href="#!">여행</a></li>
                        <li><a class="dropdown-item" href="#!">위시리스트</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="${contextPath}/cs/customerservice">고객센터</a></li>
                        <li><input type="submit" class="dropdown-item" value="로그아웃"/></li>
                    </f:form>
                </s:authorize>
            </ul>
        </div>
    </div>
</nav>