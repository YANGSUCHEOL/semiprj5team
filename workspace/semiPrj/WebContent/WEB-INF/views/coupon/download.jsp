<%@page import="java.util.List"%>
<%@page import="com.kh.semiPrj.coupon.CouponVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	List<CouponVo> voList = (List<CouponVo>)request.getAttribute("voList");
	String rNo = (String)session.getAttribute("rno");
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
    
    table{
        border-collapse: collapse;
        border-spacing: 0;
    }
    section.faq{
        width: 70vw;
        padding: 80px 0;
        margin: 0 auto;
        border: 1px solid #ccc;
        border-radius: 10px;
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
        font-weight: 500;
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
        width: 60vw;
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
        font-weight: 500;
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
        border-style: none;
        background-color: white;
    }
    .modal-notice2:hover{
        background-color: #9df0df;
        
    }


    /*두번째 모달*/
    .modal{
        position: fixed;
        background-color: rgb(0, 0, 0, .2);
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
        box-shadow: 0 0 10px rgb(117, 117, 117);
        text-align: center;
    }
    .btn-close{
        position: absolute;
        top: 15px;
        right: 15px;
    }
    .btn-guide{
        margin: 0 auto;
        width: 18vw;
        border-style: none;
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
    .noCou{
    	width: 20vw;
    	margin: 0 auto;
    	font-size: 20px;
    	text-align: center;
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
        
        
        
	        	<div class="coupon-list">
	        		<%if(voList.size() != 0){%>
			            <div class="container">
			            	<%for(int i = 0; i < voList.size(); ++i){%>
			                	<table class="coupon-table">
			                        <thead>
			                            <tr>
			                                <th scope="col" class="th-num" name="num"><%= voList.get(i).getNo() %></th>
			                                <th scope="col" class="th-title"><%= voList.get(i).getInfo() %> 쿠폰</th>
			                                <th scope="col" class="th-coupon"><button class="modal-notice2" onclick="f01(<%= voList.get(i).getNo() %>);"> ⭐⭐쿠폰 발급⭐⭐</button></th>
			                            </tr>
			                            
			                        </thead>
			                	</table>
		                	<%}%>
			            </div>
		            <%}else{%>
                         <div class="noCou">" 발급 가능한 쿠폰이 없습니다. "</div>
			       	<%}%>
		        </div>
	        
	   		<div class="modal2">
	            <div class="modal-content2">
	                <a class="btn-close2" href="#none">X</a>
	                
	                <h3>----  쿠폰 다운로드  ----</h3>
	                <div> 👇 아래 쿠폰을 클릭해주세요 👇 </div>
	                <a class="cou-btn" href="#none"><img src="/semiPrj/resources/img/coupon2.png" alt="쿠폰" width="150px" height="auto"></a>
	                <p>
	                    발급된 쿠폰은 마이페이지에서 확인이 가능합니다:)
	                </p class="mypagego">
	            </div>
	        </div>
		        <div class="modal">
		            <div class="modal-content">
		                <a class="btn-close" href="#none">X</a>
		                <h3>쿠폰을 다운로드 받으시겠습니까?</h3>
		                <p>
		                    쿠폰을 다운로드하시면 마이페이지로 이동합니다:)
		                </p>
			<form action="/semiPrj/coupon/insert" method="post" id="couDown">
						<input type="hidden" name="cNo" id="cNo" value=""></input>
		                <input type="hidden" name="rNo" id="rNo" value="<%= rNo %>"></input>
		                <input type="hidden" name="mNo" id="mNo" value="<%= loginMember.getNo()%>"></input>
		                <input type="submit" class="btn-guide" value="다운로드"></input>
		            </div>
		        </div>
        	</form>
        	
        <script>
        	var num = document.getElementById('cNo');
	       	function f01(n){
	       		num.setAttribute('value', n);
	       	}
       </script>
        
        <script>
        	//첫번째 모달
            $('.modal-notice2').click(function(){
                $('.modal2').fadeIn(150)
            })
            $('.btn-close2').click(function(){
                $('.modal2').fadeOut(100)
            })
           
        </script>

        <script>
            //두번째 모달
            $('.cou-btn').click(function(){
                $('.modal').fadeIn(150)
            })
            $('.btn-close').click(function(){
                $('.modal').fadeOut(100)
            })
        </script>
        
        <i class="bi bi-bookmarks"></i>

	</section>
    
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>