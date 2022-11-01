package com.kh.semiPrj.coupon;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiPrj.coupon.history.CouponHistoryVo;
import com.kh.semiPrj.restaurant.vo.RestaurantVo;

@WebServlet(urlPatterns = "/coupon/download")
public class CouponDwonloadController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String rno = req.getParameter("rno");
		List<CouponVo> voList = new CouponService().downloadCoupon(rno);
		
		HttpSession s = req.getSession();
		
		req.setAttribute("voList", voList);
		s.setAttribute("rno", rno);
		
		req.getRequestDispatcher("/WEB-INF/views/coupon/download.jsp").forward(req, resp);
		
	}
}
