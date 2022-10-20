<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
    padding: 0;
    margin: 0;
}
#header{
    background-color: #eefff6;
    width: 100vw;
    height: 160px;
    margin:auto;
}
#header> div{
    display: flex;
    justify-content: center;
    align-items: center;
}
#header> div > form{
    display: flex;
    justify-content: center;
    align-items: center;
}
#header> div>a{
    text-decoration: none;
    color: black;
}
#header-main-1{width: 150px; height: 100%; float: left; }
#header-main-2{width: 200px; height: 100%; float: left;  font-size: 1.4rem;}
#header-main-3{width: 500px; height: 100%; float: left;  font-size: 1.4rem; position: relative; left: 560px}
#header-main-4{width: 150px; height: 100%; float: left;  font-size: 1.4rem; position: relative; left: 560px}
#header-main-5{width: 150px; height: 100%; float: left;  font-size: 1.4rem; position: relative; left: 560px}
#search{
    border-top-left-radius: 30px;
    border-top-right-radius: 30px;
    border-bottom-left-radius: 30px;
    border-bottom-right-radius: 30px;
    width: 350px;
    height: 60px;
    font-size: 22px;
    text-align: center;
    position: absolute;
}
#searchImg{
    float: left;
    position: relative;
    left: 150px;
}


</style>
</head>
<body>

    <div id="header">
        <div id="header-main-1"><a href=""><img src="/semiPrj/resources/img/메뉴바.png" alt="메뉴바" width="50px" height="auto"></a></div>
        <div id="header-main-2"><a href=""><img src="/semiPrj/resources/img/메인로고2.png" alt="로고" width="220px" height="auto"></a></div>
        <div id="header-main-3">
            <form action="">
                <input id="search" type="text" placeholder="식당 이름을 검색해주세요 ">
                <a href=""><img id="searchImg" src="/semiPrj/resources/img/돋보기2.png" alt="돋보기" width="35px" height="auto"></a>
            </form>
        </div>
        <div id="header-main-4"><a href="">마이페이지</a></div>
        <div id="header-main-5"><a href="">로그아웃</a></div>
    </div>

</body>
</html>