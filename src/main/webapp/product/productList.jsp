<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<link rel="stylesheet" href="css/product.css">
<div id="productWrap">
	<form name="productListForm" method="post">
		<div class="row">
			<div class="title">
				<h1>Product List</h1>
			</div>
		</div>
		<div class="row">
			<div class="col" style="border: none;">
				<div class="btn">
					<input type="button" value="상품등록" id="sellButton"
						onClick="location.href='phonetail.do?command=productInsertForm'" />
				</div>
				
				<div class="select_btn">
					<select id="sellstateSelect" onchange="handleSellstateChange()" style="border: 1px solid black;">
						<option value="">-- Select State --</option>
						<option value="">전체 상품보기</option>						
            	     	<option value="N">판매중 상품보기</option>
             	       <option value="Y">판매완료 상품보기</option>
					</select>
				</div>
			</div>
			<div class="col"
				style="display: flex; align-items: center; border: none;">
				&nbsp; <input type="text" name="key" value="${key}" style="border: 1px solid black;" /> &nbsp;
				&nbsp; &nbsp; <input class="btn" type="button" name="btn_search"
					value="검색" onClick="go_psearch('productList')" />
				&nbsp;&nbsp;&nbsp;
			</div>
		</div>
		<div class="tb">
			<div class="products">
				<c:forEach items="${productList}" var="productDTO">
					<div class="product">
						<div class="productImage">
							<a
								href="phonetail.do?command=productDetail&pseq=${productDTO.pseq}"><img
								src="product/images/${productDTO.saveimagefile}" width="350px" /></a>
						</div>
						<div class="productModel">
							<a
								href="phonetail.do?command=productDetail&pseq=${productDTO.pseq}">모델명
								: ${productDTO.model}</a>
						</div>
						<div class="productPrice">가격 : <fmt:formatNumber value="${productDTO.price}" type="currency" /></div>
						<div class="productUserid"> 판매자 : ${productDTO.userid}</div>
						
							<c:choose>
								<c:when test="${productDTO.sellstate eq 'Y'}">
						<div class="productSold">
									판매완료
								</c:when>
								<c:otherwise>
							<div class="productSold" style="color:#CD426B;">
									판매중
								</c:otherwise>
							</c:choose>
						</div>
								<div class="productChat" float="left">
								
									<c:if test="${productChatList[productDTO.pseq]!=null}">
										💬 ${productChatList[productDTO.pseq]}
									</c:if>
								</div>
								<div class="productWantcount" style="color:red;">
									<c:if test="${productDTO.wantcount != 0}">
										♥ ${productDTO.wantcount}
									</c:if>
								</div>
						<div class="productDate" style="color: gray;">
							${timeList[productDTO.pseq]}
						</div>
					</div>
				</c:forEach>
			</div>

		</div>
	</form>
	<jsp:include page="/paging/paging.jsp">
		<jsp:param value="phonetail.do?command=productList" name="address" />
	</jsp:include>
</div>

<%@ include file="/footer.jsp"%>
