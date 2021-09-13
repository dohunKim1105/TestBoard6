<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%@ page import="com.example.dto.user.UserDto" %>

<html lang="ko">
<head>
    <title>분석 의뢰 페이지</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" />

</head>

<body id="users">

	<br>
	<h2>테스트 페이지 (Users)</h2>
	<br>
	<c:forEach var="user" items="${requestScope.list}">

		<li>
			${user.getUser_name()} 
		</li>
		
	</c:forEach>
	<br>
</body>
</html>