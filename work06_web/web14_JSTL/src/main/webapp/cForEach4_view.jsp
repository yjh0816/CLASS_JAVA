<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>�츮 ���Կ��� �ǸŵǴ� ���ϵ� �Դϴ�.</h2>
<c:forEach var="item" items="${list}">
	<b>${item}</b>
</c:forEach>
</body>
</html>