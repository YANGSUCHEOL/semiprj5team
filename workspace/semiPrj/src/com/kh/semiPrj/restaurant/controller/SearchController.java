package com.kh.semiPrj.restaurant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.restaurant.service.RestaurantService;
import com.kh.semiPrj.restaurant.vo.RestaurantVo;

import common.PageVo;

@WebServlet(urlPatterns = "/search")
public class SearchController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String resName = req.getParameter("resName");
		
		int listCount;
		int currentPage;
		int pageLimit;
		int voLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new RestaurantService().selectCount(resName);
		currentPage = Integer.parseInt(req.getParameter("pno"));
		pageLimit = 5;
		voLimit = 6;
		
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
		
		List<RestaurantVo> voList = new RestaurantService().searchList(resName, pv);
		
		String cnt = Integer.toString(listCount);
		
		req.setAttribute("resName", resName);
		req.setAttribute("voList", voList);
		req.setAttribute("pv", pv);
		req.setAttribute("cnt", cnt);
		
		req.getRequestDispatcher("/WEB-INF/views/search/result.jsp").forward(req, resp);
		
	}
		
}