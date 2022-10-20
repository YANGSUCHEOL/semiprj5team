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

    position: absolute;
    width: 832px;
    height: 468px;
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
        position: absolute;
        --left: 80px;
        --top: 105px;
        
    }

    hr{
        margin-top: 17%;
        color: #FFFFFF;
    }


    #title{
        width: 90%;
        display: grid;
        grid-template-columns: 6fr 2.5fr 2fr 2fr;
        margin: 0 auto;
        padding: 3px;
        align-content: center;
        border-bottom: 1px solid #DEDEDE;

    }

    #context{
        width: 90%;
        padding: 15px;
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
           
            <div id="btns">
                <input type="submit" value="작성하기">
                <a><button>목록</button></a>
            </div>


                


               

           


        </div>

        
    </div>
</body>
</html>