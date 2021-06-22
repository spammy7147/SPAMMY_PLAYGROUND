<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../include/header.jsp"/>
<title>AirBnD fileupload</title>

multi
<form name="form" method="post" action="/hosting/upload" enctype="multipart/form-data">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input name="user" value="Pyo"/>
    <input name="content" value="Content"/>
    <input type="file" name="files" multiple="multiple"/>
    <input type="submit" id="submit1" value="전송"/>
</form>

<br>
<br>

single
<form name="form" method="post" action="/hosting/file?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
    <input type="file" name="file" /><br>
    <input type="text" name="src" /><br>
    <input type="submit" value="전송" /><br>
</form>

