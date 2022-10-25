
<%@page import="com.kh.semi.Prj.member.MemberVo"%>
<%@page import="com.kh.semiPrj.notice.vo.NoticeVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<NoticeVo> voList = (List<NoticeVo>)request.getAttribute("voList");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>notice list</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>


  <style>

table {
    border-collapse: collapse;
    border-spacing: 0;
  }
  section.notice {
    padding: 80px 0;
  }
  
  .page-title {
    margin-bottom: 60px;
  }
  .page-title h3 {
    font-size: 28px;
    color: #333333;
    font-weight: 400;
    text-align: center;
  }
  
  
  .board-table {
    font-size: 13px;
    width: 100%;
    border-top: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
  }
  
  .board-table a {
    color: #333;
    display: inline-block;
    line-height: 1.4;
    word-break: break-all;
    vertical-align: middle;
  }
  .board-table a:hover {
    text-decoration: underline;
  }
  .board-table th {
    text-align: center;
  }
  
  .board-table .th-num {
    width: 100px;
    text-align: center;
  }
  
  .board-table .th-date {
    width: 200px;
  }
  
  .board-table th, .board-table td {
    padding: 14px 0;
  }
  
  .board-table tbody td {
    border-top: 1px solid #e7e7e7;
    text-align: center;
  }
  
  .board-table tbody th {
    padding-left: 28px;
    padding-right: 14px;
    border-top: 1px solid #e7e7e7;
    text-align: left;
  }
  
  .board-table tbody th p{
    display: none;
  }

  
  /* reset */
  
  * {
    list-style: none;
    text-decoration: none;
    padding: 0;
    margin: 0;
    box-sizing: border-box;
    
  }
  .clearfix:after {
    content: '';
    display: block;
    clear: both;
  }
  .container {
    width: 60vw;
    margin: 0 auto;
  }
  .blind {
    position: absolute;
    overflow: auto;
    clip: rect(0 0 0 0);
    margin: -1px;
    width: 1px;
    height: 1px;
  }
  
   #write{
        float: right;
        margin: 10px;
        background-color: #EEFFF6;
        font-size: 12px;
    }

    #write:hover {
        background-color: #e4faee;
        border: 1px solid #e4faee;
    }

    #page-area2 {
        margin: 15px;
        margin-left: 300px;
    }

  </style>
  
</head>
<body>
<!-- 첨부파일 x, 썸네일 x
	로그인 멤버 머지하면 해야 될 일
	1. 관리자만 글쓰기 버튼 보이게 하기
	
-->

<%@ include file="/WEB-INF/views/common/header.jsp" --%>


  <section class="notice">
      <div id="notice">
        <div class="page-title">
              <div class="container">
                  <h3>NOTICE🌿</h3>
              </div>
      	</div>
        
       
       <!-- board list area -->
       <div id="board-list">
           <div class="container">
               <table class="board-table table table-hover">
                   <thead>
                   <tr>
                       <th scope="col" class="th-num">번호</th>
                       <th scope="col" class="th-title">제목</th>
                       <th scope="col" class="th-date">등록일</th>
                   </tr>
                   </thead>
                   <tbody>
                   <%for(int i = 0; i < voList.size(); ++i){%>
                       <tr>
                           <td><%= voList.get(i).getNo()%></td>
                           <th>
                               <a href="/semiPrj/notice/detail?no=<%= voList.get(i).getNo()%>"><%= voList.get(i).getTitle()%></a> 
                               <p><%= voList.get(i).getWriter()%></p>
                           </th>
                           <td><%= voList.get(i).getModifyDate()%></td>
                       </tr>	   
                  <%}%>         
                   </tbody>
               </table>
               
               
 <%--프로젝트엔 관리자만 보이게 함 --%>
 		<%if(loginMember != null && loginMember.getId().equals("admin")){%>
                <div id="main-bot">
          			 <a href="/semiPrj/notice/write" class="btn btn-light" id="write">글쓰기</a>
      			 </div>
		<%} %>
	          	
              </div>
          </div>
      </div>
    </section>
    
</body>
</html>