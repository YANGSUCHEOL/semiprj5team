package com.kh.semiPrj.coupon.history;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;

public class CouponHistoryService {

	public List<CouponHistoryVo> selectCouponList() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<CouponHistoryVo> voList = new CouponHistoryDao().selectCouponList(conn);
		
		JDBCTemplate.close(conn);
		
		return voList;
	}

}
