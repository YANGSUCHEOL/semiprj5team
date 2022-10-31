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
import com.kh.semiPrj.qna.vo.QuestionVo;

@WebServlet(urlPatterns = "/bqna/detail")
public class BqnaDetailController extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String no = req.getParameter("no");
		
		BquestionVo bvo = new BqnaService().selectOne(no);
		BanswerVo bavo = new BqnaService().selectAnswerOne(no);
		//화면선택
		req.setAttribute("bvo", bvo);
		req.setAttribute("bavo", bavo);
		req.getRequestDispatcher("/WEB-INF/views/qna/detail/business.jsp").forward(req, resp);
	}
}
