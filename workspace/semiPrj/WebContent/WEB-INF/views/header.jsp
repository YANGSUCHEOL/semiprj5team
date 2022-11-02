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
	window.onload = function() {
		Swal.fire({
			title: '<%= alertMsg %>',
			showConfirmButton: true,
			icon: 'success',
			confirmButtonColor: '#82A994',
		})
	}
	<%}%>
</script> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.6.3/dist/sweetalert2.all.min.js"></script>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap')
	;
*{
   font-family: 'Noto Sans KR', sans-serif;
   letter-spacing: -0.1em;
}
.swal-button {
	color: black;
	border: 1px solid lightgray;
}
 
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
    grid-template-columns: 0.5fr 0.5fr 1.5fr 1fr 3fr 1fr 1fr 1.2fr;
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
    left: 45px;
    border: none;
    width: 33px;
    height: 33px;
   background: url(/semiPrj/resources/img/search.svg);
   background-size: cover;
   
}

/* 위쪽이 해더2 --------------------------------------------------------------------*/


#header-header>div>a{
    text-decoration: none;
    color: black;
}
#header{
    width: 100vw;
    height: 22vh;
    margin: auto;
    z-index: 100;
}
#header-header{
    width: 100%;
    height: 19.5%;
    display: grid;
    grid-template-columns: 8fr 2fr 1fr 0.5fr 1fr 1fr 2.35fr;
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
    height: 70%;
    display: grid;
    grid-template-columns: 0.8fr 1.5fr 2fr 1fr 1fr 1fr 1fr
}
#header-bot{
    width: 100%;
    height: 11.5%;
}
#header-id{
    display: flex;
    justify-content: center;
    align-items: center;
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
    left: 45px;
    border: none;
    width: 33px;
    height: 33px;
   background: url(/semiPrj/resources/img/search.svg);
   background-size: cover;
   
}

</style>
</head>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<body>

	<div id="main-header2">
		<div id="header2">
            <div></div>
	        <div id="header-main-1"><a href=""><img src="/semiPrj/resources/img/메뉴바.2png" alt="" width="50px" height="auto"></a></div>
	        <div id="header-main-2"><a href=""><img src="/semiPrj/resources/img/메인로고2.png" alt="로고" width="190px" height="auto"></a></div>
	        <div></div>
	        <div id="header-main-3">
	            <form action="/semiPrj/search" method="get">
	                <input id="search2" type="text" placeholder="식당 이름을 검색해 주세요" name="resName" required>
	                <input id="hidden" name="pno" value="1">
	              <input type="submit" id="searchImg2" value="">
	            </form>
	        </div>
	        <%if(loginMember == null && bsLoginMember == null){%>
            <div id="header-login_1"><a href="#" onclick='btnModal'>로그인</a></div>
            <div id="header-signup_1"><a href="#" onclick='btnModal'>회원가입</a></div>
            
            <%}else{%>
            		<div id="header-logout"><a href="/semiPrj/member/logout">로그아웃</a></div>
            		<div id="header-mypage"><a href="/semiPrj/mypage/mypage">마이페이지</a></div>	
            <%}%>
	        
	        <div></div>
    	</div>
	</div>

    <!-- 위쪽이 해더2 (스크롤내리면 나오는 해더) -->

    <div id="header">
        <div id="header-header">
            <div id="header-0"></div>
            
            <%if(loginMember == null && bsLoginMember == null){%>
           	<div></div>
            
            <%}else{%>
            		<%if(loginMember == null){%>
            			<div><%= bsLoginMember.getNick()%> 님 환영합니다~</div>
            		<%}else{%>
            			<div><%= loginMember.getNick() %>님 환영합니다~</div>
            		<%}%>
            <%}%>
           
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
            <div></div>
            <div id="header-main-logo"><a href="/semiPrj"><img src="/semiPrj/resources/img/메인로고1.png" alt="로고" width="auto" height="95px"></a></div>
            <div id="header-main-search">
                <form action="/semiPrj/search" method="get">
                   <input id="search" type="text" placeholder="식당 이름을 검색해 주세요" name="resName" required>
                   <input id="hidden" name="pno" value="1">
                   <input type="submit" id="searchImg" value="">
                </form>
            </div>
            <div id="header-main-area"><a href="/semiPrj/map">지역별 찾기</a></div>
            <div id="header-main-community"><a href="/semiPrj/community/list?pno=1">커뮤니티</a></div>
             <div id="header-customer"><a href="/semiPrj/faq/center">고객센터</a></div>
        </div>
        <div id="header-bot"></div>
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
    
    <%@ include file="/WEB-INF/views/member/businessJoin.jsp" %>
    <%@ include file="/WEB-INF/views/member/businessLogin.jsp" %>
    <%@ include file="/WEB-INF/views/member/join.jsp" %>
    <%@ include file="/WEB-INF/views/member/forgetPwd.jsp" %>
    <%@ include file="/WEB-INF/views/member/login.jsp" %>
    <%@ include file="/WEB-INF/views/chat/chat.jsp" %>

	<script>
		$(document).ready(function() {
			$('#searchImg').click(function() {
				if($('#search').val().trim() == '') {
					Swal.fire({
						title: '필수 입력 사항입니다.',
						showConfirmButton: true,
						icon: 'info',
						confirmButtonColor: '#82A994',
					})
					return false;
				}
			})
		})
	</script>    

</body>
</html>