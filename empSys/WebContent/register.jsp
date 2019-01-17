<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/* https://blog.csdn.net/weixin_37580235/article/details/80735385 */
			function fun1(){
				alert("注册成功，请登录");
			}
		</script>
</head>
<body>
		<form action="${pageContext.request.contextPath }/EmpServletBoss?empid=10" method="post">
		编号：<input type="text" name="id">
		<br>
		姓名：<input type="text" name="name">
		<br>
		密码：<input type="password" name="password">
		<br>
		性别：<label><input type="radio" name="gender" checked="checked">男</label>
			<label><input type="radio" name="gender">女</label>
		<br>
		年龄：<input type="text" name="age">
		<br>
		入职日期：<input type="date" name="heridate">
		<br>
		工资：<input type="text" name="salary">
		<br>
		电话：<input type="text" name="phone">
		<br>
		邮箱：<input type="text" name="email">
		<br />
		<input type="reset" value="重置" />
		<input type="submit" value="注册" onclick="fun1()" onsubmit="" />
		</form>
</body>
</html>