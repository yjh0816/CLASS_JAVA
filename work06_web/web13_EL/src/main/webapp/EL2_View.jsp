<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<b>1. JSP �⺻ Element ����ϱ�</b>
<%= request.getParameter("myId") %><br>

<b>2. JSP EL ����ϱ�</b>
${param.myId}

<hr>
<b>3. JSP Menu�� �ش��ϴ� �� �⺻ Element ����ϱ�</b>
<%
	String[] menus = request.getParameterValues("menu");
	for(String m : menus) {
%>
		<b><%=m %></b>
<%	
	}
%>
<br>
<b>4. JSP Menu�� �ش��ϴ� �� EL ����ϱ�</b>
������ �޴�::
${paramValues.menu[0]}
${paramValues.menu[1]}
${paramValues.menu[2]}
${paramValues.menu[3]}
</body>
</html>