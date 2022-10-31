package com.kh.semiPrj.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.review.service.ReviewService;

@WebServlet(urlPatterns = "/review/delete")
public class ReviewDeleteController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String no = req.getParameter("no");
		String uri = req.getParameter("uri");
		
		int result = new ReviewService().deleteOne(no);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "리뷰 삭제에 성공하셨습니다.");
			resp.sendRedirect(uri);
		} else {
			req.getSession().setAttribute("alertMsg", "리뷰 삭제에 실패하셨습니다.");
			resp.sendRedirect(uri);
		}
		
	}

}
