<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="../sub_menu.jsp"%>
<h2>
Report List hihi
</h2>
<article>
	<form method="post" name="frm">
		<div class="tb">
			<div class="row">
				<div class="col" style="display: flex; align-items:center;">
					아이디 &nbsp; <input type="text" name="key" value="${key}" /> &nbsp;
					&nbsp; &nbsp; <input class="btn" type="button" name="btn_search"
						value="검색" onClick="go_search('adminReportList')" />
					&nbsp;&nbsp;&nbsp; <input type="button" style="margin-left: auto;"
						value="신고처리" onClick="go_wrt();">
				</div>
			</div>
			<div class="row">
				<div class="coltitle">번호</div>
				<div class="coltitle">아이디</div>
				<div class="coltitle">타입</div>
				<div class="coltitle">내용</div>
				<div class="coltitle">상태</div>
			</div>
			<c:forEach items="${reportList}" var="reportDTO">
				<div class="row">
					<div class="col">${reportDTO.pseq}</div>
					<div class="col">${reportDTO.userid}</div>
					<div class="col">${reportDTO.retype}</div>
					<div class="col">${reportDTO.recontent}</div>
					<div class="col">${reportDTO.restate}</div>
				</div>
			</c:forEach>
			<jsp:include page="/admin/paging/paging.jsp">
				<jsp:param value="phonetail.do?command=adminReportList" name="address" />
			</jsp:include>
		</div>
	</form>
</article>
<%@ include file="/admin/footer.jsp"%>