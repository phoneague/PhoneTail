<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅</title>
</head>
<body>
	<div class="board">
		<div class="title_row">
			<div class="title_col">번호</div><div class="title_col">제목</div>
			<div class="title_col">작성자</div>	<div class="title_col">작성일</div>
		</div>
		<c:forEach items="${chatList}" var="board">
				<div class="row">
					<div class="col">채팅방 번호 </div>
					<div class="col">
						<a style="text-decoration:none" href="" >
							핸드폰 이름
						</a>&nbsp;
					</div>
					<div class="col">판매자</div>
					<div class="col"><fmt:formatDate value="${board.writedate}" /></div>
				</div>
		</c:forEach>
	</div>
</body>
</html>