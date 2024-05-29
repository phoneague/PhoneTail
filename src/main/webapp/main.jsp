<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
<h1>Phonetail</h1>
<a href="phonetail.do?command=productList">상품목록</a>
<a href="phonetail.do?command=chatList">채팅게시판</a>
<a href="phonetail.do?command=qnaList">qna게시판</a>>
<a href="phonetail.do?command=loginForm">로그인</a>
<a href="phonetail.do?command=logout">로그아웃</a>
<a href="phonetail.do?command=joinForm">회원가입</a>
<br>${login.userid}(${login.name})님이 로그인 하셨습니다<br>
<br>관리자접속 여부:${adminUser.adminid}<br>
<a href="phonetail.do?command=admin">admin</a><br><br>
</body>
</html>