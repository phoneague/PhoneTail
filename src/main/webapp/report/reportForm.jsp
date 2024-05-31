<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="report/script/report.js"></script>
</head>
<body>
	<h2>상품 신고</h2>
	<form name="reportViewForm" method="post" >
	<div>
		<select name="retype">
			<option value="-1">신고사유를 선택하세요</option>
			<option value="0">광고성 콘텐츠(거래와 관련없는 글)</option>
			<option value="1">상품정보 부정확</option>
			<option value="2">안전거래를 거부해요</option>
			<option value="3">사기가 의심돼요(외부 채널 유도)</option>
			<option value="4">전문업자 같아요</option>
			<option value="5">기타</option>
		</select>
		<div style="padding: 10px;">
			<textarea name="recontent" rows="8" cols="40"></textarea>
		</div>
		<input type="hidden" name="pseq" value="${pseq}">
		<input type="button" value="신고하기" onClick="report()">
	</div>
	</form>
</body>
</html>