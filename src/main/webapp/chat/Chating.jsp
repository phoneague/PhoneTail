<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../header.jsp" %>


<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<div id="main_container">
	<h2>${chatList.sid} 와 ${chatList.bid} 의 채팅방</h2>		
		
		<div class="login-button">
            <input type="button" class="btn-login" value="뒤로가기" 
            	onClick="location.href='phonetail.do?command=chatList'"/>
        </div>
	</div>
	<div class="reply">
	
		<div class="reply_row">
			<div class="reply_col reply_title">작성자</div>
			<div class="reply_col reply_title">내용</div>
			<div class="reply_col reply_title">작성일시</div>
		</div>
		<div class="mydiv3">
		
			<c:forEach items="${chatingList}" var="chating">
				<div class="reply_row" >
					<div class="reply_col">${chating.userid}</div>
					<div class="reply_col">${chating.content}</div>
					<div class="reply_col">
						<fmt:formatDate value="${chating.indate}" pattern="MM/dd hh:mm"/>
					</div>
				</div>
			</c:forEach>
	
		</div>
		<form action="phonetail.do" name="chating">
		<div class="comment-form">
				<input type="hidden" name="command" value="insertChat" /> 
				<input type="hidden" name="loginUser" value="${loginUser}" />
				<input type="hidden" name="lseq" value="${chatList.lseq}" />
				<div class="chat-textarea">
						<div class="content1">
							<input type="text" name="content" autofocus>
						</div>
						<div class="chatsubmit">
							<button type="submit" class="btn btn-light" onClick="return replyCheck();">Send</button>
						</div>
				</div>
			</div>
		</form>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
<%@ include file="../footer.jsp" %>