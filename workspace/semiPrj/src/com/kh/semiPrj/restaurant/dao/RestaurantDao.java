package com.kh.semiPrj.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.semiPrj.restaurant.vo.MenuVo;
import com.kh.semiPrj.restaurant.vo.RestaurantVo;
import com.kh.semiPrj.review.vo.ReviewVo;

import common.JDBCTemplate;
import common.PageVo;

public class RestaurantDao {

	public List<RestaurantVo> selectList(Connection conn, String resName, PageVo pv) {
		
		// SQL
		
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, A.* FROM ( SELECT R.NO, D.NAME AS DISTRICT, T.NAME AS TYPE, R.NAME, R.ADDRESS, R.DAYOFF, R.PHONE, R.OPEN, R.CLOSE, R.REG_YN, R.PHOTO FROM RESTAURANT R INNER JOIN DISTRICT D ON R.D_NO = D.NO INNER JOIN TYPE T ON R.T_NO = T.NO WHERE R.NAME LIKE '%' || ? || '%' ) A ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RestaurantVo> voList = new ArrayList<RestaurantVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
			int end = start + pv.getBoardLimit() - 1;
			
			pstmt.setString(1, resName);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String district = rs.getString("DISTRICT");
				String type = rs.getString("TYPE");
				String name = rs.getString("NAME");
				String address = rs.getString("ADDRESS");
				String dayoff = rs.getString("DAYOFF");
				String phone = rs.getString("PHONE");
				String open = rs.getString("OPEN");
				String close = rs.getString("CLOSE");
				String regYn = rs.getString("REG_YN");
				String photo = rs.getString("PHOTO");
				
				RestaurantVo vo = new RestaurantVo();
				vo.setNo(no);
				vo.setDistrict(district);
				vo.setType(type);
				vo.setName(name);
				vo.setAddress(address);
				vo.setDayoff(dayoff);
				vo.setPhone(phone);
				vo.setOpen(open);
				vo.setClose(close);
				vo.setRegYn(regYn);
				vo.setPhoto(photo);
				
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

	public int selectCount(Connection conn, String resName) {
		
		String sql = "SELECT COUNT(*) AS CNT FROM RESTAURANT WHERE NAME LIKE '%' || ? || '%'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, resName);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = Integer.parseInt(rs.getString("CNT"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public RestaurantVo selectOneByNo(Connection conn, String rNo) {
		
		String sql = "SELECT R.NO, D.NAME AS DISTRICT, T.NAME AS TYPE, R.NAME, R.ADDRESS, R.DAYOFF, R.PHONE, R.OPEN, R.CLOSE, R.REG_YN, R.PHOTO FROM RESTAURANT R INNER JOIN DISTRICT D ON R.D_NO = D.NO INNER JOIN TYPE T ON R.T_NO = T.NO WHERE R.NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RestaurantVo vo = null;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String no = rs.getString("NO");
				String district = rs.getString("DISTRICT");
				String type = rs.getString("TYPE");
				String name = rs.getString("NAME");
				String address = rs.getString("ADDRESS");
				String dayoff = rs.getString("DAYOFF");
				String phone = rs.getString("PHONE");
				String open = rs.getString("OPEN");
				String close = rs.getString("CLOSE");
				String regYn = rs.getString("REG_YN");
				String photo = rs.getString("PHOTO");
				
				vo = new RestaurantVo();
				vo.setNo(no);
				vo.setDistrict(district);
				vo.setType(type);
				vo.setName(name);
				vo.setAddress(address);
				vo.setDayoff(dayoff);
				vo.setPhone(phone);
				vo.setOpen(open);
				vo.setClose(close);
				vo.setRegYn(regYn);
				vo.setPhoto(photo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return vo;
		
	}

	public List<MenuVo> selectMenuList(Connection conn, String rno) {
		
		String sql = "SELECT * FROM MENU WHERE R_NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MenuVo> voList = new ArrayList<MenuVo>();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rno);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String name = rs.getString("NAME");
				String price = rs.getString("PRICE");
				String photo = rs.getString("PHOTO");
				
				MenuVo vo = new MenuVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setPrice(price);
				vo.setPhoto(photo);
				
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

	public List<ReviewVo> selectReviewList(Connection conn, String rno) {
		
		String sql = "SELECT R.NO, R.R_NO, S.NAME, R.RE_NO, M.NICK, R.CONTENT, R.RELEASE_YN, R.DELETE_YN, R.ENROLL_DATE, R.UPDATE_DATE FROM REVIEW R INNER JOIN MEMBER M ON M.NO = R.M_NO INNER JOIN RESTAURANT S ON S.NO = R.R_NO WHERE S.NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReviewVo> voList = new ArrayList<ReviewVo>();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rno);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String restaurant = rs.getString("NAME");
				String reNo = rs.getString("RE_NO");
				String writer = rs.getString("NICK");
				String content = rs.getString("CONTENT");
				String releaseYn = rs.getString("RELEASE_YN");
				String deleteYn = rs.getString("DELETE_YN");
				String enrollDate = rs.getString("ENROLL_DATE");
				String updateDate = rs.getString("UPDATE_DATE");
				
				ReviewVo vo = new ReviewVo();
				vo.setNo(no);
				vo.setRestaurant(restaurant);
				vo.setReNo(reNo);
				vo.setWriter(writer);
				vo.setContent(content);
				vo.setReleaseYn(releaseYn);
				vo.setDeleteYn(deleteYn);
				vo.setEnrollDate(enrollDate);
				vo.setUpdateDate(updateDate);
				
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