<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<html>
<head>
<title>���i�ꗗ</title>
</head>
<body>
<h1>���i�ꗗ</h1>
<table border="1">
	<tr><th>���i��</th><th>���i</th></tr>
	<c:forEach var="product" items="${data}">
		<tr><td>${product.name}</td><td>${product.price}</td></tr>
	</c:forEach>
</table>
</body>
</html>