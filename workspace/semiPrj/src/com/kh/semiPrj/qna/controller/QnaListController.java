package com.kh.semiPrj.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiPrj.member.MemberVo;
import com.kh.semiPrj.qna.service.QnaService;
import com.kh.semiPrj.qna.vo.PageVo;
import com.kh.semiPrj.qna.vo.QuestionVo;

@WebServlet(urlPatterns = "/qna/list")
public class QnaListController extends HttpServlet{
	
	//질문 목록 조회(화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//session
		HttpSession s = req.getSession();
		
		//로그인멤버 가져오기
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		if(req.getSession().getAttribute("loginMember") == null) {
			req.setAttribute("msg", "로그인 후 이용해주세요");
			req.getRequestDispatcher("/WEB-INF/views/errorPage.jsp").forward(req, resp);
			return;
		}
		// 데이터 꺼내기
		// 데이터 뭉치기
		QuestionVo vo = new QuestionVo();
		vo.setmNo(loginMember.getNo());
		
		
		
		//디비다녀오기
		//List<QuestionVo> x = new QnaService().selectList(pv);
		//vo.setmNo(getServletInfo());
		
		List<QuestionVo> voList = new QnaService().selectQuestionList(vo);
		
		//화면선택 (데이터 담아서)
		req.setAttribute("voList", voList);
		
		
		req.getRequestDispatcher("/WEB-INF/views/qna/list/customer.jsp").forward(req, resp);
	}
}
