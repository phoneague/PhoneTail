<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
   <article>
			<form action="phonetail.do?command=adminQnaReply"  method="post">
				<h2>QnA Reply</h2>
				<input type="hidden" name="qseq" value="${ QuestionDTO.qseq}" />
				
				<div class="field" style="border-top:2px solid #3f4549;">
						<label>작성자</label><div>${QuestionDTO.userid}</div>
				</div>
				<div class="field" style="border-top:1px solid #3f4549;">
						<label>제 목</label><div>${QuestionDTO.title}</div>
				</div>			
				<div class="field" style="border-top:1px solid #3f4549;">
						<label>등록일</label><div><fmt:formatDate value="${QuestionDTO.indate}" type="date"/></div>
				</div>
				<div class="field" style="border-top:1px solid #3f4549;">
						<label>질문내용</label><div>${QuestionDTO.content}</div>
				</div>
				<div class="field" style="border-top:2px solid #3f4549; border-bottom:2px solid #3f4549;">
						<label>답변내용</label>
						<div style="padding:10px;">
							<textarea id=story name="qreply" rows="8" cols="80" ></textarea>
								</div>
				</div>
				<div class="btn" style="border-bottom:2px solid #3f4549;">
					<input type="button" value="목록으로" onClick="location.href='phonetail.do?command=qnaList'">
					<input type="submit" value="답변완료" >
				</div>				
			</form>
		</article>
<%@ include file="/footer.jsp"%>
