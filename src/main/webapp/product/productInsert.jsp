<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="product/script/product.js"></script>
<title>productInsert</title>
</head>
<body>
		<h2>Product Insert Form</h2>
		<form name="productInsertForm" method="post" enctype="multipart/form-data">
			<div>
				<label>판매자명</label> ${loginUser}
				<input type="hidden" name="userid" value="${loginUser}" />
			</div>

			<div>
				<label>상품분류</label>
				<div>
					<select name="brand">
						<option>선택하세요</option>
						<c:forEach items="${brandList}" var="brand" varStatus="status">
							<option value="${brand}">${brand}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div>
				<label>상품시리즈</label> <input type="text" name="series" />
			</div>

			<div>
				<label>모델명</label> <input type="text" name="model" />
			</div>

			<div>
				<label>상품가격</label> <input type="text" name="price" />
			</div>
			<div>
				<label>글 내용</label>
				<textarea name="content" rows="8"></textarea>
			</div>
			<div>
				<label>이미지</label> <input type="file" name="image">
			</div>
			<div>
				<input type="button" value="상품등록" onClick="go_insert()"> 
				<input
					type="button" value="목록으로"
					onClick="location.href='phonetail.do?command=productList'">
			</div>
		</form>

</body>
</html>