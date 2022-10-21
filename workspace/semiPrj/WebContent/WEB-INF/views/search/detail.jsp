<%@page import="com.kh.semiPrj.review.vo.ReviewVo"%>
<%@page import="com.kh.semiPrj.restaurant.vo.MenuVo"%>
<%@page import="com.kh.semiPrj.restaurant.vo.RestaurantVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	RestaurantVo vo = (RestaurantVo)session.getAttribute("restaurant");
	List<MenuVo> menu = (List<MenuVo>)session.getAttribute("menu");
	List<ReviewVo> review = (List<ReviewVo>)session.getAttribute("review");
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
            justify-content: center;
            align-items: center;
            grid-template-rows: repeat(4, minmax(70px, auto));
            grid-template-columns: 1fr;
            background: #FFFFFF;
            border: 1px solid #DEDEDE;
            border-radius: 10px;
            padding: 10%;
            row-gap: 30px;
        }

        #res-info {
            display: grid;
            grid-template-rows: repeat(6, minmax(30px, auto));
            row-gap: 10px;
            column-gap: 50px;
        }
        .res-image {
            grid-row: 1/7;
            grid-column: 1/2;
            display: flex;
            align-items: center;
            justify-content: right;
        }
        .res-name {
            grid-column: 2/3;
        }
        #res-navi {
            display: flex;
            justify-content: space-evenly;
            align-items: center;
            column-gap: 20px;
        }
        .btn-common {
            width: 100px;
            height: 40px;
            background: #FFFFFF;
            border: 1px solid #DEDEDE;
            display: flex;
            justify-content: center;
            align-items: center;
            border-radius: 20px;
            font-size: 17px;
            font-weight: 400;
        }
        #res-menulist {
            display: grid;
            grid-template-columns: repeat(4, 1fr);
            grid-template-rows: 1fr 1fr;
            align-items: center;
        }
        #res-menulist>div:nth-child(1) {
            grid-column: 1/4;
        }
        div[name="more-btn"] {
            display: flex;
            justify-content: right;
            align-items: center;
        }
        .res-menu {
            display: grid;
            grid-template-columns: 1fr 1fr;
            grid-template-rows: 1fr 1fr;
            padding: 10px;
        }
        div[name="menu-picture"] {
            grid-row: 1/3;
        }
        #res-reviewlist {
            display: grid;
            grid-template-columns: minmax(10px, auto) repeat(3, 1fr);
            align-items: center;
        }
        div[name="star"] {
            padding-left: 25px;
            grid-column: 2/4;
        }
        .res-review {
            display: grid;
            grid-template-columns: minmax(10px, auto) 1fr;
            grid-auto-rows: minmax(43.2px, auto);
            column-gap: 10px;
            grid-column: 1/5;
            padding: 10px;
        }
        #res-menulist>div:nth-child(-n+2) {
            border-bottom: 1px solid lightgray;
            padding: 10px;
        }
        #res-reviewlist>div:nth-child(-n+3) {
            border-bottom: 1px solid lightgray;
            padding: 10px;
        }
        .res-review>div {
            align-self: center;
        }
        div[name="user-review"] {
            grid-column: 2/4;
        }
    </style>
</head>

<body>

	<%@ include file="/WEB-INF/views/header.jsp" %>

    <div id="main">
        <div id="sidebar"></div>
        <div id="content">
            <div id="res-info">
                <div class="res-image"><%= vo.getPhoto() %></div>
                <div class="res-name"><%= vo.getName() %></div>
                <div><%= vo.getType() %></div>
                <div><%= vo.getAddress() %></div>
                <div><%= vo.getPhone() %></div>
                <div><%= vo.getOpen() %> ~ <%= vo.getClose() %></div>
                <div><% for(int i = 0; i < vo.getOffDay().length; ++i) { %>
                <%= vo.getOffDay()[i] %> 
                <% } %>
                 휴무</div>
            </div>
            <div id="res-navi">
                <div><button class="btn-common" onclick="location-href=''">쿠폰 발급</button></div>
                <div><a class="btn-common" href="/semiPrj/res?rno=<%= vo.getNo() %>">예약하기</a></div>
                <div><a class="btn-common" href="/semiPrj/review/write?rno=<%= vo.getNo() %>">리뷰 작성</a></div>
            </div>
            <div id="res-menulist">
                <div><span>대표 메뉴 안내</span></div>
                <div name="more-btn" onclick="location-href='/semiPrj/menu/list'">더 보기</div>
                <%for(int i = 0; i < menu.size(); ++i){%>
					<div class="res-menu">
						<div name="menu-picture"><img src="<%= menu.get(i).getPhoto() %>"></img></div>
						<div name="menu-name"><%= menu.get(i).getName() %></div>
						<div name="menu-price"><%= menu.get(i).getPrice() %></div>
			        </div>
				<%}%>
            </div>
            <div id="res-reviewlist">
                <div name="review-info"><span>사용자 리뷰</span></div>
                <div name="star"><span>★ 5.0</span></div>
                <div name="more-btn" onclick="location-href='/semiPrj/review/list'">더 보기</div>
                <%for(int i = 0; i < review.size(); ++i){%>
					<div class="res-review">
						<div name="user-profile"><img src="<%= review.get(i).getWriter() %>"></img></div>
						<div name="user-review"><%= review.get(i).getContent() %></div>
			        </div>
				<%}%>
            </div>
        </div>
    </div>
</body>

</html>