<%@page import="com.kh.semiPrj.member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% MemberVo member = (MemberVo)session.getAttribute("loginMember"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<style>
.chat-btn {
	position: fixed;
	width: 77px;
	height: 77px;
	bottom: 5%;
	right: 5%;
	border: 1px solid #DEDEDE;
	border-radius: 50%;
	background: none;
}

.btn-image {
	width: 100%;
	height: 100%;
	object-fit: cover;
}

.btn-image:hover {
	
}

.chat-area {
	position: fixed;
	width: 500px;
	height: 700px;
	opacity: 0.97;
	border-radius: 20px;
	background: #ffffff;
	border: 1px solid #DEDEDE;
	bottom: 5%;
	right: 10%;
	z-index: 1;
	display: none;
}
.alert {
	width: 100%;
	height: 90%;
	border-radius: 20px;
	overflow: auto;
}
#chat-header {
	width: 100%;
	height: 10%;
	background-color: #FCFFED;
	border-radius: 20px;
	display: flex;
	justify-content: center;
	align-items: center;
	position: sticky;
}
.chat-alert {
	padding: 10px 30px 10px 30px;
	display: grid;
	grid-template-columns: 50px 1fr;
	column-gap: 10px;
}
.chat-client {
	padding: 10px 30px 10px 30px;
	display: flex;
	min-height: 50px;
}
.bubble-client {
	width: 100%;
}
.bubble-room-guide {
	width: 100%;
	cursor: pointer;
}
.bubble {
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 8px;
	border: 1px solid #DEDEDE;
	border-radius: 10px;
}

#alert2, #alert3 {
	visibility: hidden;
}

#alert1 {
	padding-top: 20px;
}

#chat-connect-btn {
	display: none;
	padding: 10px;
	justify-content: space-evenly;
	align-items: center;
}

