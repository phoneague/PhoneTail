<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="chat/chat.css">
<script src="script/ChatList.js"></script>

</head>
<body>
<div id="main_container">
	<h2>게시글 상세 보기</h2>			
		<div class="login-button">
            <input type="button" class="btn-login" value="뒤로가기" 
            	onClick="location.href='phonetail.do?command=chatList'"/>
        </div>
	</div>
	<div class="reply">
		<div class="reply_row">
			<div class="reply_col reply_title">작성자</div>
			<div class="reply_col reply_title">작성일시</div>
			<div class="reply_col reply_title" style="text-align:center">댓글</div>
			<div class="reply_col reply_title">작성/삭제</div>
		</div>
		<form action="phonetail.do" name="reply">
				<input type="hidden" name="command" value="insertReply" /> 
				<input type="hidden" name="userid" value="${loginUser.userid}" />
				<input type="hidden" name="lseq" value="${chatList.lseq}" />
				<div class="reply_row">
						<div class="reply_col">${loginUser.userid}</div>
						<div class="reply_col">
							<c:set var="now" value="<%=new java.util.Date()%>" />
							<fmt:formatDate value="${now}" pattern="MM/dd hh:mm"/>
						</div>
						<div class="reply_col"><input type="text" name="content" size="75"></div>
						<div class="reply_col">
							<input type="submit" value="답글 작성" onClick="return replyCheck();">
						</div>
				</div>
		</form>
		
		<c:forEach items="${replyList}" var="reply">
			<div class="reply_row">
				<div class="reply_col">${reply.userid}</div>
				<div class="reply_col">
					<fmt:formatDate value="${reply.writedate}" pattern="MM/dd hh:mm"/>
				</div>
				<div class="reply_col">${reply.content}</div>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>