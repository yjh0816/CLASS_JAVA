<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--  Attribute�� ���ε��� dto��ü�� �޾ƿ´� -->
<%
	Member dto = (Member)request.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2><b><%= request.getParameter("name") %></b>��, ȸ������ ����</h2>
<hr>
<!-- expression tag, ����Ҷ� ��� -->
NAME <%= dto.getName() %><br>
ADDRESS <%= dto.getAddress() %><br>
</body>
</html>