<%@page import="com.kh.vegan.admin.vo.AdminVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	AdminVo admin = (AdminVo)session.getAttribute("admin");
	//로그인 멤버 자리
	String alertMsg = (String)session.getAttribute("alertMsg");
	session.removeAttribute("alertMsg");
	String root = request.getContextPath();
%>

<script>
	<%if(alertMsg != null){%>
		alert('<%= alertMsg %>');
	<%}%>
</script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>