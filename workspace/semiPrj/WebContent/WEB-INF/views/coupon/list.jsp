<%@page import="com.kh.semiPrj.coupon.CouponVo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.semiPrj.coupon.history.CouponHistoryVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<CouponHistoryVo> voList = (List<CouponHistoryVo>)request.getAttribute("voList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
        width: 57vw;
        border-top: 1px solid #ccc;
        border-bottom: 1px solid #ccc;
        text-align: center;
        margin: 0 auto;
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
        width: 50vw;
        text-align: center;
    }
    .board-table .th-title{
        width: 200vw;
    }
    .board-table .th-writer{
        width: 50vw;
    }
    .board-table .th-date{
        width: 100vw;
    }
    .board-table th, .board-table td{
        padding: 18px 0;
    }
    .board-table tbody td{
        border-top: 1px solid #e7e7e7;
        text-align: center;
    }
    .board-table tbody th{
        width: 70vw;
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

</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/header.jsp" %>

    <div class="header"></div>
    <section class="faq">
        <div class="page-title">
            <div class="container">
                <h3>쿠폰 내역</h3>
            </div>
        </div>

        <div id="faq-list">
                <table class="board-table">
                    <thead>
                        <tr>
                            <th scope="col" class="th-num">쿠폰 번호</th>
                            <th scope="col" class="th-title">가게명</th>
                            <th scope="col" class="th-date">발급일자</th>
                            <th scope="col" class="th-writer">사용여부</th>
                        </tr>
                    </thead>
                    <%for(int i = 0; i < voList.size(); ++i){%>
                    	<tbody>
	                        <tr>
                        		<td><%= voList.get(i).getcNo() %></td>
	                            <th>
	                                <a><%= voList.get(i).getrNo() %></a>
	                            </th>
                                <td><%= voList.get(i).getEnrollDate() %></td>
	                            <td><%= voList.get(i).getUsedYn() %></td>
	                        </tr>
	                    </tbody>
                   	<%}%>
                </table>
            </div>
    </section>
    
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>