package com.kh.semiPrj.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.qna.service.QnaService;
import com.kh.semiPrj.qna.vo.QuestionVo;

@WebServlet(urlPatterns = "/qna/edit")
public class QnaEditController extends HttpServlet{
	
	//수정(화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//데이터 꺼내기
		String no = req.getParameter("no");
		
		//데이터 뭉치기
		
		//디비 다녀오기
		QuestionVo vo = new QnaService().selectOne(no);
		
		//화면 선택
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/WEB-INF/views/qna/edit/customer.jsp").forward(req, resp);
	
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
		QuestionVo vo = new QuestionVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setNo(no);
		
		// 디비 다녀오기
		int result = new QnaService().edit(vo);
		
		// 화면선택
		if(result == 1) {
			//성공 => 상세조회 //성공 알람
			req.getSession().setAttribute("alertMsg", "qna 수정 성공!");
			resp.sendRedirect("/semiPrj/qna/detail?no=" + no);
		}else {
			//실패 => 에러페이지
			req.setAttribute("msg", "qna 수정 실패 ...");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	
	}//doPost
}
