<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
a:hover {
  color: hotpink;
}

</style>
</head>
<body>
<div class="container">
	<div class="jumbotron" align="center">
		<h1> DB�������� Cafe Member Manage</h1>
	</div>
	<ul>
		<li><a href="find.jsp">ȸ�� �˻� �ϱ�</a></li>
		<c:choose>

			<c:when test="${!empty vo}">
				<li><a href="front.do?command=showAll">��ü ȸ�� ����</a></li>
				<li><a href="update.jsp">ȸ�� ���� �����ϱ�</a></li>
				<li><a href="logout.jsp">�α׾ƿ�</a></li>	
			</c:when>
			<c:otherwise>
				<li><a href="register.jsp">ȸ�� ���� �ϱ�</a></li>
				<li><a href="login.jsp">�α��� �ϱ�</a></li>			
			</c:otherwise>
		</c:choose>
	</ul>
</div>
</body>
</html>