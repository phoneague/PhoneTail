<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<div id="main_container">
	<h2>${chatList.sid} 와 ${chatList.bid} 의 채팅방</h2>		
		
		<div class="login-button">
            <input type="button" class="btn-login" value="뒤로가기" 
            	onClick="location.href='phonetail.do?command=chatList'"/>
        </div>
	</div>
	<div class="reply">
	
	
		<div class="mydiv3">
		<c:forEach items="${chatingList}" var="chating">
				<div class="reply_row" >
					<div class="chat_reply_col"></div>
					<c:set var="justify_contentValue" value="flex-start" />
							<c:if test="${chating.userid eq loginUser}" >
							    <c:set var="justify_contentValue" value="flex-end" />
							</c:if>
					<div class="chat_reply_col" style="justify-content: ${justify_contentValue};">
						<c:set var="backgroundColor" value="#DCEBFF" />
							<c:if test="${chating.userid eq loginUser}" >
							    <c:set var="backgroundColor" value="yellow" />
							</c:if>
							<div class="plz" style="background-color: ${backgroundColor};">${chating.content}</div>
						
					</div>
					<div class="chat_reply_col">
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