<%@page import="com.kh.semiPrj.businessMember.BusinessMemberVo"%>
<%@page import="com.kh.semiPrj.member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
	BusinessMemberVo bsLoginMember = (BusinessMemberVo)session.getAttribute("bsloginMember");
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
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap')
	;
*{
   font-family: 'Noto Sans KR', sans-serif;
   letter-spacing: -0.1em;
}
 
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
    height: 15vh;
    margin:auto;
    z-index:100;
}
#header-header{
    width: 100%;
    height: 26%;
    display: grid;
    grid-template-columns: 10fr 1fr 0.5fr 1fr 1fr 1fr;
    background-color: rgb(217 217 217);
    font-size: 1.1rem;
}
#header-header > div{
    
    display: flex;
    justify-content: center;
    align-items: center;
    
}
#header-main{
    width: 100%;
    height: 74%;
    display: grid;
    grid-template-columns: 1.5fr 2fr 1fr 1fr 1fr 0.5fr
}
#header-main > div{
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 1.4rem
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

#search{
    border-top-left-radius: 30px;
    border-top-right-radius: 30px;
    border-bottom-left-radius: 30px;
    border-bottom-right-radius: 30px;
    /* border-color: gainsboro; */
    width: 350px;
    height: 50px;
    font-size: 21px;
    text-align: center;
    position: absolute;
}
#searchImg{
    float: left;
    position: relative;
    left: 145px;
    border: none;
    width: 33px;
    height: 33px;
   background: url(/semiPrj/resources/img/search.svg);
   background-size: cover;
   
}
input[name="pno"] {
	display: none;
}

</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/header2.jsp" %>
    <div id="header">
        <div id="header-header">
            <div id="header-0"></div>
            <div id="header-customer"><a href="/semiPrj/notice/list">공지사항</a></div>
            <div>|</div>
            <%if(loginMember == null && bsLoginMember == null){%>
            <div id="header-login"><a href="#" onclick='btnModal'>로그인</a></div>
            <div id="header-signup"><a href="#" onclick='btnModal'>회원가입</a></div>
            
            <%}else{%>
            		<div id="header-logout"><a href="/semiPrj/member/logout">로그아웃</a></div>
            		<div id="header-mypage"><a href="/semiPrj/mypage/mypage">마이페이지</a></div>	
            <%}%>
        </div>
        <div id="header-main">
            <div id="header-main-logo"><a href="/semiPrj"><img src="/semiPrj/resources/img/메인로고1.png" alt="로고" width="auto" height="100px"></a></div>
            <div id="header-main-search">
                <form action="/semiPrj/search" method="get">
                   <input id="search" type="text" placeholder="식당 이름을 검색해 주세요" name="resName">
                   <input id="hidden" name="pno" value="1">
                   <input type="submit" id="searchImg" value="">
                </form>
            </div>
            <div id="header-main-area"><a href="/semiPrj/map">지역별 찾기</a></div>
            <div id="header-main-community"><a href="/semiPrj/community/list?pno=1">커뮤니티</a></div>
             <div id="header-customer"><a href="/semiPrj/faq/center">고객센터</a></div>
        </div>

    </div>
    
    <%@ include file="/WEB-INF/views/member/businessJoin.jsp" %>
    <%@ include file="/WEB-INF/views/member/businessLogin.jsp" %>
    <%@ include file="/WEB-INF/views/member/join.jsp" %>
    <%@ include file="/WEB-INF/views/member/login.jsp" %>

    


    

</body>
</html>