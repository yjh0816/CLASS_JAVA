<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- ������ �������� �ۼ��ؾ� �ϴµ�....�ϴ� �����̶�� ġ��.. --%>
<!-- ������ �������� �ۼ��ؾ� �ϴµ�....�ϴ� �����̶�� ġ��.. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<b>1. JSP �⺻ Element�� �޾ƿ���</b>
<%= request.getAttribute("RESULT1") %>
<%= session.getAttribute("RESULT2") %>
<%= application.getAttribute("NAME") %>

<hr>
<b>2. JSP EL �� �޾ƿ���</b>
1. ${RESULT1}
2. ${RESULT2}
3. ${RESULT1 + RESULT2}<br>
</body>
</html>