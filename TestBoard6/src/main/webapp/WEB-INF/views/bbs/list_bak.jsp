<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.dto.board.BoardDto" %>
<%@ page import="com.example.dto.user.UserDto" %>

<html lang="ko">
<head>
    <title>분석 의뢰 목록</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" />

</head>

<body id="boardList">
	<c:choose>
		<c:when test="${not empty sessionScope.user.id }">
			${sessionScope.user.user_name} 님, 안녕하세요 
			<a href="/user/logout">Logout</a><br/>
		</c:when>
		<c:when test="${empty sessionScope.user.id }">
			<a href="/user/login">Login</a><br/>
		</c:when>
	</c:choose>
	<br>
	<h2>board</h2>
	<br/>
	
	<br>
		<a href="/bbs/write">새 게시물 작성</a>
	<br>
	<br/>
	<table border=1>
		<tr>
			<td>
				번호 
			</td>
			<td>
				작성자
			</td>
			<td>
				제목
			</td>
			<td>
				조회수
			</td>
		</tr>
		<c:forEach var="board" items="${requestScope.boardList}">
			<tr>
				<td>
						${board.getNum()}
				</td>
				<td>
					${board.getWriter()}
				</td>
				<td>
					<a href="/bbs/detail/?num=${board.getNum()}">
						${board.getTitle()}
					</a>
				</td>
				<td>
						${board.getCnt()}
				</td>
			</tr>
		</a>
		</c:forEach>
	</table>
	<br>
		[페이징 처리]
	<br>
</body>
</html>