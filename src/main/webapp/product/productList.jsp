<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="/header.jsp" %>

<!-- 서브메뉴창 상품등록 -->
	<a href="phonetail.do?command=productInsertForm">내폰팔기(상품등록)</a>
	
<!-- 리스트열람(header에 있는 내용이라 삭제할 예정 -->
<div>
	<a href="phonetail.do?command=productList&brand=">전체</a>
	<a href="phonetail.do?command=productList&brand=Samsung">삼성</a>
	<a href="phonetail.do?command=productList&brand=Apple">애플</a>
	<a href="phonetail.do?command=productList&brand=LG">others</a>
</div>
<br><br><br>


<!-- 상품리스트 -->
<h2>Product List</h2>
<article>
	<form name="productListForm" method="post">
		<div class="tb">
			<div class="row">
				<div class="col" style="display: flex; align-items:center;">
					모델명 &nbsp; <input type="text" name="key" value="${key}" /> &nbsp;
					&nbsp; &nbsp; <input class="btn" type="button" name="btn_search"
						value="검색" onClick="go_search('productList')" />
					&nbsp;&nbsp;&nbsp; 
				</div>
			</div>
			<div class="row">
				<div class="coltitle">상품번호</div>
				<div class="coltitle">판매자</div>
				<div class="coltitle">상품모델</div>
				<div class="coltitle">상품가격</div>
				<div class="coltitle">상품이미지</div>
				<div class="coltitle">판매상태</div>
				<div class="coltitle">등록일</div>
			</div>
			<c:forEach items="${productList}" var="productDTO">
				<div class="row">
					<div class="col">${productDTO.pseq}</div>
					<div class="col">${productDTO.userid}</div>
					<div class="col">
					<a href="phonetail.do?command=productDetail&pseq=${productDTO.pseq}">${productDTO.model}</a></div>
					<div class="col">${productDTO.price}</div>
					<div class="col"><img src="product/images/${productDTO.saveimagefile}" width="300" /></div>
					<div class="col">${productDTO.sellstate}</div>
					<div class="col">${productDTO.indate}</div>
				</div>
				
				
			</c:forEach>
			<jsp:include page="/paging/paging.jsp">
				<jsp:param value="phonetail.do?command=productList" name="address" />
			</jsp:include>
		</div>
	</form>
</article>

<%@ include file="/footer.jsp"%>