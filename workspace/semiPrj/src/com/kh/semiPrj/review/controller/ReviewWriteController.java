package com.kh.semiPrj.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiPrj.reservation.service.ReservationService;
import com.kh.semiPrj.reservation.vo.ReservationVo;
import com.kh.semiPrj.restaurant.service.RestaurantService;
import com.kh.semiPrj.restaurant.vo.RestaurantVo;
import com.kh.semiPrj.review.service.ReviewService;
import com.kh.semiPrj.review.vo.ReviewVo;

import member.MemberVo;

@WebServlet(urlPatterns = "/review/write")
public class ReviewWriteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String rno = req.getParameter("rno");
		
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		String mno = loginMember.getNo();
		
		RestaurantVo vo = new RestaurantService().detailView(rno);
		List<ReservationVo> voList = new ReservationService().getReservationByRMNo(mno, rno);
		
		req.setAttribute("restaurant", vo);
		req.setAttribute("reservationbymno", voList);

		req.getRequestDispatcher("/WEB-INF/views/review/write.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		String rNo = req.getParameter("rno"); // 식당 번호 -> 이전 페이지
		String reNo = req.getParameter("reNo"); // 예약 번호 선택 -> option value 값
		String score = req.getParameter("rating");
		String content = req.getParameter("review");
		String release = req.getParameter("release");
		String mNo = req.getParameter("mno"); // 로그인한 회원 번호 받아 오기
		
		ReviewVo vo = new ReviewVo();
		vo.setRestaurant(rNo);
		vo.setReNo(reNo);
		vo.setScore(Integer.parseInt(score));
		vo.setContent(content);
		vo.setReleaseYn(release);
		vo.setWriter(mNo);
		
		int result = new ReviewService().reviewWrite(vo);
		
		if(result == 1) {
			// 리뷰가 성공적으로 작성되었습니다. 페이지로 넘어가서 상세 페이지
			System.out.println("리뷰 작성 성공!");
			resp.sendRedirect("/semiPrj/search/detail?rno=" + rNo);
		} else {
			// 에러 팝업 출력 -> 앞으로 돌아가기
			System.out.println("리뷰 작성 실패!");
			resp.sendRedirect("/semiPrj");
		}
	
	}

}
