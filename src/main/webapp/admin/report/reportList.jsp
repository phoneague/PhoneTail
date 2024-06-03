<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<%@ include file="../sub_menu.jsp"%>
<h2>
Report List
</h2>
<div class="recontainer">
	<form method="post" name="frm">
		<div class="retb">
			<div class="rerow">
				<div class="recol" style="display: flex; align-items:center;">
					아이디 &nbsp; <input type="text" name="key" value="${key}" /> &nbsp;
					&nbsp; &nbsp; <input class="searchbtn" type="button" name="btn_search"
						value="검색" onClick="go_search('adminReportList')" />
					&nbsp;&nbsp;&nbsp; 
				</div>	
			</div>
			<div class="rerow">
				<div class="recoltitle">번호</div>
				<div class="recoltitle">아이디</div>
				<div class="recoltitle">타입</div>
				<div class="recoltitle">신고날짜</div>
				<div class="recoltitle">상태</div>
			</div>
			<c:forEach items="${reportList}" var="reportDTO">
				<div class="rerow">
					<div class="recol">${reportDTO.reseq}</div>
					<div class="recol"><a href="phonetail.do?command=reportView&reseq=${reportDTO.reseq}">${reportDTO.userid}님의 신고글</a></div>
					<div class="recol">
						<c:choose>
								<c:when test="${reportDTO.retype==0}">광고성 콘텐츠(거래와 관련없는 글)[코드:${reportDTO.retype}]</c:when>
								<c:when test="${reportDTO.retype==1}">상품정보 부정확[코드:${reportDTO.retype}]</c:when>
								<c:when test="${reportDTO.retype==2}">안전거래를 거부해요[코드:${reportDTO.retype}]</c:when>
								<c:when test="${reportDTO.retype==3}">사기가 의심돼요(외부 채널 유도)[코드:${reportDTO.retype}]</c:when>
								<c:when test="${reportDTO.retype==4}">전문업자 같아요[코드:${reportDTO.retype}]</c:when>
								<c:when test="${reportDTO.retype==5}">기타[코드:${reportDTO.retype}]</c:when>
						</c:choose>
					</div>
					<div class="recol"><fmt:formatDate value="${reportDTO.indate}" type="date" /></div>
					<div class="recol">
						<c:choose>
							<c:when test="${reportDTO.restate=='N'}">처리 대기중</c:when>
							<c:when test="${reportDTO.restate=='Y'}">처리완료</c:when>
							<c:when test="${reportDTO.restate=='S'}">보류상태</c:when>
						</c:choose>
					</div>
				</div>
			</c:forEach>
			<div id="repaging">
				<jsp:include page="/paging/paging.jsp">
					<jsp:param value="phonetail.do?command=adminReportList" name="address" />
				</jsp:include>
			</div>
		</div>
	</form>
</div>
<%@ include file="/footer.jsp"%>