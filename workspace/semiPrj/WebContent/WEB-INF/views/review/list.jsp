<%@page import="common.PageVo"%>
<%@page import="com.kh.semiPrj.review.vo.ReviewVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<ReviewVo> voList = (List<ReviewVo>)request.getAttribute("review");
	PageVo pv = (PageVo)request.getAttribute("pv");
	String resNo = (String)session.getAttribute("resNo");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../resources/css/style.css">
    <style>
    @import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap')
	;

* {
	font-family: 'Noto Sans KR', sans-serif;
	letter-spacing: -0.1em;
}
        body {
            letter-spacing: -0.1em;
            font-size: 16px;
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
            align-items: center;
            grid-template-rows: repeat(3, minmax(70px, auto));
            background: #FFFFFF;
            border: 1px solid #DEDEDE;
            border-radius: 10px;
        }
        #navigate {
            display: grid;
            grid-template-columns: 1fr 5fr 1.5fr;
            border-bottom: 1px solid lightgray;
            align-items: center;
            padding: 20px;
            margin-left: 100px;
            margin-right: 100px;
            margin-bottom: 50px;
        }
        #backspace {
            margin-left: 100px;
            padding-top: 80px;
            padding-bottom: 20px;
        }
        .review-list {
            display: grid;
            grid-template-rows: repeat(6, auto);
            row-gap: 40px;
        }
        .review {
            border: 1px solid #DEDEDE;
            border-radius: 10px;
            padding: 30px;
            display: grid;
            margin-left: 100px;
            margin-right: 100px;
            grid-template-columns: 60px 3fr minmax(100px, auto);
            grid-template-rows: 30px 30px minmax(30px, auto);
            column-gap: 10px;
        }
        .btn-block {
        	width: 60px;
        	height: 40px;
        	line-height: 14px;
        }
        .page {
            display: flex;
            align-items: center;
            justify-content: center;
            margin: auto;
            padding: 50px;
        }
        .rev-nickname, .rev-best {
            display: flex;
            align-items: center;
        }
        .rev-day {
            grid-column: 1/4;
            display: flex;
            align-items: center;
        }
        .rev-content {
            grid-column: 1/4;
            margin-left: 30px;
            line-height: 200%;
        }
        div[name="more-btn"] {
            text-align: right;
        }
        .none {
			text-align: center;
        }
        .active {
        	font-family: "Poppins", Arial, sans-serif;
		    color: gray;
		    text-align: center;
		    display: inline-block;
		    width: 40px;
		    height: 40px;
		    line-height: 40px;
		    border-radius: 50%;
		    border: 1px solid #e6e6e6;
        }
        .active:hover {
        	background-color: #EEFFF6;
        	color: #e6e6e6;
        }
        .btn.btn-primary {
        	background: #EEFFF6;
        	border-color: #EEFFF6;
        	color: black;
        }
        .btn.btn-primary:hover, .btn.btn-primary:focus {
        	background: #d1edee !important;
        	border-color: #d1edee !important;
        	color: gray;
        }
    </style>
</head>
<body>

<%@ include file="/WEB-INF/views/header.jsp" %>

    <div id="main">
        <div id="sidebar"></div>
        <div id="content">
            <div id="backspace">
            <a href="/semiPrj/search/detail?rno=<%= resNo %>">뒤로 가기</a>
            </div>
            <div id="navigate">
                <div><span>사용자 리뷰</span></div>
                <div><span></span></div>
            </div>
            <div class="review-list">
                <% if(voList.size() != 0) { %>
					<%for(int i = 0; i < voList.size(); ++i){%>
						<div class="review">
							<div class="rev-nickname"><%= voList.get(i).getWriter() %></div>
							<div class="rev-best">★ <%= voList.get(i).getScore() %></div>
							<div class="col-md-3 rev-button">
								<div class="dropdown d-block">
									<button class="btn mb-2 mb-md-0 btn-primary btn-block btn-round dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
											    …
									</button>
									<div class="dropdown-menu dropdown-menu-left" aria-labelledby="dropdownMenuButton">
										<a class="dropdown-item" href="#">자세히 보기</a>
										
										<!-- 여기부터 로그인했을 때만 보이는 버튼들 (수정, 삭제) -->
										<% if(loginMember != null) { %>
										
											<!-- 리뷰 writer와 로그인한 사람 닉네임이 같을 때, 혹은 로그인한 사람이 관리자일 때 -->
											<% if(voList.get(i).getWriter().equals(loginMember.getNick()) || loginMember.getId().equals("admin")) { %>
												<a class="dropdown-item" href="/semiPrj/review/edit?no=<%= voList.get(i).getNo() %>
												<% if(voList.get(i).getReNo() != null) { // 리뷰에 예약 내역 있을 때 (없을 때는 값 안 넣게) %>
												&reno=<%= voList.get(i).getReNo() %>
												<% } %>
												">수정하기</a>
												
												<!-- 여기는 리뷰 넘버랑 지금 uri 받아서 넘겨서 삭제 -->
												<form action="/semiPrj/review/delete" method="post" id="deleteForm">
												<input type="hidden" name="no" value="<%= voList.get(i).getNo() %>">
												<input type="hidden" name="uri" id="deleteuri" value="">
												<button class="dropdown-item" type="button" onclick="reviewDelete()">삭제하기</a>
												</form>
											<% } %>
										<% } %>
										<!-- 여기까지 끝 -->
									</div>
								</div>
							</div>
							<div class="rev-day"><%= voList.get(i).getUpdateDate() %></div>
					        <div class="rev-content"><%= voList.get(i).getContent() %></div>
					    </div>
					<% } %>
				<% } else if(voList.size() == 0) { %>
						<div class="none"><span>작성된 리뷰가 없습니다.</span></div>
				<% } %>
			</div>
				
                <div class="page">
                
                <%if(pv.getStartPage() != 1){%>
	        		<a href="/semiPrj/review/list?pno=<%=pv.getStartPage()-1%>&rno=<%= resNo %>" class="active"><</a>
		       	<%}%>
	        
		        <%for(int i = pv.getStartPage(); i <= pv.getEndPage(); ++i){%>
		        	<a href="/semiPrj/review/list?pno=<%=i%>&rno=<%= resNo %>" class="active"><%=i%></a>
		        <%}%>
		        
		        <%if(pv.getEndPage() != pv.getMaxPage()){%>
			        <a href="/semiPrj/review/list?pno=<%=pv.getEndPage()+1%>&rno=<%= resNo %>" class="active">></a>
		        <%}%>
                
                </div>
            </div>
        </div>
    </div>
    
    <script src="../resources/js/jquery.min.js"></script>
    <script src="../resources/js/popper.js"></script>
    <script src="../resources/js/bootstrap.min.js"></script>
    <script src="../resources/js/main.js"></script>
    
    <script>
    const deleteForm = document.getElementById("deleteForm");
    function reviewDelete() {
    	document.getElementById('deleteuri').value = sessionStorage.getItem("requestURI");
    	Swal.fire({
			  title: '리뷰를 삭제하시겠습니까?',
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#82A994',
			  cancelButtonColor: 'gray',
			  confirmButtonText: '삭제해 주세요!',
			  cancelButtonText: '창 닫기'
			}).then((result) => {
				if (result.isConfirmed) {
  			deleteForm.submit();
				}
			})
    }
    </script>
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>

</html>