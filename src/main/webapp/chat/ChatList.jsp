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
		<h2>${loginUser}님의 채팅방</h2>
		<div class="title_row">
			<div class="title_col">채팅방번호</div><div class="title_col">제품명</div>
			<div class="title_col">제품가격</div>
		</div>
		<h2></h2>

		<c:forEach items="${chatList}" var="chatList">
				<div class="row">
					<div class="col">${chatList.lseq}</div>
					<div class="col">${chatList.model}</div>
					<div class="col"><input type="button" value="입장" onClick="location.href='phonetail.do?command=chating&lseq=${chatList.lseq}'"></div>
					<div class="col"><input type="button" value="나가기" onClick=""></div> <!-- 딜리트 lseq 하면됨 -->
				</div>
		</c:forEach>
	</div>
</body>
</html>