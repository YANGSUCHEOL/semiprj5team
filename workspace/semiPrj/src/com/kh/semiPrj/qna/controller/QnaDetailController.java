package com.kh.semiPrj.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.qna.service.QnaService;
import com.kh.semiPrj.qna.vo.AnswerVo;
import com.kh.semiPrj.qna.vo.QuestionVo;

@WebServlet(urlPatterns = "/qna/detail")
public class QnaDetailController extends HttpServlet{
	
	//상세조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		//데이터 꺼내기
		String no = req.getParameter("no");
		
		//데이터 뭉치기
		
		//디비 다녀오기
		QuestionVo vo = new QnaService().selectOne(no);
		AnswerVo avo = new QnaService().selectAnswerOne(no);
		
		//화면선택
		req.setAttribute("vo", vo);
		req.setAttribute("avo", avo);
		req.getRequestDispatcher("/WEB-INF/views/qna/detail/customer.jsp").forward(req, resp);
		
	}

}
