<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<link rel="stylesheet" type="text/css" href="admin/css/sub_menu.css">
<h2>Member List</h2>
<div class="content-wrapper">
    <%@ include file="../sub_menu.jsp"%>
    <article>
        <form method="post" name="frm">
            <div class="tb">
                <div class="row">
                    <div class="col" style="display: flex; align-items: center;">
                        아이디&nbsp;&nbsp;&nbsp;
                        <input type="text" name="key" value="${key}" />&nbsp;&nbsp;&nbsp;
                        <select name="userstate">
                            <option value="">전체</option>
                            <option value="B">블랙회원</option>
                            <option value="N">탈퇴(휴면)회원</option>
                            <option value="Y">일반회원</option>
                        </select>&nbsp;&nbsp;&nbsp;
                        <input class="btn" type="button" name="btn_search" value="검색" 
                        onClick="go_search('adminMemberList')"/>
                        &nbsp;&nbsp;&nbsp;
                    </div>
                </div>
                <div class="row">
                    <div class="coltitle">아이디(UserState)</div>
                    <div class="coltitle">이름</div>
                    <div class="coltitle">이메일</div>
                    <div class="coltitle">주소</div>
                    <div class="coltitle">전화</div>
                    <div class="coltitle">가입일</div>
                </div>
                <c:forEach items="${memberList}" var="memberDTO" varStatus="status">
                    <div class="row">
                        <div class="col" style="flex: 1;">
                            ${memberDTO.userid}(${memberDTO.userstate})
                            <input type="checkbox" name="userstate" value="${memberDTO.userid}" data-userstate="${memberDTO.userstate}" />
                        </div>
                        <div class="col">${memberDTO.name}</div>
                        <div class="col">${memberDTO.email}</div>
                        <div class="col">${memberDTO.address1} ${memberDTO.address2}</div>
                        <div class="col">${memberDTO.phone}</div>
                        <div class="col"><fmt:formatDate value="${memberDTO.indate}" /></div>
                    </div>
                </c:forEach>
                <div class="row_scroll">
                    <div class="col_scroll" >
                        <jsp:include page="/admin/paging/paging.jsp">
                            <jsp:param value="phonetail.do?command=adminMemberList" name="address" />
                        </jsp:include>
                    </div>
                </div>
            </div>
            <div class="btn">
                <input type="button" style="width: 200px" value="블랙리스트" name="userstateYtoB" onClick="userstate_YtoB()" />
                <input type="button" style="width: 200px" value="블랙해제" name="userstateBtoY" onClick="userstate_BtoY()" />
                <input type="button" style="width: 200px" value="휴면해제" name="userstateNtoY" onClick="userstate_NtoY()" />
            </div>
        </form>
    </article>
</div>

<%@ include file="/footer.jsp"%>