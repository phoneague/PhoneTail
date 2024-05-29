<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinForm</title>
<script src="script/jquery-3.7.1.min.js"></script>
<script src="script/member.js"></script>
</head>
<body>
<section>
		<article>
				<form action="phnetail.do?command=join" method="post" name="joinForm">
					<h2>Join Us</h2>
					<div class="field">
						<label>User ID</label>
						<div>
							<input type="text" name="userid" size="12">
							<input type="hidden" name="reid" >
				        	<input type="button" value="중복 체크" onclick="idcheck()">
				        </div>
					</div>
					<div class="field"><label>Password</label><input type="password"  name="pwd"></div>
					<div class="field">
						<label>Retype Password</label><input type="password"  name="pwdCheck"></div>
					<div class="field"><label>Name</label><input type="text"  name="name" ></div>
					<div class="field"><label>Phone</label><input type="text"  name="phone"  /></div>
					<div class="field"><label>E-Mail</label><input type="text"  name="email"  /></div>
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
						<label>detail Address</label><input type="text" name="address2" />
					</div>
					
					<div class="btn">
			   			<input type="button" value="회원가입" onclick="go_save()">
			   			<input type="button" value="메인으로" onClick="location.href='phonetail.do?command=index'">	
			   		</div>
					
				</form>
		</article>
	</div>
</section>
