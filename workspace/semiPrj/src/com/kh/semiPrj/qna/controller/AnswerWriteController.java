package com.kh.semiPrj.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiPrj.qna.service.QnaService;
import com.kh.semiPrj.qna.vo.AnswerVo;

import member.MemberVo;

@WebServlet(urlPatterns = "/qna/answer/write")
public class AnswerWriteController extends HttpServlet{
	
	private final QnaService qs = new QnaService();
	//화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/qna/write/admin_c.jsp").forward(req, resp);
	
	}
	
	//작성하기
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//세션
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		//인코딩
		req.setCharacterEncoding("UTF-8");
		
		//데이터 꺼내기
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		//뭉치기
		AnswerVo avo = new AnswerVo();
		
		avo.setTitle(title);
		avo.setContent(content);
		
		//디비
		int result = qs.writeAnswer(avo);
		
		if(result == 1) {
			//성공
			s.setAttribute("alertMsg", "게시글 작성 성공!");
			resp.sendRedirect("/semiPrj/qna/list");
		}else {
			System.out.println("게시글 작성 실패");
		}
		
	}
	
}
