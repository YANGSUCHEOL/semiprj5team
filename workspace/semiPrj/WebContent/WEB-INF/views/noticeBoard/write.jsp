<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GET EAT VEGAN</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">


<style>
    .outer{
       background: white;
       color: black;
       width: 60%;
       height: 550px;
       margin: auto;
       padding-top: 50px;
    }
 
    #enroll-form table{border: 1px solid white; margin:auto;}
    #enroll-form input, #enroll-form textarea{
       width: 100%;
       box-sizing: border-box;
    }

    #submit-btn {
        background-color: #EEFFF6;
        color: black;
        border: 1px solid #EEFFF6;
        font-size: 12px;
    }

    #submit-btn:hover {
        background-color: #e0fbed;
    }

    #title {
        border: 1px solid white;
        border-bottom: 1px solid rgb(217, 217, 217);
        margin-bottom: 10px;
    }

    #content {
        border: 1px solid rgb(217, 217, 217);
    }

    input:focus {outline: none;}
    textarea:focus {outline: none;}
    

    #title-th {
        padding-top: 10px;
    }

    #content-th {
        padding-bottom: 250px;
    }
    
    th {
        font-size: 18px;
        font-weight: 400;
        padding: 10px;
    }

    .btn-close {
        margin-left: 30px;

    }

	#reset {
		outline: none;
	}

 
 </style>
 
</head>
<body>

    

    <div id="main">

        <div class="outer">
          <br>
          <h2 align="center">NOTICE🌱</h2>
          <br>
  
            <form id="enroll-form" action="" method="post">
                <button type="reset" class="btn-close" aria-label="Close" id="reset"></button>
                <br><br>
                <!-- 카테고리, 제목, 내용, 첨부파일 한개 -->
                <table>
                    
                    <tr>
                        <th id="title-th">제목</th>
                        <td width="500px"><input type="text" name="title" required id="title"></td>
                    </tr>
                    <tr>
                        <th id="content-th">내용</th>
                        <td><textarea name="content" rows="10" style="resize:none;" required id="content"></textarea></td>
                    </tr>
        
                </table>
                <br><br>
                <div align="center">
                    <button type="submit" class="btn btn-success" id="submit-btn">작성하기</button>
                </div>
  
            </form>
          
         </div>
  
     </div>
  



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>    
</body>
</html>