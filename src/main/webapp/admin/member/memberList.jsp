<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<%@ include file="../sub_menu.jsp"%>

<h2>
Member List
</h2>
<article>
<form method="post" name="frm">
	<div class="tb">
		<div class="row">
			<div class="col" style="display:flex; align-items: center">
					회원 성명&nbsp; <input type="text" name="key" value="${key}" />&nbsp;&nbsp;&nbsp;
					<input class="btn" type="button" name="btn_search" value="검색"
						onClick="go_search( 'adminMemberList')" />&nbsp;&nbsp;&nbsp;
			</div>
		</div>
		<div class="row">
			<div class="coltitle" style="flex:1">아이디(UserState)</div>
			<div class="coltitle" style="flex:1">이름</div>
			<div class="coltitle" style="flex:2">이메일</div>
			<div class="coltitle" style="flex:4">주소</div>
			<div class="coltitle" style="flex:1">전화</div>
			<div class="coltitle" style="flex:1">가입일</div>
		</div>	
		<c:forEach items="${memberList}" var="memberDTO" varStatus="status">
			<div class="row">
				<div class="col" style="flex:1">
					${memberDTO.userid}(${memberDTO.userstate}) 
					<c:choose>
			      		<c:when test='${memberDTO.userstate=="Y"}'>
			        		<input type="checkbox" name="userstate" value="${status.index}">
				        </c:when>
			    	</c:choose>
				</div>
				<div class="col" style="flex:1">${memberDTO.name}</div>
				<div class="col" style="flex:2">${memberDTO.email} </div>
				<div class="col" style="flex:4">${memberDTO.address1} ${memberDTO.address2}</div>
				<div class="col" style="flex:1">${memberDTO.phone} </div>
				<div class="col" style="flex:1"><fmt:formatDate value="${memberDTO.indate}" /></div>
			</div>	
		</c:forEach>
		<div class="row">
			<div class="col">
		 		<jsp:include page="/admin/paging/paging.jsp" >
					<jsp:param value="phonetail.do?command=adminMemberList" name="address"/>
				</jsp:include>
			</div>
		</div> 
			<div class="btn">
    			<input type="button" style="width: 200px" value="블랙리스트" onClick="go_userstate_change()"/>
			</div>
	</div>
<form>
</article>


<%@ include file="/footer.jsp"%>