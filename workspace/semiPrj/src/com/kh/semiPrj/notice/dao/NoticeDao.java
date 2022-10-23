package com.kh.semiPrj.notice.dao;

import static com.kh.semiPrj.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.semiPrj.notice.vo.NoticeVo;

public class NoticeDao {

	
	
	//공지 작성하기(insert)
	public int insertNotice(Connection conn, NoticeVo vo) {
		//SQL 준비, 완성, 실행
		String sql = "INSERT INTO NOTICE ( NO ,TITLE ,CONTENT ,WRITER ) VALUES ( SEQ_NOTICE_NO.NEXTVAL , ? , ? , ? )";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}//insertNotice
	
	

	//공지사항 목록 조회(select)
	public List<NoticeVo> selectNoticeList(Connection conn) {
		
		String sql = "SELECT * FROM NOTICE WHERE STATUS = 'O' ORDER BY NO DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<NoticeVo> voList = new ArrayList<NoticeVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String writer = rs.getString("WRITER");
				String hit = rs.getString("HIT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				
				NoticeVo vo = new NoticeVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setHit(hit);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
				
				voList.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return voList;
	
	}//selectNoticeList

	
	
	
	//공지 게시글 상세 조회(select)
	public NoticeVo selectNoticeDetail(Connection conn, String no) {
		
		String sql = "SELECT N.NO ,N.TITLE ,N.CONTENT ,N.HIT ,N.ENROLL_DATE ,N.MODIFY_DATE ,N.STATUS ,A.NICK AS WRITER FROM NOTICE N JOIN ADMIN A ON N.WRITER = A.NO WHERE N.NO = ? AND N.STATUS = 'O'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeVo noticeVo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String writer = rs.getString("WRITER");
				String hit = rs.getString("HIT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				
				noticeVo = new NoticeVo();
				noticeVo.setNo(no);
				noticeVo.setTitle(title);
				noticeVo.setContent(content);
				noticeVo.setWriter(writer);
				noticeVo.setHit(hit);
				noticeVo.setEnrollDate(enrollDate);
				noticeVo.setModifyDate(modifyDate);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return noticeVo;
		
	}//selectNoticeDetail
	
	//공지 수정하기(update)
	public int updateByNo(Connection conn, NoticeVo vo) {
		
		String sql = "UPDATE NOTICE SET TITLE = ?, CONTENT = ?, MODIFY_DATE = SYSDATE WHERE NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}//updateByNo
	
	
	//공지 삭제(delete)
	public int delete(Connection conn, String no) {

		String sql = "DELETE NOTICE WHERE NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
	
		return result;
	}//delete
	
	

}
