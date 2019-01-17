<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a>update</a>
	<form action="${pageContext.request.contextPath }/EmpServletEditchange?empid=4" method="post">
	编号：<input type="text" name="id" value="${requestScope.emp.id }">
	<br>
	用户名：<input type="text" name="name" value="${ requestScope.emp.name}">
	<br>
	密码：<input type="password" name="password" value="${requestScope.emp.password }">
	<br>
	性别：<label><input type="radio" name="gender" value="女" checked="checked">女</label>
	<label><input type="radio" name="gender" value="男" >男</label>
	<br>
	年龄：<input type="text" name="age" value="${requestScope.emp.age }">
	<br>
	入职日期：<input type="date" name="heridate" value="">
	<br>
	工资：<input type="text" name="salary" value="${requestScope.emp.salary }">
	<br>
	电话：<input type="text" name="phone" value="${requestScope.emp.phone }">
	<br>
	邮箱：<input type="text" name="email" value="${requestScope.emp.email }">
	<br>
	<input type="reset" value="重置">
	<input type="submit" value="修改">
	</form>
	
</body>
</html>