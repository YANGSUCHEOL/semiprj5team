<%@page import="java.lang.reflect.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    #change-modal.modal-overlay {
            width: 100%;
            height: 100%;
            position: absolute;
            left: 0;
            top: 0;
            display: none;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            background: rgba(255, 255, 255, 0.25);
            box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
            backdrop-filter: blur(1.5px);
            -webkit-backdrop-filter: blur(1.5px);
            border-radius: 10px;
    }
    #change-modal .modal-window {
        background: white;
        box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
        backdrop-filter: blur( 13.5px );
        -webkit-backdrop-filter: blur( 13.5px );
        border-radius: 10px;
        border: 1px solid rgba( 255, 255, 255, 0.18 );
        width: 497px;
        height: 603px;
        position: relative;
        max-height: calc(80vh - 200px);
    overflow-y: auto;

    }
    #change-title{
        width: 100%;
        height: 25%;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    #change-modal .change-close-area {
        display: inline;
        float: right;
        padding-top: 10px;
        padding-right: 30px;
        cursor: pointer;
        text-shadow: 1px 1px 2px gray;
        color: black;
        font-size: 20px;
    }

    #change-modal .join-content {
        margin-top: 20px;
        padding: 0px 10px;
        /* text-shadow: 1px 1px 2px gray; */
        color: black;
    }
    #change-id {
    border: none;
    width: 420px;
    height: 63px;
    background: rgba(236,236,236,0.6299999952316284);
    opacity: 1;
    position: absolute;
    top: 190px;
    left: 33px;
    border-top-left-radius: 30px;
    border-top-right-radius: 30px;
    border-bottom-left-radius: 30px;
    border-bottom-right-radius: 30px;
    overflow: hidden;
    font-size: 20px;
    text-indent: 20px;
    }

    #change-pwd{
    border: none;
    width: 420px;
    height: 63px;
    background: rgba(236,236,236,0.6299999952316284);
    opacity: 1;
    position: absolute;
    top: 280px;
    left: 33px;
    border-top-left-radius: 30px;
    border-top-right-radius: 30px;
    border-bottom-left-radius: 30px;
    border-bottom-right-radius: 30px;
    overflow: hidden;
    font-size: 20px;
    text-indent: 20px;
    }
    #change-pwd2{
    border: none;
    width: 420px;
    height: 63px;
    background: rgba(236,236,236,0.6299999952316284);
    opacity: 1;
    position: absolute;
    top: 370px;
    left: 33px;
    border-top-left-radius: 30px;
    border-top-right-radius: 30px;
    border-bottom-left-radius: 30px;
    border-bottom-right-radius: 30px;
    overflow: hidden;
    font-size: 20px;
    text-indent: 20px;
    }
    #change-nick{
    border: none;
    width: 420px;
    height: 63px;
    background: rgba(236,236,236,0.6299999952316284);
    opacity: 1;
    position: absolute;
    top: 460px;
    left: 33px;
    border-top-left-radius: 30px;
    border-top-right-radius: 30px;
    border-bottom-left-radius: 30px;
    border-bottom-right-radius: 30px;
    overflow: hidden;
    font-size: 20px;
    text-indent: 20px;
    }
    #change-name{
    border: none;
    width: 420px;
    height: 63px;
    background: rgba(236,236,236,0.6299999952316284);
    opacity: 1;
    position: absolute;
    top: 550px;
    left: 33px;
    border-top-left-radius: 30px;
    border-top-right-radius: 30px;
    border-bottom-left-radius: 30px;
    border-bottom-right-radius: 30px;
    overflow: hidden;
    font-size: 20px;
    text-indent: 20px;
    }
    #change-phoneNum{
    border: none;
    width: 420px;
    height: 63px;
    background: rgba(236,236,236,0.6299999952316284);
    opacity: 1;
    position: absolute;
    top: 640px;
    left: 33px;
    border-top-left-radius: 30px;
    border-top-right-radius: 30px;
    border-bottom-left-radius: 30px;
    border-bottom-right-radius: 30px;
    overflow: hidden;
    font-size: 20px;
    text-indent: 20px;
    }
    #change-birth{
    border: none;
    width: 420px;
    height: 63px;
    background: rgba(236,236,236,0.6299999952316284);
    opacity: 1;
    position: absolute;
    top: 730px;
    left: 33px;
    border-top-left-radius: 30px;
    border-top-right-radius: 30px;
    border-bottom-left-radius: 30px;
    border-bottom-right-radius: 30px;
    overflow: hidden;
    font-size: 20px;
    text-indent: 20px;
    }
    #change-login{
    border: none;
    width: 420px;
    height: 63px;
    background-color: rgb(238,255,246);
    opacity: 1;
    position: absolute;
    top: 820px;
    left: 33px;
    border-top-left-radius: 30px;
    border-top-right-radius: 30px;
    border-bottom-left-radius: 30px;
    border-bottom-right-radius: 30px;
    overflow: hidden;
    font-size: 20px;
    }
    #change-join-login{
    width: 274px;
    position: absolute;
    top: 900px;
    left: 130px;
    font-family: Inter;
    font-weight: Regular;
    font-size: 20px;
    opacity: 1;
    text-align: left;
    }
    #change-join-login>a{
        color: rgba(60,179,113,1);
        text-decoration: none;
    }
    #change-business-join{
    width: 380px;
    position: absolute;
    top: 950px;
    left: 210px;
    font-family: Inter;
    font-weight: Regular;
    font-size: 20px;
    opacity: 1;
    text-align: left;
    }
    #change-business-join>a{
        color: red;
        text-decoration: none;
    }
  
    /*------------ <!-- 위쪽은 정보수정 모달 -->--------------- */


