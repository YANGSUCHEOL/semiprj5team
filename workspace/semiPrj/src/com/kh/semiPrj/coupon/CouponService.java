package com.kh.semiPrj.coupon;

import java.sql.Connection;
import java.util.List;

import com.kh.semiPrj.coupon.history.CouponHistoryVo;

import common.JDBCTemplate;

public class CouponService {

	//쿠폰 조회
	public List<CouponVo> downloadCoupon(String rno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<CouponVo> voList = new CouponDao().downloadCoupon(conn, rno);
		
		JDBCTemplate.close(conn);
		
		return voList;
	}

	//쿠폰 디테일
	public List<CouponHistoryVo> couponDetail(String mNo, String rNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<CouponHistoryVo> detail = new CouponDao().couponDetail(conn, mNo, rNo);
		
		JDBCTemplate.close(conn);
		
		return detail;
	}

	
	
}
