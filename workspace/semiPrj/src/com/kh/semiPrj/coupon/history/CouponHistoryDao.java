package com.kh.semiPrj.coupon.history;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CouponHistoryDao {

	public List<CouponHistoryVo> selectCouponList(Connection conn) {
		
		String sql = "";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CouponHistoryVo> voList = new ArrayList<CouponHistoryVo>();
		
		return voList;
	}

}
