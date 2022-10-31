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
import com.kh.semiPrj.qna.vo.PageVo;
import com.kh.semiPrj.qna.vo.QuestionVo;

@WebServlet(urlPatterns = "/bqna/adminList")
public class BqnaAdmListController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//session
		HttpSession s = req.getSession();
	
		//로그인멤버 가져오기
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		boolean isAdmin = loginMember != null && loginMember.getId().equals("admin");
	
		
		if(!isAdmin) {
			//관리자 아닌 경우
			req.setAttribute("msg", "접근 권한이 없습니다.");
		}else {
			//페이징
			int listCount;
			int currentPage;
			int pageLimit;
			int boardLimit;
			
			int maxPage;
			int startPage;
			int endPage;
			
			listCount = new BqnaService().selectCount();
			currentPage = Integer.parseInt(req.getParameter("pno"));
			
			pageLimit = 5;
			boardLimit = 10;
			
			maxPage = (int)Math.ceil((double)listCount / boardLimit);
			
			startPage = (currentPage-1) / pageLimit * pageLimit + 1;
			
			endPage = startPage + pageLimit - 1;
			
			if(endPage > maxPage) {
				endPage = maxPage;
			}
			
			PageVo pv = new PageVo();
			pv.setListCount(listCount);
			pv.setCurrentPage(currentPage);
			pv.setPageLimit(pageLimit);
			pv.setBoardLimit(boardLimit);
			pv.setMaxPage(maxPage);
			pv.setStartPage(startPage);
			pv.setEndPage(endPage);
			
			//디비
			List<BquestionVo> x = new BqnaService().selectList(pv);
			
			
			//화면
			req.setAttribute("bvoList", x);
			req.setAttribute("pv", pv);
			req.getRequestDispatcher("/WEB-INF/views/qna/list/answer_b.jsp").forward(req, resp);
		}
	}
}
