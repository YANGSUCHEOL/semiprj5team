<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            grid-template-columns: 1fr 5fr 1.5fr;
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

    <div id="main">
        <div id="sidebar"></div>
        <div id="content">
            <div id="backspace">뒤로 가기</div>
            <div id="navigate">
                <div><span>사용자 리뷰</span></div>
                <div><span>★ 5.0</span></div>
                <div name="more-btn">더 보기</div>
            </div>
            <div class="review-list">
                <div class="review">
                    <div class="rev-profile">이미지</div>
                    <div class="rev-nickname">닉네임</div>
                    <div class="rev-best">아이콘</div>
                    <div class="rev-day">작성 일자</div>
                    <span class="rev-content">음식이 친절하고 사장님이 맛있어요</span>
                </div>
                <div class="review">
                    <div class="rev-profile">이미지</div>
                    <div class="rev-nickname">닉네임</div>
                    <div class="rev-best">아이콘</div>
                    <div class="rev-day">작성 일자</div>
                    <span class="rev-content">음식이 친절하고 사장님이 맛있어요</span>
                </div>
                <div class="review">
                    <div class="rev-profile">이미지</div>
                    <div class="rev-nickname">닉네임</div>
                    <div class="rev-best">아이콘</div>
                    <div class="rev-day">작성 일자</div>
                    <span class="rev-content">음식이 친절하고 사장님이 맛있어요</span>
                </div>
                <div class="review">
                    <div class="rev-profile">이미지</div>
                    <div class="rev-nickname">닉네임</div>
                    <div class="rev-best">아이콘</div>
                    <div class="rev-day">작성 일자</div>
                    <span class="rev-content">음식이 친절하고 사장님이 맛있어요</span>
                </div>
                <div class="review">
                    <div class="rev-profile">이미지</div>
                    <div class="rev-nickname">닉네임</div>
                    <div class="rev-best">아이콘</div>
                    <div class="rev-day">작성 일자</div>
                    <span class="rev-content">음식이 친절하고 사장님이 맛있어요</span>
                </div>
                <div class="page">페이지</div>
            </div>
        </div>
    </div>
    
</body>
</html>