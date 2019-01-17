<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: red;">
	<h1>欢迎 ${sessionScope.emp.name}光临员工管理系统主界面</h1>
	<c:if test="${sessionScope.emp==null }">
	<a href="${pageContext.request.contextPath }/register.jsp">注册</a>
	<a href="${pageContext.request.contextPath }/login.jsp">登录</a>
	</c:if>
	<br>
	<c:if test="${sessionScope.emp!=null }">
	<a href="${pageContext.request.contextPath }/EmpServletBoss?empid=2">员工列表</a>
		<div>上次登录时间:${requestScope.lastTime }</div>
	</c:if>
	
	
</body>
</html>