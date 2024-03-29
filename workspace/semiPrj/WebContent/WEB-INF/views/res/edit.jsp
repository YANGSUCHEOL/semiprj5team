<%@page import="com.kh.semiPrj.reservation.vo.ReservationVo"%>
<%@page import="com.kh.semiPrj.restaurant.vo.RestaurantVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ReservationVo reservation = (ReservationVo)session.getAttribute("reservation");
	RestaurantVo vo = (RestaurantVo)request.getAttribute("res");
	int open = Integer.parseInt(vo.getOpen().replace(":", ""));
	int close = Integer.parseInt(vo.getClose().replace(":", ""));
	String rno = vo.getNo();
	String[] dayoff = vo.getDayoff().split(",");
	String root = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>reservation</title>

<style>
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap')
	;

* {
	font-family: 'Noto Sans KR', sans-serif;
	letter-spacing: -0.1em;
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
	justify-items: center;
	align-items: center;
	text-align: center;
	grid-template-rows: repeat(7, minmax(70px, auto));
	background: #FFFFFF;
	border: 1px solid #DEDEDE;
	border-radius: 10px;
	row-gap: 50px;
	padding: 50px;
	padding-top: 100px;
}

span {
	font-size: 23px;
}

.btn-common {
	display: flex;
	justify-content: center;
	align-items: center;
	width: 200px;
	height: 50px;
	background: #FFFFFF;
	border: 1px solid #DEDEDE;
	border-radius: 20px;
	font-size: 20px;
	cursor: pointer;
}

.box-radio-input input[type="radio"] {
	display: none;
}

.box-radio-input input[type="radio"]+span {
	display: inline-block;
	padding-top: 10px;
	width: 80px; height : 40px;
	background: #FFFFFF;
	border: 1px solid #DEDEDE;
	border-radius: 20px;
	font-size: 17px;
	font-weight: 400;
	cursor: pointer;
	height: 40px;
	width: 80px;
	height: 40px;
}

.box-radio-input input[name="cnt"]+span {
	display: inline-flex;
	flex-direction: row;
	justify-content: space-evenly;
}

.space-evenly {
	display: grid;
	grid-template-columns: repeat(3, minmax(100px, auto));
}

.box-radio-input input[type="radio"]:checked+span {
	background: #FCFFED;
	font-weight: bold;
}
.box-radio-input input[type="radio"]:disabled+span {
	background: lightgray;
}

#res-store {
	display: grid;
	width: 80%;
	grid-template-columns: 1.5fr 1fr;
	grid-template-rows: repeat(3, minmax(70px, auto));
	justify-content: center;
	justify-items: start;
	align-items: center;
}

#res-store>div:nth-child(1) {
	grid-row: 1/4;
}

#res-cnt {
	display: grid;
	grid-template-rows: repeat(2, minmax(70px, auto)) minmax(30px, auto);
	row-gap: 10px;
	column-gap: 20px;
	justify-content: space-evenly;
	align-items: center;
}

#res-day, #res-time, #res-want {
	display: grid;
	justify-content: center;
	align-items: center;
	grid-template-rows: repeat(2, minmax(70px, auto));
	row-gap: 30px;
}

#res-submit {
	display: grid;
	grid-template-rows: 100px 100px;
	justify-items: center;
	align-items: center;
}

#timetable {
	display: grid;
	grid-template-columns: repeat(5, minmax(70px, auto));
	grid-template-rows: repeat(3, minmax(50px, auto));
	row-gap: 20px;
	column-gap: 20px;
	justify-content: space-evenly;
}

input[name="request"] {
	width: 600px;
	height: 50px;
	text-align: center;
}
input::-webkit-input-placeholder {
	text-align:center;
}

span[name="warning"] {
	font-size: 14px;
	color: lightgray;
}

#res-picture>img{
	width: 80%;
	height: 80%;
	object-fit: cover;
}
#res-picture {
	display: flex;
	align-items: center;
	justify-content: right;
	width: 400px;
	height: 300px;
}
.object-fit {
	display: block;
	width: 100%;
	height: 100%;
	object-fit: cover;
}

</style>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script type="text/javascript">
	var array = [];
	<% for(int i = 0; i < dayoff.length; ++i) { %>
		array.push("<%= dayoff[i] %>");
	<% } %>
	console.log(array);
    $(document).ready(function () {
            $.datepicker.setDefaults($.datepicker.regional['ko']); 
            $( "#resDate" ).datepicker({
            	showOn: "both",
                changeMonth: true, 
                changeYear: false,
                nextText: '다음 달',
                prevText: '이전 달', 
                dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
                dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
                monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                dateFormat: "yymmdd",
                minDate: 0,
                beforeShowDay: function(date){
                	var day = date.getDay();
                	return [(day != parseInt(array[0]) && day != parseInt(array[1]) && day != parseInt(array[2]) && day != parseInt(array[3]) && day != parseInt(array[4]) && day != parseInt(array[5]) && day != parseInt(array[6]))];
                }
           });    
    });
