<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>

<div id="productWrap">
    <div class="row">
        <div class="title">Product List</div>
        <div class="btn">
            <input type="button" value="상품등록" onClick="location.href='phonetail.do?command=productInsertForm'" />
        </div>
    </div>
    <form name="productListForm" method="post">
        <div class="tb">
            <div class="row">
                <div class="col" style="display: flex; align-items: center;">
                    모델명 &nbsp; <input type="text" name="key" value="${key}" /> &nbsp;
                    &nbsp; &nbsp; <input class="btn" type="button" name="btn_search" value="검색" onClick="go_search('productList')" />
                    &nbsp;&nbsp;&nbsp;
                </div>
            </div>
            <div class="products">
                <c:forEach items="${productList}" var="productDTO">
                    <div class="product">
                        <div class="productImage"><a href="phonetail.do?command=productDetail&pseq=${productDTO.pseq}"><img src="product/images/${productDTO.saveimagefile}" width="350px"/></a></div>
                        <div class="productModel"><a href="phonetail.do?command=productDetail&pseq=${productDTO.pseq}">${productDTO.model}</a></div>
                        <div class="productPrice">${productDTO.price}</div>
                        <div class="productUserid">
                			${productDTO.userid}
            			</div>
                    </div>
                </c:forEach>
            </div>
            <jsp:include page="/paging/paging.jsp">
                <jsp:param value="phonetail.do?command=productList" name="address" />
            </jsp:include>
        </div>
    </form>
</div>

<%@ include file="/footer.jsp"%>
