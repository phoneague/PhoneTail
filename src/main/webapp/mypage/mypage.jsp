<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<link rel="stylesheet" href="mypage/css/mypage.css">
<div id="wrap">
    <section>
        <article>
        <%@ include file="sub_menu.jsp" %>
           	 	<div class="tb">
                <div class="row">
                	<div class="coltitle" >My Product List</div>
                    <div class="coltitle">My Report List</div>
                    <div class="coltitle">My QnA List</div>
                </div>
                <div class="row">
                    <div class="col" style="flex:1">
                        <c:forEach items="${ProductDTO.reportList}" var="report">
                            <div>${report}</div>
                        </c:forEach>
                    </div>
                    <div class="col" style="flex:1">
                        <c:forEach items="${ReportDTO.qnaList}" var="qna">
                            <div>${qna}</div>
                        </c:forEach>
                    </div>
                    <div class="col" style="flex:1">
                        <c:forEach items="${QuestionDTO.chatList}" var="chat">
                            <div>${chat}</div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </article>
    </section>
</div>
<%@ include file="../footer.jsp" %>