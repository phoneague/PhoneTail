<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
<div id="wrap">
	<header>
		<div id="logo">
			<a href="phonetail.do?command=index">
    			<img style="width:200px" src="admin/images/templogo.png" alt="Logo">
			</a>
			<img src="admin/images/text.gif">
			<input class="btn" type="button" value="logout" style="float:right;"
				onClick="location.href='phonetail.do?command=adminLogout'">
		</div>
	</header>