<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="com.kh.semiPrj.qna.vo.QuestionVo"%>

<%
List<QuestionVo> voList = (List<QuestionVo>)request.getAttribute("voList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link href="[https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css](https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css)" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="[https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js](https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js)"></script>

<style>
#background{
box-sizing: border-box;


position: relative;
width: 70vw;
height: 800px;

margin: auto;
margin-top:50px;

background: rgba(255, 255, 255, 0.45);
border: 1px solid #DADADA;
border-radius: 10px;
}

#top-back{
    position: relative;
    width: 75%;
    height: 5%;
    --left: 65px;
    --top: 25px;
    background: #FCFFED;
    border-radius: 10px;
    margin: auto;
    margin-top: 20px;
    padding-top: 20px;

}

#top-name{
    font-family: 'Inter';
    font-style: normal;
    font-weight: 400;
    font-size: 20px;
    line-height: 21px;
    text-align: center;
    margin: 0 auto;

    color: #000000;
}

#main-back{
    box-sizing: border-box;

    position: relative;
    width: 75vw;
    height: 362px;
    left: 65px;
    top: 100px;

    background: #FFFFFF;
    border: 2px solid #868787;
}

#main-back>div{
    text-align: center;
}

#toptxt{
    position: relative;
    left: 10vw;
    top: 5vh;
    font-size: 17px;

    --margin: 20px;
}

hr{
    width: 80%;
    margin-top: 5%;
    margin-bottom: 20px;
}
#list{

    width: 80%;
    display: grid;
    grid-template-rows: repeat(11 , 30px);
    grid-template-columns: 1.5fr 5fr 2.5fr 2fr 2fr;
    margin: 0 auto;
    border: 1px solid black;
    align-content: center;
    row-gap: 10px;

}

#list > div{
    --text-align: center;
    --border: 1px solid #DEDEDE;
    display: flex;
    justify-content: center;
    border-bottom: 1px solid #DEDEDE;
}

#ans-done{
    color: #82A994;
}
#ans-expect{
    color: #7E7E7E;
}



</style>
</head>
	<body>
	<%@ include file="/WEB-INF/views/header.jsp" %>
	<div id="background">
	
	
	    <div id="top-back">
	        <div id="top-name">내 문의 확인하기</div>
	    </div>
	
	    <div id = "main">
	        <div id="main-top">
	            <div id="toptxt">겟 잇 비건 온라인 상담실</div>
	            <hr>
	        </div>
	        <div id="list">
	            <!-- <div id="ans-done"><div id="ans-expect"> -->
	            <div>글번호</div>
	            <div>제목</div>
	            <div>작성자</div>
	            <div>날짜</div>
	            <div>답변여부</div>
	
	            <%for(int i = 0; i < voList.size(); i++) { %>
	            	<div><%= voList.get(i).getNo() %></div> <!-- 타이틀은 제대로 가져와지는데 글번호는 뭔데 -->
	            	<div><a href="/semiPrj/qna/detail?no=<%= voList.get(i).getNo() %>"><%= voList.get(i).getTitle() %></a></div>
	           		<!-- customer 뺌 -->
	           		<div><%= voList.get(i).getmNo() %></div>
	           		<div><%= voList.get(i).getEnrollDate() %></div>
	           		<% if(voList.get(i).getAnswerYn() == "Y") {%>
	          		 	<div id="ans-done">답변완료</div>
	           		<%} else{%>
	           			<div id="ans-expect">답변예정</div>
					<%} %>
	
	           		<%} %>
	
	           	 
	
	    </div>
	    <div id="page-area" align="center">
	           	 	<a href="/semiPrj/qna/write">작성하기</a>
	
	        </div>
	
	    </div>
	
	</div>
	
	
	
	</body>
</html>