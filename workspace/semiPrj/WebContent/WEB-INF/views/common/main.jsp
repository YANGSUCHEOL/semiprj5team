<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>겟 잇 비건 GET EAT VEGAN</title>
<script src="https://kit.fontawesome.com/d599d9ce45.js" crossorigin="anonymous"></script>

<style>
	#section{
	z-index:1;
	}

    #wrap{
        width: 70vw;
        height: 1500px;
        border: 1px solid #DEDEDE;
        border-radius: 20px;
       --display:flex;
        margin:auto;
        --margin-top: 80px;
    }
    #top-main{
        width: 70vw;
        height: 60px;
        display: grid;
        grid-template-columns: 2fr 1fr 1fr 1fr 1fr 1fr;
        background: #EEFFF6;
        margin: 0 auto;
        --margin-bottom: 50px;
        text-align: center;
        font-size: 20px;
        place-content: center;
        border-radius: 20px;
     
    }

	.slidewrap{
		position: relative;
		
	}
    
	/* 브라우저 마진과 패딩 리셋 */
	* {margin:0;padding:0;}

	/* INPUT 가리기 */
	.section input[id*="slide"] {display:none;}

	/* 슬라이드 영역 - max-width 크기를 조절해주면 됩니다*/
	.section .slidewrap {max-width:1400px;margin:0 auto;overflow:hidden;}
	.section .slidelist {white-space:nowrap;font-size:0;}
	.section .slidelist > li {display:inline-block;vertical-align:middle;width:100%;transition:all .5s;}
	.section .slidelist > li > a {display:block;position:relative;}
	.section .slidelist > li > a img {width:100%;}

	/* 좌우로 넘기는 LABEL버튼에 대한 스타일 */
	.section .slidelist label {position:absolute;z-index:1;top:50%;transform:translateY(-50%);padding:50px;cursor:pointer;}
	.section .slidelist .left {left:30px;background:url('/semiPrj/resources/img/left.png') center center / 100% no-repeat;}
	.section .slidelist .right {right:30px;background:url('/semiPrj/resources/img/right.png') center center / 100% no-repeat;}

	/* INPUT 체크되면 변화값이 li까지 전달되는 스타일 */
	.section input[id="slide01"]:checked ~ .slidewrap .slidelist > li {transform:translateX(0%);}
	.section input[id="slide02"]:checked ~ .slidewrap .slidelist > li {transform:translateX(-100%);}
	.section input[id="slide03"]:checked ~ .slidewrap .slidelist > li {transform:translateX(-200%);}
	
    #main-bottom{
        
        display: grid;
        grid-template-columns: 1fr 1fr 1fr 1fr;
        margin: auto;
        margin-top:50px;
        text-align: center;
        padding: 25px;
    }

    #main-bottom > div{
        --border: 1px solid black;
        font-size: 20px;
    }

    #board-list{
        display: grid;
        grid-template-columns: 1fr 1fr;
        margin-top:100px;
    }
    
    #review, #community{
    	font-size: 20px;
    }
    #review>div, #community>div{
    	margin: 10px;
    	margin-left:40px;
    	margin-right:40px;
    }
    
    #review-title, #community-title{
    	font-size: 25px;
    	border-bottom:1px solid #DEDEDE;
    }
    
    a {
  		text-decoration: none;
	}
    </style>

</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp" %>
	
    <div id="wrap">
        <div id="top-main">
            <div>지금 뜨는 식당</div>
            <div><a href="/semiPrj/search/detail?rno=476">#남미플랜트랩</a></div>
            <div><a href="/semiPrj/search/detail?rno=146">#공간녹음</a></div>
            <div><a href="/semiPrj/search/detail?rno=665">#플랜트</a></div>
            <div><a href="/semiPrj/search/detail?rno=631">#닥터로빈(여의도부국)</a></div>
            <div><a href="/semiPrj/search/detail?rno=413">#슬로우캘리</a></div>
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
                            <img src="/semiPrj/resources/img/01.png">
                            <label for="slide02" class="right"></label>
                        </a>
                    </li>
                    <li>
                        <a>
                            <label for="slide01" class="left"></label>
                            <img src="/semiPrj/resources/img/02-2.png">
                            <label for="slide03" class="right"></label>
                        </a>
                    </li>
                    <li>
                        <a>
                            <label for="slide02" class="left"></label>
                            <img src="/semiPrj/resources/img/03-2.png">
                            <label for="slide01" class="right"></label>
                        </a>
                    </li>
                </ul>
            </div>
        </div>

        <div id="main-bottom">
            <div><a href="https://youtu.be/cX20G41-694"><img src="/semiPrj/resources/img/main02.png"></a></div>
            <div><a href="https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=vegan-us&logNo=221441295753"><img src="/semiPrj/resources/img/main01.png"></a></div>
            <div><a href="https://efgvillage.com/original/?q=YToyOntzOjEyOiJrZXl3b3JkX3R5cGUiO3M6MzoiYWxsIjtzOjQ6InBhZ2UiO2k6Mzt9&bmode=view&idx=6636937&t=board"><img src="/semiPrj/resources/img/main03.png"></a></div>
            <div><a href="/semiPrj/search/detail?rno=665"><img src="/semiPrj/resources/img/main04.png"></a></div>

            <div><a href="https://youtu.be/cX20G41-694">비건 토마토 파스타 레시피가 궁금하다면?</a></div>
            <div><a href="https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=vegan-us&logNo=221441295753">맛있겠따///</a></div>
            <div><a href="https://efgvillage.com/original/?q=YToyOntzOjEyOiJrZXl3b3JkX3R5cGUiO3M6MzoiYWxsIjtzOjQ6InBhZ2UiO2k6Mzt9&bmode=view&idx=6636937&t=board">어느 비건지향인의 텀블러챌린지 3년 기록</a></div>
            <div><a href="/semiPrj/search/detail?rno=665">새로 생긴 비건식당 다녀왔어요!</a></div>

        </div>

        <div id="board-list">
            <div id="review">
            	<div id="review-title"><i class="fa-regular fa-pen-to-square"></i> 이 달의 리뷰</div>
                <div><a href="/semiPrj/review/list?pno=1&rno=476">[서초구] 남미플랜트랩 리뷰</a></div>
                <div><a href="/semiPrj/review/list?pno=1&rno=476">[용산구] 플랜트 리뷰</a></div>
                <div><a href="/semiPrj/review/list?pno=1&rno=232">[광진구] 지속 리뷰</a></div>
                <div><a href="/semiPrj/review/list?pno=1&rno=605">[송파구] 스윗솔키친 리뷰</a></div>
                </div>
            
            <div id="community">
            	<div id="community-title"><i class="fa-regular fa-comment"></i> 커뮤니티 추천글</div>
                <div><a href="/semiPrj/community/detail?bno=145">두부 김치 조림 만들기 채식 사찰 요리 레시피입니당~~~</a></div>
                <div><a href="/semiPrj/community/detail?bno=140">믿고 갔는데 실망이에요ㅡㅡ</a></div>
                <div><a href="/semiPrj/community/detail?bno=141">동물 실험 없는 화장품 추천합니다~~~</a></div>
                <div><a href="/semiPrj/community/detail?bno=139">안녕하세요 제가 요즘 채식에 대해 고민이 많습니다 ㅠㅠ 들어주실분</a></div>
                </div>

            

        </div>
        
        
    </div>
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>