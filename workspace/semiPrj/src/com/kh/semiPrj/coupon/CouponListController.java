package com.kh.semiPrj.coupon;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/coupon/download")
public class CouponListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String rno = req.getParameter("rno");
		
		CouponVo vo = new CouponService().selectCouList(rno);
		
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/WEB-INF/views/coupon/download.jsp").forward(req, resp);
		
		
	}
}
