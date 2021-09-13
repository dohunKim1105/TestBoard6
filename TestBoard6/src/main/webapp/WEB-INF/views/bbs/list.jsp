<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ko">
<head>
    <title>분석 의뢰 목록 - 002</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<style>
		h2 {
			text-align: center;
		}
		table {
			width: 100%;
		}
		#outter {
			display: block;
			width: 60%;
			margin: auto;
		}
		a {
			text-decoration: none;
		}
	</style>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.0.min.js" ></script>
	<script type="text/javascript">
		function selChange() {
			var sel = document.getElementById('cntPerPage').value;
			location.href="/bbs/list?nowPage=${paging.nowPage}&cntPerPage="+sel;
		}

	</script>
</head>

<body id="boardList">
	<c:choose>
		<c:when test="${not empty sessionScope.user.id }">
			${sessionScope.user.user_name} 님, 안녕하세요 <br>
			<a href="/user/logout">Logout</a><br/>
		</c:when>
		<c:when test="${empty sessionScope.user.id }">
			<a href="/user/login">Login</a><br/>
		</c:when>
	</c:choose>
	<br>
	<h2>board</h2>
	<br/>
	
	<div id="outter">
	<div style="float: right;">
		<select id="cntPerPage" name="sel" onchange="selChange()">
			<option value="5"
				<c:if test="${paging.cntPerPage == 5}">selected</c:if>>5줄 보기</option>
			<option value="10"
				<c:if test="${paging.cntPerPage == 10}">selected</c:if>>10줄 보기</option>
			<option value="15"
				<c:if test="${paging.cntPerPage == 15}">selected</c:if>>15줄 보기</option>
			<option value="20"
				<c:if test="${paging.cntPerPage == 20}">selected</c:if>>20줄 보기</option>
		</select>
	</div> <!-- 옵션선택 끝 -->
	<table border="1">
		<tr>
			<td>No.</td>
			<td width="50%">제목</td>
			<td>작성자</td>
			<td>조회수</td>		
		</tr>
		<c:forEach items="${viewAll }" var="board">
			<tr>
				<td>${board.num }</td>
				<td><a href='detail?num=${board.num }'>${board.title }</a></td>
				<td>${board.writer }</td>
				<td>${board.cnt }</td>
			</tr>
		</c:forEach>
	</table>
	<input type="button" value="글쓰기" style="float: right;" onclick="location.href='/bbs/write'"><br>
	
	<div style="display: block; text-align: center;">		
		<c:if test="${paging.startPage != 1 }">
			<a href="/bbs/list2?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
		</c:if>
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != paging.nowPage }">
					<a href="/bbs/list?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="/bbs/list?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
		</c:if>
	</div>
</div>
</body>
</html>