package com.kh.semiPrj.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.reservation.service.ReservationService;

@WebServlet(urlPatterns = "/res/cancel")
public class ReservationCancelController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no = req.getParameter("no");
		
		int result = new ReservationService().delete(no);
		
		if(result == 1) {
			req.getSession().setAttribute("msg", "성공적으로 예약이 취소되었습니다.");
			resp.sendRedirect("/semiPrj/mypage/mypage");
		} else {
			req.getSession().setAttribute("msg", "예약이 취소되지 않았습니다.");
			resp.sendRedirect("/semiPrj/res/detail");
		}
		
	}

}
