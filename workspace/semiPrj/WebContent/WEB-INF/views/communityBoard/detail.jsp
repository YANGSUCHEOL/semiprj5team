<%@page import="com.kh.semiPrj.community.vo.AttachmentVo"%>
<%@page import="com.kh.semiPrj.community.vo.CategoryVo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.semiPrj.community.vo.CommuVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	CommuVo vo = (CommuVo)request.getAttribute("vo");
	List<CategoryVo> cateList = (List<CategoryVo>)request.getAttribute("cateList");
	AttachmentVo attVo = (AttachmentVo)request.getAttribute("attachmentVo");
	if(attVo == null){
		attVo = new AttachmentVo();
	}
	
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GET EAT VEGAN</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  	<script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
  	
    <style>
        #main{
            width: 60vw;
            height: 70vh;
            margin: 0 auto;
            border: 1px solid lightgray;
            border-radius: 10px;
        	padding: 50px;
        	width: 70vw;
        	height: 80%;
        	overflow: auto; 
        }

        #commu {
            padding: 20px;
            border-bottom: 1px solid lightgray;
        }

        #title1{
            box-sizing: border-box;
            display: grid;
            grid-template-columns: 2fr 1fr 1fr 1fr 1fr;
            grid-template-rows: 30px;
            text-align: left;
            --border-bottom: 1px solid lightgray;
            margin: 20px auto;
            padding: 20px;
            font-size: 18px;
        }

        #content{
            box-sizing: border-box;
            display: grid;
            grid-template-rows: 300px;
            --border: 1px solid black;
            margin: 0 auto;
            padding: 20px;
        }
        
        #img {
        	padding-top: 20px;
        	width: 100%;
        	height: 50%;        
        }

        .btn{
            margin-right: 10px;
            background-color: #EEFFF6;
	        color: black;
	        border: 1px solid #EEFFF6;
	        font-size: 12px;
        }
        
        .btn:hover {
        	border: 1px solid #e0fbed;
        	background-color: #e0fbed;
    	}
        
        #insert-btn {
            background-color: #EEFFF6;
            color: black;
            border: 1px solid #EEFFF6;
            font-size: 12px;
            --margin-top: 10px;
            --float: right;

        }

        #insert-btn:hover {
            background-color: #e0fbed;
        }
        
        .cmt{
            --border: 1px solid rgb(153, 153, 153); 
            margin: 20px auto;
            box-sizing: border-box;
            height: 100%;
            width: 100%;
            resize: none;

        }

        .cmt > textarea {
			
            width: 100%;
            height: 100px;
            outline: none;
            resize: none;
        }

		
        #reply-content-area {
            height: 100px;
            --border: 1px solid lightgray;
			padding: 10px;
        }
        
        #reply-info {height: 30%;}
        #reply-info2 {height: 70%;}

    </style>



</head>

<body>
	<%@ include file="/WEB-INF/views/header.jsp" %>
<div id="main">
        <div id="commu">
            <h4>COMMUNITY🌱</h4>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
	            <button class="btn btn-outline-secondary me-md-2" type="button" onclick="location.href='/semiPrj/community/list?pno=1'">목록</button>
	           	<%if(loginMember != null && loginMember.getNick().equals(vo.getWriter())){%>
		            <a href="/semiPrj/community/edit?bno=<%= vo.getNo()%>" class="btn btn-outline-secondary me-md-2" type="button">수정</a>
		            <a href="/semiPrj/community/delete?bno=<%= vo.getNo()%>" class="btn btn-outline-secondary" type="button">삭제</a>
				<%}%>
        	</div>
        </div>

        <div id="title1">
            <div><b><%= vo.getTitle() %></b></div>
            <div id="category"><%= vo.getCategory() %></div>
            <div><%= vo.getEnrollDate() %></div>
            <div><%= vo.getWriter() %></div>
            <div><%= vo.getHit() %></div>
        </div>
		<hr>
        <div id="content-box">
        	<div id="img"><img src="/semiPrj/<%= attVo.getFilePath()%>/<%= attVo.getChangeName()%>" onerror="this.style.display='none'"/></div>
            <div id="content"><%= vo.getContent() %></div>
        </div>

        <hr>

		<div id="reply-board">
	        <div class="comment" id="reply-list-area">
	            <div id="reply-content-area">
					<div id="reply-info">작성자 | 작성일자</div>
					<div id="reply-info2">댓글 내용</div>
				</div>
			<hr>
	        </div>
		</div>
			
			 <form id="frm-cmt">
			        
					<%if(loginMember != null) {%>
			           <div class="cmt">
			               <textarea name="replyContent" id="replyContent" required placeholder="댓글을 작성해 주세요"></textarea>
			               <button type="button" class="btn btn-success" id="insert-btn" onclick="return insertReply(); location.href='/semiPrj/communityBoard/detail?bno=<%= vo.getNo()%>'">등록</button>
			           </div>
			          	<%}else{ %>
			           <div class="cmt">
			               <textarea readonly>댓글은 로그인 후 작성하실 수 있습니다.</textarea>
			           </div>
			           <%} %>
			   </form>
       
</div>			

</div>

    

    

    <script>
    
    $(function() {
    	selectReplyList();
    	setInterval(selectReplyList, 1000);   	
	})
    
    

        function insertReply(){
        $.ajax({
        	
        	url: "/semiPrj/replyInsert",
            type: "post",
            data: {
                content : $("#replyContent").val(),
                commuNo : <%= vo.getNo() %>
            },
            success: function(result){

                // result 가 1 이라면 성공 / 0 이라면 실패
                if (result > 0) { // 댓글작성 성공
                	alert("댓글이 등록됐습니다.");
                
                    // 갱신된 댓글 리스트 조회
                    selectReplyList();
                    
                    // textarea 초기화
                    $("#replyContent").val("");
                    return true;
                }
                else { // 댓글작성 실패
                    alert("댓글 등록에 실패했습니다.");
                return false;
                }
            },
            
            error: function(){
                console.log("댓글 작성 ajax 통신 실패!");
            }
        	
        	
        });
    	
        }//insertReply
        
      
       
        
		function selectReplyList(){
        	$.ajax({
        	url: "/semiPrj/selectReplyList",
        	data: {
        	commuNo : <%= vo.getNo() %>
        	},
        	success: function (result) {
        	let resultStr="";
	        	for (let i in result) {
	        	resultStr+=
	        	'<div class="comment" id="reply-list-area">'+
	        	'<div id="reply-content-area"'+
	        	'<div id="reply-info">' + result[i].Nick + result[i].enrollDate +'</div>'+
	        	'<div id="reply-info2">'+ result[i].content +'</div>'+ '</div>' + '</div>' + '<hr>';
	        	}
        	$("#reply-board").html(resultStr);
        	},
        	
        	error: function () {
        	console.log("댓글 리스트 ajax 통신 실패!");
        	}
        	
        	});
        	}//selectReplyList


    </script>




    
</body>
</html>