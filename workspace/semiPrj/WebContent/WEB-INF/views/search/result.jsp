<%@page import="common.PageVo"%>
<%@page import="com.kh.semiPrj.restaurant.vo.RestaurantVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<RestaurantVo> voList = (List<RestaurantVo>)request.getAttribute("voList");
	PageVo pv = (PageVo)request.getAttribute("pv");
	String resName = (String)request.getAttribute("resName");
	String cnt = (String)request.getAttribute("cnt");
%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>search</title>
    
    <!-- Latest compiled and minified CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Latest compiled JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
	
    <style>
        #main {
            width: 65vw;
            display: grid;
            margin: 0 auto;
            grid-template-rows: 70px minmax(100px, auto);
            row-gap: 30px;
            align-content: center;
        }

        #sidebar {
            background: #EEFFF6;
            display: flex;
        }

        #content {
            box-sizing: border-box;
            display: grid;
        	padding: 50px;
            justify-content: center;
            align-items: center;
            text-align: center;
            grid-template-columns: 1fr;
            grid-template-rows: repeat(4, minmax(70px, auto));
            background: #FFFFFF;
            border: 1px solid #DEDEDE;
            border-radius: 10px;
            row-gap: 30px;
        }
        body {
            letter-spacing: -0.1em;
        }
        #text {
        	font-size: 24px;
            font-weight: bold;
        }
        #now {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            grid-template-rows: repeat(2, 1fr);
            row-gap: 50px;
            column-gap: 30px;
        }
    </style>
</head>

<body>

	<%@ include file="/WEB-INF/views/header.jsp" %>

    <div id="main">
        <div id="sidebar"></div>
        <div id="content">
            <div id="text"><span>검색 결과 <%= cnt %> 건</span></div>
            <div id="now">
            
				<%for(int i = 0; i < voList.size(); ++i){%>
					<div class="result" onclick="location.href='/semiPrj/search/detail?rno=<%= voList.get(i).getNo() %>'">
						<div><img src="<%= voList.get(i).getPhoto() %>"></img></div>
						<div><%= voList.get(i).getName() %></div>
				        <div><%= voList.get(i).getAddress() %></div>
				        <div><%= voList.get(i).getOpen() %> ~ <%= voList.get(i).getClose() %></div>
				        <div><%= voList.get(i).getDayoff() %> 휴무</div>
			        </div>
				<%}%>
				
            </div>
            <div id="page-area">
        
	        <%if(pv.getStartPage() != 1){%>
	        	<a href="/semiPrj/search?pno=<%=pv.getStartPage()-1%>&resName=<%= resName %>" class="btn btn-primary btn-sm">이전</a>
	       	<%}%>
        
	        <%for(int i = pv.getStartPage() ; i <= pv.getEndPage(); ++i){%>
	        	<a href="/semiPrj/search?pno=<%=i%>&resName=<%= resName %>" class="btn btn-primary btn-sm"><%=i%></a>
	        <%}%>
	        
	        <%if(pv.getEndPage() != pv.getMaxPage()){%>
		        <a href="/semiPrj/search?pno=<%=pv.getEndPage()+1%>&resName=<%= resName %>" class="btn btn-primary btn-sm">다음</a>
	        <%}%>
        
        	</div>
            <div><a href="/semiPrj">돌아가기</a></div>
        </div>
    </div>
</body>

</html>