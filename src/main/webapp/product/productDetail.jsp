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
<h2>여기는 프로덕트 디테일 페이지</h2>
<h2>막 이미지랑 가격이랑 있겠죠?</h2>

<h2>${productDTO.pseq}</h2>
<h2>${productDTO.brand}</h2>
<h2>${productDTO.series}</h2>
<h2>${productDTO.model}</h2>
<h2>${productDTO.price}</h2>
<h2>${productDTO.comment}</h2>
<h2>${productDTO.image}</h2>

	<img src="product/images/${productDTO.saveimagefile}"  width="300"/>
<h2>${productDTO.sellstate}</h2>
<h2>${productDTO.indate}</h2>
<h2>${productDTO.userid}</h2>


<a href="phonetail.do?command=productUpdateForm">상품수정</a>
<a href="phonetail.do?command=">상품삭제(js로 처리)</a>
<input type="button" onClick="go_report(${productDTO.pseq},'${login.userid}')" value="신고하기">



<a href="phonetail.do?command=">댓글쓰기 학현!</a>



</body>
</html>