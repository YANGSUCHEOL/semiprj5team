package com.kh.semiPrj.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiPrj.reservation.vo.ReservationVo;

@WebServlet(urlPatterns = "/res/detail")
public class ReservationDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		HttpSession session = req.getSession();
//		ReservationVo vo = (ReservationVo)session.getAttribute("reservation");
//		
//		session.setAttribute("reservation", vo);
		
		req.getRequestDispatcher("/WEB-INF/views/res/detail.jsp").forward(req, resp);
		
	}
	
}
