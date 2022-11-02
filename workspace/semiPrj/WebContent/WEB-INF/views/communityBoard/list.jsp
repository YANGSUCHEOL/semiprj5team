<%@page import="common.PageVo"%>
<%@page import="com.kh.semiPrj.community.vo.CategoryVo"%>
<%@page import="com.kh.semiPrj.community.vo.CommuVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
	List<CommuVo> voList = (List<CommuVo>)request.getAttribute("voList");
	CategoryVo cateVo = (CategoryVo)request.getAttribute("cateVo");
	PageVo pv = (PageVo)request.getAttribute("pv");
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
            text-align: center;
            place-items: center;
            background-color: #EEFFF6;
            border-bottom: 1px solid lightgray;
            font-size: 20px;
        }

        #content{
            --box-sizing: border-box;
            padding: 10px;
            display: grid;
            grid-template-columns: 1fr 1fr 4fr 2fr 2fr 1fr;
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
          margin: 10px;
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
            margin-left: 450px;
            
        }


    </style>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp" %>
    <div id="main">
        <div id="title1">
            <div><h3>COMMUNITY🌿</h3></div>
        </div>

        <div id="content">
            <div class="list"><b>번호</b></div>
            <div class="list"></div>
            <div class="list"><b>제목</b></div>
            <div class="list"><b>작성자</b></div>
            <div class="list"><b>작성일시</b></div>
            <div class="list"><b>조회수</b></div>

			<%for(int i = 0; i < voList.size(); ++i){ %>
				
	            <div class="list"><%= voList.get(i).getNo() %></div>
	            <div class="list"><%= voList.get(i).getCategory() %></div>
	            <div class="list"><a href="/semiPrj/community/detail?bno=<%= voList.get(i).getNo()%>"><%= voList.get(i).getTitle()%></a></div>
	            <div class="list"><%= voList.get(i).getWriter() %></div>
	            <div class="list"><%= voList.get(i).getEnrollDate() %></div>
	            <div class="list"><%= voList.get(i).getHit() %></div>
			<%} %>

        </div>
        
		<%if(loginMember != null){ %>
        <div id="main-bot">
            <a href="/semiPrj/community/write" class="btn btn-light" id="write">글쓰기</a>
        </div>
		<%} %>
		
        <div id="page-area" class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
            <div id="page-area2" class="btn-group me-2" role="group" aria-label="First group">
            
	            <%if(pv.getStartPage() != 1){%>
		        	<a href="/semiPrj/community/list?pno=<%=pv.getStartPage()-1%>" class="btn btn-outline-secondary"><</a>
		       	<%}%>
	        
	           	<%for(int i = pv.getStartPage() ; i <= pv.getEndPage(); ++i){%>
		        	<a href="/semiPrj/community/list?pno=<%=i%>" class="btn btn-outline-secondary"><%=i%></a>
		        <%}%>
		        
		        <%if(pv.getEndPage() != pv.getMaxPage()){%>
			        <a href="/semiPrj/community/list?pno=<%=pv.getEndPage()+1%>" class="btn btn-outline-secondary">></a>
		        <%}%>    

                
            </div>
        </div>



    </div>



    
</body>
</html>