.btn-common {
	display: block;
	min-width: 70px;
	padding: 10px 10px;
	background-color: #FFFFFF;
	border: 1px solid #DEDEDE;
	border-radius: 20px;
	font-size: 17px;
	font-weight: 400;
	cursor: pointer;
}
.btn-common:hover {
	color: gray;
}
#chat-room {
	width: 100%;
	height: 75%;
	overflow: auto;
	flex-direction: column;
	display: none;
}
#input-area {
	width: 100%;
	height: 15%;
	display: none;
	align-content: space-between;
	grid-template-columns: 0.8fr 0.2fr;
	grid-template-rows: 0.2fr 0.8fr;
	border: none;
	position: fixed;
	bottom: 0;
}
#input-area>div:nth-child(2) {
	display: flex;
	justify-content: center;
	align-items: center;
}
#chat-client {
	height: 100%;
	font-size: 16px;
	border: 1px solid white;
	resize: none;
	border-radius: 10px;
	padding-left: 5px;
}
#submit {
	border: none;
	height: 100%;
	border-radius: 10px;
}
#submit:hover {
	background-color: #FCFFED;
	border-radius: 10px;
}
.guide {
	display: flex;
	padding: 5px 30px 5px 30px;
	justify-content: center;
	align-items: center;
	color: gray;
}
#end-btn {
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 12px;
	width: 40px;
	height: 20px;
	border-radius: 10px;
}
a {
	text-decoration: none;
	color: black;
}
#guide1, #guide2, #guide3, #bubble1 {
	visibility: hidden;
}
#guide1 {
	padding-top: 20px;
}
</style>
</head>
<body>
	<div>
		<button class="chat-btn" id="toggle-area">
			<img class="btn-image" src="/semiPrj/resources/img/livechat.png">
		</button>
	</div>
	<% if(member != null && member.getId().equals("admin")) { %>
	<div>
		<div id="admin-chat-area" class="chat-area animate__animated animate__zoomInLeft">
			<div id="chat-header">
				<h3>∘✧₊⁺관리자 상담실⁺₊✧∘</h3>
			</div>
			<div id="admin-alert" class="alert">
				<div id="alert1" class="guide">어서 오세요, 노예야. 채팅방에 입장해 주세요.</div>
			</div>
		</div>
	</div>
	<% } else { %>
	<div>
		<div id="chat-area" class="chat-area animate__animated animate__zoomInLeft">
			<div id="chat-header">
				<h3>∘✧₊⁺온라인 상담실⁺₊✧∘</h3>
			</div>
			<div id="alert">
				<div id="alert1" class="chat-alert">
					<div>
						<img src="./resources/img/admin.png">
					</div>
					<div class="bubble">어서오세요. 겟잇비건 온라인 상담실입니다.</div>
				</div>
				<div id="alert2" class="chat-alert">
					<div>
						<img src="./resources/img/admin.png">
					</div>
					<div class="bubble">
						채팅 연결 전에&nbsp<a href="">FAQ</a>&nbsp를 확인해 주세요.
					</div>
				</div>
				<div id="alert3" class="chat-alert">
					<div>
						<img src="./resources/img/admin.png">
					</div>
					<div class="bubble">채팅 신청을 하시겠습니까?</div>
				</div>
				<div id="chat-connect-btn">
					<input type="hidden" id="roomNum" value="">
					<button class="btn-common" onclick="hide_area()">예</button>
					<button class="btn-common" onclick="stop()">아니오</button>
				</div>
			</div>
			<div id="chat-room">
				<div id="guide1" class="guide">근무 사정에 따라 연결이 지연될 수 있습니다.</div>
				<div id="guide2" class="guide">연결 중입니다 ... ጿ ኈ ቼ ዽ ጿ ኈ ቼ ዽ ጿ 💭</div>
				<div id="guide3" class="guide">연결되었습니다.</div>
				<div id="bubble1" class="chat-alert">
					<div>
						<img src="./resources/img/admin.png">
					</div>
					<div class="bubble">안녕하세요. 무엇을 도와드릴까요?</div>
				</div>
			</div>
			<div id="input-area">
				<div></div>
				<div><button id="end-btn" class="btn-common" onclick="stopIt()">종료</button></div>
				<textarea id="chat-client" placeholder="문의할 내용을 입력해 주세요."></textarea><button id="submit" disabled="true">전송</button>
			</div>
		</div>
	</div>
	<% } %>

	<script>
	$('#toggle-area').click(function() {
		$('#admin-chat-area').toggle();
		roomGuide();
		$('#chat-area').toggle();
		show_area();
	})
	
	function roomGuide() {
		$.ajax({
			url: "/semiPrj/chat/roomguide",
			method: "get",
			success: function(e){
				var data = JSON.parse(e);
				$.each(data, function(i, item){
					var cmd = '<div class="chat-client"><div class="bubble bubble-room-guide" onclick="roomEnter(this)">' + item + ' 번 채팅방 입장하기</div></div>';
					$("#admin-alert").append(cmd);
				})
			},
			error: function() {
				console.log('room error !');
			}
		})
	}
	
	$('.bubble-room-guide').on('click', function() {
		var target = $(this);
		console.log(target);
/* 		target.querySelector('.bubble-room-guide').innerText;
		console.log(target.querySelector('.bubble-room-guide').innerText); */
	})
	
	
	function roomEnter(room) {
		$('#admin-alert').toggle();
/* 		$('').toggle(); */
		console.log(room.innerText);
		var text = room.innerText;
		text = text.split(' ');
		console.log(text[0]);
		$.ajax({
			url: "/semiPrj/chat/list",
			method: "get",
			data: {
				num: text[0]
			},
			success: function(e) {
				var data = JSON.parse(e);
				console.log(data);
/* 				$.each(data, function(i, item) {
					
				}) */
			},
			error: function() {
				console.log('room enter error !');
			}
		})
	}
	
	function chatRefresh() {
		$.ajax({
			url: "/semiPrj/chat/admin",
			method: "get",
			data: {
				room: $('#roomNum').val()
			},
			success: function(e){
				if(e.length >= 1) {
					var s = '<div class="chat-alert"><div><img src="./resources/img/admin.png"></div><div class="bubble">' + e + '</div></div>';
					$('#chat-room').append(s);
					$('#chat-room').scrollTop($('#chat-room')[0].scrollHeight);
				} else if (e == '') {
					console.log('connect success !');
				}
			},
			error: function() {
				console.log('refresh error');
			}
		})
	}
	
	var refresh = null;
	
	// 전송 버튼 누르면 client 채팅 내역이 db 안으로 + 동시에 출력
	$('#submit').click(function() {
		$.ajax({
			url: "/semiPrj/chat/client",
			method: "get",
			data: {
				chat: $('#chat-client').val(),
				room: $('#roomNum').val(),
				mno: 2
			},
			success: function(e) {
				var s = '<div class="chat-client"><div class="bubble bubble-client">' + e + '</div></div>';
				$('#chat-room').append(s);
				$('#chat-client').val('');
				$('#chat-room').scrollTop($('#chat-room')[0].scrollHeight);
			},
			error: function(){
				console.log('error');
			}
		})
	})
	
	function stopIt() {
		clearInterval(refresh);
		$('#submit').attr('disabled', 'true');
		var s = '<div class="guide">상담이 종료되었습니다. 5초 뒤에 채팅창이 닫힙니다.</div>';
		$('#chat-room').append(s);
		setTimeout(function() {
			$('#chat-area').css('display', 'none');
		}, 5000);
	}
	function stop() {
		var s = '<div class="guide">상담이 종료되었습니다. 5초 뒤에 채팅창이 닫힙니다.</div>';
		$('#alert').append(s);
		setTimeout(function() {
			$('#chat-area').css('display', 'none');
		}, 5000);
	}
	
	function show_area() {
		setTimeout(function() {
			$('#alert2').css('visibility', 'visible');
		}, 2000);
		setTimeout(function() {
			$('#alert3').css('visibility', 'visible');
		}, 4000);
		setTimeout(function() {
			$('#chat-connect-btn').css('display', 'flex');
		}, 5000);
	}
	
	const loginMember = '<%= member %>';
	
	function couCheck(){
 		if(loginMember != 'null'){
  			hide_area()
        } else {
            document.getElementById("header-login").click();
        }
    }
	
	function hide_area() {
		$('#alert').css('display', 'none');
		$('#chat-room').css('display', 'inline-block');
		$('#input-area').css('display', 'grid');
		setTimeout(function() {
			$('#guide1').css('visibility', 'visible');
		}, 1000);
		setTimeout(function() {
			$('#guide2').css('visibility', 'visible');
		}, 2000);
		setTimeout(function() {
			$('#guide3').css('visibility', 'visible');
		}, 5000);
		setTimeout(function() {
			$('#bubble1').css('visibility', 'visible');
		}, 6000);
		setTimeout(function() {
			$('#submit').attr('disabled', false);
		}, 5000);
		$.ajax({
			url: "/semiPrj/chatroom",
			method: "get",
			success: function(num){
				$('#roomNum').val(num);
			},
			error: function(){
				console.log('error');
			}
		})
		refresh = setInterval(chatRefresh, 3000);
	}
</script>
</body>
</html>