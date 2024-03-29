package com.kh.semiPrj.coupon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.semiPrj.coupon.history.CouponHistoryVo;

import common.JDBCTemplate;

public class CouponDao {

	//쿠폰 조회
	public List<CouponVo> downloadCoupon(Connection conn, String rno) {
		
		String sql = "SELECT C.NO , R.NAME AS RESTAURANT , C.C_NO , G.NAME AS INFO FROM COUPON C JOIN RESTAURANT R ON C.R_NO = R.NO JOIN COU_CATEGORY G ON C.C_NO = G.NO WHERE C.R_NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CouponVo> voList = new ArrayList<CouponVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rno);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");	
				String restaurant = rs.getString("RESTAURANT");
				String cNo = rs.getString("C_NO");
				String info = rs.getString("INFO");
				
				CouponVo vo = new CouponVo();
				vo.setNo(no);
				vo.setrNo(restaurant);
				vo.setcNo(cNo);
				vo.setInfo(info);
				
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


	//쿠폰 인서트
	public int insertCoupon(Connection conn, CouponHistoryVo vo) {
		
		String sql = "INSERT INTO COU_HISTORY (NO, R_NO, C_NO, M_NO) VALUES(SEQ_COU_HISTORY_NO.NEXTVAL, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getrNo());
			pstmt.setString(2, vo.getcNo());
			pstmt.setString(3, vo.getmNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
}
