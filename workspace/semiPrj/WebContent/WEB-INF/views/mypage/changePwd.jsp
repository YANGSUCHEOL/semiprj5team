<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
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
    left: 200px;
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
  
       

     
 </style>
</head>
<body>

    </div>
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
                            <td><input id="change-id" type="text" name="joinmemberId" placeholder="아이디123"></td>
                            <td><input id="change-pwd" type="password" name="joinmemberPwd" placeholder="비밀번호"></td>
                            <td><input id="change-pwd2" type="password" name="joinmemberPwd2" placeholder="비밀번호확인"></td>
                            <td><input id="change-nick" type="text" name="joinmemberNick" placeholder="닉네임"></td>
                            <td><input id="change-name" type="text" name="joinmemberName" placeholder="이름"></td>
                            <td><input id="change-phoneNum" type="text" name="joinphoneNum" placeholder="전화번호"></td>
                            <td><input id="change-birth" type="text" name="joinbirth" placeholder="생년월일(6자리)"></td>
                        </tr>
                        <tr>
                            <td><input id="change-login" type="submit" value="정보수정"></td>   
                            <td><span  id="change-business-join"><a id="join-businessjoin-button" href="#" onclick='joinlogin33'>회원 탈퇴</a></span></td>
                        </tr>
                    </table>
                </form>
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