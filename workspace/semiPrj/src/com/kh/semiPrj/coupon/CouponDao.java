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

	//쿠폰 디테일
	public List<CouponHistoryVo> couponDetail(Connection conn, String mNo, String rNo) {
		
		String sql = "SELECT H.NO, R.NAME AS RESTAURANT, C.NO AS COUPON, M.NO AS NAME, H.USED_YN, H.ENROLL_DATE FROM COU_HISTORY H JOIN MEMBER M ON H.M_NO = M.NO JOIN RESTAURANT R ON H.R_NO = R.NO JOIN COUPON C ON H.C_NO = C.NO WHERE M.NO = ? AND R.NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CouponHistoryVo> detail = new ArrayList<CouponHistoryVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mNo);
			pstmt.setString(2, rNo);
			
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
				
				detail.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return detail;
	}
}
