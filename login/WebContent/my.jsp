<%@page import="java.util.Date"%>
<%@page import="javax.xml.crypto.Data"%>
<%@page import="org.apache.tomcat.jni.Time"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	<!-- 哎1111111111111111111这段代码别人看得到 -->
		<%--aaaaaaaaaaaa这段代码是jsp的注释代码，别人看不到 --%>
		<p>无情老开</p>
		当前时间：<%= new Date().toLocaleString() %>
		<% 
		String str="abb";
		System.out.println(str);
		response.getWriter().write("wawaw");
		%>
		
	
		
		
	<%	int time = 12;
	
		if(time == 12){
	%>
			12点钟了, 吃饭
	<%
		} else {
	%>
			还没到12点, 学习为重
	<% 
		}
	%>
		
		
			<%
		int time1=12;
		if(time1==12){%>
			吃饭
	<%	}
		else{ 
		%>
			不吃
		<%}
		
		%>
</body>
</html>