package com.kh.semiPrj.coupon.history;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;

public class CouponHistoryDao {

	//마이페이지 내 쿠폰 목록 조회
	public List<CouponHistoryVo> couponList(Connection conn, String mno) {

		String sql = "SELECT H.NO, R.NAME AS RESTAURANT, C.NO AS COUPON, M.NO AS NAME, H.USED_YN, H.ENROLL_DATE FROM COU_HISTORY H JOIN MEMBER M ON H.M_NO = M.NO JOIN RESTAURANT R ON H.R_NO = R.NO JOIN COUPON C ON H.C_NO = C.NO WHERE M.NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CouponHistoryVo> voList = new ArrayList<CouponHistoryVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mno);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String restaurant = rs.getString("RESTAURANT");
				String coupon = rs.getString("COUPON");
				String name = rs.getString("NAME");
				String usedYn = rs.getString("USED_YN");
				String enrollDate = rs.getString("ENROLL_DATE");
				
				CouponHistoryVo vo = new CouponHistoryVo();
				vo.setNo(no);
				vo.setrNo(restaurant);
				vo.setcNo(coupon);
				vo.setmNo(name);
				vo.setUsedYn(usedYn);
				vo.setEnrollDate(enrollDate);
				
				voList.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return voList;
	}

	

}