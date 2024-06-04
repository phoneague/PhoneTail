<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
   <div class="ViewContainer">
   <div class="vititle">
		<h2>QnA View</h2>
	</div>
			<form>
			<div class="vifields-horizontal">
				<div class="vifield">
						<label>작성자</label><div>${QuestionDTO.userid}</div>
				</div>
				<div class="vifield">
						<label>제 목</label><div>${QuestionDTO.title}</div>
				</div>			
				<div class="vifield">
						<label>등록일</label><div><fmt:formatDate value="${QuestionDTO.indate}" type="date"/></div>
				</div>
			</div>
				<div class="vicontent">
						<label>질문내용</label><div>${QuestionDTO.content}</div>
				</div>
				
				<div class="vicontent">
						<label>답변내용</label><div style="padding:10px;">${QuestionDTO.qreply == '' ? '답변 대기중' : QuestionDTO.qreply}</div>
				</div>
				
				<div class="vifields-horizontal">
					<div class="btn" >
						<input type="button" value="목록으로" onClick="location.href='phonetail.do?command=qnaList'">
						<c:if test="${QuestionDTO.userid eq login.userid}">
	                  <input type="button" value="삭제하기"  onClick ="if(confirm('정말로 삭제하시겠습니까?')) location.href='phonetail.do?command=deleteQna&qseq=${QuestionDTO.qseq}'"> 
	                       </c:if>
	                    <c:if test="${!empty adminUser.adminid}">
							<input type="button" value="답변하기" onClick="location.href='phonetail.do?command=adminQnaReplyForm&qseq=${QuestionDTO.qseq}'">
						</c:if>	
					</div>
				</div>		
			</form>
		</div>
<%@ include file="/footer.jsp"%>
