package com.kh.semiPrj.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.semiPrj.review.vo.ReviewVo;

import common.JDBCTemplate;

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

}
