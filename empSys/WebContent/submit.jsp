<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<% 
		/*  生成一个随机数令牌*/
String token=	UUID.randomUUID().toString();	
		session.setAttribute("TOKEN_IN_SESSION", token);
		%>

	<form action="${pageContext.request.contextPath }/SubmitServlet" method="post">
			<input type="hidden" value="${sessionScope.TOKEN_IN_SESSION }" name="hidden">
			<input type="text" name="text">
			<input type="submit"> 
	</form>
</body>
</html>