</script>

</head>

<body>

<%@ include file="/WEB-INF/views/header.jsp" %>

	<div id="main">
		<form action="/semiPrj/res/edit" method="post">
			<div id="content">
				<div id="res-store">
					<div id="res-picture"><img class="object-fit" src="<%= root %>/resources/img/<%= vo.getPhoto() %>.jpg"></img></div>
					<div id="res-name"><%= vo.getName() %></div>
					<div id="res-openclose"><%= vo.getOpen() %> ~ <%= vo.getClose() %> 운영</div>
					<div id="res-cou">
					<a id="cou-modal" href="#coupon">쿠폰 변경 불가</a>
					<input type="hidden" name="couNo" value="<%= reservation.getCoupon() %>">
					</div>
					<input type="hidden" name="rNo" value="<%= vo.getNo() %>">
					<input type="hidden" name="rName" value="<%= vo.getName() %>">
					<input type="hidden" name="resNo" value="<%= reservation.getNo() %>">
				</div>
				<div id="res-cnt">
					<div>
						<span>예약 인원</span>
					</div>
					<div class="space-evenly">
						<label class="box-radio-input"><input type="radio"
							name="cnt" value="2"><span>2인</span></label> <label
							class="box-radio-input"><input type="radio" name="cnt"
							value="3"><span>3인</span></label> <label class="box-radio-input"><input
							type="radio" name="cnt" value="4"><span>4인</span></label>
					</div>
					<div>
						<span name="warning">5명 이상은 단체 손님으로 가게로 직접 예약 부탁드립니다</span>
					</div>
				</div>
				<div id="res-day">
					<div>
						<span>예약 날짜</span>
					</div>
					<div><input type="text" id="resDate" name="date" onchange="timeCheck()" value="<%= reservation.getDate() %>"></div>	
				</div>
				<div id="res-time">
					<div>
						<span>예약 시간</span>
					</div>
					<div id="timetable">
						<div>
							<label class="box-radio-input imsi"><input type="radio" id="0900" 
								name="time" value="0900"><span>09:00</span></label>
						</div>
						<div>
							<label class="box-radio-input imsi"><input type="radio" id="1000" 
								name="time" value="1000"><span>10:00</span></label>
						</div>
						<div>
							<label class="box-radio-input imsi"><input type="radio" id="1100" 
								name="time" value="1100"><span>11:00</span></label>
						</div>
						<div>
							<label class="box-radio-input imsi"><input type="radio" id="1200" 
								name="time" value="1200"><span>12:00</span></label>
						</div>
						<div>
							<label class="box-radio-input imsi"><input type="radio" id="1300" 
								name="time" value="1300"><span>13:00</span></label>
						</div>
						<div>
							<label class="box-radio-input imsi"><input type="radio" id="1400" 
								name="time" value="1400"><span>14:00</span></label>
						</div>
						<div>
							<label class="box-radio-input imsi"><input type="radio" id="1500" 
								name="time" value="1500"><span>15:00</span></label>
						</div>
						<div>
							<label class="box-radio-input imsi"><input type="radio" id="1600" 
								name="time" value="1600"><span>16:00</span></label>
						</div>
						<div>
							<label class="box-radio-input imsi"><input type="radio" id="1700" 
								name="time" value="1700"><span>17:00</span></label>
						</div>
						<div>
							<label class="box-radio-input imsi"><input type="radio" id="1800" 
								name="time" value="1800"><span>18:00</span></label>
						</div>
						<div>
							<label class="box-radio-input imsi"><input type="radio" id="1900" 
								name="time" value="1900"><span>19:00</span></label>
						</div>
						<div>
							<label class="box-radio-input imsi"><input type="radio" id="2000" 
								name="time" value="2000"><span>20:00</span></label>
						</div>
						<div>
							<label class="box-radio-input imsi"><input type="radio" id="2100" 
								name="time" value="2100"><span>21:00</span></label>
						</div>
						<div>
							<label class="box-radio-input imsi"><input type="radio" id="2200" 
								name="time" value="2200"><span>22:00</span></label>
						</div>
						<div>
							<label class="box-radio-input imsi"><input type="radio" id="2300" 
								name="time" value="2300"><span>23:00</span></label>
						</div>
					</div>
				</div>
				<div id="res-want">
					<div>
						<span>요청 사항</span>
					</div>
					<div>
						<input type="text" name="request" placeholder="50자까지 작성 가능합니다." value="<%= reservation.getRequest() %>">
					</div>
				</div>
				<div id="res-submit">
					<span name="warning">예약은 식당의 개인 사정으로 취소될 수 있으며,<br>악의적으로 예약을 반복할 경우 트래픽 초과로 차단될 수 있음을 고지드립니다.</span>
					<input type="submit" value="예약하기" class="btn-common">
				</div>
		</form>
	</div>
	</div>
	</div>

	<script>
		// 인원 체크
		const cntArr = document.querySelectorAll('input[name=cnt]');
		const cntStr = '<%= reservation.getCnt() %>';
		
		for(let i = 0; i < cntArr.length; i++) {
			const v = cntArr[i].value;
			
			const result = cntStr.search(v);
			if(result >= 0) {
				cntArr[i].checked = true;
			}
		}
		
		// 시간 체크
		const timeArr = document.querySelectorAll('input[name=time]');
		const timeStr = '<%= reservation.getTime() %>';
		
		for(let j = 0; j < timeArr.length; j++) {
			const val = timeArr[j].value;
			
			const result = timeStr.search(val);
			if(result >= 0) {
				timeArr[j].checked = true;
			}
		}
	</script>

