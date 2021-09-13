<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%@ page import="com.example.dto.board.BoardDto" %>
<%@ page import="com.example.dto.board.FileDto" %>

<html lang="ko">
<head>
    <title>분석 의뢰 내용</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js"></script>
	<style>
		.button {
			width:120px;
			margin: 0;
			padding: 0.5rem 1rem;
		}
		.button:hover {
			color:white; 
			background-color: skyblue;
		}
		#close {
			width:20px;
			height:20px;
			margin: 0;
		}
	</style>
	<script type="text/javascript">
		function filedownload(fileName) {
		    const encFileName = encodeURI(fileName);
		    const fullPath = "/bbs/fileDownload?fileName=" + encFileName;
		    window.location = fullPath;
		}
		function filedelete(fileName, boardNum) {
			const encFileName = encodeURI(fileName);
			const fullPath = "/bbs/fileDelete?fileName=" + encFileName + "&boardNum=" + boardNum;
			window.location = fullPath;
		}		
	</script>
</head>

<body id="analysisRequestBoarderDetail">
	<c:set var="board" value="${requestScope.boardDto}" />
	<c:set var="fileList" value="${requestScope.fileList}" />
	<c:choose>
		<c:when test="${not empty sessionScope.user.id }">
			${sessionScope.user.user_name} 님, 안녕하세요 
			<a href="/user/logout">Logout</a><br/>
		</c:when>
		<c:when test="${empty sessionScope.user.id }">
			<a href="/user/login">Login</a><br/>
		</c:when>
	</c:choose><br>
	
	번호 : <c:out value="${board.getNum()}" /> <br>
	제목 : <c:out value="${board.getTitle()}" /> <br> 
	작성자 : <c:out value="${board.getWriter()}" /> <br>
	조회수 : <c:out value="${board.getCnt()}" /> <br>
	내용 : <c:out value="${board.getContent()}" /> <br>
	파일개수 : <c:out value="${fileList.size()}" /> <br>
	
	<c:forEach var="file" items="${fileList}">
		파일경로 : <c:out value="${file.getFilePath()}" /> <br>
		파일명 : <c:out value="${file.getFileName()}" />
		<button id="fdown_btn" onclick="filedownload('${file.getFileName()}')">
			파일 다운로드
		</button>
		<img id="close" onclick="filedelete('${file.getFileName()}', '${file.getBoardNum()}')" src="/images/close.png"><br>
	</c:forEach>
	
	
	<a href="/bbs/list">목록</a><br>
	<c:if test="${board.getWriter() eq sessionScope.user.user_name }">
		<a href="/bbs/modify/?num=${board.getNum()}">수정</a><br>
		<a href="/bbs/delete/?num=${board.getNum()}">삭제</a>
	</c:if>

</body>
</html>