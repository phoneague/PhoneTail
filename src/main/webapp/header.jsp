<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PhoneTail</title>

<link rel="stylesheet" href="css/submenu.css"> <!-- submenu들 css 통합  -->
<link rel="stylesheet" href="css/header_footer.css"> <!-- header footer의 css 통합 -->
<link rel="stylesheet" href="css/list.css"> <!-- product, chat제외 list 들 css 통합 -->
<link rel="stylesheet" href="css/view.css"><!-- product, chat제외 view 들 css 통합 --> 
<link rel="stylesheet" href="css/login.css"> <!-- admin,일반 로그인 폼들 css 통합 -->
<link rel="stylesheet" href="css/chat.css"> <!-- chat css 통합 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<script src="script/phonetail.js"></script>
<script src="script/jquery-3.7.1.min.js"></script>
<script src="product/script/product.js"></script>
<script src="admin/script/admin.js"></script>
<script src="report/script/report.js"></script>
<script src="chat/ChatList.js"></script>
<script src="member/script/member.js" ></script>
<script src="customer/script/customer.js"></script>
</head>
<body>

<div id="wrap">
	<header>
		<nav id="top_menu">
				<div id="logo"><img src="images/logo.png" height="150" onClick="location.href='phonetail.do?command=main'"></div>
				<div class="gnb">
						<c:choose>
								<c:when test="${empty login}">
										<a href="phonetail.do?command=loginForm">LOGIN</a>
										<a href="phonetail.do?command=joinForm">JOIN</a>
								</c:when>
								<c:otherwise>
										<a href="phonetail.do?command=mypage">${login.name}(${login.userid})</a>
				       					<a href="phonetail.do?command=logout">LOGOUT</a>
								</c:otherwise>
						</c:choose>
						<a href="phonetail.do?command=productInsertForm">SELL</a>
						<a href="phonetail.do?command=mypage">MY PAGE</a>
						<a href="phonetail.do?command=qnaList">QnA</a>	
						<a href="phonetail.do?command=chatList">CHAT</a>	
				</div>
				<div class="hmenu"><div></div>	<div></div>	<div></div> 	</div>
		</nav>
		<nav id="category_menu">
				<a href="phonetail.do?command=productList&brand=">All Products</a>
				<a href="phonetail.do?command=productList&brand=Apple">Apple</a>
				<a href="phonetail.do?command=productList&brand=Samsung">Galaxy</a>
				<a href="phonetail.do?command=productList&brand=LG">Others</a>
		</nav>
	</header>


