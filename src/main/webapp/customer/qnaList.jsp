<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<script src="customer/script/customer.js"></script>
    <meta charset="UTF-8">
    <title>Q&A List</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 8px;
        }
        th {
            background-color: gray;
        }
    </style>
</head>
<body>
<form method="post" name="frm">
    <h2>Q&A List</h2>
    	<div class="field" style="border-top:2px solid gold;">
				아이디 &nbsp; <input type="text" name="key" value="${key}" /> &nbsp;
					&nbsp; &nbsp; <input class="btn" type="button" name="btn_search"
						value="검색" onClick="go_search('qnaList')"/>
						<div class="btn" >
					<input type="button" value="글 작성"  onclick="location.href='phonetail.do?command=writeQnaForm'"/>
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
                <%-- <td><a href="qnaView.jsp?qseq=${qna.qseq}">${qna.title}</a></td> --%>
               <td><a href="phonetail.do?command=qnaView&qseq=${qna.qseq}">${qna.title}</a></td> 
                <td><fmt:formatDate value="${qna.indate}" type="date"/></td>
                <td>${empty qna.qreply ? 'NO' : 'YES'}</td>
            </tr>
        </c:forEach>
    </table>
	<jsp:include page="/paging/paging.jsp">
				<jsp:param value="phonetail.do?command=qnaList" name="address" />
	</jsp:include>
	</form>	
</body>
</html>