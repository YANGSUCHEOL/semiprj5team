package com.kh.semiPrj.coupon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;

public class CouponDao {

	//쿠폰 조회
	public CouponVo selectCouponList(Connection conn, String rno) {
		
		String sql = "SELECT C.NO, C.R_NO, C.INFO, R.NAME FROM COUPON C JOIN RESTAURANT R ON C.R_NO = R.NO JOIN COU_CATEGORY G ON C.C_NO = G.NO WHERE R.NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		CouponVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String no = rs.getString("NO");
				String rNo = rs.getString("R_NO");
				String cNo = rs.getString("C_NO");
				String info = rs.getString("INFO");
				
				vo = new CouponVo();
				vo.setcNo(cNo);
				vo.setrNo(rNo);
				vo.setcNo(cNo);
				vo.setInfo(info);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return vo;
	}

}