package com.kh.semiPrj.bqna.controller;

import java.io.IOException;
import java.util.List;

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
import com.kh.semiPrj.qna.service.QnaService;
import com.kh.semiPrj.qna.vo.QuestionVo;

@WebServlet(urlPatterns = "/bqna/list")
public class BqnaListController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//session
		HttpSession s = req.getSession();
	
		//로그인멤버 가져오기
		BusinessMemberVo bsloginMember = (BusinessMemberVo)s.getAttribute("bsloginMember");
	
		if(req.getSession().getAttribute("bsloginMember") == null) {
			req.setAttribute("msg", "사업자 로그인 후 이용해주세요");
			req.getRequestDispatcher("/WEB-INF/views/errorPage.jsp").forward(req, resp);
			return;
		}
		
		// 데이터 꺼내기
		// 데이터 뭉치기
		BquestionVo bvo = new BquestionVo();
		bvo.setbNo(bsloginMember.getNo());
		
		List<BquestionVo> bvoList = new BqnaService().selectQuestionList(bvo);
	
		//화면선택 (데이터 담아서)
		req.setAttribute("bvoList", bvoList);
	
		req.getRequestDispatcher("/WEB-INF/views/qna/list/business.jsp").forward(req, resp);
	}
}
