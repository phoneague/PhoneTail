<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<!-- <link rel="stylesheet" href="mypage/css/mypage.css"> -->
<div class="lititle">
<h2>${login.name}'s MY PAGE</h2>
</div>
<div class="content-wrapper">
<%@ include file="mypage_submenu.jsp"%>
<div class="container">
<section>
	<article>
		<form>
			<div class="field" style="border-top:2px solid #3f4549;">
						<label>내 아이디</label><input type="text" name="userid"
					value="${login.userid}" readonly />
			</div>
			<div class="field" style="border-top:2px solid #3f4549;">
						<label>이름</label><input type="text" name="name"
					value="${login.name}" readonly />
			</div>
			<div class="field" style="border-top:2px solid #3f4549;">
						<label>전화번호</label><input type="text" name="phone"
					value="${login.phone}" readonly />
			</div>
			<div class="field" style="border-top:2px solid #3f4549;">
						<label>E-mail</label><input type="text" name="email"
					value="${login.email}" readonly />
			</div>
			<div class="field" style="border-top:2px solid #3f4549;">
						<label>주소1</label><input type="text" name="address1"
					value="${login.address1}" readonly />
			</div>
			<div class="field" style="border-top:2px solid #3f4549;">
						<label>주소2</label><input type="text" name="address2"
					value="${login.address2}" readonly />
			</div>
			<div class="field" style="border-top:2px solid #3f4549;">
						<label>가입날짜</label><input type="text" name="indate"
					value="${login.indate}" readonly />
			</div>
		</form>
	</article>
	<input class="searchbtn" type="button" name="btn_search" value="회원정보수정" onClick="location.href='phonetail.do?command=updateMemberForm'" />
	<input class="searchbtn" type="button" name="btn_delete" value="회원탈퇴" onClick="withDraw()" />
</section>
</div>
</div>
<%@ include file="../footer.jsp"%>