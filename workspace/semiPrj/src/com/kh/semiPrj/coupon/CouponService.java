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

	//쿠폰 인서트
	public int insertCoupon(CouponHistoryVo vo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		CouponDao dao = new CouponDao();
		int result = dao.insertCoupon(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	
	
}
