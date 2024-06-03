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
		<h2>${loginUser}님의 채팅방</h2>
		
		<form name="chatListForm" method="post">
		
				<div class="col" style="display: flex; align-items:center;">
					모델명 &nbsp; <input type="text" name="key" value="${key}" /> &nbsp;
					&nbsp; &nbsp; <input class="btn" type="button" name="btn_search"
						value="검색" onClick="go_search('chatList')" />
					&nbsp;&nbsp;&nbsp; 
				</div>
		</form>
		
		<div class="title_row">
			<div class="title_col">채팅방번호</div>
			<div class="title_col">제품넘버</div>
			<div class="title_col">채팅방 이름</div>
			<div class="title_col">모델명</div>
			<div class="title_col">제품가격</div>
			<div class="title_col">신분? </div>
		</div>
		<h2></h2>

		<c:forEach items="${chatList}" var="chatList">
				<div class="row">
					<div class="col">${chatList.lseq}</div>
					<div class="col">${chatList.pseq}</div>
					<div class="col"> ${chatList.sid},${chatList.bid } 의 채팅방</div>
					<div class="col">${chatList.model}</div>
					<div>${chatList.price}</div>
					<c:choose>
   						<c:when test="${chatList.bid == loginUser}">구매자</c:when>
    					<c:otherwise>판매자</c:otherwise>
					</c:choose>


					
					<div class="col"><input type="button" value="입장" onClick="location.href='phonetail.do?command=chating&lseq=${chatList.lseq}'"></div>
				</div>
		</c:forEach>
		<jsp:include page="/paging/paging.jsp">
				<jsp:param value="phonetail.do?command=chatList" name="address" />
		</jsp:include>
	</div>
</body>
</html>

<%@ include file="../footer.jsp" %>