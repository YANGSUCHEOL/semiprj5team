package com.kh.semiPrj.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.review.service.ReviewService;
import com.kh.semiPrj.review.vo.ReviewVo;

@WebServlet(urlPatterns = "/review/edit")
public class ReviewEditController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String reNo = req.getParameter("reNo");
		
		req.getRequestDispatcher("/WEB-INF/views/review/edit.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ReviewVo vo = new ReviewVo();
		
		int result = new ReviewService().editOne(vo);
		
		if(result == 1) {
			
		} else {
			
		}
		
	}

}
