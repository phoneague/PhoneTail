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
			<form action="phonetail.do?command=adminQnaReply"  method="post">
				<h2>QnA Reply</h2>
				<input type="hidden" name="qseq" value="${ QuestionDTO.qseq}" />
				
				<div class="field" style="border-top:2px solid red;">
						<label>작성자</label><div>${QuestionDTO.userid}</div>
				</div>
				<div class="field" style="border-top:1px solid red;">
						<label>제 목</label><div>${QuestionDTO.title}</div>
				</div>			
				<div class="field" style="border-top:1px solid red;">
						<label>등록일</label><div><fmt:formatDate value="${QuestionDTO.indate}" type="date"/></div>
				</div>
				<div class="field" style="border-top:1px solid red;">
						<label>질문내용</label><div>${QuestionDTO.content}</div>
				</div>
				<div class="field" style="border-top:2px solid red; border-bottom:2px solid red;">
						<label>답변내용</label>
						<div style="padding:10px;">
							<textarea id=story name="qreply" rows="8" cols="40" ></textarea>
								</div>
				</div>
				<div class="btn" style="border-bottom:2px solid red;">
					<input type="button" value="목록으로" onClick="location.href='phonetail.do?command=qnaList'">
					<input type="submit" value="답변완료" >
				</div>				
			</form>
		</article>
</body>
</html>
