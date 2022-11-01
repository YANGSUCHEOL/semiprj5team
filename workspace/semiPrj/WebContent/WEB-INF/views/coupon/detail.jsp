<%@page import="com.kh.semiPrj.coupon.history.CouponHistoryVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<CouponHistoryVo> detail = (List<CouponHistoryVo>)request.getAttribute("detail");
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
        width: 70vw;
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
    .coupon-table{
        font-size: 16px;
        width: 100%;
        border-top: 1px solid #ccc;
        border-bottom: 1px solid #ccc;
    }
    .coupon-table a{
        color: #333;
        display: inline-block;
        line-height: 1.4;
        word-break: break-all;
        vertical-align: middle;
    }
    .coupon-table a:hover{
        text-decoration: underline;
    }
    .coupon-table tbody tr:hover{
        background-color: #FCFFED;
    }
    .coupon-table th{
        text-align: center;
    }
    .coupon-table .th-num{
        width: 50vw;
        text-align: center;
    }
    .coupon-table .th-title{
        width: 150vw;
        text-align: left;
        font-size: 20px;
    }
    .coupon-table .th-coupon{
        width: 50vw;
    }
    .coupon-table th, .coupon-coupon td{
        padding: 18px 0;
    }
    * {
        list-style: none;
        text-decoration: none;
        padding: 0;
        margin: 0;
        box-sizing: border-box;
    }
    .container {
        width: 30vw;
        margin: 0 auto;
    }

    /*첫번째 모달*/
    .modal2{
        position: fixed;
        background-color: rgb(0, 0, 0, .2);
        top: 0;
        left: 0;
        height: 100vh;
        width: 100%;
        display: none;
    }
    .modal-content2{
        background-color: white;
        width: 450px;
        border-radius: 10px;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        padding: 30px;
        box-shadow: 0 0 10px rgb(117, 117, 117);
        text-align: center;
    }
    .btn-close2{
        position: absolute;
        top: 15px;
        right: 15px;
    }
    .btn-guide2{
        background-color: #FCFFED;
        color: black;
        border-radius: 5px;
        font-size: 14px;
        padding: 7px;
        display: block;
    }
    .btn-guide2:hover{
        background-color: rgb(217, 245, 235);
    }
    .modal-content2 > h3{
        font-size: 30px;
        font-weight: 600;
        margin-bottom: 30px;
    }
    .modal-content2 > p{
        margin-bottom: 20px;
    }
    .coupon{
        text-align: center;
    }
    .modal-notice2{
        font-size: 20px;
        border: 1px solid #ccc;
    }
    .modal-notice2:hover{
        background-color: #FCFFED;
        font-weight: 600;
        text-decoration-line: none;
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
    .font{
    	font-size: 20px;
    	font-weight: 800;
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

        <div id="coupon-list">
            <div class="container">
            	<%-- <%for(int i = 0; i > 5; ++i){%> --%>
           			<table class="coupon-table">
	                        <thead>
	                            <tr>
	                                <th scope="col" class="th-num">1</th>
	                                <th scope="col" class="th-title">10% 할인 쿠폰</th>
	                                <th scope="col" class="th-coupon"><a class="modal-notice2" href="#none">쿠폰 선택</a></th>
	                            </tr>
	                        </thead>
	                </table>
           		<%-- <%}%> --%>
            </div>
        </div>
        
   		<div class="modal2">
            <div class="modal-content2">
                <a class="btn-close2" href="#none">X</a>
                
                <p class="font">👇👇 쿠폰을 사용하시겠습니까? 👇👇</p>
                <a class="btn-guide" href="/semiPrj/res/res">사용하기</a>
            </div>
        </div>
        
        <script>
        	//첫번째 모달
            $('.modal-notice2').click(function(){
                $('.modal2').fadeIn(150)
            })
            $('.btn-close2').click(function(){
                $('.modal2').fadeOut(100)
            })
           
        </script>
        
        <i class="bi bi-bookmarks"></i>

    </section>
    
</body>
</html>