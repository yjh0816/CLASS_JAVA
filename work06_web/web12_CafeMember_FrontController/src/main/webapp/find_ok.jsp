<%@page import="servlet.model.MemberVO"%>
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
<h2> ȸ�� ��ȸ ��� </h2>
ID: ${vo.id} <br>
NAME: ${vo.name} <br>
ADDRESS: ${vo.address} 
</body>
</html>