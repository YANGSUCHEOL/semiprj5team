<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
    #join-modal.modal-overlay {
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
    #join-modal .modal-window {
        /* background: red; */
        box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
        backdrop-filter: blur( 13.5px );
        -webkit-backdrop-filter: blur( 13.5px );
        border-radius: 10px;
        border: 1px solid rgba( 255, 255, 255, 0.18 );
        width: 497px;
        height: 603px;
        position: relative;
        max-height: calc(80vh - 30px);
    overflow-y: auto;
    }
    #join-title{
        width: 100%;
        height: 25%;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    #join-modal .close-area {
        display: inline;
        float: right;
        padding-top: 10px;
        padding-right: 30px;
        cursor: pointer;
        text-shadow: 1px 1px 2px gray;
        color: black;
        font-size: 20px;
    }

    #join-modal .join-content {
        margin-top: 20px;
        padding: 0px 10px;
        /* text-shadow: 1px 1px 2px gray; */
        color: black;
    }
    #join-id {
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

    #join-pwd{
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
    #join-pwd2{
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
    #join-nick{
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
    #join-name{
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
    #join-phoneNum{
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
    #join-birth{
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
    #join-login{
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
    #join-join-login{
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
    #join-join-login>a{
        color: rgba(60,179,113,1);
        text-decoration: none;
    }
    #join-business-join{
    width: 380px;
    position: absolute;
    top: 950px;
    left: 70px;
    font-family: Inter;
    font-weight: Regular;
    font-size: 20px;
    opacity: 1;
    text-align: left;
    }
    #join-business-join>a{
        color: rgba(60,179,113,1);
        text-decoration: none;
    }
  
       

     
 </style>
</head>
<body>

    </div>
    <div id="join-modal" class="modal-overlay">
        <div class="modal-window">
            <div class="close-area">X</div>
            <div id="join-title">
                <img id="join-login-logo" src="/semiPrj/resources/img/로그인회원가입로고.png" alt="로고" width="260px" height="160px">
            </div>
            <div class="join-content">
                <form action="/semiPrj/member/join" method="post">
                    <table>
                        <tr>
                            <td><input id="join-id" type="text" name="joinmemberId" placeholder="아이디"></td>
                            <td><input id="join-pwd" type="password" name="joinmemberPwd" placeholder="비밀번호"></td>
                            <td><input id="join-pwd2" type="password" name="joinmemberPwd2" placeholder="비밀번호확인"></td>
                            <td><input id="join-nick" type="text" name="joinmemberNick" placeholder="닉네임"></td>
                            <td><input id="join-name" type="text" name="joinmemberName" placeholder="이름"></td>
                            <td><input id="join-phoneNum" type="text" name="joinphoneNum" placeholder="전화번호"></td>
                            <td><input id="join-birth" type="text" name="joinbirth" placeholder="생년월일(6자리)"></td>
                        </tr>
                        <tr>
                            <td><input id="join-login" type="submit" value="회원가입"></td>
                            <td><span  id="join-join-login">이미 가입하셨나요? <a href="">로그인</a></span></td>
                            <td><span  id="join-business-join">사업자 회원이신가요? <a href="">사업자 회원가입</a></span></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
    <script>         
        const modal2 = document.getElementById("join-modal")
        const btnModal2 = document.getElementById("header-signup")
        btnModal2.addEventListener("click", e => {
                modal2.style.display = "flex"
        })
       
        const closeBtn2 = modal.querySelector(".close-area")
        closeBtn2.addEventListener("click", e => {
            	modal2.style.display = "none"
        })
   </script>

</body>
</html>