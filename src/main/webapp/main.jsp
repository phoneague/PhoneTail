<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/header_footer.css">

<script src="member/script/member.js" ></script>
</head>
<body>

<br>관리자 접속상태:
<c:choose>
<c:when test="${!empty adminUser.adminid}">O(${adminUser.adminid})<br>
<a href="phonetail.do?command=adminReportList">▶관리자 페이지로 이동◀</a>
</c:when>
<c:otherwise>X(<a href="phonetail.do?command=admin">관리자로그인</a>)</c:otherwise>
</c:choose>
<br><br>


<%@ include file="footer.jsp" %>

