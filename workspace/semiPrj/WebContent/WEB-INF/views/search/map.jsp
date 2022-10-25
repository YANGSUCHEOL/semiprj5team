<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    @import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap')
	;

* {
	font-family: 'Noto Sans KR', sans-serif;
	letter-spacing: -0.1em;
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
        	padding: 50px;
            justify-content: center;
            align-items: center;
            text-align: center;
            grid-template-columns: 1fr;
            grid-template-rows: repeat(3, minmax(70px, auto));
            background: #FFFFFF;
            border: 1px solid #DEDEDE;
            border-radius: 10px;
            row-gap: 30px;
            padding-top: 100px;
        }
        body {
            letter-spacing: -0.1em;
        }
        #msg-area {
        	position: absolute;
			justify-content: center;
			align-items: center;
		}
        #alertMsg {
			box-sizing: border-box;
			position: flex;
			justify-content: center;
			align-items: center;
			width: 222px;
			height: 189px;
			background: #FFFFFF;
			opacity: 0.7;
			border: 1px solid #DEDEDE;
			border-radius: 20px;
			line-height: 200%;
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
    </style>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
</head>

<body>

	<%@ include file="/WEB-INF/views/header.jsp" %>

    <div id="main">
        <div id="sidebar"></div>
        <div id="content">
<!--         	<form action="/semiPrj/district" method="get" id="frm"> -->
	        <div id="map" class="seoul">
	        </div>
<!-- 	        <input type="hidden" id="district" name="district" value="">
	        </form> -->
	        <div id="district-result">
	        	<div id="district-view"></div>
	        	<div id="district-result-list"></div>
	        </div>
			<div id="msg-area">
				<div id="alertMsg">
					<span>찾고자 하는 지역을<br>눌러 주세요!<br></span><br><button class="btn-common" onclick="없어지는이벤트();">확인</button>
				</div>
			</div>
		</div>
    </div>
    
    <script src="resources/js/raphael-min.js"></script>
	<script src="resources/js/map.js"></script>
    
</body>
</html>