<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jstl�� ����ϱ� ���ؼ���
1. jar���� 2���� �ʿ��ϴ� (o)
2. taglib�� �����ؼ� ����ؾ� �Ѵ�.
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>if���� jstl�� �ٷﺸ��</title>
</head>
<body>
<h2>jstl if...���</h2>
<c:if test="${param.NUM=='100'}">
	<b> ������ 100������ �ԱݵǾ����ϴ�.</b>
</c:if>
<c:if test="${param.NUM=='200'}">
	<b> ������ 200������ �ԱݵǾ����ϴ�.</b>
</c:if>
</body>
</html>
