<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp"%>
<script src="member/script/member.js" ></script>
<div id="loginwrap">
<h2>LogIn</h2>
	<article>
			<form method="post" action="phonetail.do?command=login" >
					<div class="field">
							<label>User ID</label><input name="userid" type="text" />
					</div>
					<div class="field">
							<label>Password</label><input name="pwd" type="password" >
					</div>
					<div class="loginbtn">
	  				        	<input type="submit" value="Login" />
	  				        	<input type="button" value="Find ID"  onClick="find_id()"/>
	  				        	<input type="button" value="Find PW"  onClick="find_pw()"/>
					</div>
					<div style="font-size:80%; font-weight:bold padding:30px;">${message} </div>
			</form>
	</article>
</div>
<%@ include file="/footer.jsp"%>
