<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#main {
	width: 65vw;
	display: grid;
	margin: 0 auto;
	grid-template-rows: 70vh;
	align-content: center;
    
}

#content {
	box-sizing: border-box;
	display: grid;
	justify-content: center;
	align-items: center;
	grid-template-rows: 1fr 4fr 5fr;
    grid-template-columns: 1fr;
	background: #FFFFFF;
	border: 1px solid #DEDEDE;
	border-radius: 10px;
	padding: 3%;
    /* padding: 20px; */
}
#content-header{
   
    font-size: 30px;
    color: #333333;
    font-weight: 400;
    text-align: center;
    line-height: 50px;
    border-radius: 10px;
    background: #FCFFED;
    
}
#content-myinfo{
    display: grid;
	justify-content: center;
	align-items: center;
    grid-template-rows: repeat(2, minmax(100px, auto));
    grid-template-columns: 1fr 1fr 1fr;
	background: #FFFFFF;
	border: 1px solid black;
}
#content-myinfo > .title{
    display: flex;
    justify-content: center;
	align-items: center;
    font-size: 1.5rem;
}
#content-myinfo > .myinfo{
    
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 1.5rem;
    color: #8B00FF;
    padding-bottom: 50px;
}

#content-detail{
    display: grid;
    justify-content: center;
	align-items: center;
    grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
    grid-template-rows:4fr 1fr
}
#content-detail > div{
    display: flex;
    justify-content: center;
	align-items: center;
}
#content-detail > div > a{
    text-decoration: none;
    color: black;
    font-size: 1.5rem;
}      
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/header.jsp" %>

    <div id="main">
        <div id="content">
            <div id="content-header">마이페이지</div>
            <div id="content-myinfo">
                <div class="title">이름</div>
                <div class="title">등급</div>
                <div class="title">쿠폰</div>
                <div class="myinfo">김비건</div>
                <div class="myinfo">일반회원</div>
                <div class="myinfo">2장</div>
            </div>
            <div id="content-detail">
                <div><a href=""><img src="/semiPrj/resources/img/찜한내역.png" alt="찜한내역" width="150px" height="auto"></a></div>
                <div><a href=""><img src="/semiPrj/resources/img/예약내역.png" alt="예약내역" width="150px" height="auto"></a></div>
                <div><a href=""><img src="/semiPrj/resources/img/내리뷰.png" alt="내리뷰" width="150px" height="auto"></a></div>
                <div><a href="/semiPrj/qna/list"><img src="/semiPrj/resources/img/문의내역.png" alt="문의내역" width="150px" height="auto"></a></div>
                <div><a href=""><img src="/semiPrj/resources/img/정보수정.png" alt="정보수정" width="150px" height="auto"></a></div>
                <div><a href="">찜한 내역</a></div>
                <div><a href="">예약 내역</a></div>
                <div><a href="">내 리뷰&nbsp&nbsp&nbsp&nbsp</a></div>
                <div><a href="/semiPrj/qna/list">문의 내역&nbsp&nbsp&nbsp&nbsp</a></div>
                <div><a href="">정보수정</a></div>
            </div>
        </div>
    </div>

</body>
</html>