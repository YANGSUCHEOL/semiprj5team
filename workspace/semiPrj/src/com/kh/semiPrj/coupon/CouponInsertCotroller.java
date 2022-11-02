package com.kh.semiPrj.coupon;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiPrj.coupon.history.CouponHistoryVo;

@WebServlet(urlPatterns = "/coupon/insert")
public class CouponInsertCotroller extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//인코딩
		req.setCharacterEncoding("UTF-8");
		
		//데이터 꺼내기
		String rNo = req.getParameter("rNo");
		String cNo = req.getParameter("cNo");
		String mNo = req.getParameter("mNo");
		
		//데이터 뭉치기
		CouponHistoryVo vo = new CouponHistoryVo();
		vo.setrNo(rNo);
		vo.setcNo(cNo);
		vo.setmNo(mNo);
		
		//디비 댕겨오기
		int result = new CouponService().insertCoupon(vo);
		
		if(result == 1) {
			resp.sendRedirect("/semiPrj/mypage/mypage");
		}else {
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	}
}
