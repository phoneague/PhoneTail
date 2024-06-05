<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅</title>
</head>
<body>
	<div class="board">
		<h2>${loginUser} 채팅목록</h2>
		
		<form name="chatListForm" method="post">
				<div class="col" style="display: flex; align-items:center;">
					모델명 &nbsp; <input type="text" name="key" value="${key}" /> &nbsp;
					&nbsp; &nbsp; 
					<button type="button" class="btn btn-dark" onClick="go_searcha('chatList')">검색</button>
					&nbsp;&nbsp;&nbsp; 
				</div>
		
		
		<div class="title_row">
			<div class="title_col">제품넘버</div>
			<div class="title_col">채팅방 이름</div>
			<div class="title_col">모델명</div>
			<div class="title_col">제품가격</div>
			<div class="title_col">신분? </div>
		</div>
		<h2></h2>

		<c:forEach items="${chatList}" var="chatList">
				<div class="chat_row">
					<div class="chatcol">${chatList.pseq}</div>
					<div class="chatcol">
						<div class="phonename">
							${chatList.model}
						</div>
						<div class="phoneprice">
							<fmt:formatNumber value="${chatList.price}" pattern="#,###"/>원							
						</div>
					</div>
					<div class="chatcol"> ${chatList.sid},${chatList.bid } 의 채팅방</div>
					<div class="chatcol">
					<c:choose>
   						<c:when test="${chatList.bid == loginUser}"><h5><span class="badge text-bg-success">구매자</span></h5></c:when>
    					<c:otherwise><h5><span class="badge text-bg-danger">판매자</span></h5></c:otherwise>
					</c:choose>
					</div>
					<div class="chatcol">
					<button type="button" class="btn btn-secondary" onClick="location.href='phonetail.do?command=chating&lseq=${chatList.lseq}'">입장</button>
					</div>
				</div>
					
			</c:forEach>
		<%-- <jsp:include page="/paging/paging.jsp">
				<jsp:param value="phonetail.do?command=chatList" name="address" />
		</jsp:include> --%>
	</form>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>	
</body>
</html>

<%@ include file="../footer.jsp" %>