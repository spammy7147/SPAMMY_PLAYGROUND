<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="#"> 
			<table>
				<tr>
					<td>
						<input type="text" name="id" placeholder="input id"><br>
						<input type="password" name="pwd" placeholder="input pwd"><br>
					</td>
				</tr>
				<tr>
					<td align="right">
						<a href="..//user/register">회원가입</a>&nbsp;&nbsp;
						<input type="submit" value="login">
					</td>
				</tr>				
			</table>
		</form>
	</div>
</body>
</html>