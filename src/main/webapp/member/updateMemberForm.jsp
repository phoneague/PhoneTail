<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinForm</title>
<script src="script/jquery-3.7.1.min.js"></script>
<script src="member/script/member.js"></script>
</head>
<body>
<section>
		<article>
				<form name="joinForm" action="phonetail.do" method="post">
				<input type="hidden" name="command" value="updateMember" />
        		<h2>Update Member</h2>
					<div class="field">
						<label>User ID</label>
						<input type="text" name="userid" value="${login.userid}" readonly />
					</div>
					<div class="field"><label>Password</label><input type="password"  name="pwd"></div>
					<div class="field">
						<label>Retype Password</label><input type="password"  name="pwdCheck"></div>
					<div class="field"><label>name</label><input type="text" name="name" value="${login.name}"></div>
					<label>Phone</label><input type="text" name="phone" value="${login.phone}"></div>
					<div class="field"><label>E-mail</label><input type="text" name="email" value="${login.email}"></div>
					<div class="field">
						<label>Zip Code</label>
						<div>
							 <input type="text" name="zip_num" readonly>
							 <input type="button" value="우편번호 찾기" onclick="post_zip()">
						</div>
					</div>
					<div class="field">
						<label>Address</label><input type="text"  name="address1"  readonly />
					</div>
					<div class="field">
						<label>detail Address</label><input type="text" name="address2" value="${login.address2}">
					</div>
					
					<div class="btn">
			   			<input type="submit" value="수정" onClick="return updateCheck()">
			   			<input type="button" value="Main" onClick="location.href='phonetail.do?command=main'">	
			   		</div>
					
				</form>
		</article>
	</div>
</section>
