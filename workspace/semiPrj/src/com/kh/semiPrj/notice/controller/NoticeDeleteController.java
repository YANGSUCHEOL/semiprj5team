package com.kh.semiPrj.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.notice.service.NoticeService;

@WebServlet(urlPatterns = "/notice/delete")
public class NoticeDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//데이터 꺼내기
		String no = req.getParameter("no");
		
		//삭제는 디비 가서 쿼리 실행만 하면 됨
		int result = new NoticeService().delete(no);
		
		//화면 선택
		if(result == 1) {
			//삭제 성공
			req.getSession().setAttribute("alertMsg", "공지사항 삭제 성공!");
			resp.sendRedirect("/semiPrj/notice/list");
			
		} else {
			//삭제 실패
			req.setAttribute("msg", "공지사항 삭제 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
	
	
	
	}//get
	
}
