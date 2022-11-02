<%@page import="com.kh.semiPrj.faq.vo.FaqVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	FaqVo vo = (FaqVo)request.getAttribute("vo");

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
    .btn {
        margin-top: 10px;
        margin-left: 90%;
        display: inline-block;
        padding: 0 30px;
        font-size: 15px;
        font-weight: 400;
        background: transparent;
        white-space: nowrap;
        vertical-align: middle;
        -ms-touch-action: manipulation;
        touch-action: manipulation;
        cursor: pointer;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
        border: 1px solid #ccc;
        text-transform: uppercase;
        -webkit-border-radius: 0;
        -moz-border-radius: 0;
        border-radius: 20px;
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
        width: 100%;
        border-top: 1px solid #ccc;
        border-bottom: 1px solid #ccc;
    }
    .board-table .th-title{
        width: 200px;
        text-align: left;
    }
    .board-table th, .board-table td{
        padding: 18px 0;
    }
    .board-table thead td{
        width: 20vw;
        text-align: right;
        border-bottom: 1px solid #e7e7e7;
    }
    .board-table tbody td{
        width: 80vw;
        height: 40vh;
        border-top: 1px solid #e7e7e7;
        text-align: left;
        vertical-align: text-top;
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
                <h3>FAQ</h3>
            </div>
        </div>

        <div id="faq-list">
            <div class="container">
                <table class="board-table">
                    <thead>
                        <tr>
                            <th scope="col" class="th-title"><%= vo.getTitle() %></th>
                            <td><%= vo.getEnrollDate()%></td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><%= vo.getContent() %></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <div id="board-write">
            <div class="container">
                	<button type="submit" class="btn btn-dark" onclick="location.href='/semiPrj/faq/list'">목록가기</button>
                
            </div>
        </div>

    </section>
    
</body>
</html>