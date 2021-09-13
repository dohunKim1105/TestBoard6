<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.example.dto.board.BoardDto" %>

<html lang="ko">
<head>
    <title>분석 의뢰 수정</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" />

</head>

<body id="boardModify">
	<c:choose>
		<c:when test="${not empty sessionScope.user.id }">
			${sessionScope.user.user_name} 님, 안녕하세요 
			<a href="/user/logout">Logout</a><br/>
		</c:when>
		<c:when test="${empty sessionScope.user.id }">
			<a href="/user/login">Login</a><br/>
		</c:when>
	</c:choose>
	
	<c:set var="board" value="${requestScope.boardDto}"/>
	<form method="post">
		
		<label>제목</label>
		<input type="text" name="title" value="${board.getTitle()}" /><br>
		
		<label>내용</label>
		<input type="text" name="content" value="${board.getContent()}" /><br>
		
		<input type="hidden" name="num" value=${board.getNum()} /><br>
		<input type="hidden" name="writer" value=${board.getWriter()} /><br>
		<button type="submit" formaction="/bbs/update">수정 완료</button>
	</form>

</body>
</html>