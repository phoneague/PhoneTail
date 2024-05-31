<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib  prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Q&A View</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 8px;
        }
        th {
            background-color: gray;
        }
    </style>
</head>
<body>
   <article>
			<form>
				<h2>QnA View</h2>
				
				<div class="field" style="border-top:2px solid gold;">
						<label>작성자</label><div>${QuestionDTO.userid}</div>
				</div>
				<div class="field" style="border-top:1px solid gold;">
						<label>제 목</label><div>${QuestionDTO.title}</div>
				</div>			
				<div class="field" style="border-top:1px solid gold;">
						<label>등록일</label><div><fmt:formatDate value="${QuestionDTO.indate}" type="date"/></div>
				</div>
				<div class="field" style="border-top:1px solid gold;">
						<label>질문내용</label><div>${QuestionDTO.content}</div>
				</div>
				<div class="field" style="border-top:2px solid gold; border-bottom:2px solid gold;">
						<label>답변내용</label><div style="padding:10px;">${QuestionDTO.qreply == '' ? '답변 대기중' : QuestionDTO.qreply}</div>
				</div>
				<div class="btn" style="border-bottom:2px solid gold;">
					<input type="button" value="목록으로" onClick="location.href='phonetail.do?command=qnaList'">
					
          <c:if test="${!empty adminUser.adminid}">
						<input type="button" value="답변하기" onClick="location.href='phonetail.do?command=adminQnaReplyForm&qseq=${QuestionDTO.qseq}'">
					</c:if>	
				</div>		
			</form>
		</article>
</body>
</html>
