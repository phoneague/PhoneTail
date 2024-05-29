<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<section>

	<%@ include file="sub_image_menu.jsp"%>
		<article>
			<form action="phonetail.do?command=WriteQna" method="post">
				<h2> QnA Write </h2>
				<div class="field" >
						<label>작성자</label>
						<input type="text" name="userid" value="${loginUser.userid}" readonly/>
				</div>
				<div class="field" >
						<label>제 목</label>
						<input type="text" name="title" />
				</div>			
				<div class="field" >
						<label>질문내용</label>
						<textarea name="content" rows="10" cols="85"></textarea>
				</div>
				<div class="btn" >
					<input type="submit" value="작성완료" />
					<input type="button" value="작성취소" />
				</div>													
			</form>
		</article>
		
</section>
