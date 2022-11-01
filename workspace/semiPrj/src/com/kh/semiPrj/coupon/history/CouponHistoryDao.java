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

		String sql = "SELECT H.NO , R.NAME AS RESTAURANT , G.NAME AS COUPON , M.NO AS NAME , H.USED_YN , H.ENROLL_DATE FROM COU_HISTORY H JOIN RESTAURANT R ON H.R_NO = R.NO JOIN COU_CATEGORY G ON H.C_NO = G.NO JOIN MEMBER M ON H.M_NO = M.NO WHERE H.M_NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CouponHistoryVo> voList = new ArrayList<CouponHistoryVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mno);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String rNo = rs.getString("RESTAURANT");
				String cNo = rs.getString("COUPON");
				String mNo = rs.getString("NAME");
				String usedYn = rs.getString("USED_YN");
				String enrollDate = rs.getString("ENROLL_DATE");
				
				CouponHistoryVo vo = new CouponHistoryVo();
				vo.setNo(no);
				vo.setrNo(rNo);
				vo.setcNo(cNo);
				vo.setmNo(mno);
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