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
	String root = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>search</title>

<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="resources/css/style.css">

<style>
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap')
	;

* {
	font-family: 'Noto Sans KR', sans-serif;
	letter-spacing: -0.1em;
}

#main {
	width: 70vw;
	display: grid;
	margin: 0 auto;
	grid-template-rows: 1fr;
	row-gap: 30px;
	align-content: center;
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
	font-size: 24pt;
	font-weight: bold;
}

#now {
	display: grid;
	grid-template-columns: repeat(3, 1fr);
	grid-template-rows: repeat(2, 1fr);
	row-gap: 70px;
	column-gap: 30px;
	justify-content: center;
	align-items: center;
}

.result {
	display: grid;
	grid-template-columns: 1fr;
	grid-template-rows: repeat(5, auto);
	row-gap: 10px;
	cursor: pointer;
}

.result>div>img {
	width: 200px;
	height: 200px;
	object-fit: cover;
}

.res-name {
	font-size: 20pt;
}

.none {
	grid-column: 1/4;
	grid-row: 1/3;
}

.btn-common {
	display: flex;
	width: 100px;
	height: 40px;
	justify-content: center;
	align-items: center;
	background: #FFFFFF;
	border: 1px solid #DEDEDE;
	border-radius: 20px;
	font-size: 17px;
	font-weight: 400;
}

a {
	text-decoration: none;
	color: black;
}

a:hover {
	color: gray;
}

#back-btn {
	display: flex;
	justify-content: center;
	align-items: center;
}

.active {
	font-family: "Poppins", Arial, sans-serif;
	color: gray;
	text-align: center;
	display: inline-block;
	width: 40px;
	height: 40px;
	line-height: 40px;
	border-radius: 50%;
	border: 1px solid #e6e6e6;
}

.active:hover {
	background-color: #EEFFF6;
	color: #e6e6e6;
}
</style>
</head>

<body>

	<%@ include file="/WEB-INF/views/header.jsp"%>

	<div id="main">
		<div id="content">
			<div id="text">
				<span>검색 결과 <%= cnt %> 건
				</span>
			</div>
			<div id="now">
				<% if(voList.size() != 0) { %>
				<%for(int i = 0; i < voList.size(); ++i){%>
				<div class="result"
					onclick="location.href='/semiPrj/search/detail?rno=<%= voList.get(i).getNo() %>'">
					<div>
						<img
							src="<%= root %>/resources/img/<%= voList.get(i).getPhoto() %>.jpg"></img>
					</div>
					<div class="res-name"><%= voList.get(i).getName() %></div>
					<div><%= voList.get(i).getAddress() %></div>
					<div><%= voList.get(i).getOpen() %>
						~
						<%= voList.get(i).getClose() %></div>
					<div>
						<% for(int k = 0; k < voList.get(i).getOffDay().length; ++k) { %>
						<%= voList.get(i).getOffDay()[k] %>
						<% } %>
						휴무
					</div>
				</div>
				<% } %>
				<% } else if(voList.size() == 0) { %>
				<div class="none">
					<span>검색 결과가 없습니다. 다시 검색해 주세요.</span>
				</div>
				<% } %>
			</div>
			<div id="page-area">

				<%if(pv.getStartPage() != 1){%>
				<a
					href="/semiPrj/search?pno=<%=pv.getStartPage()-1%>&resName=<%= resName %>"
					class="active"><</a>
				<%}%>

				<%for(int i = pv.getStartPage() ; i <= pv.getEndPage(); ++i){%>
				<a href="/semiPrj/search?pno=<%=i%>&resName=<%= resName %>"
					class="active"><%=i%></a>
				<%}%>

				<%if(pv.getEndPage() != pv.getMaxPage()){%>
				<a
					href="/semiPrj/search?pno=<%=pv.getEndPage()+1%>&resName=<%= resName %>"
					class="active">></a>
				<%}%>

			</div>
			<div id="back-btn">
				<a href="/semiPrj" class="btn-common">돌아가기</a>
			</div>
		</div>
	</div>

</body>

</html>