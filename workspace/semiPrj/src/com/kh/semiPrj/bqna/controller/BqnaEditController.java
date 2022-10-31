package com.kh.semiPrj.bqna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.bqna.service.BqnaService;
import com.kh.semiPrj.bqna.vo.BquestionVo;
import com.kh.semiPrj.qna.service.QnaService;
import com.kh.semiPrj.qna.vo.QuestionVo;

@WebServlet(urlPatterns = "/bqna/edit")
public class BqnaEditController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no = req.getParameter("no");
		
		BquestionVo bvo = new BqnaService().selectOne(no);
		
		//화면 선택
		req.setAttribute("bvo", bvo);
		req.getRequestDispatcher("/WEB-INF/views/qna/edit/business.jsp").forward(req, resp);
	
	}//doGet
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//인코딩
		req.setCharacterEncoding("UTF-8");
		
		// 데이터 꺼내기
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String no = req.getParameter("no");
		
		// 데이터 뭉치기
		BquestionVo bvo = new BquestionVo();
		bvo.setTitle(title);
		bvo.setContent(content);
		bvo.setNo(no);
		
		// 디비 다녀오기
		int result = new BqnaService().edit(bvo);
		
		// 화면선택
		if(result == 1) {
			//성공 => 상세조회 //성공 알람
			req.getSession().setAttribute("alertMsg", "qna 수정 성공!");
			resp.sendRedirect("/semiPrj/bqna/detail?no=" + no);
		}else {
			//실패 => 에러페이지
			req.setAttribute("msg", "qna 수정 실패 ...");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	}
}//class
