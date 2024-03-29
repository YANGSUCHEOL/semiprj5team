<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    #modal.modal-overlay {
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
            border: 1px solid rgba(255, 255, 255, 0.18);
            z-index:100;
          
}
#modal .modal-window {
    background: white;
    box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
    backdrop-filter: blur( 13.5px );
    -webkit-backdrop-filter: blur( 13.5px );
    border-radius: 10px;
    border: 1px solid rgba( 255, 255, 255, 0.18 );
    width: 497px;
    height: 603px;
    position: relative;
    /* top: -100px;
    padding: 10px; */
}
#title{
    width: 100%;
    height: 25%;
    display: flex;
    justify-content: center;
    align-items: center;
}
#modal .close-area {
    display: inline;
    float: right;
    padding-top: 10px;
    padding-right: 30px;
    cursor: pointer;
    text-shadow: 1px 1px 2px gray;
    color: black;
    font-size: 20px;
}

#modal .content {
    margin-top: 20px;
    padding: 0px 10px;
    /* text-shadow: 1px 1px 2px gray; */
    color: black;
}
#id {
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

#pwd{
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
#login{
border: none;
width: 420px;
height: 63px;
background-color: rgb(238,255,246);
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
}
#forget{
width: 274px;
color: rgba(60,179,113,1);
position: absolute;
top: 460px;
left: 123px;
font-family: Inter;
font-weight: Regular;
font-size: 20px;
opacity: 1;
text-align: left;
}
#signUp{
width: 274px;
position: absolute;
top: 500px;
left: 120px;
font-family: Inter;
font-weight: Regular;
font-size: 20px;
opacity: 1;
text-align: left;
}
#signUp>a{
    color: rgba(60,179,113,1);
    text-decoration: none;
}
#businessLogin{
width: 300px;
position: absolute;
top: 540px;
left: 110px;
font-family: Inter;
font-weight: Regular;
font-size: 20px;
opacity: 1;
text-align: left;
}
#businessLogin>a{
    color: rgba(60,179,113,1);
    text-decoration: none;
}

</style>
</head>
<body>

    <div id="modal" class="modal-overlay">
        <div class="modal-window">
            <div class="close-area">X</div>
            <div id="title">
                <img id="login-logo" src="/semiPrj/resources/img/로그인회원가입로고.png" alt="로고" width="260px" height="160px">
            </div>
            <div class="content">
                <form action="/semiPrj/member/login" method="post">
                    <table>
                        <tr>
                            <td><input id="id" type="text" name="memberId" placeholder="아이디"></td>
                        </tr>
                        <tr>
                            <td><input id="pwd" type="password" name="memberPwd" placeholder="비밀번호"></td>
                        </tr>
                        <tr>
                            <td><input id="login" type="submit" value="로그인"></td>
                            <td><a id="forgeta" href="#" onclick='forgetbt'><span id="forget" >비밀번호를 잊어버리셨나요?</span></a></td>
                            <td><span  id="signUp">계정이 없으신가요? <a id="login-join" href="#" onclick='loginjoin'>회원가입</a></span></td>
                            <td><span  id="businessLogin">사업자 이신가요? <a id="login-login" href="#" onclick='login'>사업자 로그인</a></span></td>
                        	<input type="hidden" id="uri" name="requestURI" value="">
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
    <script>         
        const modal = document.getElementById("modal")
        const btnModal = document.getElementById("header-login")
        const requestURI = window.location.pathname + window.location.search;
        sessionStorage.setItem("requestURI", requestURI);
        
        // 헤더1 로그인
        btnModal.addEventListener("click", e => {
        	document.getElementById('uri').value = sessionStorage.getItem("requestURI");
            modal.style.display = "flex"
        })

        // 헤더2 로그인
        const btnModal_1 = document.getElementById("header-login_1")
        btnModal_1.addEventListener("click", e => {
        	document.getElementById('uri').value = sessionStorage.getItem("requestURI");
            modal.style.display = "flex"
        })
       
        // 닫는 버튼
        const closeBtn = modal.querySelector(".close-area")
        closeBtn.addEventListener("click", e => {
        	sessionStorage.removeItem("requestURI");
        	modal.style.display = "none"
        })
        
        //로그인 ->비지니스 로그인
        const bslogin = document.getElementById("bs-modal")
        const login = document.getElementById("login-login")
        login.addEventListener("click", e => {
                modal.style.display = "none"
                bslogin.style.display = "flex"
        })
        
         //로그인 -> 회원가입
        const modal22 = document.getElementById("join-modal")
        const loginjoin = document.getElementById("login-join")
        loginjoin.addEventListener("click", e => {
        modal.style.display = "none"
        modal22.style.display = "flex"
        })

        // 회원가입 -> 로그인
            // const modal33 = document.getElementById("join-modal")
            const joinlogin33 = document.getElementById("join-loigin-button")
            joinlogin33.addEventListener("click", e => {
            modal22.style.display = "none"
            modal.style.display = "flex"
        })
        //로그인 -> 비밀번호찾기
        const forgetmodal = document.getElementById("forget-modal")
        const forgetbt = document.getElementById("forgeta")
        forgetbt.addEventListener("click", e => {
        modal.style.display = "none"
        forgetmodal.style.display = "flex"
        })
     </script>



</body>
</html>