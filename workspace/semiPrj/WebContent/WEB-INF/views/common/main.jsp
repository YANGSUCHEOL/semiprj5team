<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

    #wrap{
        width: 80vw;
        border: 1px solid gray;
        align-items: center;
    }
    #top-main{
        width: 80vw;
        height: 8vh;
        display: grid;
        grid-template-columns: 2fr 1fr 1fr 1fr 1fr 1fr;
        background: #EEFFF6;
        margin: auto;
        text-align: center;
     
    }

    
	/* 브라우저 마진과 패딩 리셋 */
	* {margin:0;padding:0;}

	/* INPUT 가리기 */
	.section input[id*="slide"] {display:none;}

	/* 슬라이드 영역 - max-width 크기를 조절해주면 됩니다*/
	.section .slidewrap {max-width:800px;margin:0 auto;overflow:hidden;}
	.section .slidelist {white-space:nowrap;font-size:0;}
	.section .slidelist > li {display:inline-block;vertical-align:middle;width:100%;transition:all .5s;}
	.section .slidelist > li > a {display:block;position:relative;}
	.section .slidelist > li > a img {width:100%;}

	/* 좌우로 넘기는 LABEL버튼에 대한 스타일 */
	.section .slidelist label {position:absolute;z-index:1;top:50%;transform:translateY(-50%);padding:50px;cursor:pointer;}
	.section .slidelist .left {left:30px;background:url('/semi01/resources/img/left.png') center center / 100% no-repeat;}
	.section .slidelist .right {right:30px;background:url('/semi01/resources/img/right.png') center center / 100% no-repeat;}

	/* INPUT 체크되면 변화값이 li까지 전달되는 스타일 */
	.section input[id="slide01"]:checked ~ .slidewrap .slidelist > li {transform:translateX(0%);}
	.section input[id="slide02"]:checked ~ .slidewrap .slidelist > li {transform:translateX(-100%);}
	.section input[id="slide03"]:checked ~ .slidewrap .slidelist > li {transform:translateX(-200%);}
	
    #main-bottom{
        
        display: grid;
        grid-template-columns: 1fr 1fr 1fr 1fr;
        margin: auto;
        text-align: center;
        padding: 50px;
    }

    #main-bottom > div{
        --border: 1px solid black;
    }

    #board-list{
        display: grid;
        grid-template-columns: 1fr 1fr;
    }
    
    </style>

    
    <%@ include file="/WEB-INF/views/header.jsp" %>
</style>
</head>
<body>
    <div id="wrap">
        <div id="top-main">
            <div>지금 뜨는 식당</div>
            <div><a>#남미플랜트랩</a></div>
            <div><a>#레이지파머스</a></div>
            <div><a>#플랜트</a></div>
            <div><a>#브레게티</a></div>
            <div><a>#슬로우캘리</a></div>
        </div>
        
        <!--<div id="banner">슬라이드로 넘어감</div>-->

        <div class="section">
            <input type="radio" name="slide" id="slide01" checked>
            <input type="radio" name="slide" id="slide02">
            <input type="radio" name="slide" id="slide03">
    
            <div class="slidewrap">
                <ul class="slidelist">
                    <li>
                        <a>
                            <label for="slide03" class="left"></label>
                            <img src="/semi01/resources/img/1copy.png">
                            <label for="slide02" class="right"></label>
                        </a>
                    </li>
                    <li>
                        <a>
                            <label for="slide01" class="left"></label>
                            <img src="/semi01/resources/img/coupon1.jpg">
                            <label for="slide03" class="right"></label>
                        </a>
                    </li>
                    <li>
                        <a>
                            <label for="slide02" class="left"></label>
                            <img src="/semi01/resources/img/vegan.jpg">
                            <label for="slide01" class="right"></label>
                        </a>
                    </li>
                </ul>
            </div>
        </div>

        <div id="main-bottom">
            <div><a><img src="/semi01/resources/01.png"></a></div>
            <div><a><img src="/semi01/resources/02.png"></a></div>
            <div><a><img src="/semi01/resources/03.png"></a></div>
            <div><a><img src="/semi01/resources/04.png"></a></div>

            <div>비건 토마토파스타 레시피가 궁금하다면?!</div>
            <div>맛있겠따///</div>
            <div>비건이 바꾸는 세상!</div>
            <div>졸려요,,,</div>

        </div>

        <div id="board-list">
            <div id="review">리뷰 페이지
                <div>[안국] 어디어디 리뷰</div>
                <div>[역삼] 어디어디 리뷰</div>
                <div>[서촌] 어디어디 리뷰</div>
            </div>
            <div id="community">커뮤니티 페이지
                <div>제 레시피 구경하고 가세용~~~~</div>
                <div>믿고 갔는데 실망이에요ㅡㅡ</div>
                <div>거북목이 되어 목이 아파요</div>

            </div>

        </div>
    </div>
</body>
</html>