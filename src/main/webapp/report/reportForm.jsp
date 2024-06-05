<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="report/script/report.js"></script>
<link rel="stylesheet" href="css/login.css"> <!-- admin,일반 로그인 폼들 css 통합 -->
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
<style>
#loginwrap section{
font-family: "Noto Sans KR", sans-serif;
display:flex;
justify-content:flex-start;
align-items:flex-start;
padding:0;
color:#00acee;
}
h2{
color:black;
font-family: "Noto Sans KR", sans-serif;
}
h5{
color:black;
font-family: "Noto Sans KR", sans-serif;
margin-bottom:10px;
}
textarea {
			width: 80%;
			height: 150px;
			padding: 10px;
			box-sizing: border-box;
			border: solid 2px black;
			border-radius: 5px;
			font-size: 16px;
			resize: both;
			font-family: "Noto Sans KR", sans-serif;
		}
.field select{
font-family: "Noto Sans KR", sans-serif;
}
</style>
</head>
<body >
		<section>
			<article>
				<form name="reportViewForm" method="post" style="margin:0;">
					<h2>상품 신고</h2>
					<div class="field">
						<select name="retype">
							<option value="-1">신고사유를 선택하세요</option>
							<option value="0">광고성 콘텐츠(거래와 관련없는 글)</option>
							<option value="1">상품정보 부정확</option>
							<option value="2">안전거래를 거부해요</option>
							<option value="3">사기가 의심돼요(외부 채널 유도)</option>
							<option value="4">전문업자 같아요</option>
							<option value="5">기타</option>
						</select>
					</div>
					<h5>상세 내용</h5>
					<div class="field">
						<textarea name="recontent" rows="8" cols="40"></textarea>
					</div>
					<div class="loginbtn" style="width:120px;">
						<input type="hidden" name="pseq" value="${pseq}">
						<input type="button" style=" background:black;" value="신고하기" onClick="report()">
					</div>
				</form>
			</article>
		</section>
</body>
</html>