<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp" %>
    <%
    	String msg = (String)request.getAttribute("msg");
    %>
    
    <h1>에러페이지</h1>
	<h2><%= msg %></h2>
	<a href="/semiPrj">홈으로 돌아가기</a>
	
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>