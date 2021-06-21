<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<c:import url="../include/header.jsp" />
<div>
	<form action="${contextPath}/user/login" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="text" name="email" placeholder="input id"><br>
		<input type="password" name="password" placeholder="input pwd"><br>
		자동 로그인 : <input type="checkbox" name="auto-login"/>
		<input type="submit" value="login">
	</form>
</div>
${requestScope.loginFailMsg}
<a href="../user/register">회원가입</a>&nbsp;&nbsp;
