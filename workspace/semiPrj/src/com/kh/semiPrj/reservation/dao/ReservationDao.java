package com.kh.semiPrj.reservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.semiPrj.reservation.vo.ReservationVo;
import com.kh.semiPrj.restaurant.vo.RestaurantVo;

import common.JDBCTemplate;

public class ReservationDao {
	
public int insertOne(Connection conn, ReservationVo vo) {
		
		String sql = "INSERT INTO RESERVATION ( NO, R_NO, M_NO, COU_NO, RESDATE, RESTIME, CNT, REQUEST ) VALUES ( SEQ_RESERVATION_NO.NEXTVAL, ?, ?, ?, ?, ?, ?, ? )";

		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getRestaurant());
			pstmt.setString(2, vo.getMember());
			pstmt.setString(3, vo.getCoupon());
			pstmt.setString(4, vo.getDate());
			pstmt.setString(5, vo.getTime());
			pstmt.setString(6, vo.getCnt());
			pstmt.setString(7, vo.getRequest());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}
	
	public int updateOne(Connection conn, ReservationVo vo) {
		
		String sql = "UPDATE RESERVATION SET TIME = ?, CNT = ? WHERE NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTime());
			pstmt.setString(2, vo.getCnt());
			pstmt.setString(3, vo.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

	public ReservationVo selectOne(Connection conn, ReservationVo vo) {
		
		String sql = "SELECT R.NO, S.NAME AS RESTAURANT, M.NAME AS NAME, C.INFO AS COUPON, RESDATE, RESTIME, CNT, REQUEST FROM RESERVATION R INNER JOIN RESTAURANT S ON S.NO = R.R_NO LEFT OUTER JOIN COUPON C ON R.COU_NO = C.NO INNER JOIN MEMBER M ON M.NO = R.M_NO WHERE R.R_NO = ? AND R.M_NO = ? AND R.RESDATE = ? AND R.RESTIME = ? AND R.CNT = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReservationVo res = null;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getRestaurant());
			pstmt.setString(2, vo.getMember());
			pstmt.setString(3, vo.getDate());
			pstmt.setString(4, vo.getTime());
			pstmt.setString(5, vo.getCnt());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String no = rs.getString("NO");
				String rNo = rs.getString("RESTAURANT");
				String mNo = rs.getString("NAME");
				String couNo = rs.getString("COUPON");
				String date = rs.getString("RESDATE");
				String time = rs.getString("RESTIME");
				String cnt = rs.getString("CNT");
				String request = rs.getString("REQUEST");
				
				res = new ReservationVo();
				res.setNo(no);
				res.setRestaurant(rNo);
				res.setMember(mNo);
				res.setCoupon(couNo);
				res.setDate(date);
				res.setTime(time);
				res.setCnt(cnt);
				res.setRequest(request);
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return res;
		
	}
	
	public String getRsvTimes(Connection conn, String rsvDate, String resNo) {
		
		String rsvTimes = "";
		String time = "";
		String sql = "SELECT RESTIME FROM RESERVATION WHERE RESDATE = ? AND R_NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rsvDate);
			pstmt.setString(2, resNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				time = rs.getString(1);
				rsvTimes += time + "/";
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return rsvTimes;
		
	}

	// 한 회원이 했던 모든 예약 LIST (MY PAGE 전용 / 내 예약 보기)
	public List<ReservationVo> getListByMNo(Connection conn, String no) {
		
		String sql = "SELECT ROWNUM, A.* FROM ( SELECT R.NO, S.NAME AS RESTAURANT, M.NAME AS NAME, C.INFO AS COUPON, RESDATE, RESTIME, CNT, REQUEST FROM RESERVATION R INNER JOIN RESTAURANT S ON S.NO = R.R_NO LEFT OUTER JOIN COUPON C ON R.COU_NO = C.NO INNER JOIN MEMBER M ON M.NO = R.M_NO WHERE M.NO = ?) A";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReservationVo> voList = new ArrayList<ReservationVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String num = rs.getString("NO");
				String res = rs.getString("RESTAURANT");
				String name = rs.getString("NAME");
				String coupon = rs.getString("COUPON");
				String date = rs.getString("RESDATE");
				String time = rs.getString("RESTIME");
				String cnt = rs.getString("CNT");
				String request = rs.getString("REQUEST");
				
				ReservationVo vo = new ReservationVo();
				vo.setNo(num);
				vo.setRestaurant(res);
				vo.setMember(name);
				vo.setCoupon(coupon);
				vo.setDate(date);
				vo.setTime(time);
				vo.setCnt(cnt);
				vo.setRequest(request);
				
				voList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return voList;
		
	}
	
	// 한 회원이 한 식당에서 했던 예약 LIST
	public List<ReservationVo> getListByRMNo(Connection conn, String mno, String rno) {
		
		String sql = "SELECT ROWNUM, A.* FROM ( SELECT R.NO, S.NAME AS RESTAURANT, M.NAME AS NAME, C.INFO AS COUPON, RESDATE, RESTIME, CNT, REQUEST FROM RESERVATION R INNER JOIN RESTAURANT S ON S.NO = R.R_NO LEFT OUTER JOIN COUPON C ON R.COU_NO = C.NO INNER JOIN MEMBER M ON M.NO = R.M_NO WHERE M.NO = ? AND S.NO = ?) A";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReservationVo> voList = new ArrayList<ReservationVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mno);
			pstmt.setString(2, rno);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String num = rs.getString("NO");
				String res = rs.getString("RESTAURANT");
				String name = rs.getString("NAME");
				String coupon = rs.getString("COUPON");
				String date = rs.getString("RESDATE");
				String time = rs.getString("RESTIME");
				String cnt = rs.getString("CNT");
				String request = rs.getString("REQUEST");
				
				ReservationVo vo = new ReservationVo();
				vo.setNo(num);
				vo.setRestaurant(res);
				vo.setMember(name);
				vo.setCoupon(coupon);
				vo.setDate(date);
				vo.setTime(time);
				vo.setCnt(cnt);
				vo.setRequest(request);
				
				voList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return voList;
		
	}
	
	// 한 식당의 예약 LIST
	public List<ReservationVo> getListByRNo(Connection conn, String no) {
		
		String sql = "SELECT ROWNUM, A.* FROM ( SELECT R.NO, S.NAME AS RESTAURANT, M.NAME AS NAME, C.INFO AS COUPON, RESDATE, RESTIME, CNT, REQUEST FROM RESERVATION R INNER JOIN RESTAURANT S ON S.NO = R.R_NO LEFT OUTER JOIN COUPON C ON R.COU_NO = C.NO INNER JOIN MEMBER M ON M.NO = R.M_NO WHERE S.NO = ?) A";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReservationVo> voList = new ArrayList<ReservationVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String num = rs.getString("NO");
				String res = rs.getString("RESTAURANT");
				String name = rs.getString("NAME");
				String coupon = rs.getString("COUPON");
				String date = rs.getString("RESDATE");
				String time = rs.getString("RESTIME");
				String cnt = rs.getString("CNT");
				String request = rs.getString("REQUEST");
				
				ReservationVo vo = new ReservationVo();
				vo.setNo(num);
				vo.setRestaurant(res);
				vo.setMember(name);
				vo.setCoupon(coupon);
				vo.setDate(date);
				vo.setTime(time);
				vo.setCnt(cnt);
				vo.setRequest(request);
				
				voList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return voList;
		
	}

}
