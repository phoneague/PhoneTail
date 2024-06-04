<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
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
			<div class="reply_col reply_title">작성일시</div>
			<div class="reply_col reply_title">내용</div>
		</div>
		<c:forEach items="${chatingList}" var="chating">
			<div class="reply_row">
				<div class="reply_col">${chating.userid}</div>
				<div class="reply_col">${chating.content}</div>
				<div class="reply_col">
					<fmt:formatDate value="${chating.indate}" pattern="MM/dd hh:mm"/>
				</div>
			</div>
		</c:forEach>
		<form action="phonetail.do" name="chating">
				<input type="hidden" name="command" value="insertChat" /> 
				<input type="hidden" name="loginUser" value="${loginUser}" />
				<input type="hidden" name="lseq" value="${chatList.lseq}" />
				<div class="reply_row">
						<div class="reply_coll"><input type="text" name="content" size="75" autofocus></div>
						<div class="reply_coll">
							<input type="submit" value="전송" onClick="return replyCheck();">
						</div>
				</div>
		</form>
	</div>

</body>
</html>
<%@ include file="../footer.jsp" %>