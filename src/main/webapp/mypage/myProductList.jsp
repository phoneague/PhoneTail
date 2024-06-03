<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<%@ include file="mypage_submenu.jsp"%>
<h2>My Product List</h2>
<article>
	<form name="productListForm" method="post">
		<div class="tb">
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
				<jsp:param value="phonetail.do?command=myProductList" name="address" />
			</jsp:include>
		</div>
	</form>
</article>
<%@ include file="/footer.jsp"%>