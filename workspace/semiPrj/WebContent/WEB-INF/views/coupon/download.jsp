<%@page import="com.kh.semiPrj.coupon.CouponVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CouponVo vo = (CouponVo)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.2.0/css/fontawesome.min.css" integrity="sha384-z4tVnCr80ZcL0iufVdGQSUzNvJsKjEtqYZjiQrrYKlpGow+btDHDfQWkFjoaz/Zr" crossorigin="anonymous">
<!-- 제이쿼리 CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<style>
    .header{
        margin-bottom: 180px;
    }
    table{
        border-collapse: collapse;
        border-spacing: 0;
    }
    section.faq{
        width: 80vw;
        padding: 80px 0;
        margin: 0 auto;
        border: 1px solid #ccc;
        border-radius: 20px;
    }
    .page-title{
        margin-bottom: 40px;
    }
    .page-title h3{
        height: 7vh;
        font-size: 30px;
        color: #333333;
        font-weight: 400;
        text-align: center;
        line-height: 50px;

        border-radius: 10px;
        background: #FCFFED;
    }
    .board-table{
        font-size: 16px;
        width: 100%;
        border-top: 1px solid #ccc;
        border-bottom: 1px solid #ccc;
    }
    .board-table a{
        color: #333;
        display: inline-block;
        line-height: 1.4;
        word-break: break-all;
        vertical-align: middle;
    }
    .board-table a:hover{
        text-decoration: underline;
    }
    .board-table tbody tr:hover{
        background-color: #FCFFED;
    }
    .board-table th{
        text-align: center;
    }
    .board-table .th-num{
        width: 100px;
        text-align: center;
    }
    .board-table .th-title{
        width: 200px;
    }
    .board-table th, .board-table td{
        padding: 18px 0;
    }
    .board-table tbody td{
        border-top: 1px solid #e7e7e7;
        text-align: center;
    }
    .board-table tbody th{
        width: 70%;
        padding-left: 40px;
        padding-right: 14px;
        border-top: 1px solid #e7e7e7;
        text-align: left;
    }
    * {
        list-style: none;
        text-decoration: none;
        padding: 0;
        margin: 0;
        box-sizing: border-box;
    }
    .container {
        width: 1100px;
        margin: 0 auto;
    }
    .page-middle{
        border: 1px solie #ccc;
        margin: 0 auto;
    }


    /*모달*/
    .modal{
        position: fixed;
        background-color: rgb(0, 0, 0, .5);
        top: 0;
        left: 0;
        height: 100vh;
        width: 100%;
        display: none;
    }
    .modal-content{
        background-color: white;
        width: 450px;
        border-radius: 10px;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        padding: 30px;
        box-shadow: 0 0 15px black;
        text-align: center;
    }
    .btn-close{
        position: absolute;
        top: 15px;
        right: 15px;
    }
    .btn-guide{
        background-color: #FCFFED;
        color: black;
        border-radius: 5px;
        font-size: 14px;
        padding: 7px;
        display: block;
    }
    .btn-guide:hover{
        background-color: rgb(217, 245, 235);
    }
    .modal-content > h3{
        margin-bottom: 30px;
    }
    .modal-content > p{
        margin-bottom: 20px;
    }
    
</style>
</head>
<body>
	
	<div class="header"></div>
    <section class="faq">
        <div class="page-title">
            <div class="container">
                <h3>쿠폰</h3>
            </div>
        </div>
        <div class="page-middle">
            <div>< 10% 할인 쿠폰 ></div>
            <!--모달-->
            <a class="modal-notice" href="#none"><img src="/semiPrj/resources/img/coupon2.png" alt="쿠폰" width="100px" height="auto"></a>
        </div>

        <div class="modal">
            <div class="modal-content">
                <a class="btn-close" href="#none">X</a>
                <h3>쿠폰을 다운로드 받으시겠습니까?</h3>
                <p>
                    발급된 쿠폰은 마이페이지에서 확인이 가능합니다:)
                </p>
                <a class="btn-guide" href="/semiPrj/coupon/download">다운로드</a>
            </div>
        </div>
        
        <script>
            $('.modal-notice').click(function(){
                $('.modal').fadeIn(150)
            })
            $('.btn-close').click(function(){
                $('.modal').fadeOut(100)
            })
        </script>
        
        <i class="bi bi-bookmarks"></i>

    </section>
    
</body>
</html>