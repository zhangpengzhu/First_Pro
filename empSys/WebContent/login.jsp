<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<script type="text/javascript">
function changeImg(){
	// 获取到img的空间对象
	var val = document.getElementById("validate");
	// 每次重新访问地址
	val.src="${pageContext.request.contextPath }/ValidateServlet?date=" + new Date();
}
	
		function fun1(){
			var a=	document.getElementById("name").value;
			var b=	a.length;
			if(b>8){
				alert("输入的长度不能超过8");
				
			}
		}
		</script>
<style type="text/css">
		*{
			padding: 0;
			margin: 0;
		}
			#login {
				border-radius: 10px;
				width: 360px;
				height: 340px;
				margin-top: 130px;
			margin-left: 700px;
			background-color: white;
				opacity: 0.7;
			position:absolute;
			font-size: 20px;
			padding: 15px;
			}
			
			#div1 {
				width: 100%;
				height: 100%;
				position: absolute;
				background-image: url(img/05.jpg);
				background-color: red;
				background-repeat: no-repeat;
				background-size: cover;
			}#chongzhi{
				width: 120px;
			margin-left: 10px;
				margin-right: 50px;
			
			}
			#chongzhi1{
				
				width: 330px;
				
			}
			#yanzhen{
			
			width:190px ;
			border-radius: 5px;
			margin-left: 10px;
				display: inline-block;
			}
		</style>
	</head>

	<body>
		<div id="div1">

			<form action="${pageContext.request.contextPath }/EmpServletBoss?empid=1" method="post" id="login">
				<label for="exampleInputEmail1">用户名:</label><input type="text" name="name" id="name" placeholder="请输入用户名" class="form-control"><span id="namespan"></span>
				
				<label for="exampleInputPassword1">密码:</label><input type="password" name="password" placeholder="请输入密码"  id="password" class="form-control">
				
			<!-- 	<input type="checkbox" checked="checked" >记住用户名 -->
				 ${requestScope.error_msg }
				<br>
				<img alt="验证码" id="validate" src="${pageContext.request.contextPath }/ValidateServlet"
				style="cursor: pointer;" onclick="changeImg()"/>	
				<label for="exampleInputEmail1"></label><input type="text" id="yanzhen" class="form-control" name="validate" placeholder="请输入验证码"  >
				<label style="position: absolute;bottom:0px;right:0px;"><font color="red">${val_msg }</font></label>
			<br>
		<br>
				<!-- <input id="chongzhi" type="reset" value="重置" class="btn btn-primary"> -->
				<input id="chongzhi1" type="submit" value="登录"  class="btn btn-success" onclick="fun1()">

			</form>
		</div>
</body>
</html>