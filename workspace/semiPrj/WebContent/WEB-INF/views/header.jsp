<%@page import="member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVo loginMember = (MemberVo)session.getAttribute("loginMember"); 
	String alertMsg = (String)session.getAttribute("alertMsg");
	session.removeAttribute("alertMsg");
%>   

<script>
	<%if(alertMsg != null){%>
			alert('<%= alertMsg %>');
	<%}%>
	
</script> 
    
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
#header-header>div>a{
    text-decoration: none;
    color: black;
}
#header{
    width: 100vw;
    height: 216px;
    margin:auto;
}
#header-header{
    width: 100%;
    height: 26%;
    background-color: rgb(217 217 217);
    font-family: Inter;
    font-weight: Regular;
}
#header-header > div{
    
    display: flex;
    justify-content: center;
    align-items: center;
    
}
#header-main{
    width: 100%;
    height: 74%;
}
#header-main > div{
    display: flex;
    justify-content: center;
    align-items: center;
}
#header-main > div > form{
    display: flex;
    justify-content: center;
    align-items: center;
}
#header-main>div>a{
    text-decoration: none;
    color: black;
}
#header-0{width: 74%; height: 100%; float: left;  font-size: 1.2rem;}
#header-customer{width: 6%; height: 100%; float: left;  font-size: 1.2rem;}
#header-2{width: 3%; height: 100%; float: left; font-size: 1.4rem;}
#header-login{width: 5%; height: 100%; float: left;  font-size: 1.2rem;}
#header-signup{width: 7%; height: 100%; float: left;  font-size: 1.2rem;}
#header-5{width: 6%; height: 100%; float: left;  font-size: 1.2rem;}

#header-logout{width: 5%; height: 100%; float: left;  font-size: 1.2rem;}
#header-mypage{width: 7%; height: 100%; float: left;  font-size: 1.2rem;}

#header-main-logo{width: 200px; height: 100%; float: left; }
#header-main-search{width: 700px; height: 100%; float: left;  font-size: 1.4rem;}
#header-main-area{width: 200px; height: 100%; float: left;  font-size: 1.4rem;}
#header-main-review{width: 200px; height: 100%; float: left;  font-size: 1.4rem;}
#header-main-reservation{width: 200px; height: 100%; float: left;  font-size: 1.4rem;}
#header-main-community{width: 200px; height: 100%; float: left;  font-size: 1.4rem;}

#search{
    border-top-left-radius: 30px;
    border-top-right-radius: 30px;
    border-bottom-left-radius: 30px;
    border-bottom-right-radius: 30px;
    /* border-color: gainsboro; */
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
#header-main-2{
    position: relative;
}
input[name="pno"] {
	display: none;
}

</style>
</head>
<body>
    <div id="header">
        <div id="header-header">
            <div id="header-0"></div>
            <div id="header-customer"><a href="">고객센터</a></div>
            <div id="header-2">&nbsp&nbsp&nbsp|</div>
            <%if(loginMember == null){%>
            <div id="header-login"><a href="#" onclick='btnModal'>로그인</a></div>
            <div id="header-signup"><a href="#" onclick='btnModal'>회원가입</a></div>
            <div id="header-5"></div>
            
            <%}else{%>
            		<div id="header-logout"><a href="/semiPrj/member/logout">로그아웃</a></div>
            		<div id="header-mypage"><a href="">마이페이지</a></div>	
            		<div id="header-5"></div>
            <%}%>
        </div>
        <div id="header-main">
            <div id="header-main-logo"><a href="/semiPrj"><img src="/semiPrj/resources/img/메인로고.png" alt="로고" width="230px" height="auto"></a></div>
            <div id="header-main-search">
                <form action="/semiPrj/search" method="get">
                    <input id="search" type="text" placeholder="식당 이름을 검색해 주세요." name="resName">
                	<input type="text" name="pno" value="1">
                    <input type="submit" id="searchImg" src="/semiPrj/resources/img/돋보기2.png" alt="돋보기" width="35px" height="auto" value="검색하기">
                    <!-- 검색하기에 이미지 씌워 주세요 -->
                </form>
            </div>
            <div id="header-main-area"><a href="">지역별 찾기</a></div>
            <div id="header-main-review"><a href="">리뷰</a></div>
            <div id="header-main-reservation"><a href="">예약</a></div>
            <div id="header-main-community"><a href="">커뮤니티</a></div>
        </div>

    </div>
    
    <%@ include file="/WEB-INF/views/member/login.jsp" %>
    <%@ include file="/WEB-INF/views/member/join.jsp" %>
    
    

    


    

</body>
</html>