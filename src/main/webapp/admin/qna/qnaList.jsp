<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="../sub_menu.jsp"%>
<h2>
Report List
</h2>
<article>
	<form method="post" name="frm">
		<div class="tb">
			<div class="row">
				<div class="col" style="display: flex; align-items:center;">
					아이디 &nbsp; <input type="text" name="key" value="${key}" /> &nbsp;
					&nbsp; &nbsp; <input class="btn" type="button" name="btn_search"
						value="검색" onClick="go_search('adminQnaList')" />
					&nbsp;&nbsp;&nbsp; <input type="button" style="margin-left: auto;"
						value="신고처리" onClick="go_wrt();">
				</div>
			</div>
			<div class="row">
				<div class="coltitle">번호</div>
				<div class="coltitle">작성자</div>
				<div class="coltitle">제목</div>
				<div class="coltitle">작성일</div>
				<div class="coltitle">답변여부</div>
			</div>
			<c:forEach items="${qnaList}" var="qnaDTO">
				<div class="row">
					<div class="col">${qnaDTO.qseq}</div>
					<div class="col">${qnaDTO.userid}</div>
					<div class="col"><a href="phonetail.do?command=qnaView&qseq=${qnaDTO.qseq}">${qnaDTO.title}</a></div>
					<div class="col"><fmt:formatDate value="${qnaDTO.indate}" type="date"/></div>
					<div class="col">${qnaDTO.qreply == null ? 'NO' : 'YES'}</div>
				</div>
			</c:forEach>
			<jsp:include page="/admin/paging/paging.jsp">
				<jsp:param value="phonetail.do?command=adminQnaList" name="address" />
			</jsp:include>
		</div>
	</form>
</article>
<%@ include file="/admin/footer.jsp"%>