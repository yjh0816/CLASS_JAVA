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
		<b> 오늘은 100만원이 입금되었습니다.</b> 
	</c:when>
	<c:when test="${param.NUM == '200'}"> 
		<b> 오늘은 100만원이 입금되었습니다.</b> 
	</c:when>
	<c:otherwise>
		<b> 오늘은 x만원이 입금되었습니다.</b>
	</c:otherwise>
</c:choose>
</body>
</html>