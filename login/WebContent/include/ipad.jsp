<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%/*
	JSP内置对象
	*/
	request.setAttribute("name", "siri");
	System.out.println(1/1);
	%>
	<%=request.getAttribute("name") %>
	<% response.setCharacterEncoding("utf-8"); %>
	<%=response.getCharacterEncoding() %>
</body>
</html>