package com.kh.semiPrj.coupon;

import java.sql.Connection;

import common.JDBCTemplate;

public class CouponService {

	//쿠폰 조회
	public CouponVo donwloadCoupon(String rno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		CouponVo vo = new CouponDao().donwloadCoupon(conn, rno);
		
		JDBCTemplate.close(conn);
		
		return vo;
	}

}
