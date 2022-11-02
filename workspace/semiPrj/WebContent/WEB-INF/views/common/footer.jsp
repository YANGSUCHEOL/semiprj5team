<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style>
	footer{
		margin-top: 150px;
		border-top: 1px solid #DEDEDE;
	}
	footer>div{
		margin:20px;
	}
	#footer-wrap{
		display:grid;
	 	grid-template-columns: 2fr 8fr;
	}
	
	#logo{
		margin-left:50px;
		justify-content:center;
	}
	
	#navi{
		font-size: 18px;
		--color: #DEDEDE;
	}
	#navi>a{
		color: black;
	}
</style>
</head>
<body>
	
	<footer>
		<div id="footer-wrap">
			<div id="logo"><img src="/semiPrj/resources/img/footerlogo.png"></div>
			<div id="navi">
				<br>
				<a href="https://github.com/YANGSUCHEOL/semiprj5team"><i class="fa-brands fa-github"></i>GitHub</a>
				&nbsp;&nbsp;&nbsp;
				<a href=""><i class="fa-solid fa-envelope"></i>Email</a>
				<br><br>
				<span>겟 잇 비건 GET EAT VEGAN</span>
				<br>
				<span>Copyright 2022. ㅇㅈ? ㅇㅈ!. All rights reserved.</span>
			</div>
			
			<div id="text">
				
			</div>
		</div>
	</footer>
</body>
</html>