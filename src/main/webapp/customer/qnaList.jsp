<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%-- <%@ include file="../main.jsp"%> --%>

<%-- <%@ page import="com.miniproject.phonetail.DTO.QuestionDTO" %> --%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Q&A List</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>Q&A List</h2>
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
                <td><a href="qnaView.jsp?qseq=${qna.qseq}">${qna.title}</a></td>
                <td><fmt:formatDate value="${qna.indate}" type="date"/></td>
                <td>${qna.qreply == null ? 'NO' : 'YES'}</td>
            </tr>
        </c:forEach>
    </table>

    <!-- 페이징 처리 -->
  <%--   <div>
        <c:if test="${paging.hasPreviousPage}">
            <a href="?page=${paging.getPreviousPage}">이전</a>
        </c:if>

        <c:forEach begin="1" end="${paging.getTotalPages}" varStatus="page">
            <c:choose>
                <c:when test="${paging.currentPage == page.index}">
                    <span>${page.index}</span>
                </c:when>
                <c:otherwise>
                    <c:if test="${paging.getTotalPages > 0}">
                        <a href="?page=${page.index}">${page.index}</a>
                    </c:if>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${paging.hasNextPage}">
            <a href="?page=${paging.getNextPage}">다음</a>
        </c:if>
    </div> --%>
</body>
</html>
