package com.kh.semiPrj.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiPrj.member.MemberVo;
import com.kh.semiPrj.qna.service.QnaService;
import com.kh.semiPrj.qna.vo.AnswerVo;

@WebServlet(urlPatterns = "/qna/adminWrite")
public class QnaAdmWriteController extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		//인코딩
		req.setCharacterEncoding("UTF-8");
		
		String answerContent = req.getParameter("content");
		String qno = req.getParameter("qNo");
		//String mno = req.getParameter("mNo");
		
		AnswerVo avo = new AnswerVo();
		avo.setContent(answerContent);
		avo.setqNo(qno);
		avo.setmNo(loginMember.getNo());
		
		int result = new QnaService().insertAnswer(avo);
		
		System.out.println("result ::: " + result);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}
}
