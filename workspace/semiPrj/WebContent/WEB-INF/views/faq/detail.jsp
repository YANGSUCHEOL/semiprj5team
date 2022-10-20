<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .header{
        margin-bottom: 180px;
    }
    table{
        border-collapse: collapse;
        border-spacing: 0;
    }
    section.faq{
        width: 80vw;
        padding: 80px 0;
        margin: 0 auto;
        border: 1px solid #ccc;
        border-radius: 20px;
    }
    .page-title{
        margin-bottom: 40px;
    }
    .page-title h3{
        height: 7vh;
        font-size: 30px;
        color: #333333;
        font-weight: 400;
        text-align: center;
        line-height: 50px;

        border-radius: 10px;
        background: #FCFFED;
    }
    .btn {
        margin-top: 10px;
        margin-left: 90%;
        display: inline-block;
        padding: 0 30px;
        font-size: 15px;
        font-weight: 400;
        background: transparent;
        white-space: nowrap;
        vertical-align: middle;
        -ms-touch-action: manipulation;
        touch-action: manipulation;
        cursor: pointer;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
        border: 1px solid #ccc;
        text-transform: uppercase;
        -webkit-border-radius: 0;
        -moz-border-radius: 0;
        border-radius: 20px;
        -webkit-transition: all 0.3s;
        -moz-transition: all 0.3s;
        -ms-transition: all 0.3s;
        -o-transition: all 0.3s;
        transition: all 0.3s;
    }
    .btn:hover{
        background-color: #EEFFF6;
    }
    .board-table{
        font-size: 16px;
        width: 100%;
        border-top: 1px solid #ccc;
        border-bottom: 1px solid #ccc;
    }
    .board-table .th-title{
        width: 200px;
        text-align: left;
    }
    .board-table th, .board-table td{
        padding: 18px 0;
    }
    .board-table thead td{
        width: 20vw;
        text-align: right;
        border-bottom: 1px solid #e7e7e7;
    }
    .board-table tbody td{
        width: 80vw;
        height: 40vh;
        border-top: 1px solid #e7e7e7;
        text-align: left;
        vertical-align: text-top;
    }
    * {
        list-style: none;
        text-decoration: none;
        padding: 0;
        margin: 0;
        box-sizing: border-box;
    }
    .container {
        width: 1100px;
        margin: 0 auto;
    }
</style>
</head>
<body>

	<div class="header"></div>
    <section class="faq">
        <div class="page-title">
            <div class="container">
                <h3>FAQ</h3>
            </div>
        </div>

        <div id="faq-list">
            <div class="container">
                <table class="board-table">
                    <thead>
                        <tr>
                            <th scope="col" class="th-title">[공지사항] 예약은 어떻게 하나요?</th>
                            <td>2022-10-16</td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                예약하는 방법은 아래와 같습니다.<br>
                                1. 메인 페이지 내 검색창에서 원하는 식당을 검색한 후,<br>
                                2. 식당의 상세 정보 페이지 내 예약 버튼을 누른 뒤,<br>
                                3. 예약 시간, 인원 수를 입력한 후 예약하기 버튼을 클릭하면 예약이 완료됩니다.
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <div id="board-write">
            <div class="container">
                <button type="submit" class="btn btn-dark">목록가기</button>
                <button type="submit" class="btn btn-dark">수정하기</button>
            </div>
        </div>

    </section>
    
</body>
</html>