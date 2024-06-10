<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
	<div id="loginwrap">
	<h2>Admin LogIn</h2>
		<article>
			<form method="post" action="phonetail.do?command=adminLogin"
				name="loginForm">
				<div class="field">
					<label>Admin ID</label><input name="adminid" type="text" />
				</div>
				<div class="field">
					<label>Password</label><input name="pwd" type="password">
				</div>
				<div class="loginbtn">
					<input type="submit" value="LOGIN" onClick="return loginCheck()">
				</div>
				<div style="font-size: 80%; font-weight: bold">${message}</div>
			</form>
		</article>
	</div>
<%@ include file="/footer.jsp"%>