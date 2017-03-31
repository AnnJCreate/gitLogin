<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
<!--
-->
</style>
</head>
<body id="home">

	<script type="text/javascript" src="js/boc2013_jquery-min.js"></script>
	<!--header-->

	<div class="con_r">
		<div align="center">
			<h3 class="title">用户登录</h3>
		</div>
		<div align="center">
			<form action="/GitLogin/loginAction" method="POST" >
				<label>用户名:</label> <input type="text" name="username" /> <br /> <br />
				<label>密&nbsp;&nbsp;码:</label> <input type="password"
					name="password" /> <br /> <br />
				<button type="submit">登陆</button>
			</form>
		</div>
	</div>

</body>
</html>