<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>

<h2>Product Insert Form</h2>
		<form name="productUpdateForm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="pseq" value="${ProductDTO.pseq}">
		<input type="hidden" name="oldimage" value="${ProductDTO.image}">
		<input type="hidden" name="oldsaveimagefile" value="${ProductDTO.saveimagefile}">
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
							<c:choose>
								<c:when test="${ProductDTO.brand eq brand}">
									<option value="${brand}" selected>${brand}</option>
								</c:when>
								<c:otherwise>
									<option value="${brand}">${brand}</option>
								</c:otherwise>
							</c:choose>
							
						</c:forEach>
					</select>
				</div>
			</div>

			<div>
				<label>상품시리즈</label> <input type="text" name="series" value="${ProductDTO.series}" />
			</div>

			<div>
				<label>모델명</label> <input type="text" name="model" value="${ProductDTO.model}" />
			</div>

			<div>
				<label>상품가격</label> <input type="text" name="price" value="${ProductDTO.price}"/>
			</div>
			<div>
				<label>글 내용</label>
				<textarea name="comment" rows="8">${ProductDTO.comment}</textarea>
			</div>
			<div>
				<label>이미지</label> <input type="file" name="image" onClick="previewImage()">
				<img id='preview' src="product/images/${ProductDTO.saveimagefile}" width="200" />
				
				
				
			</div>
			<div>
				<input type="button" value="상품수정" onClick="go_update()"> 
				<input
					type="button" value="목록으로"
					onClick="location.href='phonetail.do?command=productList'">
			</div>
		</form>

<%@ include file="/footer.jsp"%>