<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>

<div class="content-wrapper">
<%@ include file="mypage_submenu.jsp"%>
<div id="loginwrap">
<section>
		<article>
				<form >
					<h2>My Info</h2>
					<div class="field">
						<label>User ID</label>
						<div>
							<input type="text" name="userid" size="12" value="${login.userid}" readonly>
				        </div>
					</div>
					<div class="field"><label>이름</label><input type="text"  name="name" value="${login.name}" readonly /></div>
					<div class="field"><label>전화번호</label><input type="text"  name="phone"  value="${login.phone}" readonly /></div>
					<div class="field"><label>이메일</label><input type="text"  name="email"  value="${login.email}" readonly /></div>
						
					<div class="field">
						<label>주소 </label><input type="text"  name="address1"  value="${login.address1}" readonly />
					</div>
					<div class="field">
						<label>추가 주소</label><input type="text" name="address2" value="${login.address2}" readonly/>
					</div>
					<div class="field">
						<label>가입일</label><input type="text" name="indate" value="${login.indate}" readonly/>
					</div>
					<div class="loginbtn">
			   			<input type="button" value="회원정보수정" onclick="location.href='phonetail.do?command=updateMemberForm'">
			   			<input type="button" value="회원탈퇴" onClick="withDraw()">	
			   		</div>
				</form>
		</article>
	</div>
</section>
</div>
<%@ include file="../footer.jsp"%>
<!-- <link rel="stylesheet" href="mypage/css/mypage.css"> -->


