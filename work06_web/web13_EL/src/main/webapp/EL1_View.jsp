<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- 원래는 서블릿으로 작성해야 하는데....일단 서블릿이라고 치자.. --%>
<!-- 원래는 서블릿으로 작성해야 하는데....일단 서블릿이라고 치자.. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<b>1. JSP 기본 Element로 받아오기</b>
<%= request.getAttribute("RESULT1") %>
<%= session.getAttribute("RESULT2") %>
<%= application.getAttribute("NAME") %>

<hr>
<b>2. JSP EL 로 받아오기</b>
1. ${RESULT1}
2. ${RESULT2}
3. ${RESULT1 + RESULT2}<br>
</body>
</html>