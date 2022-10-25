package com.kh.semiPrj.community.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageVo;
import com.kh.semiPrj.community.service.CommuService;
import com.kh.semiPrj.community.vo.CategoryVo;
import com.kh.semiPrj.community.vo.CommuVo;

@WebServlet(urlPatterns = "/community/list")
public class CommuListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//페이징처리
		int listCount;
		int currentPage;
		int pageLimit;		//5
		int boardLimit;		//10
		
		int maxPage;
		int startPage;		//<
		int endPage;		//>

		listCount = new CommuService().selectCount();
		currentPage = Integer.parseInt(req.getParameter("pno"));
		pageLimit = 5;
		boardLimit = 15;
		
		//maxPage : listCount , boardLimit 으로 계산
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		//startPage : pageLimit , currentPage 로 계산
		startPage = (currentPage-1) / pageLimit * pageLimit + 1;
		
		//endPage : startPage , pageLimit 으로 계산 ( + maxPage 도 고려하긴 해야함)
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
		
		//디비 다녀오기
		List<CommuVo> voList  = new CommuService().selectList(pv);
		
		req.setAttribute("voList", voList);
		req.setAttribute("pv", pv);

		//화면 선택
		req.getRequestDispatcher("/WEB-INF/views/communityBoard/list.jsp").forward(req, resp);
		
	}//get
	
	
}
