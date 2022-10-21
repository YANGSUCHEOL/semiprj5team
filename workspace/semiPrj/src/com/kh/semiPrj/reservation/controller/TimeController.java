package com.kh.semiPrj.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.reservation.service.ReservationService;

@WebServlet(urlPatterns = "/res/time")
public class TimeController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		
		String date = req.getParameter("date");
		String rNo = req.getParameter("rNo");
		
		String rsvTimes = new ReservationService().rsvTime(date, rNo);
		
		out.write(rsvTimes);

	}
	
}
