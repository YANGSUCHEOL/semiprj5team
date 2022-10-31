package com.kh.semiPrj.bqna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiPrj.bqna.service.BqnaService;
import com.kh.semiPrj.bqna.vo.BquestionVo;
import com.kh.semiPrj.businessMember.BusinessMemberVo;
import com.kh.semiPrj.member.MemberVo;

@WebServlet(urlPatterns = "/bqna/write")
public class BqnaWriteController extends HttpServlet {

	private final BqnaService bqs = new BqnaService();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//session
		HttpSession s = req.getSession();
		
		BusinessMemberVo bsloginMember = (BusinessMemberVo)s.getAttribute("bsloginMember");
		
		//로그인 안 되어있으면 로그인부터
		if(req.getSession().getAttribute("bsloginMember") == null) {
			req.setAttribute("msg", "로그인 후 이용해주세요");
			req.getRequestDispatcher("views/common/errorPage.jsp").forward(req, resp);
			
		}else {
			req.getRequestDispatcher("/WEB-INF/views/qna/write/business.jsp").forward(req, resp);
		}
	
	}//doGet
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//session
		HttpSession s = req.getSession();
		
		//로그인멤버 가져오기
		BusinessMemberVo bsloginMember = (BusinessMemberVo)s.getAttribute("bsloginMember");
		
		//인코딩
		req.setCharacterEncoding("UTF-8");
		
		//데이터 꺼내기
		String title = req.getParameter("title");
		//String Date = req.getParameter("Date");
		String content = req.getParameter("content");
		
		
		//뭉치기
		BquestionVo bvo = new BquestionVo();
		
		bvo.setTitle(title);
		bvo.setContent(content);
		bvo.setbNo(bsloginMember.getNo());
		
		int result = bqs.write(bvo);
		
		if(result == 1) {
			//성공
			s.setAttribute("alertMsg", "게시글 작성 성공!");
			//resp.sendRedirect("/semiPrj/WEB-INF/views/qna/list/customer.jsp");
			resp.sendRedirect("/semiPrj/bqna/list");
		}else {
			System.out.println("게시글 작성 실패");
		}
	}
}//class
