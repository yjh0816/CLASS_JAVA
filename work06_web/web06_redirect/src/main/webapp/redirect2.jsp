<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String city = request.getParameter("city");
%>
<b>����� ������ ���ô� <%= city %> �Դϴ�.</b>
</body>
</html>