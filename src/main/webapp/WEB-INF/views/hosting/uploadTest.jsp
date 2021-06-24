<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../include/header.jsp"/>
<title>AirBnD fileupload</title>

multi
<form name="form" method="post" action="/hosting/file?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
    <input type="text" name="src" /><br>
    <input type="file" name="file" multiple="multiple"/><br>
    <input type="submit" value="전송"/>
</form>

<br>
<br>

single
<form name="form" method="post" action="/hosting/file?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
    <input type="file" name="file" /><br>
    <input type="text" name="src" /><br>
    <input type="submit" value="전송" /><br>
</form>

