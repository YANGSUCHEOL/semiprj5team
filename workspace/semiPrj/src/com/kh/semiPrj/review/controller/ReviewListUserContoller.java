package com.kh.semiPrj.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiPrj.member.MemberVo;
import com.kh.semiPrj.review.service.ReviewService;
import com.kh.semiPrj.review.vo.ReviewVo;

import common.PageVo;

@WebServlet(urlPatterns = "/review/user")
public class ReviewListUserContoller extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		HttpSession s = req.getSession();
		
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		String mno = loginMember.getNo();
		
		int listCount;
		int currentPage;
		int pageLimit;
		int voLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new ReviewService().selectCountMember(mno);
		currentPage = Integer.parseInt(req.getParameter("pno"));
		pageLimit = 5;
		voLimit = 4;
		
		maxPage = (int)Math.ceil((double)listCount / voLimit);
		startPage = (currentPage-1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageVo pv = new PageVo();
		pv.setListCount(listCount);
		pv.setCurrentPage(currentPage);
		pv.setPageLimit(pageLimit);
		pv.setBoardLimit(voLimit);
		pv.setMaxPage(maxPage);
		pv.setStartPage(startPage);
		pv.setEndPage(endPage);
		
		List<ReviewVo> voList = new ReviewService().searchListClient(mno, pv);
		
		req.setAttribute("review", voList);
		req.setAttribute("pv", pv);
		
		req.getRequestDispatcher("/WEB-INF/views/review/listclient.jsp").forward(req, resp);
		
	}

}
