<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
<script src="script/jquery-3.7.1.min.js"></script>
<link  rel="stylesheet" href="css/header_footer.css">
	<div class="clear"></div>
	<footer>
		<hr>
		<div id="copy">
			All contents Copyright 2024  PhoneTail.co  Inc. all rights reserved<br>
			Contact mail : phonetail@abc.com  Tel : +82 02 1234 1234	Fax : +82 02 1233 1233 &nbsp;
		</div>
		<div id="admin">
			관리자 접속상태:
			<c:choose>
				<c:when test="${!empty adminUser.adminid}">O(${adminUser.adminid})
					<a href="phonetail.do?command=adminReportList">관리자 페이지로 이동</a>
					/<a href="phonetail.do?command=adminLogout">로그아웃</a>
					
				</c:when>
			<c:otherwise>
				X /<a href="phonetail.do?command=admin">관리자로그인</a>
			</c:otherwise>
</c:choose> 
		</div>
	</footer>
	</div>
</body>
</html>

    