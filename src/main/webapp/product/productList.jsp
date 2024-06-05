<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<link rel="stylesheet" href="css/product.css">


<div id="productWrap">
	<form name="productListForm" method="post">
		<div class="row">
			<div class="title"><h1>Product List</h1></div>
		</div>
		<div class="row">
			<div class="col">
				<div class="btn">
					<input type="button" value="상품등록" id="sellButton"
						onClick="location.href='phonetail.do?command=productInsertForm'" />
				</div>
			</div>
			<div class="col" style="display: flex; align-items: center;">
				&nbsp; <input type="text" name="key" value="${key}" /> &nbsp;
				&nbsp; &nbsp; <input class="btn" type="button" name="btn_search"
					value="검색" onClick="go_search('productList')" />
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
						<div class="productPrice">가격 : ${productDTO.price}</div>
						<div class="productUserid">
                            판매자 : ${productDTO.userid} 
                            <c:choose>
                                <c:when test="${userStates[productDTO.userid] eq 'B'}">
                                    <span style="color: black; font-weight: bold;">
                                        블랙리스트
                                    </span>
                                </c:when>
                                <c:when test="${userStates[productDTO.userid] eq 'N'}">
                                	<span style="color: black; font-weight: bold;">
                                        탈퇴(휴면)회원
                                    </span>
                                </c:when>
                                <c:otherwise>
                                    (${userStates[productDTO.userid]})
                                </c:otherwise>
                            </c:choose>
                        </div>
						<div class="productSold">
							<c:choose>
								<c:when test="${productDTO.sellstate eq 'Y'}">
									판매완료
								</c:when>
								<c:otherwise>
									판매중
								</c:otherwise>
							</c:choose>
						</div>
						<div class="productChat">
						채팅방 수 : ${productChatList[productDTO.pseq]}
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
