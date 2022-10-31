<%@page import="com.kh.semiPrj.member.MemberVo"%>
<%@page import="com.kh.semiPrj.notice.vo.NoticeVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<NoticeVo> voList = (List<NoticeVo>)request.getAttribute("voList");
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

        @import url('https://fonts.googleapis.com/css2?family=Alumni+Sans+Pinstripe&display=swap');

        *{font-family: 'Alumni Sans Pinstripe', sans-serif;}

        #main{
            width: 70vw;
            height: 70%;
            border: 1px solid lightgray;
            border-radius: 10px;
            margin: 100px auto;
            padding: 50px;
            align-content: center;
        }

        #title1{ 
            display: grid; 
            grid-template-rows: 100px;
            margin: 0 auto;
            place-items: center;
            text-align: center;
            background-color: #EEFFF6;
            border-bottom: 1px solid black;
            font-size: 25px;
            --font-weight: 300;
        }

        #content{
            --box-sizing: border-box;
            padding: 10px;
            display: grid;
            grid-template-columns: 1fr 1fr 4fr 2fr 1fr;
            grid-template-rows: repeat(13, 50px);
            text-align: center;
            place-items: center;  
        } 
          
          
        #content .list{
          width: 100%;
          height: 100%;
          display: flex;
          align-items: center;
          justify-content: center;
          border-bottom: 1px solid lightgray;
          padding: 10px;
        }
        
        .list > a {
        	text-decoration : none;
        	color : black;
        	}
        
       	.list > a:hover {
    		text-decoration: underline;
  		}	
        
        #write{
          float: right;
          margin: -10px;
          background-color: #EEFFF6;

        }

        #write:hover {
            background-color: #e4faee;
            border: 1px solid #e4faee;
        }

        #page-area2{
            padding: 20px;
            display: flex;
            justify-content: center;
            margin-left: 250px;
            
        }


    </style>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp" %>
    <div id="main">
        <div id="title1">
            <div>NOTICE🌿</div>
        </div>

        <div id="content">
            <div class="list">번호</div>
            <div class="list"></div>
            <div class="list">제목</div>
            <div class="list">작성일시</div>
            <div class="list">조회수</div>

			<%for(int i = 0; i < voList.size(); ++i){ %>
				
	            <div class="list"><%= voList.get(i).getNo() %></div>
	            <div class="list"></div>
	            <div class="list"><a href="/semiPrj/notice/detail?no=<%= voList.get(i).getNo()%>"><%= voList.get(i).getTitle()%></a></div>
	            <div class="list"><%= voList.get(i).getEnrollDate() %></div>
	            <div class="list"><%= voList.get(i).getHit() %></div>
			<%} %>

        </div>
        
		<%if(loginMember != null){ %>
        <div id="main-bot">
            <a href="/semiPrj/notice/write" class="btn btn-light" id="write">글쓰기</a>
        </div>
		<%} %>
		

    </div>



    
</body>
</html>