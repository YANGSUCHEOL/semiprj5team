<%@page import="com.kh.semiPrj.member.MemberVo"%>
<%@page import="com.kh.semiPrj.notice.vo.NoticeVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	NoticeVo vo = (NoticeVo)request.getAttribute("noticeVo");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GET EAT VEGAN</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

    <style>
        #main{
            width: 60vw;
            height: 70vh;
            margin: 100px auto;
            border: 1px solid lightgray;
            border-radius: 10px;
        	padding: 50px;
        	width: 70vw;
        	height: 800px;
        }

        #notice {
            padding: 20px;
            border-bottom: 1px solid lightgray;
        }

        #title1{
            box-sizing: border-box;
            display: grid;
            grid-template-columns: 5fr 2fr 1fr 1fr;
            grid-template-rows: 50px;
            text-align: left;
            --border-bottom: 1px solid lightgray;
            margin: 20px auto;
            padding: 20px;
        }

        #content{
            box-sizing: border-box;
            display: grid;
            grid-template-rows: 330px;
            --border: 1px solid black;
            margin: 0 auto;
            padding: 20px;
        }

        .btn{
            margin-right: 10px;
            background-color: #EEFFF6;
	        color: black;
	        border: 1px solid #EEFFF6;
	        font-size: 12px;
        }
        
        .btn:hover {
        	border: 1px solid #e0fbed;
        	background-color: #e0fbed;
    	}
        
        
        

    </style>


</head>

<body>
	<%@ include file="/WEB-INF/views/header.jsp" %>
    <div id="main">
        <div id="notice">
            <h4>NOTICE🌱</h4>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button class="btn btn-outline-secondary me-md-2" type="button" onclick="location.href='/semiPrj/notice/list'">목록</button>
           <%if(loginMember != null && loginMember.getId().equals("admin")){%>
	            <a href="/semiPrj/notice/edit?no=<%= vo.getNo()%>" class="btn btn-outline-secondary me-md-2" type="button">수정</a>
	            <a href="/semiPrj/notice/delete?no=<%= vo.getNo() %>" class="btn btn-outline-secondary" type="button">삭제</a>
			<%}%>
        </div>
        </div>

        <div id="title1">
            <div><b><%= vo.getTitle() %></b></div>
            <div><%= vo.getEnrollDate() %></div>
            <div><%= vo.getWriter() %></div>
            <div><%= vo.getHit() %></div>
        </div>

        <div id="content">
            <div><%= vo.getContent() %></div>
        </div>

        
			

    </div>









    
</body>
</html>