<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	* {margin: 0; padding: 0;}
	.grid{
		float :left;
	}
	#Submenu {
		padding : 20px;
		margin-left : 10px;
		border-radius: 20px; 
		background-color: rgba(230, 232, 231, 0.9);
		display: inline-block;
		vertical-align: top;
	}
	ul {
		list-style:none;
	}
	a {
		color: black;
	}
</style>

</head>
<body>

	<div class="grid" id="Submenu">
		<h3>고객센터</h3>
		<hr>
		<ul>
			<li><a href="customerservice">FAQ</a></li>
			<li><a href="customerqna">문의하기</a></li>
		</ul>
	</div>

</body>
</html>