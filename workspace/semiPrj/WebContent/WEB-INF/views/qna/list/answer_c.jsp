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
        line-height: 21px;
        text-align: center;

        color: #000000;
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

    #toptxt{
        position: absolute;
        left: 80px;
        top: 105px;
    }

    hr{
        width: 85%;
        margin-top: 17%;
    }
    #list{
        width: 85%;
        display: grid;
        grid-template-rows: repeat(11 , 30px);
        grid-template-columns: 1.5fr 5fr 2.5fr 2fr 2fr;
        margin: 0 auto;
        --border: 1px solid black;
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

    <div id="background">

        <div id="top-back">
            <div id="top-name">개인회원 문의 확인하기</div>
        </div>

        <div id = "main">
            <div id="main-top">
                <div id="toptxt">겟 잇 비건 온라인 상담실</div>
                <hr>
            </div>
            <div id="list">
                
                <div>글번호</div>
                <div>제목</div>
                <div>작성자</div>
                <div>날짜</div>
                <div>답변여부</div>

                <div>25</div>
                <div>안녕하세요</div>
                <div>홈런왕</div>
                <div>2022-10-12</div>
                <div id="ans-done">답변완료</div>

                <div>24</div>
                <div>안녕~~~</div>
                <div>홈런왕</div>
                <div>2022-10-09</div>
                <div id="ans-expect">답변예정</div>

                <div>23</div>
                <div>제보할게요~~~</div>
                <div>랄랄랄라</div>
                <div>2022-10-09</div>
                <div id="ans-expect">답변예정</div>

                <div>22</div>
                <div>저녁뭐먹지</div>
                <div>fdsfasd</div>
                <div>2022-09-30</div>
                <div id="ans-done">답변완료</div>


               

            </div>


        </div>

        
    </div>
</body>
</html>