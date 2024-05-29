<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link  rel="stylesheet" href="css/header.css">


<script src="script/jquery-3.7.1.min.js"></script>
<script src="member/script/member.js"></script>
</head>
<body>

<div id="wrap">
	<header>
		<nav id="top_menu">
				<div id="logo"><img src="images/logo.png" height="150">	</div>
				<div class="gnb">
						<c:choose>
								<c:when test="${empty loginUser}">
										<a href="phonetail.do?command=loginForm">LOGIN</a>
										<a href="phonetail.do?command=contract">JOIN</a>
								</c:when>
								<c:otherwise>
										<a href="#">${loginUser.name}(${loginUser.userid})</a>
				       					<a href="phonetail.do?command=logout">LOGOUT</a>
								</c:otherwise>
						</c:choose>
						<a href="phonetail.do?command=">Sell</a>
						<a href="phonetail.do?command=">MY PAGE</a>
						<a href="phonetail.do?command=">QnA</a>	
				</div>
				<div class="hmenu"><div></div>	<div></div>	<div></div> 	</div>
		</nav>
		<nav id="category_menu">
				<a href="phonetail.do?command=">Apple</a>
				<a href="phonetail.do?command=">Galaxy</a>
				<a href="phonetail.do?command=">Others</a>
		</nav>
	</header>


