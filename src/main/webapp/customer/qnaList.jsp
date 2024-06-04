<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<form method="post" name="frm">
    <h2>Q&A List</h2>
    <div class="field" style="border-top: 2px solid gold;">
        아이디 &nbsp; <input type="text" name="key" value="${key}" /> &nbsp;
        &nbsp; &nbsp; <input class="btn" type="button" name="btn_search" value="검색" onClick="go_search('qnaList')"/>
        <div class="btn">
            <input type="button" value="글 작성" onclick="location.href='phonetail.do?command=writeQnaForm'"/>
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
            <th>조회수</th>
            <th>비밀글</th>
        </tr>
        <c:forEach items="${questionList}" var="qna" varStatus="status">
            <tr>
                <td>${qna.qseq}</td>
                <td>${qna.userid}</td>
                <c:if test="${qna.userid eq login.userid}">
                <td><a href="phonetail.do?command=qnaView&qseq=${qna.qseq}">${qna.title}</a></td>
               </c:if>
                <c:if test="${qna.userid ne login.userid}">
                <td><a href="javascript:void(0);" onclick="alert('작성자만 비밀글을 열람할 수 있습니다')">비밀글</a></td>
               </c:if>
                <td><fmt:formatDate value="${qna.indate}" type="date"/></td>
                <td>${qna.qreply == '' ? 'NO' : 'YES'}</td>
                <td>${qna.readCount}</td> 
                <td>${qna.secret == true ? '비밀글입니다' : ''}</td>
            </tr>
        </c:forEach>
    </table>
    <div class="pagination">
        <jsp:include page="/paging/paging.jsp">
            <jsp:param value="phonetail.do?command=qnaList" name="address" />
        </jsp:include>
    </div>
</form>    
<%@ include file="/footer.jsp"%>