#main {
	width: 70vw;
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
    background-color : #EEFFF6;
    
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
#qna{
	background-color: yellow
}
#qna2{
	background-color: yellow
}
 
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/header.jsp" %>
	
	
    <div id="change-modal" class="modal-overlay">
        <div class="modal-window">
            <div class="change-close-area">X</div>
            <div id="change-title">
                <img id="change-login-logo" src="/semiPrj/resources/img/로그인회원가입로고.png" alt="로고" width="260px" height="160px">
            </div>
            <div class="change-content">
                <form action="/semiPrj/member/change" method="post">
                    <table>
                        <tr>
                            <td><input id="change-id" type="text" name="updatenmemberId" value="<%=loginMember.getId() %>"></td>
                            <td><input id="change-pwd" type="password" name="updatememberPwd" placeholder="비밀번호"></td>
                            <td><input id="change-pwd2" type="password" name="updatememberPwd2" placeholder="비밀번호확인"></td>
                            <td><input id="change-nick" type="text" name="updatememberNick" value="<%=loginMember.getNick() %>"></td>
                            <td><input id="change-name" type="text" name="updatememberName" value="<%=loginMember.getName() %>"></td>
                            <td><input id="change-phoneNum" type="text" name="updatephoneNum" value="<%=loginMember.getPhone() %>"></td>
                            <td><input id="change-birth" type="text" name="updatebirth" value="<%=loginMember.getBirth() %>"></td>
                        </tr>
                        <tr>
                            <td><input id="change-login" type="submit" value="정보수정"></td>   
                            <td><span  id="change-business-join"><a href="/semiPrj/member/quit">회원 탈퇴</a></span></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>

	<!-- 위쪽은 정보수정 모달 -->
	

    <div id="main">
        <div id="content">
            <div id="content-header">
           			<%if(loginMember.getId().equals("admin")){%>
	                	관리자 전용 마이페이지
	                <%}else{%>
	               	마이페이지
	                <%}%>
            </div>
            <div id="content-myinfo">
                <div class="title">이름</div>
                <div class="title">
	                <%if(loginMember.getId().equals("admin")){%>
	                	관리자 전용
	                <%}else{%>
	                등급
	                <%}%>
				</div>
                <div class="title">
	                <%if(loginMember.getId().equals("admin")){%>
	                	관리자 전용
	                <%}else{%>
	                쿠폰
	                <%}%>
                </div>
                <div class="myinfo"><%= loginMember.getNick() %></div>
                <div class="myinfo">
                 <%if(loginMember.getId().equals("admin")){%>
	                	<a id="qna" href="/semiPrj/qna/adminList?pno=1">개인회원 문의 확인</a>
	                <%}else{%>
	                 	<%= loginMember.getGradeNo() %>등급
	                <%}%>
                </div>
                <div class="myinfo">
					<%if(loginMember.getId().equals("admin")){%>
	                	<a id="qna2" href="/semiPrj/bqna/adminList?pno=1">사업자회원 문의 확인</a>
	                <%}else{%>
	                 	2장
	                <%}%>                
                </div>
            </div>
            <div id="content-detail">
                <div><a href="/semiPrj/coupon/list?mno= <%= loginMember.getNo()%>"><img src="/semiPrj/resources/img/쿠폰.png" alt="찜한내역" width="150px" height="auto"></a></div>
                <div><a href="/semiPrj/res/list?pno=1"><img src="/semiPrj/resources/img/예약내역.png" alt="예약내역" width="150px" height="auto"></a></div>
                <div><a href="/semiPrj/review/user?pno=1"><img src="/semiPrj/resources/img/내리뷰.png" alt="내리뷰" width="150px" height="auto"></a></div>
                <div><a href="/semiPrj/qna/list"><img src="/semiPrj/resources/img/문의내역.png" alt="문의내역" width="150px" height="auto"></a></div>
                <div id="changePwd"><a href="#" onclick='changeBtn'><img src="/semiPrj/resources/img/정보수정.png" alt="정보수정" width="150px" height="auto"></a></div>
                <div><a href="/semiPrj/coupon/list?mno= <%= loginMember.getNo()%>">쿠폰</a></div>
                <div><a href="/semiPrj/res/list?pno=1">예약 내역</a></div>
                <div><a href="/semiPrj/review/user?pno=1">내 리뷰&nbsp&nbsp&nbsp&nbsp</a></div>
                <div><a href="/semiPrj/qna/list">문의 내역&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a></div>
                <div id="changePwd2"><a href="#" onclick='changeBtn2'>정보수정</a></div>
            </div>
        </div>
    </div>
    
      <script>         
        const changmodal = document.getElementById("change-modal")
        const changeBtn = document.getElementById("changePwd")
        changeBtn.addEventListener("click", e => {
            changmodal.style.display = "flex"
        })
        const changeBtn2 = document.getElementById("changePwd2")
        changeBtn2.addEventListener("click", e => {
            changmodal.style.display = "flex"
        })
        const closeBtn04 = changmodal.querySelector(".change-close-area")
        closeBtn04.addEventListener("click", e => {
            changmodal.style.display = "none"
        })
       
   </script>
   

</body>
</html>