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
String url = "https://search.naver.com/search.naver?";
String word = request.getParameter("word");
url += "query="+word;

//������ �̵�...redirect ���
response.sendRedirect(url);

%>
</body>
</html>