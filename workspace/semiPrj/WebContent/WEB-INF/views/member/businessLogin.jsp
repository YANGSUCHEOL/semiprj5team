<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    #bs-modal.modal-overlay {
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
#bs-modal .modal-window {
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
#bs-title{
    width: 100%;
    height: 25%;
    display: flex;
    justify-content: center;
    align-items: center;
}
#bs-modal .bs-loginclose-area {
    display: inline;
    float: right;
    padding-top: 10px;
    padding-right: 30px;
    cursor: pointer;
    text-shadow: 1px 1px 2px gray;
    color: black;
    font-size: 20px;
}

#bs-modal .bs-content {
    margin-top: 20px;
    padding: 0px 10px;
    /* text-shadow: 1px 1px 2px gray; */
    color: black;
}
#bs-id {
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

#bs-pwd{
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
#bs-login{
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
#bs-forget{
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
#bs-signUp{
width: 350px;
position: absolute;
top: 500px;
left: 80px;
font-family: Inter;
font-weight: Regular;
font-size: 20px;
opacity: 1;
text-align: left;
}
#bs-signUp>a{
    color: rgba(60,179,113,1);
    text-decoration: none;
}
#bs-businessLogin{
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
#bs-businessLogin>a{
    color: rgba(60,179,113,1);
    text-decoration: none;
}

</style>
</head>
<body>

    <div id="bs-modal" class="modal-overlay">
        <div class="modal-window">
            <div class="bs-loginclose-area">X</div>
            <div id="bs-title">
                <img id="bs-login-logo" src="/semiPrj/resources/img/로그인회원가입로고.png" alt="로고" width="260px" height="160px">
            </div>
            <div class="bs-content">
                <form action="/semiPrj/businessmember/login" method="post">
                    <table>
                        <tr>
                            <td><input id="bs-id" type="text" name="bsmemberId" placeholder="사업자 아이디"></td>
                        </tr>
                        <tr>
                            <td><input id="bs-pwd" type="password" name="bsmemberPwd" placeholder="사업자 비밀번호"></td>
                        </tr>
                        <tr>
                            <td><input id="bs-login" type="submit" value="사업자 로그인"></td>
                            <td><a href=""><span id="bs-forget" >비밀번호를 잊어버리셨나요?</span></a></td>
                            <td><span  id="bs-signUp">계정이 없으신가요? <a id="bslogin-join" href="#" onclick='businessloginjoin'>사업자 회원가입</a></span></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
    <script>    
         
        const bslogin2 = document.getElementById("bs-modal")
        const closeBtn4 = bslogin2.querySelector(".bs-loginclose-area")
        closeBtn4.addEventListener("click", e => {
            bslogin2.style.display = "none"
        })

        //비지니스 로그인->비지니스 회원가입
        const modal23 = document.getElementById("bsjoin-modal")
        const businessloginjoin = document.getElementById("bslogin-join")
        businessloginjoin.addEventListener("click", e => {
            bslogin2.style.display = "none"
            modal23.style.display = "flex"
        })

        //비지니스 회원가입 -> 비지니스 로그인
        const bsnlogin = document.getElementById("bslogin-bslogin")
        bsnlogin.addEventListener("click", e => {
            modal23.style.display = "none"
            bslogin2.style.display = "flex"
        })
   </script>

  
         


</body>
</html>