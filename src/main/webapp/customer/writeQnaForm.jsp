<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<section>
		<article>
			<form name="qnaWriteForm"  method="post">
				<h2> QnA Write </h2>
				<div class="field" >
						<label>작성자</label>
						<input type="text" name="userid" value="${loginUser}" readonly/>
				</div>
				<div class="field" >
						<label>제 &nbsp;&nbsp;목</label>
						<input type="text" name="title" />
				</div>			
				<div class="field" >
						<label>질문내용</label>
						<textarea name="content" rows="10" cols="150"></textarea>
				</div>
				<div class="btn" >
					<input type="button" value="제출하기"  onClick="go_write()">
					 <input type="button" value="목록으로" onClick="location.href='phonetail.do?command=qnaList'">
				</div>													
			</form>
		</article>
		
</section>
<%@ include file="/footer.jsp"%>

