<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%
    	String msg = (String)request.getAttribute("msg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error page</title>

<style>
	#main{
		width: 60vw;
		margin: 0 auto;
	
	}

</style>

</head>

	<%@include file="/views/common/header.jsp" %>
	
	<div id="main">
		<h1>에러페이지!!!</h1>
		<h2><%= msg %></h2>	
		<a href="/semiPrj">홈으로 돌아가기</a>
	</div>

</body>
</html>