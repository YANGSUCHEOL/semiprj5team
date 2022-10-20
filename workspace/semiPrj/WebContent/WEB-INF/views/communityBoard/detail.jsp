<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>communityBoardDetail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <style>

    .container{
        border: 1px solid lightgray;
        border-radius: 10px;
        background: white;
        color: black;
        width: 60%;
        height: 800px;
        margin: 0 auto;
        padding-top: 50px;
        padding: 50px;
        box-sizing: border-box
        
    }

    #th > div {
        margin-top: 10px;
        margin-right: 500px;
    }

    #bb{
        --border: 1px solid lightgray; 
        width: 100%;
        height: 60vh;
    }


    .foot {
        width: 100%;
        height: 20vh;
        padding: 20px;
    }

    #cmt{
        --border: 1px solid rgb(153, 153, 153); 
        margin: 0 auto;
    }

    #cmt > textarea {
        width: 735px;
        height: 100px;
        outline: none;
        resize: none;
    }
    
    #title {
        font-size: 20px;
    }

    #info {
        font-size: 13px;
    }

    #submit-btn {
        background-color: #EEFFF6;
        color: black;
        border: 1px solid #EEFFF6;
        font-size: 12px;
        margin-top: 10px;
        float: right;

    }

    #submit-btn:hover {
        background-color: #e0fbed;
    }

    </style>

   


</head>
<body>

    <div class="container">
        <div class="d-grid gap-2 d-md-flex justify-content-md-end" id="th">
            <div id="category">일상</div>
            <a class="btn btn-outline-secondary me-md-2" type="button">목록</a>
            <a class="btn btn-outline-secondary me-md-2" type="button">수정</a>
            <a class="btn btn-outline-secondary" type="button">삭제</a>
        </div>
        <hr>

        <div class="body">
            <div id="bb"> 
                <div id="title">제목입니다 안녕하세요</div>
                <div id="info">두부조아 2022.10.12 23:25 111</div>
                <br><br>
                <div id="content">내용내용내용</div>
            </div>
        </div>

        <div class="foot">
            <form action="">
                <div id="cmt">
                    <textarea name="" id="" cols="30" rows="10" required placeholder="댓글을 작성해 주세요"></textarea>
                    <button type="submit" class="btn btn-success" id="submit-btn">등록</button>
                </div>
            </form>
        </div>
   
    </div>  


    
</body>
</html>