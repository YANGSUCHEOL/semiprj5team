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


        #main{
            width: 70vw;
            height: 70%;
            border: 1px solid lightgray;
            border-radius: 10px;
            margin: 0 auto;
            padding: 0px;
            align-content: center;
            overflow: auto;
        }

        #title1{ 
            display: grid; 
            grid-template-rows: 100px;
            margin: 0 auto;
            place-items: center;
            text-align: center;
            background-color: #EEFFF6;
            border-bottom: 1px solid lightgray;
            font-size: 25px;
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
        
        #main-bot{
        	margin: 50px;
        	padding: 10px;
        }
        
        #write{

          float: right;
          background-color: #EEFFF6;

        }

        #write:hover {
            background-color: #e4faee;
            border: 1px solid #e4faee;
        }

     


    </style>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp" %>
    <div id="main">
        <div id="title1">
            <div><h3>NOTICE🌿</h3></div>
        </div>

        <div id="content">
            <div class="list"><b>번호</b></div>
            <div class="list"></div>
            <div class="list"><b>제목</b></div>
            <div class="list"><b>작성일시</b></div>
            <div class="list"><b>조회수</b></div>

			<%for(int i = 0; i < voList.size(); ++i){ %>
				
	            <div class="list"><%= voList.get(i).getNo() %></div>
	            <div class="list"></div>
	            <div class="list"><a href="/semiPrj/notice/detail?no=<%= voList.get(i).getNo()%>"><%= voList.get(i).getTitle()%></a></div>
	            <div class="list"><%= voList.get(i).getEnrollDate() %></div>
	            <div class="list"><%= voList.get(i).getHit() %></div>
			<%} %>

        </div>
        
		<%if(loginMember != null && loginMember.getId().equals("admin")){ %>
        <div id="main-bot">
            <a href="/semiPrj/notice/write" class="btn btn-light" id="write">글쓰기</a>
        </div>
		<%} %>
		

    </div>



    
</body>
</html>