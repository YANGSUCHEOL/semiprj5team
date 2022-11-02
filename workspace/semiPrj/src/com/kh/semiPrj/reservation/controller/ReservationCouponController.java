package com.kh.semiPrj.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semiPrj.coupon.CouponVo;
import com.kh.semiPrj.reservation.service.ReservationService;

@WebServlet(urlPatterns = "/res/coupon")
public class ReservationCouponController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		String mno = req.getParameter("mno");
		String resno = req.getParameter("rno");
		
		List<CouponVo> voList = new ReservationService().callCouList(mno, resno);
		Gson gson = new Gson();
		String str = gson.toJson(voList);
		System.out.println(str);
		
		out.write(str);
		
	}
	
}
