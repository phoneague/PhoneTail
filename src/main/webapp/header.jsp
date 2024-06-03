<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PhoneTail</title>
<link rel="stylesheet" href="admin/css/adminReport.css">
<link rel="stylesheet" href="css/header_footer.css">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="admin/css/admin.css">
<link rel="stylesheet" href="customer/css/qna.css"> 
<link rel="stylesheet" href="product/css/product.css"> 
<link rel="stylesheet" href="admin/css/admin.css">
<link rel="stylesheet" href="customer/css/qna.css">
<link rel="stylesheet" href="admin/css/sub_menu.css">
<link rel="stylesheet" href="admin/css/admin_member.css">
  
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
						<a href="phonetail.do?command=productList">PRODUCT LIST</a>
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


