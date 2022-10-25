package com.kh.semiPrj.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.semiPrj.review.vo.ReviewVo;

import common.JDBCTemplate;
import common.PageVo;

public class ReviewDao {

	public int insertOne(Connection conn, ReviewVo vo) {

		String sql = "INSERT INTO REVIEW ( NO, R_NO, M_NO, RE_NO, SCORE, CONTENT, RELEASE_YN, DELETE_YN, ENROLL_DATE, UPDATE_DATE ) VALUES ( SEQ_REVIEW_NO.NEXTVAL, ?, ?, ?, ?, ?, ?, 'N', SYSDATE, SYSDATE )";

		PreparedStatement pstmt = null;
		int result = 0;

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getRestaurant());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getReNo());
			pstmt.setString(4, Integer.toString(vo.getScore()));
			pstmt.setString(5, vo.getContent());
			pstmt.setString(6, vo.getReleaseYn());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;

	}

	public int selectCount(Connection conn, String rno) {

		String sql = "SELECT COUNT(*) AS CNT FROM REVIEW WHERE R_NO = ? AND RELEASE_YN = 'Y' AND DELETE_YN = 'N'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, rno);

			rs = pstmt.executeQuery();

			if (rs.next()) {
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
	
	public int selectCountMember(Connection conn, String mno) {

		String sql = "SELECT COUNT(*) AS CNT FROM REVIEW WHERE M_NO = ? AND RELEASE_YN = 'Y' AND DELETE_YN = 'N'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mno);

			rs = pstmt.executeQuery();

			if (rs.next()) {
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

	public List<ReviewVo> selectList(Connection conn, String resNo, PageVo pv) {
		
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, A.* FROM ( SELECT R.NO, S.NAME AS RESTAURANT, M.NAME AS NAME, R.SCORE, R.CONTENT, R.RELEASE_YN, R.DELETE_YN, R.ENROLL_DATE, R.UPDATE_DATE FROM REVIEW R INNER JOIN RESTAURANT S ON S.NO = R.R_NO INNER JOIN MEMBER M ON M.NO = R.M_NO WHERE R.R_NO = ? AND R.RELEASE_YN = 'Y' AND R.DELETE_YN = 'N') A) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReviewVo> voList = new ArrayList<ReviewVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
			int end = start + pv.getBoardLimit() - 1;
			
			pstmt.setString(1, resNo);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String restaurant = rs.getString("RESTAURANT");
				String name = rs.getString("NAME");
				String score = rs.getString("SCORE");
				String content = rs.getString("CONTENT");
				String releaseYn = rs.getString("RELEASE_YN");
				String deleteYn = rs.getString("DELETE_YN");
				String enrollDate = rs.getString("ENROLL_DATE");
				String updateDate = rs.getString("UPDATE_DATE");
				
				ReviewVo vo = new ReviewVo();
				vo.setNo(no);
				vo.setRestaurant(restaurant);
				vo.setWriter(name);
				vo.setScore(Integer.parseInt(score));
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
	
	public List<ReviewVo> selectListExceptPage(Connection conn, String resNo) {
		
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, A.* FROM ( SELECT R.NO, S.NAME AS RESTAURANT, M.NAME AS NAME, R.SCORE, R.CONTENT, R.RELEASE_YN, R.DELETE_YN, R.ENROLL_DATE, R.UPDATE_DATE FROM REVIEW R INNER JOIN RESTAURANT S ON S.NO = R.R_NO INNER JOIN MEMBER M ON M.NO = R.M_NO WHERE R.R_NO = ? AND R.RELEASE_YN = 'Y' AND R.DELETE_YN = 'N') A)";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReviewVo> voList = new ArrayList<ReviewVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, resNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String restaurant = rs.getString("RESTAURANT");
				String name = rs.getString("NAME");
				String score = rs.getString("SCORE");
				String content = rs.getString("CONTENT");
				String releaseYn = rs.getString("RELEASE_YN");
				String deleteYn = rs.getString("DELETE_YN");
				String enrollDate = rs.getString("ENROLL_DATE");
				String updateDate = rs.getString("UPDATE_DATE");
				
				ReviewVo vo = new ReviewVo();
				vo.setNo(no);
				vo.setRestaurant(restaurant);
				vo.setWriter(name);
				vo.setScore(Integer.parseInt(score));
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

	public int editOne(Connection conn, ReviewVo vo) {
		
		return 0;
		
	}

	public List<ReviewVo> selectListClient(Connection conn, String mno, PageVo pv) {
		
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, A.* FROM ( SELECT R.NO, S.NAME AS RESTAURANT, M.NAME AS NAME, R.SCORE, R.CONTENT, R.RELEASE_YN, R.DELETE_YN, R.ENROLL_DATE, R.UPDATE_DATE FROM REVIEW R INNER JOIN RESTAURANT S ON S.NO = R.R_NO INNER JOIN MEMBER M ON M.NO = R.M_NO WHERE M.NO = ? AND R.RELEASE_YN = 'Y' AND R.DELETE_YN = 'N') A) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReviewVo> voList = new ArrayList<ReviewVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
			int end = start + pv.getBoardLimit() - 1;
			
			pstmt.setString(1, mno);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String restaurant = rs.getString("RESTAURANT");
				String name = rs.getString("NAME");
				String score = rs.getString("SCORE");
				String content = rs.getString("CONTENT");
				String releaseYn = rs.getString("RELEASE_YN");
				String deleteYn = rs.getString("DELETE_YN");
				String enrollDate = rs.getString("ENROLL_DATE");
				String updateDate = rs.getString("UPDATE_DATE");
				
				ReviewVo vo = new ReviewVo();
				vo.setNo(no);
				vo.setRestaurant(restaurant);
				vo.setWriter(name);
				vo.setScore(Integer.parseInt(score));
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
