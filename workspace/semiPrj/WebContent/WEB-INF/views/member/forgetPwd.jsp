<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
    #forget-modal.modal-overlay {
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
            z-index:100;
            
    }
    #forget-modal .modal-window {
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
    #forget-title{
        width: 100%;
        height: 25%;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    #forget-modal .forgetclose-area {
        display: inline;
        float: right;
        padding-top: 10px;
        padding-right: 30px;
        cursor: pointer;
        text-shadow: 1px 1px 2px gray;
        color: black;
        font-size: 20px;
    }

    #forget-modal .forget-content {
        margin-top: 20px;
        padding: 0px 10px;
        /* text-shadow: 1px 1px 2px gray; */
        color: black;
    }
    #forget-restaurantname {
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
    #forget-id {
    border: none;
    width: 420px;
    height: 63px;
    background: rgba(236,236,236,0.6299999952316284);
    opacity: 1;
    position: absolute;
    top: 300px;
    left: 33px;
    border-top-left-radius: 30px;
    border-top-right-radius: 30px;
    border-bottom-left-radius: 30px;
    border-bottom-right-radius: 30px;
    overflow: hidden;
    font-size: 20px;
    text-indent: 20px;
    }

    #forget-login{
    border: none;
    width: 420px;
    height: 63px;
    background-color: rgb(238,255,246);
    opacity: 1;
    position: absolute;
    top: 410px;
    left: 33px;
    border-top-left-radius: 30px;
    border-top-right-radius: 30px;
    border-bottom-left-radius: 30px;
    border-bottom-right-radius: 30px;
    overflow: hidden;
    font-size: 20px;
    }
       

     
 </style>
</head>
<body>

    </div>
    <div id="forget-modal" class="modal-overlay">
        <div class="modal-window">
            <div class="forgetclose-area">X</div>
            <div id="forget-title">
                <img id="forget-login-logo" src="/semiPrj/resources/img/로그인회원가입로고.png" alt="로고" width="260px" height="160px">
            </div>
            <div class="forget-content">
                <form action="/semiPrj/member/forgetPwd" method="post">
                    <table>
                        <tr>
                            <td><input id="forget-restaurantname" type="text" name="forgetName" placeholder="이름"></td>
                            <td><input id="forget-id" type="text" name="forgetId" placeholder="아이디"></td>
                        </tr>
                        <tr>
                            <td><input id="forget-login" type="submit" value="비밀번호 찾기"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
    <script>       
         const forgetmodall = document.getElementById("forget-modal")      
        const forgetcloseBtn = forgetmodall.querySelector(".forgetclose-area")
        forgetcloseBtn.addEventListener("click", e => {
            forgetmodall.style.display = "none"
        })

   </script>

</body>
</html>