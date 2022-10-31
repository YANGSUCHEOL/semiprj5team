package com.kh.semiPrj.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.member.MemberVo;
import com.kh.semiPrj.reservation.service.ReservationService;
import com.kh.semiPrj.reservation.vo.ReservationVo;
import com.kh.semiPrj.review.service.ReviewService;
import com.kh.semiPrj.review.vo.ReviewVo;

@WebServlet(urlPatterns = "/review/edit/user")
public class ReviewEditUserController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no = req.getParameter("no");
		String reNo = req.getParameter("reno");
		ReviewVo vo = new ReviewService().getOne(no);
		ReservationVo res = new ReservationService().getOneByNo(reNo);
		
		req.setAttribute("myReview", vo);
		req.setAttribute("myBooking", res);
		
		req.getRequestDispatcher("/WEB-INF/views/review/editclient.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String no = req.getParameter("rno");
		String release = req.getParameter("release");
		String review = req.getParameter("review");
		String rating = req.getParameter("rating");
		
		ReviewVo vo = new ReviewVo();
		vo.setNo(no);
		vo.setReleaseYn(release);
		vo.setContent(review);
		vo.setScore(Integer.parseInt(rating));
		
		int result = new ReviewService().editOne(vo);
		MemberVo member = (MemberVo)req.getSession().getAttribute("loginMember");
		
		if(result == 1) {
			resp.sendRedirect("/semiPrj/review/user?pno=1&mno=" + member.getNo());
		} else {
			resp.sendRedirect("/semiPrj");
		}
		
	}

}
