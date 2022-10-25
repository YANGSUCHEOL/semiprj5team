package com.kh.semiPrj.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.qna.service.QnaService;

@WebServlet(urlPatterns = "/qna/delete")
public class QnaDeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//데이터 꺼내기
		String no = req.getParameter("no");
		
		//데이터 뭉치기
		
		//디비 다녀오기
		int result = new QnaService().delete(no);
		
		//화면선택
		if(result == 1) {
			//성공 => 알람 , 리스트조회
			req.getSession().setAttribute("alertMsg", "qna 삭제 성공!");
			resp.sendRedirect("/semiPrj/qna/list");
		}else {
			//실패 => 메세지 , 에러페이지
			req.setAttribute("msg", "qna 삭제 실패...");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	
	}
}
