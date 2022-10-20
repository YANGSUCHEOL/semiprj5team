package com.kh.semiPrj.qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.semiPrj.common.JDBCTemplate;
import com.kh.semiPrj.qna.vo.QuestionVo;

public class QnaDao {
	
	
	//게시글 작성 >> 이건 일반 회원인데...?
	public int insertQna(Connection conn, QuestionVo vo) {
		
		String sql = "INSERT INTO QUESTION ( NO , M_NO , TITLE , CONTENT ) VALUES ( SEQ_Q_NO.NEXTVAL , ? , ? , ? )";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getmNo()); // 추후 닉네임으로 나오게 쿼리 수정
			pstmt.setString(2,  vo.getTitle());
			pstmt.setString(3, vo.getContent());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
		
	}
	//question 목록조회
	public List<QuestionVo> selectQuestionList(Connection conn, QuestionVo vo) {
		
		String sql = "SELECT * FROM QUESTION WHERE DELETE_YN = 'N' AND M_NO = '?' ORDER BY NO DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QuestionVo> voList = new ArrayList<QuestionVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getmNo());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String no = rs.getString("NO");
				String mNo = rs.getString("M_NO");
				String title = rs.getString("CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String updateDate = rs.getString("UPDATE_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				
				vo = new QuestionVo();
				vo.setNo(mNo);
				vo.setmNo(mNo);
				vo.setTitle(title);
				vo.setEnrollDate(enrollDate);
				vo.setUpdateDate(updateDate);
				vo.setDeleteYn(deleteYn);
				
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
	
	
	//QUESTION 상세조회
	public QuestionVo selectOne(Connection conn, String qno) {
		
		String sql = "SELECT Q.NO , Q.TITLE , Q.CONTENT , Q.ENROLL_DATE , Q.UPDATE_DATE , Q.DELETE_YN , M.NICK AS WRITER FROM QUESTION Q JOIN MEMBER M ON Q.M_NO= M.NO WHERE Q.NO = 1 AND Q.DELETE_YN = 'N'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QuestionVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, qno);
			rs = pstmt.executeQuery();
			
			
			String no = rs.getString("NO");
			String mNo = rs.getString("M_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String updateDate = rs.getString("UPDATE_DATE");
			String deleteYn = rs.getString("DELETE_YN");
			
			vo = new QuestionVo();
			vo.setNo(qno);
			vo.setmNo(mNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setUpdateDate(updateDate);
			vo.setDeleteYn(deleteYn);
			
			
			
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return vo;
		
		
	}

}
