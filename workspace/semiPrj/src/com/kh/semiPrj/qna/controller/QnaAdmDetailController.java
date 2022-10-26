package com.kh.semiPrj.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.qna.service.QnaService;
import com.kh.semiPrj.qna.vo.QuestionVo;

@WebServlet(urlPatterns = "/qna/adminDetail")
public class QnaAdmDetailController extends HttpServlet{
	
	//상세조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		
		System.out.println(bno);
		
		//디비
		QuestionVo vo = new QnaService().selectAdminOne(bno);
		
		//화면선택
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/WEB-INF/views/qna/detail/answer_c.jsp").forward(req, resp);
		
		
	}

}
