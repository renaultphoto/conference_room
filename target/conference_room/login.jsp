<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE HTML>
<html>
<head>
	<title>登录首页</title>
	<!-- Custom Theme files -->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
	<!--Google Fonts-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
	<!--Google Fonts-->
</head>
<body>
<div class="login">
	<h2>极简会议室预定系统</h2>
	<div class="login-top">
		<h1>Please Login</h1>
		<form role="form" action="${pageContext.request.contextPath}/login" id="from1" method="post">
			<input type="text" placeholder="请输入名字" name="id" id="id">
			<input type="password"  id="password" placeholder="请输入密码" name="password">
		<div class="forgot">
			<a href="${pageContext.request.contextPath}/public/userRegister">注册</a>
			<input type="submit" value="登录" >
		</div>
		</form>
	</div>
	<div class="login-bottom">
		中国化工信息中心出品
	</div>
</div>
</body>
</html>

