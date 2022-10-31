<%@page import="com.kh.semiPrj.reservation.vo.ReservationVo"%>
<%@page import="com.kh.semiPrj.review.vo.ReviewVo"%>
<%@page import="com.kh.semiPrj.restaurant.vo.RestaurantVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ReviewVo vo = (ReviewVo)request.getAttribute("myReview");
	ReservationVo book = (ReservationVo)request.getAttribute("myBooking");
%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>review</title>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap')
	;

* {
	font-family: 'Noto Sans KR', sans-serif;
	letter-spacing: -0.1em;
}

#main {
	padding-top: 70px;
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
	justify-content: center;
	align-items: center;
	text-align: center;
	grid-template-rows: repeat(5, minmax(70px, auto));
	grid-template-columns: 1fr;
	background: #FFFFFF;
	border: 1px solid #DEDEDE;
	border-radius: 10px;
	padding: 10%;
	row-gap: 30px;
	padding-top: 100px;
}

#text {
	text-align: left;
	padding-left: 5%;
	font-size: 24px;
}

input[name="review"] {
	width: 48vw;
	height: 40vh;
	letter-spacing: -0.1em;
	align-self: flex-start;
}

body {
	letter-spacing: -0.1em;
}

.star-rating {
	display: flex;
	flex-direction: row-reverse;
	font-size: 2.25rem;
	line-height: 2.5rem;
	justify-content: space-around;
	align-items: center;
	padding: 0 0.2em;
	text-align: center;
	width: 5em;
}

#star {
	display: grid;
	grid-template-columns: 0.5fr 2fr 1fr;
	justify-content: center;
	align-items: center;
}

.star-rating input {
	display: none;
}

.star-rating label {
	-webkit-text-fill-color: transparent;
	-webkit-text-stroke-width: 2.3px;
	-webkit-text-stroke-color: #2b2a29;
	cursor: pointer;
}

.star-rating :checked ~ label {
	-webkit-text-fill-color: gold;
}

.star-rating label:hover, .star-rating label:hover ~ label {
	-webkit-text-fill-color: #fff58c;
}

#history {
	display: grid;
	grid-template-columns: 1fr;
}

.review-list {
	display: flex;
	justify-content: center;
	align-items: center;
}

.review-res-list {
	border: 1px solid lightgray;
	width: 80%;
}

.box-radio-input input[type="radio"] {
	display: none;
}

.box-radio-input input[type="radio"]+span {
	display: block;
	width: 100%;
	background: none;
	text-align: center;
	height: 35px;
	line-height: 33px;
	font-weight: 500;
	cursor: pointer;
}

.box-radio-input input[type="radio"]:checked+span {
	margin: 0px;
	background: #FCFFED;
	color: #000000;
}

#content>div:nth-child(1)>span {
	font-size: 20pt;
}

.forlabel {
	font-size: 15pt;
}

.review {
	width: 48vw;
	height: 40vh;
	letter-spacing: -0.1em;
	align-self: flex-start;
	resize: none;
}

</style>
</head>

<script>
	ratingToPercent() {
    	const score = +this.restaurant.averageScore * 20;
    	return score + 1.5;
	}
</script>

<body>

	<%@ include file="/WEB-INF/views/header.jsp"%>

	<div id="main">
		<form action="/semiPrj/review/edit/user" method="post">
			<div id="content">
				<div>
					<span><%= vo.getWriter() %> 님, <%= vo.getRestaurant() %>
						에서의 식사는 어떠셨나요?</span>
				</div>
				<div id="text">
					<span>예약 내역</span>
				</div>
				<div id="history">
					<% if(book != null) { %>
					<div class="review-list">
						<label class="box-radio-input review-res-list"> <input
							type="radio" name="reNo" value="<%= book.getNo() %>" checked>
							<span><%= book.getDate() %> / <%= book.getRestaurant() %>
								/ <%= book.getCnt() %> 인 / <%= book.getTime() %></span>
						</label>
					</div>
					<% } else { %>
					<div>
						<span>본 리뷰에는 예약하신 내역이 없습니다.</span>
					</div>
					<% } %>
				</div>
				<div id="star">
					<div class="forlabel">별점:</div>
					<div class="star-rating space-x-4 mx-auto">
						<input type="radio" id="5-stars" name="rating" value="5"
							v-model="ratings" /> <label for="5-stars" class="star pr-4">★</label>
						<input type="radio" id="4-stars" name="rating" value="4"
							v-model="ratings" /> <label for="4-stars" class="star">★</label>
						<input type="radio" id="3-stars" name="rating" value="3"
							v-model="ratings" /> <label for="3-stars" class="star">★</label>
						<input type="radio" id="2-stars" name="rating" value="2"
							v-model="ratings" /> <label for="2-stars" class="star">★</label>
						<input type="radio" id="1-star" name="rating" value="1"
							v-model="ratings" /> <label for="1-star" class="star">★</label>
					</div>
					<div>
						<span>공개 여부: </span><input type="radio" name="release" value="Y"
							checked>공개<input type="radio" name="release" value="N">비공개
					</div>
				</div>
				<div id="review">
					<textarea class="review" name="review" placeholder="내용을 입력해 주세요"><%= vo.getContent() %></textarea>
					<input type="hidden" name="rno" value="<%= vo.getNo() %>">
					<input type="hidden" name="mno" value="<%= loginMember.getNo() %>">
				</div>
				<div>
					<input type="submit" value="수정하기">
				</div>
		</form>
	</div>
	</div>
	
	<script>
		// 별점 체크
		const ratingArr = document.querySelectorAll('input[name=rating]');
		const ratingStr = '<%= vo.getScore() %>';
		
		for(let i = 0; i < ratingArr.length; i++) {
			const v = ratingArr[i].value;
			
			const result = ratingStr.search(v);
			if(result >= 0) {
				ratingArr[i].checked = true;
			}
		}
		
		// 공개 여부 체크
		const releaseArr = document.querySelectorAll('input[name=release]');
		const releaseStr = '<%= vo.getReleaseYn() %>';
		
		for(let j = 0; j < releaseArr.length; j++) {
			const val = releaseArr[j].value;
			
			const result = releaseStr.search(val);
			if(result >= 0) {
				releaseArr[j].checked = true;
			}
		}
	
	</script>
	
</body>

</html>