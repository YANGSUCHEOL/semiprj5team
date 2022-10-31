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


position: relative;
width: 70vw;
height: 800px;

margin: auto;
margin-top:50px;

background: rgba(255, 255, 255, 0.45);
border: 1px solid #DADADA;
border-radius: 10px;
}

#top-back{
    position: relative;
    width: 75%;
    height: 5%;
    --left: 65px;
    --top: 25px;
    background: #FCFFED;
    border-radius: 10px;
    margin: auto;
    margin-top: 20px;
    padding-top: 20px;

}

#top-name{
    font-family: 'Inter';
    font-style: normal;
    font-weight: 400;
    font-size: 20px;
    line-height: 21px;
    text-align: center;
    margin: 0 auto;

    color: #000000;
}

#main-back{
    box-sizing: border-box;

    position: relative;
    width: 80%;
    height: 600px;
  	margin: auto;
  	margin-top:50px;

    background: #FFFFFF;
    border: 2px solid #868787;
}

#main-back>div{
    text-align: center;
}

#toptxt{
    position: relative;
    left: 10vw;
    top: 5vh;
    font-size: 17px;

    --margin: 20px;
}

    textarea {
        width: 85%;
        height: 350px;
        resize: none;
        background: #FFFFFF;
        border: 1px solid #D9D9D9;
  }
  #btns{
    text-align: center;
  }

  #submit-btn{
    position: absolute;
    width: 65px;
    height: 22px;
    margin: auto;
    display: inline-block;

    background: #F0F0F0;
    text-align: center;

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
<%@ include file="/WEB-INF/views/header.jsp" %>

    <div id="background">

        <div id="top-back">
            <div id="top-name">사업자 회원 문의 수정</div>
        </div>

        <form action="" method="post">
            <div id="main-back">
                <br>
                <div>제목</div>  
                <div><input type="text" name="title" style="width:905px;"></div>
                <br><br>
                <div>내용</div>
                <div><textarea name="content"></textarea></div> 
                <br><br>
                <div id="btns">
                <input type="submit" value="작성하기" id="submit-btn"></div>

            </div>
        </form>
    </div>
</body>
</html>