<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
	/* 校验删除时的提示框 */
	function delete1(){
		/*alert("确定要删除吗？");*/
		var msg="你确定要删除吗";
		if(confirm(msg)==true)
		{return true;}
		else{
			return false;
		}
	}
	</script>
</head>
<body>
	<table border="1" with="700" cellspacing="0" method="post">
		<thead>
		<tr>
			<th>id</th>
			<th>姓名</th>
			<th>密码</th>
			<th>性别</th>
			<th>年龄</th>
			<th>入职时间</th>
			<th>薪资</th>
			<th>电话</th>
			<th>邮箱</th>
			<th colspan="2">操作</th>
		</tr>
		</thead>
		<c:forEach items="${requestScope.emp }" var="e" >
		<tr>
			<td>${e.id }</td>
			<td>${e.name }</td>
			<td>${e.password }</td>
			<td>${e.gender }</td>
			<td>${e.age }</td>
			<td>${e.hiredate }</td>
			<td>${e.salary }</td>
			<td>${e.phone }</td>
			<td>${e.email }</td>
			<td><a href="${pageContext.request.contextPath }/EmpServletBoss?empid=7&id=${e.id}" >恢复</a></td>
			<td><a href="${pageContext.request.contextPath }/EmpServletBoss?empid=8&id=${e.id}" onclick="return delete1()">删除</a></td>
		</tr>
		</c:forEach>
		<br>
	<%-- 	<a href="${pageContext.request.contextPath }/EmpServletEditall">员工恢复</a> --%>
	
	
	</table>
	
</body>
</html>