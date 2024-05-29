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
<link rel="stylesheet" href="css/header.css">

<script src="member/script/member.js" ></script>
</head>
<body>
<a href="phonetail.do?command=productList">상품목록</a>
<a href="phonetail.do?command=chatList">채팅게시판</a>
<a href="phonetail.do?command=qnaList">qna게시판</a>>
<a href="phonetail.do?command=loginForm">로그인</a>
<a href="phonetail.do?command=logout">로그아웃</a>
<a href="phonetail.do?command=joinForm">회원가입</a>
<input type="button" value="회원탈퇴" onClick="withDraw('${userid}')"/>
<br>${login.userid}(${login.name})님이 로그인 하셨습니다<br>
<br>${adminUser.admind}(${login.name})님이 로그인 하셨습니다<br>
<a href="phonetail.do?command=admin">admin</a><br><br>
</body>
</html>