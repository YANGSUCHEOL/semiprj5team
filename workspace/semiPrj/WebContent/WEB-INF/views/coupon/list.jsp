<%@page import="com.kh.semiPrj.restaurant.vo.RestaurantVo"%>
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
<style>
    .header{
        margin-bottom: 100px;
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
    .board-table th{
        text-align: center;
    }
    .board-table .th-num{
        width: 100px;
        text-align: center;
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

	<%@ include file="/WEB-INF/views/header.jsp" %>

    <div class="header"></div>
    <section class="faq">
        <div class="page-title">
            <div class="container">
                <h3>쿠폰</h3>
            </div>
        </div>

        <div id="faq-list">
            <div class="container">
                <table class="board-table">
                    <tbody>
                        <tr>
                            <td>1</td>
                            <th>
                                <a>5% 할인</a>
                            </th>
                            <td><a class="modal-notice" href="#none">다운로드</a></td>
                            
                            <div class="modal">
				            <div class="modal-content">
				                <a class="btn-close" href="#none">X</a>
				                <h3>쿠폰을 다운로드 받으시겠습니까?</h3>
				                <p>
				                    발급된 쿠폰은 마이페이지에서 확인이 가능합니다:)
				                </p>
				                <a class="btn-guide" href="/semiPrj/coupon/list">다운로드</a>
				            </div>
					        </div>
                        </tr>
                    </tbody>
                </table>
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