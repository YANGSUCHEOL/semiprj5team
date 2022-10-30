package com.kh.semiPrj.coupon.history;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;

public class CouponHistoryService {

	//마이페이지 내 쿠폰 목록 조회
	public List<CouponHistoryVo> couponList(String mno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<CouponHistoryVo> voList = new CouponHistoryDao().couponList(conn, mno);
		
		JDBCTemplate.close(conn);
		
		return voList;
	}
	
}
