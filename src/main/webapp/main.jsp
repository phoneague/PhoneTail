<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="header.jsp"%>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/header_footer.css">
</div>
    <div class="container">
    <div class="box"><br>
        <h1>PhoneTail</h1><br><br><br>
        <h2>당신이 선택한 중고핸드폰 직거래 전문 플랫폼</h2><br>
    </div>
    </div>
<div class="wrap">
    <div class="box1">
        <div class="box-inner">
            <img src="images/1.png">
        </div>
        <div class="box-inner">
            <img src="images/2.png">      
        </div>
        <div class="box-inner">
            <img src="images/3.png">  
        </div>
    </div>
    
    <div class="box1">
        <div class="box-inner">
            <img src="images/4.png">     
        </div>
        <div class="box-inner">
            <img src="images/5.png" style="object-position: top;">      
        </div>
        <div class="box-inner">
            <img src="images/6.png">  
        </div>
    </div>
 </div>   
     <div class="container">
    <div class="box">
        <br><h2>New List</h2><br>
    </div>
    </div>                               
<div class="container new-list-container">
    <c:forEach items="${newList}" var="newlist" varStatus="status">
        <div class="box new-list-item">
            <div class="box-inner">
                <a href="phonetail.do?command=productDetail&pseq=${newlist.pseq}">
                    <img src="product/images/${newlist.saveimagefile}">
                </a>
            </div>
            <h2>
                <a href="phonetail.do?command=productDetail&pseq=${newlist.pseq}">
                    ${newlist.model} - <fmt:formatNumber value="${newlist.price}" type="currency" />
                </a>
            </h2>
        </div>
    </c:forEach>
</div>
     <div class="container">
    <div class="box">
       <br><h2>PhoneTail 에서 사야하는 이유</h2><br>
    </div>
    </div>
<div class="container">
<div class="box">
<div class="features-container">
    <div class="features-box">
        <h2>안전한 직거래</h2>
        <img src="images/55.jpg">
    </div>
    <div class="features-box">
        <h2>합리적인 가격</h2>
        <img src="images/p2.PNG" style="max-width:600px;" >
    </div>
</div>
</div>
</div>
<%@ include file="footer.jsp"%>