<script>		
	const arr = document.querySelectorAll(".imsi");
	const dateArea = document.querySelector("#resDate");
	
	arr.forEach(element => {
		element.addEventListener("click", function(e){
			/* function(변수) 에서 변수 == 이벤트 객체 */
			var date = $('input[name="date"]').val();
			var time = $('input[name="time"]:checked').val();
			
			if(date == "" && time != null) {
				alert("날짜를 먼저 선택해 주세요.")
				e.target.checked = false;
			}
		});
	});
	
	window.onload = reClick();
	
	function reClick() {
		for(let i = 0; i < 15; ++i) {
			const s = $("input[name=time]")[i].id;
			if(parseInt(s) < <%= open %> || <%= close %> < parseInt(s)) {
				$('#' + s).attr("disabled", true)
			}
		}
	};
	
	$('a[href="#coupon"]').click(function(event) {
	      event.preventDefault();
	      callCouNo()
	    });
	
	function timeCheck(){
		$.ajax({
			url: "/semiPrj/res/time",
			method: "GET",
			data: {
				date : $('#resDate').val(),
				rNo : <%=rno%>
			},
			success: function(time){
				if(time != null) {
					const flag1 = time.includes("0900");
					if(flag1 == true) {$('#0900').attr("disabled", true)} else {$('#0900').attr("disabled", false)}
					const flag2 = time.includes("1000");
					if(flag2 == true) {$('#1000').attr("disabled", true)} else {$('#1000').attr("disabled", false)}
					const flag3 = time.includes("1100");
					if(flag3 == true) {$('#1100').attr("disabled", true)} else {$('#1100').attr("disabled", false)}
					const flag4 = time.includes("1200");
					if(flag4 == true) {$('#1200').attr("disabled", true)} else {$('#1200').attr("disabled", false)}
					const flag5 = time.includes("1300");
					if(flag5 == true) {$('#1300').attr("disabled", true)} else {$('#1300').attr("disabled", false)}
					const flag6 = time.includes("1400");
					if(flag6 == true) {$('#1400').attr("disabled", true)} else {$('#1400').attr("disabled", false)}
					const flag7 = time.includes("1500");
					if(flag7 == true) {$('#1500').attr("disabled", true)} else {$('#1500').attr("disabled", false)}
					const flag8 = time.includes("1600");
					if(flag8 == true) {$('#1600').attr("disabled", true)} else {$('#1600').attr("disabled", false)}
					const flag9 = time.includes("1700");
					if(flag9 == true) {$('#1700').attr("disabled", true)} else {$('#1700').attr("disabled", false)}
					const flag10 = time.includes("1800");
					if(flag10 == true) {$('#1800').attr("disabled", true)} else {$('#1800').attr("disabled", false)}
					const flag11 = time.includes("1900");
					if(flag11 == true) {$('#1900').attr("disabled", true)} else {$('#1900').attr("disabled", false)}
					const flag12 = time.includes("2000");
					if(flag12 == true) {$('#2000').attr("disabled", true)} else {$('#2000').attr("disabled", false)}
					const flag13 = time.includes("2100");
					if(flag13 == true) {$('#2100').attr("disabled", true)} else {$('#2100').attr("disabled", false)}
					const flag14 = time.includes("2200");
					if(flag14 == true) {$('#2200').attr("disabled", true)} else {$('#2200').attr("disabled", false)}
					const flag15 = time.includes("2300");
					if(flag15 == true) {$('#2300').attr("disabled", true)} else {$('#2300').attr("disabled", false)}
					reClick();
				}
			},
			error: function(){
				console.log("error");
				return;
			}
		})
	};
	// request focus => 값 비워 주는 함수
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>