<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<div class="lititle">
<h2>QnA List</h2>
</div>
<div class="content-wrapper">
<%@ include file="../admin_submenu.jsp"%>
<div class="container">
	<form method="post" name="frm">
		<div class="litb">
			<div class="row">
				<div class="col" style="display: flex; align-items:right;">
					아이디 &nbsp; <input type="text" name="key" value="${key}" /> &nbsp;
					&nbsp; &nbsp; <input class="searchbtn" type="button" name="btn_search"
						value="검색" onClick="go_search('adminQnaList')" />
					&nbsp;&nbsp;&nbsp;<input class="searchbtn" type="button" value="글 작성" onclick="location.href='phonetail.do?command=writeQnaForm'"/>
				</div>
			</div>
			<div class="row">
				<div class="coltitle">번호</div>
				<div class="coltitle">작성자</div>
				<div class="coltitle">제목</div>
				<div class="coltitle">작성일</div>
				<div class="coltitle">답변여부</div>
				<div class="coltitle">조회수</div>
				<div class="coltitle">비밀글</div>
			</div>
			<c:forEach items="${questionList}" var="qna" varStatus="status">
				<div class="row">
					<div class="col">${qna.qseq}</div>
					<div class="col">${qna.userid}</div>
					<div class="col"><a href="phonetail.do?command=qnaView&qseq=${qna.qseq}">${qna.title}</a></div>	
					<div class="col"><fmt:formatDate value="${qna.indate}" type="date"/></div>
					<div class="col">${qna.qreply == '' ? 'NO' : 'YES'}</div>
					<div class="col">${qna.readCount}</div>
					<div class="col">${qna.secret == true ? '비밀글입니다' : ''}</div>
				</div>
			</c:forEach>
			<jsp:include page="/paging/paging.jsp">
				<jsp:param value="phonetail.do?command=adminQnaList" name="address" />
			</jsp:include>
		</div>
	</form>
</div>
</div>
<%@ include file="/footer.jsp"%>