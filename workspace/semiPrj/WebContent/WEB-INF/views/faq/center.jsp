<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
        line-height: 60px;

        border-radius: 10px;
        background: #FCFFED;
    }
    .page-middle{
        width: 55vw;
        height: 28vh;
        margin: 0 auto;
        padding: 30px;
        border:  2px solid #ccc;
    }
    .page-middle2{
        width: 26vw;
        height: 28vh;
        margin-top: 30px;
        margin-left: 240px;
        padding: 30px;
        border:  2px solid #ccc;
    }
    .page-middle3{
        width: 26vw;
        height: 28vh;
        margin-top: 30px;
        margin-left: 295px;
        padding: 30px;
        border:  2px solid #ccc;
    }
    .page-middle h4{
        height: 4vh;
        font-size: 20px;
        color: #434242;
        line-height: 40px;
        margin-bottom: 20px;
    }
    .page-middle2 h4{
        width: 20vw;
        height: 4vh;
        font-size: 20px;
        color: #434242;
        line-height: 40px;
    }
    .page-middle3 h4{
        height: 4vh;
        font-size: 20px;
        color: #434242;
        line-height: 40px;
    }
    .page-middle2 h5{
        font-size: 15px;
        color: #8e8e8e;
        line-height: 40px;
        margin-bottom: 20px;
    }
    .page-middle3 h5{
        font-size: 15px;
        color: #8e8e8e;
        line-height: 40px;
        margin-bottom: 20px;
    }
    .btn {
        height: 7vh;
        margin-top: 5px;
        margin-right: 10px;
        display: inline-block;
        padding: 0 30px;
        font-size: 17px;
        font-weight: 400;
        background: rgb(222, 222, 222);
        white-space: nowrap;
        vertical-align: middle;
        -ms-touch-action: manipulation;
        touch-action: manipulation;
        cursor: pointer;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
        text-transform: uppercase;
        border-style: none;
        
        -webkit-transition: all 0.3s;
        -moz-transition: all 0.3s;
        -ms-transition: all 0.3s;
        -o-transition: all 0.3s;
        transition: all 0.3s;
    }
    .btn:hover{
        background-color: #EEFFF6;
    }
    .board-table{
        font-size: 16px;
        width: 55vw;
    }
    .board-table th, .board-table td{
        padding: 5px 0;
    }
    .board-table tbody td{
        width: 2vw;
        padding-left: 5px;
        text-align: left;
    }
    .board-table tbody th{
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
        width: 60vw;
        margin: 0 auto;
    }
    .container2 {
        width: 25vw;
        margin: 0 auto;
    }
    .bottom{
        margin: 0 auto;
        display: grid;
        grid-template-columns: repeat(2, 500px);
    }
</style>
</head>
<body>
	
	<%@ include file="/WEB-INF/views/header.jsp" %>
	
	<div class="header"></div>
    <section class="faq">
        <div class="page-title">
            <div class="container">
                <h3>고객센터</h3>
            </div>
        </div>

        <div class="page-middle">
            <div class="container">
                <h4><a href="/semiPrj/WEB-INF/views/faq/list.jsp">Q. 자주 묻는 질문</a></h4>
	                <table class="board-table">
	                    <tbody>
	                        <tr>
	                            <td>1.</td>
	                            <th>
	                                <a href="/semiPrj/WEB-INF/views/faq/list.jsp">리뷰는 어떻게 작성하나요?</a>
	                            </th>
	                        </tr>
                            <tr>
	                            <td>2.</td>
	                            <th>
	                                <a href="/semiPrj/WEB-INF/views/faq/list.jsp">예약은 어떻게 하나요?</a>
	                            </th>
	                        </tr>
                            <tr>
	                            <td>3.</td>
	                            <th>
	                                <a href="/semiPrj/WEB-INF/views/faq/list.jsp">리뷰는 어떻게 작성하나요?</a>
	                            </th>
	                        </tr>
                            <tr>
	                            <td>4.</td>
	                            <th>
	                                <a href="/semiPrj/WEB-INF/views/faq/list.jsp">리뷰는 어떻게 작성하나요?</a>
	                            </th>
	                        </tr>
	                    </tbody>
	                </table>
            </div>
        </div>
        <div class="bottom">
            <div class="page-middle2">
                <div class="container2">
                    <h4>겟 잇 비건 온라인 상담실</h4>
                    <h5>궁금하신 사항을 해결해드립니다.</h5>
                    <table>
                        <tbody>
                            <tr>
                                <td><button type="submit" class="btn btn-dark" onclick="/semiPrj/WEB-INF/views/customer.jsp">개인 회원 1:1 문의</button></td>
                                <td><button type="submit" class="btn btn-dark" onclick="/semiPrj/WEB-INF/views/business.jsp">사업자 회원 1:1 문의</button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="page-middle3">
                <div class="container3">
                    <h4>겟 잇 비건 입점 문의</h4>
                    <h5>내 단골 식당을 제보하고 싶다면 1:1 문의를 이용해주세요.</h5>
                    <table>
                        <tbody>
                            <tr>
                                <td><button type="submit" class="btn btn-dark" onclick="">사업자 입점 신청</button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
    
</body>
</html>