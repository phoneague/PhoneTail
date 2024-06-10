<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="header.jsp"%>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/header_footer.css">

<div class="container">
	<div class="box">
		<h2>PhoneTail-세상을 묶다</h2>
		<br>
		<h3>하나로 묶여있는</h3>
		<h3>너와 나의 연결고리</h3>
		<h3>동네에서 함께 해요</h3>
	</div>

	<div class="box">
		<div class="box-inner">
			<img src="images/1.png">
		</div>
		<div class="box-inner">
			<img src="images/2.png"">
		</div>
		<div class="box-inner">
			<img src="images/3.png">
		</div>
	</div>

	<div class="box">
		<div class="box-inner">
			<img src="images/4.png"">
		</div>
		<div class="box-inner">
			<img src="images/5.png">
		</div>
		<div class="box-inner">
			<img src="images/6.png"">
		</div>
	</div>

	<c:forEach items="${newList}" var="newlist" varStatus="status">
		<div class="box">
			<div class="box-inner">
				<a href="phonetail.do?command=productDetail&pseq=${newlist.pseq}">
					<img src="product/images/${newlist.saveimagefile}" width="200">
				</a>
			</div>
			<div class="box-inner">
				<a href="phonetail.do?command=productDetail&pseq=${newlist.pseq}">
					${newlist.model} - <fmt:formatNumber value="${newlist.price}"
						type="currency" />
				</a>
			</div>
		</div>
	</c:forEach>

	<div class="box">
		<h2>PhoneTail 에서 사야하는 이유</h2>
	</div>

	<div class="box">
		<h2>안전한 직거래</h2>
		<img src="images/55.jpg">
	</div>

	<div class="box">
		<h2>합리적인 가격</h2>
		<img src="images/p1.png">
	</div>

	<div class="box">
		<h2>PhoneTail 만의 회원관리</h2>
	</div>

	<div class="box">
		<h2>BLACKLIST</h2>
		<img src="images/b1.jpg">
	</div>

	<div class="box">
		<div class="image-container">
			<img src="images/m2.png" class="box-image">
			<div class="red-border"></div>
		</div>
	</div>


	<%@ include file="footer.jsp"%>