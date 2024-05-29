<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Q&A View</title>
</head>
<body>
    <h2>Q&A View</h2>
    <table border="1">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>내용</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>답변여부</th>
            <th>답변</th>
        </tr>
        <tr>
            <td>${qna.qseq}</td>
            <td>${qna.title}</td>
            <td>${qna.content}</td>
            <td>${qna.userid}</td>
            <td><fmt:formatDate value="${qna.indate}" type="date"/></td>
            <td>${qna.qreply == null ? 'NO' : 'YES'}</td>
            <td>${qna.qreply}</td>
        </tr>
    </table>
    
    <!-- 이전 페이지로 돌아가는 링크 -->
    
    <a href="qnaList.jsp">이전 페이지로 돌아가기</a>
</body>
</html>
