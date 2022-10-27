<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
    #bsjoin-modal.modal-overlay {
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
    #bsjoin-modal .modal-window {
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
    #bsjoin-title{
        width: 100%;
        height: 25%;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    #bsjoin-modal .bsclose-area {
        display: inline;
        float: right;
        padding-top: 10px;
        padding-right: 30px;
        cursor: pointer;
        text-shadow: 1px 1px 2px gray;
        color: black;
        font-size: 20px;
    }

    #bsjoin-modal .bsjoin-content {
        margin-top: 20px;
        padding: 0px 10px;
        /* text-shadow: 1px 1px 2px gray; */
        color: black;
    }
    #bsjoin-restaurantname {
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
    #bsjoin-id {
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

    #bsjoin-pwd{
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
    #bsjoin-pwd2{
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
    #bsjoin-nick{
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
    #bsjoin-name{
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
    #bsjoin-phoneNum{
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
    #bsjoin-birth{
    border: none;
    width: 420px;
    height: 63px;
    background: rgba(236,236,236,0.6299999952316284);
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
    text-indent: 20px;
    }
    #bsjoin-login{
    border: none;
    width: 420px;
    height: 63px;
    background-color: rgb(238,255,246);
    opacity: 1;
    position: absolute;
    top: 910px;
    left: 33px;
    border-top-left-radius: 30px;
    border-top-right-radius: 30px;
    border-bottom-left-radius: 30px;
    border-bottom-right-radius: 30px;
    overflow: hidden;
    font-size: 20px;
    }
    #bsjoin-join-login{
    width: 274px;
    position: absolute;
    top: 980px;
    left: 130px;
    font-family: Inter;
    font-weight: Regular;
    font-size: 20px;
    opacity: 1;
    text-align: left;
    }
    #bsjoin-join-login>a{
        color: rgba(60,179,113,1);
        text-decoration: none;
    }
    #bsjoin-business-join>a{
        color: rgba(60,179,113,1);
        text-decoration: none;
    }
  
       

     
 </style>
</head>
<body>

    </div>
    <div id="bsjoin-modal" class="modal-overlay">
        <div class="modal-window">
            <div class="bsclose-area">X</div>
            <div id="bsjoin-title">
                <img id="bsjoin-login-logo" src="/semiPrj/resources/img/로그인회원가입로고.png" alt="로고" width="260px" height="160px">
            </div>
            <div class="bsjoin-content">
                <form action="/semiPrj/businessmember/join" method="post">
                    <table>
                        <tr>
                            <td><input id="bsjoin-restaurantname" type="text" name="bsrestaurantname" placeholder="식당이름"></td>
                            <td><input id="bsjoin-id" type="text" name="bsjoinmemberId" placeholder="아이디"></td>
                            <td><input id="bsjoin-pwd" type="password" name="bsjoinmemberPwd" placeholder="비밀번호"></td>
                            <td><input id="bsjoin-pwd2" type="password" name="bsjoinmemberPwd2" placeholder="비밀번호확인"></td>
                            <td><input id="bsjoin-nick" type="text" name="bsjoinmemberNick" placeholder="닉네임"></td>
                            <td><input id="bsjoin-name" type="text" name="bsjoinmemberName" placeholder="이름"></td>
                            <td><input id="bsjoin-phoneNum" type="text" name="bsjoinphoneNum" placeholder="전화번호"></td>
                            <td><input id="bsjoin-birth" type="text" name="bsnumber" placeholder="사업자번호(10자리)"></td>
                        </tr>
                        <tr>
                            <td><input id="bsjoin-login" type="submit" value="사업자 회원가입"></td>
                            <td><span  id="bsjoin-join-login">이미 가입하셨나요?<a id="bslogin-bslogin" href="#" onclick='bsnlogin'>로그인</a></span></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
    <script>       
         const businessjoin2 = document.getElementById("bsjoin-modal")      
        const closeBtn3 = businessjoin2.querySelector(".bsclose-area")
        closeBtn3.addEventListener("click", e => {
            businessjoin2.style.display = "none"
        })

   </script>

</body>
</html>