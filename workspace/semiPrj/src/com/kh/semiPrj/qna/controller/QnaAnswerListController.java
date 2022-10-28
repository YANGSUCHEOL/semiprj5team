package com.kh.semiPrj.qna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.qna.service.QnaService;
import com.kh.semiPrj.qna.vo.AnswerVo;

@WebServlet(urlPatterns = "/qna/answerList")
public class QnaAnswerListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String qNo = req.getParameter("qNo");

		ArrayList<AnswerVo> list = new QnaService().selectAnswerList(qNo);
	}

}
