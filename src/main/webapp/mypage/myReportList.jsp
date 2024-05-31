<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<%@ include file="mypage_submenu.jsp"%>
<form method="post" name="frm">
	<h2>My Report List</h2>
	
	<table>
		<tr>
			<th>번호</th>
			<th>신고글</th>
			<th>제목</th>
			<th>타입</th>
			<th>상태</th>
		</tr>
		<c:forEach items="${reportList}" var="reportDTO">
			<tr>
				<td>${reportDTO.reseq}</td>
				<td><a href="phonetail.do?command=reportView&reseq=${reportDTO.reseq}">${reportDTO.userid}님의 신고글</a></td>
				<td><c:choose>
								<c:when test="${reportDTO.retype==0}">광고성 콘텐츠(거래와 관련없는 글)</c:when>
								<c:when test="${reportDTO.retype==1}">상품정보 부정확</c:when>
								<c:when test="${reportDTO.retype==2}">안전거래를 거부해요</c:when>
								<c:when test="${reportDTO.retype==3}">사기가 의심돼요(외부 채널 유도)</c:when>
								<c:when test="${reportDTO.retype==4}">전문업자 같아요</c:when>
								<c:when test="${reportDTO.retype==5}">기타</c:when>
						</c:choose>
				</td>
				<td><fmt:formatDate value="${reportDTO.indate}" type="date" /></td>
				<td><c:choose>
							<c:when test="${reportDTO.restate=='N'}">처리 대기중</c:when>
							<c:when test="${reportDTO.restate=='Y'}">처리완료</c:when>
							<c:when test="${reportDTO.restate=='S'}">보류상태</c:when>
						</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
	<jsp:include page="/paging/paging.jsp">
		<jsp:param value="phonetail.do?command=myReportList" name="address" />
	</jsp:include>
	
</form>
<%@ include file="/footer.jsp"%>