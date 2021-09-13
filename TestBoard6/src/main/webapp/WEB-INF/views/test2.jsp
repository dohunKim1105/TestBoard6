<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" trimDirectiveWhitespaces="true"%>
<%
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
%>
{"id":"<%=id%>", "pwd":"<%=pwd%>", "result":"success"}
