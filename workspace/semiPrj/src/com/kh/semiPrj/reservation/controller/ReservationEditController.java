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

@WebServlet(urlPatterns = "/res/edit")
public class ReservationEditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no = req.getParameter("no");
		
		ReservationVo vo = new ReservationService().getOneByNo(no);
		RestaurantVo res = new RestaurantService().resFindVo(vo.getNo());
		
		HttpSession s = req.getSession();
		s.setAttribute("reservation", vo);
		req.setAttribute("res", res);
		
		req.getRequestDispatcher("/WEB-INF/views/res/edit.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String no = req.getParameter("resNo");
		String rName = req.getParameter("rName");
		String cnt = req.getParameter("cnt");
		String date = req.getParameter("date");
		String time = req.getParameter("time");
		String request = req.getParameter("request");
		
		ReservationVo vo = new ReservationVo();
		vo.setNo(no);
		vo.setRestaurant(rName);
		vo.setCnt(cnt);
		vo.setDate(date);
		vo.setTime(time);
		vo.setRequest(request);
		
		HttpSession s = req.getSession();
		s.setAttribute("reservation", vo);
		
		int result = new ReservationService().editOne(vo);
		
		if(result == 1) {
			resp.sendRedirect("/semiPrj/res/detail");
		} else {
			resp.sendRedirect("/semiPrj");
		}
		
	}
	
}
