package com.kh.semiPrj.coupon;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.coupon.history.CouponHistoryVo;

@WebServlet(urlPatterns = "/coupon/detail")
public class CouponDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String mNo = req.getParameter("mNo");
		String rNo = req.getParameter("rNo");
		
		CouponHistoryVo vo = new CouponService().couponDetail(mNo, rNo);
		
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/WEB-INF/views/coupon/detail.jsp").forward(req, resp);
	}
}