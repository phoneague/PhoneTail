<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>

</head>
<body>
		<h2>Report View</h2>
	<article>
		<form name="reportViewForm" method="post">
			<div class="field" style="border-top: 2px solid #3f4549;">
				<label>신고 글 번호</label>
				<div>${reportDTO.reseq}</div>
				<input name="reseq" type="hidden" value="${reportDTO.reseq}"/>
			</div>
			<div class="field" style="border-top: 1px solid #3f4549;">
				<label>신고 사유</label>
				<div>
					<c:choose>
						<c:when test="${reportDTO.retype==0}">광고성 콘텐츠(거래와 관련없는 글)</c:when>
						<c:when test="${reportDTO.retype==1}">상품정보 부정확</c:when>
						<c:when test="${reportDTO.retype==2}">안전거래를 거부해요</c:when>
						<c:when test="${reportDTO.retype==3}">사기가 의심돼요(외부 채널 유도)</c:when>
						<c:when test="${reportDTO.retype==4}">전문업자 같아요</c:when>
						<c:when test="${reportDTO.retype==5}">기타</c:when>
					</c:choose>
				</div>
			</div>
			<div class="field" style="border-top: 1px solid #3f4549;">
				<label>등록일</label>
				<div>
					<fmt:formatDate value="${reportDTO.indate}" type="date" />
				</div>
			</div>
			<div class="field" style="border-top: 1px solid #3f4549;">
				<label>작성자</label>
				<div>${reportDTO.userid}</div>
			</div>
			<div class="field" style="border-top: 1px solid #3f4549;">
				<label>상세 내용</label>
				<div>${reportDTO.recontent}</div>
			</div>
			<div class="field" style="border-top: 1px solid #3f4549;">
				<label>처리상태</label>
				<div>
					${reportDTO.restate}
					<c:choose>
						<c:when test="${reportDTO.restate=='N'}">처리 대기중</c:when>
						<c:when test="${reportDTO.restate=='Y'}">처리완료</c:when>
						<c:when test="${reportDTO.restate=='S'}">보류상태</c:when>
					</c:choose>
				</div>
			</div>
			신고 대상 아이디:${reportDTO.pid}<br>
			<div class="btn" style="border-bottom: 2px solid #3f4549;">
				<a href="phonetail.do?command=productDetail&pseq=${reportDTO.pseq}">신고 대상 게시글 확인하기</a>
			</div>
			<input name="pid" type="hidden" value="${reportDTO.pid}" />
			<c:if test="${!empty adminUser.adminid}">
				<h2>신고처리</h2>
				<select name="newRestate" style="width:250px;">
					<option value="${reportDTO.restate}">--신고처리하기--</option>
					<option value="Y">블랙처리</option>
					<option value="S">보류하기</option>
				</select>
				<input type="button" style="width:200px;" value="처리하기" onClick="processReport()">
				</c:if>
		</form>
	</article>
<%@ include file="/footer.jsp"%>