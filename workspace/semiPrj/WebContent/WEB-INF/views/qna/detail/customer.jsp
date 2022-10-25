<%@page import="java.util.List"%>

<%@page import="com.kh.semiPrj.qna.vo.QuestionVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>


<%
	QuestionVo vo = (QuestionVo)request.getAttribute("vo");
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#background{
box-sizing: border-box;


position: relative;
width: 832px;
height: 800px;
left: 82px;
top: 150px;

background: rgba(255, 255, 255, 0.45);
border: 1px solid #DADADA;
border-radius: 10px;
}

#top-back{
    position: absolute;
    width: 697px;
    height: 41px;
    left: 65px;
    top: 25px;
    background: #FCFFED;
    border-radius: 10px;
    margin: auto;
    padding-top: 20px;

}

#top-name{
    font-family: 'Inter';
    font-style: normal;
    font-weight: 400;
    font-size: 17px;
    --line-height: 21px;
    text-align: center;

    color: #000000;
}

#main{
    width: 85%;
    margin: auto;
}

#main-back{
    box-sizing: border-box;

    position: absolute;
    width: 697px;
    height: 500px;
    left: 65px;
    top: 100px;

    background: #FFFFFF;
    border: 2px solid #868787;
}

#main-back>div{
    text-align: center;
}

#main-top{
    padding-bottom: 20px;
    border-bottom: 1px solid #868787;

}

#toptxt{
    position: absolute;
    --left: 80px;
    --top: 105px;
    padding: 10px;
    -border: 1px solid #DEDEDE;

}

hr{
    width: 90%;
    margin-top: 20%;
    color: #DEDEDE;
}

#title{
    width: 90%;
    display: grid;
    grid-template-columns: 6fr 2.5fr 2fr 2fr;
    margin: 0 auto;
    padding: 10px;
    --align-content: center;
    border-bottom: 1px solid #DEDEDE;

}

#title>div{
	display: grid;
    grid-template-columns: 6fr 2.5fr 2fr 2fr;
    justify-content: center;
}

#context{
    width: 87%;
    padding: 15px;
    height: 260px;
    --border: 1px solid red;
}

#ans-done{
    color: #82A994;
}
#ans-expect{
    color: #7E7E7E;
}

#btns{
    text-align: center;
}

#answer{

    border-top: 1px solid #DEDEDE;
    border-bottom: 1px solid #DEDEDE;
    display: grid;
    grid-template-columns: 8.5fr 4fr;
}

#answer>div{
    margin-top: 10px;
    margin-bottom: 5px;

}

#answer-title{
    padding-left: 10px;
    color: #82A994;
}

#answer-content{
    border-top: 1px solid #DEDEDE;
    padding: 10px;
    grid-column: span 2;
    height: 150px;
}

#main-bot{
		width : 60vw;
		margin : 0 auto;
		text-align : center;
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

        <div id="title">
            <div><%= vo.getTitle() %></div>
            <div><%= vo.getmNo() %></div>
            <div><%= vo.getEnrollDate() %></div>

            <% if(vo.getAnswerYn() == "Y") {%>
          		 	<div id="ans-done">답변완료</div>
           		<%} else{%>
           			<div id="ans-expect">답변예정</div>
				<%} %>
        </div>
        <div id="context">
            <div><%= vo.getContent() %></div>
        </div>
        <div id="main-bot">
			<a href="/semiPrj/qna/edit?no=<%= vo.getNo() %>">수정하기</a>
			<a href="/semiPrj/qna/delete?no=<%= vo.getNo() %>">삭제하기</a>
		</div>

        <div id="answer">
            <div id="answer-title">고객님 질문 답변 드립니다~</div>
            <div id="answer-date">2022.10.01</div>
            <div id="answer-content">어쩌구 저쩌구 저쩌구 어쩌구~~~~</div>

        </div>

        <div id="btns">
            <a><button>목록</button></a>
        </div>

    </div>

</div>



</body>
</html>