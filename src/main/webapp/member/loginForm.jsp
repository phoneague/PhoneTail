<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp"%>
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
					</div>
					<div style="font-size:80%; font-weight:bold padding:30px;">${message} </div>
			</form>
	</article>
</div>
<%@ include file="/footer.jsp"%>
