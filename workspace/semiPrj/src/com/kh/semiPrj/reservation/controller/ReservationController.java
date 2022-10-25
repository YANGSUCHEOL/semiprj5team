package com.kh.semiPrj.reservation.controller;

import java.io.IOException;

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

@WebServlet(urlPatterns = "/res")
public class ReservationController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/res/res.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String rNo = req.getParameter("rNo");
		String mNo = req.getParameter("mNo");
		String couNo = req.getParameter("couNo");
		String date = req.getParameter("date");
		String time = req.getParameter("time");
		String cnt = req.getParameter("cnt");
		String request = req.getParameter("request");
		
		ReservationVo vo = new ReservationVo();
		vo.setRestaurant(rNo);
		vo.setMember(mNo);
		vo.setCoupon(couNo);
		vo.setDate(date);
		vo.setTime(time);
		vo.setCnt(cnt);
		vo.setRequest(request);
		
		int result = new ReservationService().reservation(vo);
		ReservationVo detail = new ReservationService().selectOne(vo);
		
		if(result == 1) {
			// 예약 내역 페이지 출력
			HttpSession session = req.getSession();
			session.setAttribute("reservation", detail);
			resp.sendRedirect("/semiPrj/res/detail");
		} else {
			// 처음부터 다시 하게 만들기
			resp.sendRedirect("");
		}
	
	}
	
}
