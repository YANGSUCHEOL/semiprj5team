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
        margin-left: 45%;
        display: inline-block;
        padding: 0 30px;
        font-size: 16px;
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
        background-color: #FCFFED;
    }
    .board-table{
        font-size: 16px;
        width: 100%;
        border-top: 1px solid #ccc;
        border-bottom: 1px solid #ccc;
    }
    .board-table a{
        color: #333;
        display: inline-block;
        line-height: 1.4;
        word-break: break-all;
        vertical-align: middle;
    }
    .board-table a:hover{
        text-decoration: underline;
    }
    .board-table tbody tr:hover{
        background-color: #FCFFED;
    }
    .board-table th{
        text-align: center;
    }
    .board-table .th-num{
        width: 100px;
        text-align: center;
    }
    .board-table .th-title{
        width: 200px;
    }
    .board-table th, .board-table td{
        padding: 18px 0;
    }
    .board-table tbody td{
        border-top: 1px solid #e7e7e7;
        text-align: center;
    }
    .board-table tbody th{
        width: 70%;
        padding-left: 40px;
        padding-right: 14px;
        border-top: 1px solid #e7e7e7;
        text-align: left;
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


    /*모달*/
    .modal {
        position: fixed;
        display: none;
        z-index: 200;
        top: 20%;
        left: 30%;
        width: 40%;
        background: white;
        padding: 1rem;
        border: 1px solid #ccc;
        box-shadow: 1px 1px 1px rgba(0, 0, 0, 0.5);
    }

    .modal__title {
        text-align: center;
        margin: 0 0 1rem 0;
    }

    .modal__actions {
        text-align: center;
    }

    .modal__action {
        border: 1px solid #0e4f1f;
        background: #0e4f1f;
        text-decoration: none;
        color: white;
        font: inherit;
        padding: 0.5rem 1rem;
        cursor: pointer;
    }

    .modal__action:hover,
    .modal__action:active {
        background: #2ddf5c;
        border-color: #2ddf5c;
    }

    .modal__action--negative {
        background: red;
        border-color: red;
    }

    .modal__action--negative:hover,
    .modal__action--negative:active {
        background: #ff5454;
        border-color: #ff5454;
    }
    
</style>
</head>
<body>

    <div class="header"></div>
    <section class="faq">
        <div class="page-title">
            <div class="container">
                <h3>쿠폰</h3>
            </div>
        </div>

        <div id="faq-list">
            <div class="container">
                <table class="board-table">
                    <thead>
                        <tr>
                            <th scope="col" class="th-num">번호</th>
                            <th scope="col" class="th-title">제목</th>
                            <th scope="col" class="th-writer">조회수</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>4</td>
                            <th>
                                <a href="#!">리뷰는 어떻게 작성하나요?</a>
                            </th>
                            <td>102</td>
                        </tr>

                        <tr>
                            <td>3</td>
                            <th>
                                <a href="#!">예약 내역은 어떻게 변경하나요?</a>
                            </th>
                            <td>205</td>
                        </tr>

                        <tr>
                            <td>2</td>
                            <th>
                                <a href="#!">쿠폰은 어떻게 사용하나요?</a>
                            </th>
                            <td>83</td>
                        </tr>

                        <tr>
                            <td>1</td>
                            <th>
                                <a href="#!">예약은 어떻게 하나요?</a>
                            </th>
                            <td>95</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <div id="board-write">
            <div class="container">
                <button type="submit" class="btn btn-dark">닫기</button>
            </div>
        </div>

    </section>

    <div class="modal">
        <h1 class="modal__title">결제하시겠습니까?</h1>
        <div class="modal__actions">
          <a href="index.html" class="modal__action">예</a>
          <button class="modal__action modal__action--negative" type="button">
            아니오
          </button>
        </div>
    </div>

</body>
</html>