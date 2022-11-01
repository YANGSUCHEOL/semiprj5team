package com.kh.semiPrj.coupon.history;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/coupon/list")
public class CouponHistoryController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String mno = req.getParameter("mno");
		List<CouponHistoryVo> voList = new CouponHistoryService().couponList(mno);
		
		HttpSession s = req.getSession();
		
		s.setAttribute("mno", mno);
		req.setAttribute("voList", voList);
		
		req.getRequestDispatcher("/WEB-INF/views/coupon/list.jsp").forward(req, resp);
	}
	
	
}
