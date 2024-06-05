<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
    
    <div class="ViewContainer">
    <div class="vititle">
    <h2>Report View</h2>
    </div>
        <form name="reportViewForm" method="post">
            <div class="vifields-horizontal">
                <div class="vifield">
                    <label>Report No.</label>
                    <div>${reportDTO.reseq}</div>
                    <input name="reseq" type="hidden" value="${reportDTO.reseq}"/>
                </div>
                <div class="vifield">
                    <label>신고 사유</label>
                    <div>	
                        신고코드: ${reportDTO.retype}<br>
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
                <div class="vifield">
                <label>작성자</label>
                <div>${reportDTO.userid}</div>
            </div>
                <div class="vifield">
                    <label>등록일</label>
                    <div>
                        <fmt:formatDate value="${reportDTO.indate}" type="date" />
                    </div>
                </div>
                 <div class="vifield">
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
                </div>
            <div class="vicontent">
                <label>상세 내용</label>
                <div>${reportDTO.recontent}</div>
            </div>
            <input type="button" style="width:400px; margin-top:5px; margin-left:15px;" value="신고 대상 게시글 확인하기" onclick="location.href='phonetail.do?command=productDetail&pseq=${reportDTO.pseq}'"/>
            <input name="pid" type="hidden" value="${reportDTO.pid}" />
            <c:if test="${!empty adminUser.adminid}">
                <div class="vifield">
                    <label>신고처리</label>
                    <select name="newRestate">
                        <option value="${reportDTO.restate}">신고분류</option>
                        <option value="Y">블랙처리</option>
                        <option value="S">보류하기</option>
                    </select>
                    <div class="vifields-horizontal" style="border:none;">
                    <input  type="button" value="처리하기" onClick="processReport()">
                    <input  type="button" value="목록으로" onClick="location.href='phonetail.do?command=adminReportList'">
                    </div>
                </div>
            </c:if>
        </form>
    </div>
<%@ include file="/footer.jsp"%>
