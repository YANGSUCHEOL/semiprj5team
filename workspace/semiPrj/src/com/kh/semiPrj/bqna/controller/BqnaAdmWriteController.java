package com.kh.semiPrj.bqna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiPrj.bqna.service.BqnaService;
import com.kh.semiPrj.bqna.vo.BanswerVo;
import com.kh.semiPrj.member.MemberVo;
import com.kh.semiPrj.qna.service.QnaService;

@WebServlet(urlPatterns = "/bqna/adminWrite")
public class BqnaAdmWriteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		//인코딩
		req.setCharacterEncoding("UTF-8");
		
		String answerContent = req.getParameter("content");
		String bno = req.getParameter("bNo");
		
		BanswerVo bavo = new BanswerVo();
		bavo.setContent(answerContent);
		bavo.setbNo(bno);
		bavo.setmNo(loginMember.getNo());
		
		int result = new BqnaService().insertAnswer(bavo);
		//여기부터  답변완료 수정
		if(result > 0) {
			int result2 = new BqnaService().answerYnCheck(bno);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}
}
