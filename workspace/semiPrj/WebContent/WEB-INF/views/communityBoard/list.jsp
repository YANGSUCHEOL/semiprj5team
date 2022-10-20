<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>communityBoardList</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

    <style>
    .container{
        border: 1px solid lightgray;
        border-radius: 10px;
        background: white;
        color: black;
        width: 70%;
        height: 800px;
        margin: 0 auto;
        padding-top: 50px;
        padding: 50px;
        box-sizing: border-box
        
    }

    #title{
        background-color: #EEFFF6;
        width: 100%;
        height: 5vh;
        text-align: center;
        font-size: 20px;
        border-bottom: 1px solid black;
    }lo

    .table{
        margin: 0 auto;
    }

    #write{
        float: right;
        margin: 10px;
        background-color: #EEFFF6;
    }

    #write:hover {
        background-color: #e4faee;
        border: 1px solid #e4faee;
    }

    #page-area2 {
        margin: 15px;
        margin-left: 300px;
    }


    </style>



</head>
<body>

    <div class="container">
        <div id="title">자유게시판</div>
        <table class="table table-hover">
            <thead>
              <tr>
                <th scope="col">번호</th>
                <th scope="col">말머리</th>
                <th scope="col">제목</th>
                <th scope="col">작성자</th>
                <th scope="col">작성일시</th>
                <th scope="col">조회수</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">7</th>
                <td>일상</td>
                <td>안녕하세요</td>
                <td>@mdo</td>
                <td>2022.10.13</td>
                <td>123</td>
              </tr>
              <tr>
                <th scope="row">6</th>
                <td>일상</td>
                <td>안녕하세요</td>
                <td>@fat</td>
                <td>2022.10.13</td>
                <td>23</td>
              </tr>
              <tr>
                <th scope="row">5</th>
                <td>일상</td>
                <td>안녕하세요</td>
                <td>Otto</td>
                <td>2022.10.13</td>
                <td>34</td>
              </tr>
              <tr>
                <th scope="row">4</th>
                <td>일상</td>
                <td>안녕하세요</td>
                <td>Otto</td>
                <td>2022.10.12</td>
                <td>44</td>
              </tr>
              <tr>
                <th scope="row">3</th>
                <td>일상</td>
                <td>안녕하세요</td>
                <td>Otto</td>
                <td>2022.10.12</td>
                <td>123</td>
              </tr>
              <tr>
                <th scope="row">2</th>
                <td>일상</td>
                <td>안녕하세요</td>
                <td>Otto</td>
                <td>2022.10.12</td>
                <td>78</td>
              </tr>
              <tr>
                <th scope="row">1</th>
                <td>일상</td>
                <td>안녕하세요</td>
                <td>Otto</td>
                <td>2022.10.12</td>
                <td>99</td>
              </tr>
            </tbody>
          </table>

            <div id="main-bot">
                <a href="/semiPrj/communityBoard/write" class="btn btn-light" id="write">글쓰기</a>
            </div>

            <div id="page-area" class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
                <div id="page-area2" class="btn-group me-2" role="group" aria-label="First group">
                    <a href="/semiPrj/communityBoard/list?p=1" class="btn btn-outline-secondary"><</a>
                    <a href="/semiPrj/communityBoard/list?p=1" class="btn btn-outline-secondary">1</a>
                    <a href="/semiPrj/communityBoard/list?p=2" class="btn btn-outline-secondary">2</a>
                    <a href="/semiPrj/communityBoard/list?p=3" class="btn btn-outline-secondary">3</a>
                    <a href="/semiPrj/communityBoard/list?p=4" class="btn btn-outline-secondary">4</a>
                    <a href="/semiPrj/communityBoard/list?p=5" class="btn btn-outline-secondary">5</a>
                    <a href="/semiPrj/communityBoard/list?p=1" class="btn btn-outline-secondary">></a>
                </div>
            </div>


    </div>


    
</body>
</html>