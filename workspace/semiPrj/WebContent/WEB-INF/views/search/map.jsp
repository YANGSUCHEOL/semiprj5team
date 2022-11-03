<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAP</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css" />
<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.6.3/dist/sweetalert2.all.min.js"></script>
<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
  />
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap')
	;

html, body {
	position: relative;
	height: auto;
}

body {
	letter-spacing: -0.1em;
}

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
	padding: 50px;
	justify-content: center;
	align-items: center;
	text-align: center;
	grid-template-columns: 1fr;
	grid-template-rows: repeat(2, minmax(20px, auto));
	background: #FFFFFF;
	border: 1px solid #DEDEDE;
	border-radius: 10px;
	row-gap: 30px;
	padding-top: 100px;
}

.swiper-slide img {
	width: 80%;
	height: 80%;
	object-fit: cover;
}

.btn-common {
	display: flex;
	width: 100px;
	height: 40px;
	justify-content: center;
	align-items: center;
	background: #FFFFFF;
	border: 1px solid #DEDEDE;
	border-radius: 20px;
	font-size: 17px;
	font-weight: 400;
}

a {
	text-decoration: none;
	color: black;
}

#district-view {
	grid-row: 1/3;
}

#district-result {
	display: grid;
	grid-template-columns: 1fr 1.5fr;
	grid-template-rows: 1fr;
}

.res-photo, .res-name, .res-time {
	grid-column: 1/3;
}

.res-photo, .res-name {text-align: center;}
.res-score {text-align: right;}
.res-name {font-weight: bold; font-size: 13pt;}

.district-res {
	width: 60%;
	border-radius: 10px;
	display: grid;
	grid-template-columns: 1fr 1fr;
	grid-template-rows: 40% 20% 20% 20%;
	row-gap: 5px;
	align-items: center;
}

.wrapper {
	max-width: 600px;
	width: 75%;
	margin: 0 auto;
}

.swiper {
	width: 100%;
	height: 100%;
}

.swiper-container{
    width: 80%;
    padding-left: 50px;
    padding-right: 50px;
}

.swiper-slide {
	max-width: 600px;
	width: 100%;
	height: 340px;
	text-align: left;
	font-size: 15px;
	background: #fff;
	border: 1px solid #DEDEDE;
	border-radius: 10px;
	/* Center slide text vertically */
	display: -webkit-box;
	display: -ms-flexbox;
	display: -webkit-flex;
	display: flex;
	-webkit-box-pack: center;
	-ms-flex-pack: center;
	-webkit-justify-content: center;
	justify-content: center;
	-webkit-box-align: center;
	-ms-flex-align: center;
	-webkit-align-items: center;
	align-items: center;
}

/**/
.swiper-slide {
	opacity: 0.5;
	transition: opacity 0.5s;
}

.swiper-slide-active {
	opacity: 1;
}

.changing {
	transition: opacity 0.3s;
	pointer-events: none;
}

.changed {
	transition: none;
}

/* pagination */
.swiper-pagination {
	position: absolute;
	bottom: -5px;
	text-align: left;
}

.igemoya {
	display: flex;
}

.parent {
	position: absolute;
	visibility: hidden;
}

/* nav btn*/
.swiper-button-prev {
	color: #c8eaec;
}

.swiper-button-next {
	color: #c8eaec;
}

/* .swiper-button-prev {
	transform: translateX(500%);
}

.swiper-button-next {
	transform: translateX(-500%);
} */

.custom-fraction {
	text-align: right;
	margin: 15px 5px 0 0;
}

#region-name {
	position: absolute;
	top: 400px;
	left: 600px;
	font-size: 25px;
}

</style>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
</head>

<body>

	<%@ include file="/WEB-INF/views/header.jsp"%>

	<div id="main">
		<div id="content">
			<div id="map" class="seoul">
			</div>
			<div id="district-result">
				<div id="district-view"><div id="region-name"></div></div>
				<div class="igemoya">
				<div class="parent">
					<div class="wrapper" id="wrapper">
						<div class="swiper swiper-container mySwiper">
							<div id="district-result-list" class="swiper-wrapper"></div>
						</div>
					</div>
					<div class="swiper-pagination"></div>
					<div class="swiper-button-next"></div>
					<div class="swiper-button-prev"></div>
					<div class="custom-fraction" id="fraction"></div>
				</div>
				</div>
			</div>
		</div>
	</div>

	<script src="resources/js/raphael-min.js"></script>
	<script src="resources/js/map.js"></script>
	<script src="resources/js/move.js"></script>
	
	<script>
	 $().ready(function() {
		 let timerInterval
		 Swal.fire({
			  title: '검색하고자 하는 지역을 눌러 주세요!',
			  showClass: {
			    popup: 'animate__animated animate__fadeInDown'
			  },
			  hideClass: {
			    popup: 'animate__animated animate__fadeOutUp'
			  },
			  confirmButtonColor: '#82A994'
			})
	 });
	</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>