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
<c:choose>
	<c:when test="${param.NUM == '100'}"> 
		<b> ������ 100������ �ԱݵǾ����ϴ�.</b> 
	</c:when>
	<c:when test="${param.NUM == '200'}"> 
		<b> ������ 100������ �ԱݵǾ����ϴ�.</b> 
	</c:when>
	<c:otherwise>
		<b> ������ x������ �ԱݵǾ����ϴ�.</b>
	</c:otherwise>
</c:choose>
</body>
</html>