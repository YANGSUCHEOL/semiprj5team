package com.kh.semiPrj.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.community.service.CommuService;

@WebServlet(urlPatterns = "/community/delete")
public class CommuDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//데이터 꺼내기
		String bno = req.getParameter("bno");
		
		
		//디비 다녀오기
		int result = new CommuService().delete(bno);
		
		//화면 선택
		if(result == 1){
			//성공 -> 알람, 리스트 조회
			req.getSession().setAttribute("alertMsg", "게시글 삭제 성공!");
			resp.sendRedirect("/semiPrj/community/list?pno=1");
		} else {
			//실패 -> 메시지, 에러페이지
			req.setAttribute("msg", "게시글 삭제 실패...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
				
	
	}//get
	
}
