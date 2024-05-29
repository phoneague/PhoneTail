<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅</title>
</head>
<body>
	<div class="board">
		<div class="title_row">
			<div class="title_col">채팅방번호</div><div class="title_col">제품명</div>
			<div class="title_col">제품가격</div>
			<div class="title_col">판매자id</div><div class="title_col">구매자 id</div>
			<div class="title_col">시간</div>
		</div>
		<h2></h2>

		<c:forEach items="${chatList}" var="chatList">
				<div class="row">
					<div class="col">${chatList.lseq}</div>
					<div class="col">${chatList.model}</div>
					<div class="col">${chatList.sid}</div>
					<div class="col">${chatList.bid}</div>
					<div class="col"><fmt:formatDate value="${chatList.indate}" /></div>
					<div class="col"><input type="button" value="입장"></div>
				</div>
		</c:forEach>
	</div>
</body>
</html>