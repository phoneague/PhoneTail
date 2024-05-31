<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="wrap">
            <nav class="sub_menu">
            	<h2>${loginUserName}'s MY PAGE</h2>
                <div><a href="phonetail.do?command=updateMemberForm">회원정보수정</a></div>
                <div><input type="button" value="회원탈퇴" onClick="withDraw('${userid}')"/></div>
            </nav> 
        </div>