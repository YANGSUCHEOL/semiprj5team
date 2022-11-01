package com.kh.semiPrj.bqna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.bqna.service.BqnaService;
import com.kh.semiPrj.bqna.vo.BanswerVo;
import com.kh.semiPrj.bqna.vo.BquestionVo;
import com.kh.semiPrj.qna.service.QnaService;

@WebServlet(urlPatterns = "/bqna/editAnswer")
public class BqnaAnswerEditController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String no = req.getParameter("no");
		String bno = req.getParameter("bno");
		BanswerVo bavo = new BqnaService().selectAnswerOne(no);
	
		//화면 선택
		req.setAttribute("bavo", bavo);
		req.getRequestDispatcher("/WEB-INF/views/qna/edit/admin_b.jsp").forward(req, resp);
	}//doget
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//인코딩
		req.setCharacterEncoding("UTF-8");
		String content = req.getParameter("content");
		String no = req.getParameter("no");
		String bno = req.getParameter("bno");
		
		//
		BanswerVo bavo = new BanswerVo();
		bavo.setContent(content);
		bavo.setNo(no);
		bavo.setbNo(bno);
		
		// 디비 다녀오기
		int result = new BqnaService().edit(bavo);
		
		// 화면선택
		if(result == 1) {
			//성공 => 상세조회 //성공 알람
			req.getSession().setAttribute("alertMsg", "qna 수정 성공!");
			resp.sendRedirect("/semiPrj/bqna/adminList?pno=1");
		}else {
			//실패 => 에러페이지
			req.setAttribute("msg", "qna 수정 실패 ...");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	}
	
}
