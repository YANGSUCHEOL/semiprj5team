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
}
#modal .modal-window {
    /* background: red; */
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
                            <td><a href=""><span id="forget" >비밀번호를 잊어버리셨나요?</span></a></td>
                            <td><span  id="signUp">계정이 없으신가요? <a href="">회원가입</a></span></td>
                            <td><span  id="businessLogin">사업자 이신가요? <a href="">사업자 로그인</a></span></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
    <script>         
        const modal = document.getElementById("modal")
        const btnModal = document.getElementById("header-login")
        btnModal.addEventListener("click", e => {
                modal.style.display = "flex"
        })
       
        const closeBtn = modal.querySelector(".close-area")
        closeBtn.addEventListener("click", e => {
        modal.style.display = "none"
        })
   </script>

</body>
</html>