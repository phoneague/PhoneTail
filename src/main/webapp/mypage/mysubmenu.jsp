<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="wrap">
            <nav class="sub_menu">
                <div><a href="phonetail.do?command=updateMemberForm">회원정보수정</a></div>
                <div><input type="button" value="회원탈퇴" onClick="withDraw('${userid}')"/></div>
            </nav> 
        </div>