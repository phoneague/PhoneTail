<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="header.jsp"%>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/header_footer.css">


<div id="container">

	<h2>1. 회사의 가치? 이념? 슬로건? 등... 세상을 묶다? (하나로 묶여있는 너와 나의 연결고리 동네에서 함께
		해요)</h2>
</div>

<h2>당신 주변 3명 중 1명은 중고폰을 구매했다니!</h2>
<div id="container">
	<img src="images/mainimg.jpg">
</div>

<h2>3. New Items</h2>
<div class="product_List">
	<c:forEach items="${newList}" var="productDTO">
		<div class="product">
			<div class="productImage">
				<a href="phonetail.do?command=productDetail&pseq=${productDTO.pseq}"><img
					src="product/images/${productDTO.saveimagefile}" width="300px" /></a>
			</div>
			<div class="productModel">
				<a href="phonetail.do?command=productDetail&pseq=${productDTO.pseq}">모델명
					: ${productDTO.model}</a>
			</div>
			<div class="productPrice">가격 : ${productDTO.price}</div>
			<div class="productUserid">판매자 : ${productDTO.userid}</div>
		</div>
		</c:forEach>
</div>





<div id="container">
	<h2>4. 블랙리스트 관리로 인한 안전한 회원관리? 개인정보 걱정 ㄴㄴ 해라</h2>
</div>


<div id="container">
	<h2>5. 동네소개팅?</h2>
</div>

<%@ include file="footer.jsp"%>
