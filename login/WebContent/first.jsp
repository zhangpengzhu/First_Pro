<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fun(){
		alert("还有3秒跳转");
		var timer=setTimeout(function(){window.location.href="/login/testr";},3000);
	}
</script>
</head>
<body>
	<form action="/login/testr" method="get">
		账号:<input type="text" name="username">
		<br>
		密码:<input type="password" name="password" >
			<br>
			<input type="button" value="登录" onclick="fun()"> 
	</form>
</body>
</html>