<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    
     #answer{

    border-top: 1px solid #DEDEDE;
    --border-bottom: 1px solid #DEDEDE;
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

    <div id="background">

        <div id="top-back">
            <div id="top-name">사업자 문의 확인하기</div>
        </div>

        <div id = "main">
            <div id="main-top">
                <div id="toptxt">겟 잇 비건 온라인 상담실</div>
                <hr>
            </div>
           
            <div id="title">
                <div>쿠폰 사용 어디서 하나요?</div>
                <div>닉네임</div>
                <div>2022-12-31</div>
                <div id="ans-done">답변완료</div>
            </div>
            <div id="context">
                <div>본문내용~~~~</div>
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