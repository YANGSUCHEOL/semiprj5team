<%@page import="common.PageVo"%>
<%@page import="com.kh.semiPrj.reservation.vo.ReservationVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<ReservationVo> voList = (List<ReservationVo>)request.getAttribute("reservation");
	PageVo pv = (PageVo)request.getAttribute("pv");
	String resNo = (String)session.getAttribute("resNo");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="../resources/css/style.css">
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap')
	;

* {
	font-family: 'Noto Sans KR', sans-serif;
	letter-spacing: -0.1em;
}

body {
	letter-spacing: -0.1em;
	font-size: 16px;
}

#main {
	width: 70vw;
	display: grid;
	margin: 0 auto;
	grid-template-rows: 1fr;
	row-gap: 30px;
	align-content: center;
}

#content {
	box-sizing: border-box;
	display: grid;
	align-items: center;
	grid-template-rows: repeat(3, minmax(70px, auto));
	background: #FFFFFF;
	border: 1px solid #DEDEDE;
	border-radius: 10px;
}

#navigate {
	display: grid;
	grid-template-columns: 1fr 5fr 1.5fr;
	border-bottom: 1px solid lightgray;
	align-items: center;
	padding: 20px;
	margin-left: 100px;
	margin-right: 100px;
	margin-bottom: 50px;
}

#backspace {
	margin-left: 100px;
	padding-top: 80px;
	padding-bottom: 20px;
}

.res-list {
	display: grid;
	grid-template-columns: repeat(2, 1fr);
	grid-template-rows: repeat(2, 300px);
	row-gap: 40px;
}

.reservation {
	border: 1px solid #DEDEDE;
	border-radius: 10px;
	padding: 30px;
	margin: 20px;
	display: grid;
	margin-left: 100px;
	margin-right: 100px;
	grid-template-columns: 25% 60% 15%;
	grid-template-rows: repeat(5, minmax(40px, auto));
}

.btn-block {
	width: 60px;
	height: 40px;
	line-height: 14px;
}

.page {
	display: flex;
	align-items: center;
	justify-content: center;
	margin: auto;
	padding: 50px;
}

.res-restName {
	display: flex;
	align-items: center;
}
.res-date, .res-cnt, .rev-day, .res-time, .res-request {
	grid-column: 2/4;
	display: flex;
	align-items: center;
	line-height: 200%;
}
.flex-th {
	display: flex;
	align-items: center;
}

div[name="more-btn"] {
	text-align: right;
}

.none {
	grid-column: 1/3;
	text-align: center;
}

.active {
	font-family: "Poppins", Arial, sans-serif;
	color: gray;
	text-align: center;
	display: inline-block;
	width: 40px;
	height: 40px;
	line-height: 40px;
	border-radius: 50%;
	border: 1px solid #e6e6e6;
}

.active:hover {
	background-color: #EEFFF6;
	color: #e6e6e6;
}

.btn.btn-primary {
	background: #EEFFF6;
	border-color: #EEFFF6;
	color: black;
}

.btn.btn-primary:hover, .btn.btn-primary:focus {
	background: #d1edee !important;
	border-color: #d1edee !important;
	color: gray;
}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/header.jsp"%>

	<div id="main">
		<div id="sidebar"></div>
		<div id="content">
			<div id="backspace">
				<a href="/semiPrj/mypage/mypage">뒤로 가기</a>
			</div>
			<div id="navigate">
				<div>
					<span>예약 내역 확인</span>
				</div>
				<div>
					<span></span>
				</div>
			</div>
			<div class="res-list">
				<% if(voList.size() != 0) { %>
				<%for(int i = 0; i < voList.size(); ++i){%>
				<div class="reservation">
					<div class="flex-th">상호명</div><div class="res-restName"><%= voList.get(i).getRestaurant() %></div>
					<div class="dropdown d-block">
						<button
							class="btn mb-2 mb-md-0 btn-primary btn-block btn-round dropdown-toggle"
							type="button" id="dropdownMenuButton" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">…</button>
						<div class="dropdown-menu dropdown-menu-left"
							aria-labelledby="dropdownMenuButton">
							<%
							if (voList.get(i).getMember().equals(loginMember.getName()) || loginMember.getId().equals("admin")) {
							%>
							<a class="dropdown-item"
								href="/semiPrj/res/edit?no=<%=voList.get(i).getNo()%>">수정하기</a>
							<!-- 여기는 리뷰 넘버랑 지금 uri 받아서 넘겨서 삭제 -->
							<form action="/semiPrj/res/cancel" method="post" id="deleteForm">
								<input type="hidden" name="no"
									value="<%=voList.get(i).getNo()%>">
								<button class="dropdown-item" type="button"
									onclick="resDelete()">
							취소하기</a>
							</form>
							<%
							}
							%>
							<!-- 여기까지 끝 -->
						</div>
					</div>
					<div class="flex-th">예약 날짜</div><div class="res-date"><%= voList.get(i).getDate().substring(0, 4) %>년 <%= voList.get(i).getDate().substring(4, 6) %>월 <%= voList.get(i).getDate().substring(6, 8) %>일</div>
					<div class="flex-th">예약 시간</div><div class="res-time"><%= voList.get(i).getTime().substring(0, 2) %>:<%= voList.get(i).getTime().substring(2, 4) %></div>
					<div class="flex-th">예약 인원</div><div class="res-cnt"><%= voList.get(i).getCnt() %> 명</div>
					<div class="flex-th">요청 사항</div><div class="res-request"><%= voList.get(i).getRequest() %></div>
				</div>
				<% } %>
				<% } else if(voList.size() == 0) { %>
				<div class="none">
					<span>예약하신 내역이 없습니다.</span>
				</div>
				<% } %>
			</div>

			<div class="page">

				<%if(pv.getStartPage() != 1){%>
				<a href="/semiPrj/res/list?pno=<%=pv.getStartPage()-1%>"
					class="active"><</a>
				<%}%>

				<%for(int i = pv.getStartPage(); i <= pv.getEndPage(); ++i){%>
				<a href="/semiPrj/res/list?pno=<%=i%>" class="active"><%=i%></a>
				<%}%>

				<%if(pv.getEndPage() != pv.getMaxPage()){%>
				<a href="/semiPrj/res/list?pno=<%=pv.getEndPage()+1%>"
					class="active">></a>
				<%}%>

			</div>
		</div>
	</div>
	</div>

	<script src="../resources/js/jquery.min.js"></script>
	<script src="../resources/js/popper.js"></script>
	<script src="../resources/js/bootstrap.min.js"></script>
	<script src="../resources/js/main.js"></script>

	<script>
    const deleteForm = document.getElementById("deleteForm");
    function resDelete() {
    	Swal.fire({
			  title: '정말 예약을 취소하시겠습니까?',
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: '취소해 주세요!',
			  cancelButtonText: '창 닫기'
			}).then((result) => {
				if (result.isConfirmed) {
					deleteForm.submit();
				}
			})
    }
    </script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>

</html>