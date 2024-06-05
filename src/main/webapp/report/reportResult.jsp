<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Report result</title>
<script src="report/script/report.js"></script>
<style>
input[type=button] {

	font-family: "Noto Sans KR", sans-serif;
	background: black;
	color: white;
	border-radius: 5px;
}
body{
display: flex; flex-direction:column; height:100vh; align-items:center; padding:20px;
}
</style>
</head>
<body>
<h2>신고가 접수되었습니다.</h2>
<input type="button" value="닫기" onClick="close()">
</body>
</html>