<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
	<c:when test="${!empty vo}">
		<% session.invalidate(); %>
	</c:when>
	<c:otherwise>		
		<h2><a href="login.jsp">�α��� �ϱ�</a></h2>
	</c:otherwise>
</c:choose>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
	function logout() {
		alert("Log Out~~");
	}
</script>
</head>
<body onload="return logout()">
<b>�α׾ƿ� �Ǽ̽��ϴ�...</b><br>
<a href="index.jsp">INDEX</a>
</body>
</html>