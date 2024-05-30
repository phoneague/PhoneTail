<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="report/script/report.js"></script>
</head>
<body>

	<h2>Product Details</h2>
	<article>
		<div class="tb">
			<div class="row">
				<div class="coltitle">상품번호</div>
				<div class="coltitle">판매자</div>
				<div class="coltitle">브랜드</div>
				<div class="coltitle">시리즈</div>
				<div class="coltitle">모델</div>
				<div class="coltitle">가격</div>
				<div class="coltitle">글 내용</div>
				<div class="coltitle">이미지</div>
				<div class="coltitle">이미지이름</div>
				<div class="coltitle">판매상태</div>
				<div class="coltitle">등록일</div>
			</div>
			
			<div>
				<div class="col">${productDTO.pseq}</div>
				<div class="col">${productDTO.userid}</div>
				<div class="col">${productDTO.brand}</div>
				<div class="col">${productDTO.series}</div>
				<div class="col">${productDTO.model}</div>
				<div class="col">${productDTO.price}</div>
				<div class="col">${productDTO.comment}</div>
				<div class="col">	<img src="product/images/${productDTO.saveimagefile}" width="300" /></div>
				<div class="col">${productDTO.image}</div>
				<div class="col">${productDTO.sellstate}</div>
				<div class="col">${productDTO.userid}</div>
				<div class="col"></div>
				<div class="col"></div>
			</div>
		</div>
	</article>

	<div>
		<input type="button" value="상품수정" onClick="go_updateForm(${productDTO.pseq})" />
		<input type="button" value="상품삭제" onClick="go_delete(${productDTO.pseq})" />
		<input type="button" value="댓글쓰기_학현" onClick="go_chat(${productDTO.pseq})" /> 
    <input type="button" onClick="go_report(${productDTO.pseq},'${login.userid}')" value="신고하기">
	</div>

</body>
</html>