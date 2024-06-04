<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<div class="container">
	<form method="post" name="frm">
		<div class="litb">
			<div class="row">
				<div class="col" style="display: flex; align-items:right;">
					아이디 &nbsp; <input type="text" name="key" value="${key}" /> &nbsp;
        			&nbsp; &nbsp; <input class="searchbtn" type="button" name="btn_search" value="검색" onClick="go_search('qnaList')"/>
					<input class="searchbtn" type="button" name="btn_search" value="글 작성" onClick="location.href='phonetail.do?command=writeQnaForm'"/>
        			&nbsp;&nbsp;&nbsp; 
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
					<c:if test="${qna.userid eq login.userid}">
                        <div class="col"><a href="phonetail.do?command=qnaView&qseq=${qna.qseq}">${qna.title}</a></div>
               </c:if>
                <c:if test="${qna.userid ne login.userid}">
                    <div class="col"><a href="javascript:void(0);" onclick="alert('작성자만 비밀글을 열람할 수 있습니다')">비밀글</a></div>
               </c:if>
					<div class="col"><fmt:formatDate value="${qna.indate}" type="date"/></div>
					<div class="col">${qna.qreply == '' ? 'NO' : 'YES'}</div>
					<div class="col">${qna.readCount}</div>
					<div class="col">${qna.secret == true ? '비밀글입니다' : ''}</div>
				</div>
			</c:forEach>
			<div id="paging">
				<jsp:include page="/paging/paging.jsp">
            		<jsp:param value="phonetail.do?command=qnaList" name="address" />
       			</jsp:include>
			</div>
		</div>
	</form>
</div>
<%@ include file="/footer.jsp"%>