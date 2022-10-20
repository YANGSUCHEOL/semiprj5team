<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    #background{
        box-sizing: border-box;

    position: absolute;
    width: 832px;
    height: 468px;
    left: 82px;
    top: 150px;

    background: rgba(255, 255, 255, 0.45);
    border: 1px solid #DADADA;
    border-radius: 10px;
    }

    #top-back{
        position: absolute;
        width: 697px;
        height: 41px;
        left: 65px;
        top: 25px;
        background: #FCFFED;
        border-radius: 10px;
        margin: auto;
        padding-top: 20px;

    }

    #top-name{
        font-family: 'Inter';
        font-style: normal;
        font-weight: 400;
        font-size: 17px;
        line-height: 21px;
        text-align: center;

        color: #000000;
    }


    #main-back{
        box-sizing: border-box;

        position: absolute;
        width: 697px;
        height: 362px;
        left: 65px;
        top: 100px;

        background: #FFFFFF;
        border: 2px solid #868787;
    }

    #main-back>div{
        text-align: center;
    }

    textarea {
        width: 85%;
        height: 18em;
        resize: none;
        background: #FFFFFF;
        border: 1px solid #D9D9D9;
  }

  #submit-btn{
    position: absolute;
    width: 65px;
    height: 22px;
    display: block;
     margin: 0 auto;

    background: #F0F0F0;

  }

  #write-title{
    box-sizing: border-box;

    position: absolute;
    width: 85%;
    height: 25px;

    background: #FFFFFF;
    border: 1px solid #D9D9D9;
  }

</style>
</head>
<body>

    <div id="background">

        <div id="top-back">
            <div id="top-name">사업자 회원 문의 답변하기</div>
        </div>

        <form action="">
            <div id="main-back">
                <br>
                제목  <input type="text" id="write-title">
                <br><br>
                내용 <textarea></textarea>
                <br><br>
                <div id="submit-btn"><input type="submit" value="작성하기" ></div>

            </div>
        </form>
    </div>
</body>
</html>