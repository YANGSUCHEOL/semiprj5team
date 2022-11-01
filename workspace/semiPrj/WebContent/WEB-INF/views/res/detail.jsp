<%@page import="com.kh.semiPrj.restaurant.vo.RestaurantVo"%>
<%@page import="com.kh.semiPrj.reservation.vo.ReservationVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ReservationVo vo = (ReservationVo)session.getAttribute("reservation");
	RestaurantVo res = (RestaurantVo)session.getAttribute("restaurant");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.6.3/dist/sweetalert2.all.min.js"></script>
    <style>
        * {
            letter-spacing: -0.1rem;
        }
        #main {
            width: 65vw;
            display: grid;
            margin: 0 auto;
            grid-template-rows: 70px minmax(100px, auto);
            row-gap: 30px;
            align-content: center;
        }

        #sidebar {
            background: #EEFFF6;
            display: flex;
        }

        #content {
            box-sizing: border-box;
            display: grid;
            justify-content: center;
            align-items: center;
            text-align: center;
            grid-template-rows: repeat(3, minmax(70px, auto));
            background: #FFFFFF;
            border: 1px solid #DEDEDE;
            border-radius: 10px;
            row-gap: 50px;
            padding: 50px;
            padding-top: 100px;
            padding-bottom: 100px;
        }
        #content>div:nth-child(3) {
            width: 400px;
            display: flex;
            flex-direction: row;
            justify-content: space-evenly;
        }
        table {
            width: 100%;
            height: 100%;
        }
        th {
            text-align: right;
            padding: 10px;
        }
        td {
            text-align: left;
            padding: 10px;
        }
        .btn-common {
            display: flex;
            padding: 10px 10px;
            background-color: #FFFFFF;
            border: 1px solid #DEDEDE;
            border-radius: 20px;
            font-size: 17px;
            font-weight: 400;
            cursor: pointer;
        }
        .btn-common:hover {
        	color: lightgray;
        }
        span[name="alertMsg"] {
            font-size: 24px;
            font-weight: bold;
        }
    </style>
</head>

<body>

<%@ include file="/WEB-INF/views/header.jsp" %>

    <div id="main">
        <div id="sidebar">

        </div>
        <div id="content">
            <div><span name="alertMsg">🎉 예약이 완료되었습니다!</span></div>
            <table>
                <tr>
                    <th>상호명</th>
                    <td><%= vo.getRestaurant() %></td>
                </tr>
                <tr>
                    <th>인원 수</th>
                    <td><%= vo.getCnt() %>명</td>
                </tr>
                <tr>
                    <th>예약 날짜</th>
                    <td><%= vo.getDate().substring(0, 4) %>년 <%= vo.getDate().substring(4, 6) %>월 <%= vo.getDate().substring(6, 8) %>일</td>
                </tr>
                <tr>
                    <th>예약 시간</th>
                    <td><%= vo.getTime().substring(0, 2) %>:<%= vo.getTime().substring(2, 4) %></td>
                </tr>
                <tr>
                    <th>요청 사항</th>
                    <td><%= vo.getRequest() %></td>
                </tr>
            </table>
            <div>
                <button class="btn-common" onclick="location.href='/semiPrj/res/edit?no=<%= vo.getNo() %>'">수정하기</button>
                <button class="btn-common" onclick="javascript:cancelAlert()">취소하기</button>
                <%-- <button class="btn-common" onclick="location.href='/semiPrj/res/cancel?no=<%= vo.getNo() %>'";>취소하러 가기</button> --%>
                <button class="btn-common" onclick="location.href='/semiPrj'">메인으로 돌아가기</button>
            </div>
        </div>
    </div>
    
    <script>
    	function cancelAlert() {
    		Swal.fire({
    			  title: '예약을 취소하시겠습니까?',
    			  text: "<%= vo.getDate().substring(0, 4) %>년 <%= vo.getDate().substring(4, 6) %>월 <%= vo.getDate().substring(6, 8) %>일 <%= vo.getTime().substring(0, 2) %>:<%= vo.getTime().substring(2, 4) %> <%= vo.getCnt() %>명 예약을 취소합니다.",
    			  icon: 'warning',
    			  showCancelButton: true,
    			  confirmButtonColor: '#3085d6',
    			  cancelButtonColor: '#d33',
    			  confirmButtonText: '취소해 주세요!',
    			  cancelButtonText: '창 닫기'
    			}).then((result) => {
    			  location.href='/semiPrj/res/cancel?no=<%= vo.getNo() %>';
    			})
    	}
    </script>
    
</body>

</html>