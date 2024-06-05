<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<link rel="stylesheet" href="css/product.css"> 


<div id="productWrap">
	<div class="row">
		<div class="title">Product Detail</div>
	</div>

	<div class="container">
		<div class="detailImage">
			<img src="product/images/${productDTO.saveimagefile}" width="600" />
		</div>
		<div class="detailInfos">
			<div class="row">
				<div class="coltitle">상품번호</div>
				<div class="col">${productDTO.pseq}</div>
			</div>
			<div class="row">
				<div class="coltitle">판매자</div>
				<div class="col">${productDTO.userid}
				<c:choose>
                                <c:when test="${userStates[productDTO.userid] eq 'B'}">
                                    <span style="color: black; font-weight: bold;">
                                       &nbsp; 블랙리스트
                                    </span>
                                </c:when>
                                <c:when test="${userStates[productDTO.userid] eq 'N'}">
                                	<span style="color: black; font-weight: bold;">
                                       &nbsp; 탈퇴(휴면)회원
                                    </span>
                                </c:when>
                </c:choose>
              </div>
			</div>
			<div class="row">
				<div class="coltitle">브랜드</div>
				<div class="col">${productDTO.brand}</div>
			</div>
			<div class="row">
				<div class="coltitle">시리즈</div>
				<div class="col">${productDTO.series}</div>
			</div>
			<div class="row">
				<div class="coltitle">모델</div>
				<div class="col">${productDTO.model}</div>
			</div>
			<div class="row">
				<div class="coltitle">가격</div>
				<div class="col">${productDTO.price}</div>
			</div>
			<div class="row">
				<div class="coltitle">글 내용</div>
				<div class="col">${productDTO.comment}</div>
			</div>
			<div class="row">
				<div class="coltitle">판매상태</div>
				<div class="col">
				<c:choose>
                                <c:when test="${productDTO.sellstate eq 'Y'}">
                                    <span style="color: red; font-weight: bold;">
                                       &nbsp; 판매완료
                                    </span>
                                </c:when>
                                <c:when test="${productDTO.sellstate eq 'N'}">
                                	<span style="color: black; font-weight: bold;">
                                       &nbsp; 판매중
                                    </span>
                                </c:when>
                </c:choose>
				</div>
			</div>
			<div class="row">
				<div class="coltitle">등록일</div>
				<div class="col">${productDTO.indate}</div>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${productDTO.userid eq login.userid}">
			<div class = "row">
				<c:choose>
				<c:when test="${productDTO.sellstate eq 'N'}">
					<input type="button" value="판매확정" onClick="sold(${productDTO.pseq})" />
					<input type="button" value="상품수정" 
					onClick="go_updateForm(${productDTO.pseq}, '${productDTO.userid}', '${login.userid}')" />
				</c:when>
				</c:choose>
				<input type="button" value="상품삭제" 
					onClick="go_delete(${productDTO.pseq}, '${productDTO.userid}', '${login.userid}')" />
				<input type="button" value="1:1 대화"
					onClick="go_chat(${productDTO.pseq},'${login.userid}')" /> 
			</div>
		</c:when>
		<c:otherwise>
			<div class = "row">
				<input type="button" value="1:1 대화"
					onClick="go_chat(${productDTO.pseq},'${login.userid}')" /> 
				<input type="button" 
					onClick="go_report(${productDTO.pseq},'${login.userid}')"
					value="신고하기">
			</div>
		</c:otherwise>
	</c:choose>
	<div class="row" style="position:relative; margin-bottom:20px;">
		<input type="button" value="이전 상품" style="position:absolute; left:10px;" onclick="go_prev()"/>
		<input type="button" value="다음 상품" style="position:absolute; right:10px;" onclick="go_next()"/>
	</div>
	

</div>

<%@ include file="/footer.jsp"%>