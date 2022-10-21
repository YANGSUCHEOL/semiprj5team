package com.kh.semiPrj.restaurant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiPrj.restaurant.vo.MenuVo;
import com.kh.semiPrj.restaurant.service.RestaurantService;
import com.kh.semiPrj.restaurant.vo.RestaurantVo;
import com.kh.semiPrj.review.vo.ReviewVo;

@WebServlet(urlPatterns = "/search/detail")
public class SearchDetailController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String rno = req.getParameter("rno");
		
		RestaurantVo vo = new RestaurantService().detailView(rno);
		List<MenuVo> menu = new RestaurantService().selectMenuList(rno);
		List<ReviewVo> review = new RestaurantService().selectReviewList(rno);
		
		HttpSession s = req.getSession();
		
		s.setAttribute("restaurant", vo);
		s.setAttribute("menu", menu);
		s.setAttribute("review", review);
		
//		req.setAttribute("vo", vo);
//		req.setAttribute("menu", menu);
//		req.setAttribute("review", review);
		req.getRequestDispatcher("/WEB-INF/views/search/detail.jsp").forward(req, resp);
		
	}

}
