<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<h2>My Q&A List</h2>
<div class="content-wrapper">
<%@ include file="mypage_submenu.jsp"%>  
<form method="post" name="frm">
	<div class="field" style="border-top: 2px solid gold;">
		제목 명 &nbsp; <input type="text" name="key" value="${key}" /> &nbsp;
		&nbsp; &nbsp; <input class="btn" type="button" name="btn_search"
			value="검색" onClick="go_search('myQnaList')" />
		<div class="btn">
			<input type="button" value="글 작성"
				onclick="location.href='phonetail.do?command=writeQnaForm'" />
		</div>
		&nbsp;&nbsp;&nbsp;
	</div>
	<table>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
			<th>답변여부</th>
		</tr>
		<c:forEach items="${questionList}" var="qna" varStatus="status">
			<tr>
				<td>${qna.qseq}</td>
				<td>${qna.userid}</td>
				<td><a href="phonetail.do?command=qnaView&qseq=${qna.qseq}">${qna.title}</a></td>
				<td><fmt:formatDate value="${qna.indate}" type="date" /></td>
				<td>${qna.qreply == '' ? 'NO' : 'YES '}</td>
			</tr>
		</c:forEach>
	</table>
	<jsp:include page="/paging/paging.jsp">
		<jsp:param value="phonetail.do?command=myQnaList" name="address" />
	</jsp:include>
	
</form>
</div>
<%@ include file="/footer.jsp"%>