<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	MemberVO vo = (MemberVO)session.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>Login Information</h2>
ID <%= vo.getId() %>
NAME <%= vo.getName() %>
ADDRESS <%= vo.getAddress() %>
<p></p><hr><p></p>
<a href="logout.jsp">LOG OUT</a>
<a href="index.html">INDEX</a>
</body>
</html>