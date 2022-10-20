package com.kh.semiPrj.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.qna.service.QnaService;
import com.kh.semiPrj.qna.vo.QuestionVo;

@WebServlet(urlPatterns = "/qna/list")
public class QnaListController extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 데이터 꺼내기
		// 데이터 뭉치기
		QuestionVo vo = new QuestionVo();
		
		//vo.setmNo(getServletInfo());
		
		// 디비 다녀오기
		List<QuestionVo> voList = new QnaService().selectQuestionList(vo);
		
		//화면선택 (데이터 담아서)
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/views/qna/list.jsp").forward(req, resp);
	}
}
