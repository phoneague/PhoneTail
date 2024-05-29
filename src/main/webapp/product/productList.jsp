<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="script/product.js"></script>


</head>
<body>

<!-- 서브메뉴창 상품등록 -->
	<a href="phonetail.do?command=productInsertForm">내폰팔기(상품등록)</a>
	
	<br><br><br>
	



<!-- 리스트열람버튼 -->
<div>
	<a href="phonetail.do?command=productList&brand='*'">전체</a>
	<a href="phonetail.do?command=productList&brand='Samsung'">삼성</a>
	<a href="phonetail.do?command=productList&brand='Apple'">애플</a>
	<a href="phonetail.do?command=productList&brand='LG'">LG</a>
	<a href="phonetail.do?command=productList&brand='others'">기타</a>
</div>


<br><br><br>
<!-- 상품리스트 -->
<div>
<c:forEach items="${productList}" var="productDTO">
	<div>
<a href="phonetail.do?command=productDetail&pseq=${productDTO.pseq}">상품열람</a>
	${productDTO.pseq}<br>
	${productDTO.brand}<br>
	${productDTO.series}<br>
	${productDTO.model}<br>
	${productDTO.price}<br>
	${productDTO.comment}<br>
	${productDTO.image}<br>
	<img src="product/images/${productDTO.saveimagefile}" width="300" />
	${productDTO.sellstate}<br>
	${productDTO.indate}<br>
	${productDTO.userid}<br>
	<hr>
	</div>
</c:forEach>

</div>
<!-- 검색창 -->




</body>
</html>