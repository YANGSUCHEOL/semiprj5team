package faq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import faq.vo.FaqVo;

public class FaqDao {

	//FAQ 목록조회
	public List<FaqVo> selectFaqList(Connection conn) {

		//SQL (준비, 완성, 실행 및 결과 저장)
		String sql = "SELECT * FROM FAQ WHERE STATUS = 'O' ORDER BY NO DESC ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FaqVo> voList = new ArrayList<FaqVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String updateDate = rs.getString("UPDATE_DATE");
				
				FaqVo vo = new FaqVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setEnrollDate(enrollDate);
				vo.setUpdateDate(updateDate);
				
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

	//FAQ 작성
	public int insertFaq(Connection conn, FaqVo vo) {
		
		String sql = "INSERT INTO FAQ (NO, TITLE, CONTENT) VALUES (SEQ_FAQ_NO.NEXTVAL, ?, ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	//FAQ 상세조회
	public FaqVo selectFaqOne(Connection conn, String no) {
		
		String sql = "SELECT NO, TITLE, CONTENT, ENROLL_DATE, UPDATE_DATE, STATUS FROM FAQ WHERE NO = ? AND STATUS = 'O'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FaqVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String updateDate = rs.getString("UPDATE_DATE");
				
				vo = new FaqVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setEnrollDate(enrollDate);
				vo.setUpdateDate(updateDate);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return vo;
	}

	//FAQ 수정하기
	public int updateOne(Connection conn, FaqVo vo) {
		
		String sql = "UPDATE FAQ SET TITLE = ?, CONTENT = ?, UPDATE_DATE = SYSDATE WHERE NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(1, vo.getContent());
			pstmt.setString(1, vo.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	//FAQ 삭제하기
	public int delet(Connection conn, String no) {
		
		String sql = "UPDATE FAQ SET STATUS = 'X' WHERE NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	

}
