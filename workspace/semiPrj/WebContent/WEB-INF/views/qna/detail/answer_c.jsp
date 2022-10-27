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

    --position: absolute;
    width: 70vw;
    height: 800px;
    --left: 82px;
    --top: 150px;
    margin: 0 auto;
    margin-top:50px;

    background: rgba(255, 255, 255, 0.45);
    border: 1px solid #DADADA;
    border-radius: 10px;
    }

    #top-back{
        --position: absolute;
        width: 80%;
        height: 41px;
        left: 65px;
        top: 25px;
        background: #FCFFED;
        border-radius: 10px;
        margin: auto;
        margin-top: 30px;
        padding-top: 20px;

    }

    #top-name{
        
        font-style: normal;
        font-weight: 400;
        
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

        --position: absolute;
        width: 697px;
        height: 362px;
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
        font-size: 17px;
        margin-top: 20px;
        --border-bottom :1px solid #868787;
        
    }


    #title{
    width: 90%;
    display: grid;
    grid-template-columns: 6fr 2.5fr 2fr 2fr;
    margin: 0 auto;
    padding: 10px;
    align-content: center;
    text-align: center;
    border-bottom: 1px solid #DEDEDE;

}

	#title>div{
	display: grid;
    grid-template-columns: 6fr 2.5fr 2fr 2fr;
    justify-content: center;
    text-align: center;
}

    #context{
        width: 90%;
        height: 300px;
        padding: 10px;
      
    }

    #ans-done{
        color: #82A994;
    }
    #ans-expect{
        color: #7E7E7E;
    }

    #btns{
        text-align: center;
        color: #FCFFED;
    }
    

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jsp" %>
    <div id="background">

        <div id="top-back">
            <div id="top-name">개인 회원 문의 확인하기</div>
        </div>

        <div id = "main">
            <div id="main-top">
                <div id="toptxt">겟 잇 비건 온라인 상담실</div>
                
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
            
            
            <div id="answer-wrap">
                <label for="answer"></label>
            	<div><input type="text" id="answer" style="width:900px; height:150px;"></div>
            </div>
           
            <div id="btns">
                <button onclick="insertAnswer();">작성하기</button>
                <a href="/semiPrj/qna/adminList?pno=1"><button>목록</button></a>
            </div>
            
            
                    	


            <script>

                function insertAnswer(){

                    $.ajax({

                    	url:"/semiPrj/qna/adminWrite"
                    	,data : {
	                        content: $("#answer").val()
	                        , qNo : <%=vo.getNo()%>
                    	}
                    	, type:"post"
                    	, success : function(result){
	                        if(result>0){
	                        selectAnswerList();
	                        $("#answer").val("");
	                        }
                    	}
                    })
                };

                
            </script>


                


               

           


        </div>

        
    </div>
</body>
</html>