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
#main-header2{
	display : none;
 	position: fixed;
 	z-index: 101;
}
#header2{
    background-color: #eefff6;
    width: 100vw;
    height: 14vh;
    margin:auto;
    display: grid;
    grid-template-columns: 0.5fr 1.5fr 1fr 3fr 1fr 1fr 1fr;
}
#header2> div{
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 1.4rem;
}
#header2> div > form{
    display: flex;
    justify-content: center;
    align-items: center;
}
#header2> div>a{
    text-decoration: none;
    color: black;
}
#search2{
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
#searchImg2{
    float: left;
    position: relative;
    left: 140px;
    border: none;
    width: 33px;
    height: 33px;
   background: url(/semiPrj/resources/img/search.svg);
   background-size: cover;
   
}


</style>
</head>
<body>
	<div id="main-header2">
		<div id="header2">
	        <div id="header-main-1"><a href=""><img src="/semiPrj/resources/img/메뉴바.png" alt="메뉴바" width="50px" height="auto"></a></div>
	        <div id="header-main-2"><a href=""><img src="/semiPrj/resources/img/메인로고2.png" alt="로고" width="190px" height="auto"></a></div>
	        <div></div>
	        <div id="header-main-3">
	            <form action="">
	                <input id="search2" type="text" placeholder="식당 이름을 검색해 주세요" name="resName">
	                <input id="hidden" name="pno" value="1">
	              <input type="submit" id="searchImg2" value="">
	            </form>
	        </div>
	        
	        <div id="header-main-4"><a href="/semiPrj/mypage/mypage">마이페이지</a></div>
	        <div id="header-main-5"><a href="/semiPrj/member/logout">로그아웃</a></div>
	        <div></div>
    	</div>
	</div>
	
	<script>
      window.addEventListener('scroll', () => { 

            const header2 = document.getElementById("main-header2")

            if(window.scrollY > 180){
                header2.style.display = "flex"
              }else{
            	  header2.style.display = "none"
              }
			});

    </script>
    

</body>
</html>