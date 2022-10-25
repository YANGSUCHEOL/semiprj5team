<%@page import="common.PageVo"%>
<%@page import="com.kh.semiPrj.review.vo.ReviewVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<ReviewVo> voList = (List<ReviewVo>)request.getAttribute("review");
	PageVo pv = (PageVo)request.getAttribute("pv");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
    @import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap')
	;

* {
	font-family: 'Noto Sans KR', sans-serif;
	letter-spacing: -0.1em;
}
        body {
            letter-spacing: -0.1em;
        }
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
            align-items: center;
            grid-template-rows: repeat(3, minmax(70px, auto));
            background: #FFFFFF;
            border: 1px solid #DEDEDE;
            border-radius: 10px;
        }
        #navigate {
            display: grid;
            grid-template-columns: 1fr;
            border-bottom: 1px solid lightgray;
            align-items: center;
            padding: 20px;
            margin-left: 100px;
            margin-right: 100px;
            margin-bottom: 50px;
        }
        #backspace {
            margin-left: 100px;
            padding-top: 80px;
            padding-bottom: 20px;
        }
        .review-list {
            display: grid;
            grid-template-rows: repeat(6, auto);
            row-gap: 40px;
        }
        .review {
            border: 1px solid #DEDEDE;
            border-radius: 10px;
            padding: 20px;
            display: grid;
            margin-left: 100px;
            margin-right: 100px;
            grid-template-columns: 60px minmax(20px, auto) 5fr;
            grid-template-rows: 20px 30px auto;
            row-gap: 10px;
            column-gap: 10px;
        }
        .page {
            display: flex;
            align-items: center;
            justify-content: center;
            margin: auto;
            padding: 50px;
        }
        .rev-profile {
            grid-column: 1/2;
            grid-row: 1/3;
        }
        .rev-nickname, .rev-best {
            display: flex;
        }
        .rev-day {
            grid-column: 2/4;
            display: flex;
            align-items: center;
        }
        .rev-content {
            grid-column: 1/4;
            margin-left: 30px;
            line-height: 200%;
        }
        div[name="more-btn"] {
            text-align: right;
        }
    </style>
</head>
<body>

<%@ include file="/WEB-INF/views/header.jsp" %>

    <div id="main">
        <div id="sidebar"></div>
        <div id="content">
            <div id="backspace"><a href="/semiPrj/mypage">뒤로 가기</a></div>
            <div id="navigate">
                <div><span>사용자 리뷰</span></div>
            </div>
            <div class="review-list">
                <div class="review">
                    <div class="rev-profile">이미지</div>
                    <div class="rev-nickname">닉네임</div>
                    <div class="rev-best">아이콘</div>
                    <div class="rev-day">작성 일자</div>
                    <span class="rev-content">음식이 친절하고 사장님이 맛있어요</span>
                </div>
                <% if(voList.size() != 0) { %>
					<%for(int i = 0; i < voList.size(); ++i){%>
						<div class="review">
							<div class="rev-nickname"><%= voList.get(i).getWriter() %></div>
							<div class="rev-best"><%= voList.get(i).getScore() %></div>
							<div class="rev-day"><%= voList.get(i).getEnrollDate() %></div>
					        <div class="rev-content"><%= voList.get(i).getContent() %></div>
					    </div>
					<% } %>
				<% } else if(voList.size() == 0) { %>
						<div class="none"><span>검색 결과가 없습니다. 다시 검색해 주세요.</span></div>
				<% } %>
				
                <div class="page">
                
                <%if(pv.getStartPage() != 1){%>
                	<form action="/semiPrj/review/list" method="post">
                		<input type="button" name="pno" value="<%= pv.getStartPage()-1 %>">
                		<input type="hidden" name="mno" value="<%= loginMember.getNo() %>">
                		<input type="submit" value="이전" class="btn btn-primary btn-sm">
                	</form>
		       	<%}%>
	        
		        <%for(int i = pv.getStartPage(); i <= pv.getEndPage(); ++i){%>
		        	<form action="/semiPrj/review/list" method="post">
		        		<input type="button" name="pno" value="<%=i%>">
                		<input type="hidden" name="mno" value="<%= loginMember.getNo() %>">
                		<input type="submit" value="<%=i%>" class="btn btn-primary btn-sm">
                	</form>
		        <%}%>
		        
		        <%if(pv.getEndPage() != pv.getMaxPage()){%>
		        	<form action="/semiPrj/review/list" method="post">
		        		<input type="button" name="pno" value="<%=pv.getEndPage()+1%>>">
                		<input type="hidden" name="mno" value="<%= loginMember.getNo() %>">
                		<input type="submit" value="다음" class="btn btn-primary btn-sm">
                	</form>
		        <%}%>
                
                </div>
            </div>
        </div>
    </div>
    
</body>
</html>