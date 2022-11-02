package com.kh.semiPrj.community.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static common.JDBCTemplate.*;

import common.PageVo;
import oracle.jdbc.proxy.annotation.Pre;

import com.kh.semiPrj.community.vo.AttachmentVo;
import com.kh.semiPrj.community.vo.CategoryVo;
import com.kh.semiPrj.community.vo.CommentVo;
import com.kh.semiPrj.community.vo.CommuVo;

public class CommuDao {

	//카테고리 목록 조회(select)
	public List<CategoryVo> selectCategoryList(Connection conn) {

		String sql = "SELECT C_NO, NAME FROM CATEGORY";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CategoryVo> list = new ArrayList<CategoryVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String cNo = rs.getString("C_NO");
				String name = rs.getString("NAME");
				
				CategoryVo vo = new CategoryVo(cNo, name);
				
				list.add(vo);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	
	}//selectCategoryList

	
	
	//게시글 작성(insert)
	public int insertBoard(Connection conn, CommuVo vo) {

		String sql = "INSERT INTO COMMUNITY ( NO ,TYPE ,CATEGORY ,TITLE ,CONTENT ,WRITER ) VALUES ( SEQ_COMMUNITY_NO.NEXTVAL , 1 , ? , ? , ? , ? )";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getCategory());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getWriter());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	
	}//insertBoard

	
	
	//커뮤니티 리스트 조회하기(select)
	public List<CommuVo> selectList(Connection conn, PageVo pv) {

		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT C.NO , C.TYPE , C.TITLE , C.CONTENT , C.HIT , C.ENROLL_DATE , C.MODIFY_DATE , C.STATUS , M.NICK AS WRITER , A.NAME AS CATEGORY FROM COMMUNITY C JOIN MEMBER M ON C.WRITER = M.NO JOIN CATEGORY A ON C.CATEGORY = A.C_NO WHERE C.STATUS = 'O' ORDER BY C.NO DESC )T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CommuVo> voList = new ArrayList<CommuVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
			int end = start + pv.getBoardLimit() - 1;
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String no = rs.getString("NO");
				String type = rs.getString("TYPE");
				String category = rs.getString("CATEGORY");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String writer = rs.getString("WRITER");
				String hit = rs.getString("HIT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String status = rs.getString("STATUS");
				
				CommuVo vo = new CommuVo();
				vo.setNo(no);
				vo.setType(type);
				vo.setCategory(category);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setHit(hit);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
				vo.setStatus(status);
				
				voList.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return voList;
	
	}//selectList


	//게시글 갯수 조회(select)
	public int selectCount(Connection conn) {
		
		String sql = "SELECT COUNT(*) AS CNT FROM COMMUNITY WHERE STATUS = 'O'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("CNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
		
	}//selectCount


	//게시글 상세 조회
	public CommuVo selectOne(Connection conn, String bno) {

		String sql = "SELECT C.NO ,C.TYPE ,C.TITLE ,C.CONTENT ,C.HIT ,C.ENROLL_DATE ,C.MODIFY_DATE ,C.STATUS ,M.NICK AS WRITER ,A.NAME AS CATEGORY FROM COMMUNITY C JOIN MEMBER M ON C.WRITER = M.NO JOIN CATEGORY A ON C.CATEGORY = A.C_NO WHERE C.NO = ? AND C.STATUS = 'O'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CommuVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String no = rs.getString("NO");
				String type = rs.getString("TYPE");
				String category = rs.getString("CATEGORY");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String writer = rs.getString("WRITER");
				String hit = rs.getString("HIT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String status = rs.getString("STATUS");
				
				vo = new CommuVo();
				vo.setNo(no);
				vo.setType(type);
				vo.setCategory(category);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setHit(hit);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
				vo.setStatus(status);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
			
		return vo;
		
	}//selectOne


	//조회수 증가
	public int increaseHit(Connection conn, String bno) {
		
		String sql = "UPDATE COMMUNITY SET HIT = HIT + 1 WHERE NO = ? AND STATUS = 'O'";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	
	}//increaseHit

	//게시글 수정하기(update)
	public int updateByNo(Connection conn, CommuVo vo) {

		String sql = "UPDATE COMMUNITY SET CATEGORY = ?, TITLE = ?, CONTENT = ?, MODIFY_DATE = SYSDATE WHERE NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getCategory());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getNo());
			
			result = pstmt.executeUpdate();
			
			//System.out.println("dao" + vo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	
	
	}//updateByNo


	
	
	//게시글 삭제하기
	public int delete(Connection conn, String bno) {
		
		String sql = "UPDATE COMMUNITY SET STATUS = 'X' WHERE NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}



	//댓글 작성하기(insert)
	public int insertReply(Connection conn, CommentVo r) {

		String sql = "INSERT INTO COMMUNITY_CMT ( NO, CONTENT, COMMU_NO, M_NO, NICK ) VALUES ( SEQ_COMMUNITY_CMT_NO.NEXTVAL, ?, ?, ?, ? )";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, r.getContent());
			pstmt.setString(2, r.getCommuNo());
			pstmt.setString(3, r.getmNo());
			pstmt.setString(4, r.getNick());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
			
	}


	//첨부파일 insert
	public int insertAttachment(Connection conn, AttachmentVo attachmentVo) {

		String sql = "INSERT INTO ATTACHMENT ( NO ,COMMUNITY_NO ,ORIGIN_NAME ,CHANGE_NAME ,FILE_PATH ) VALUES ( SEQ_ATTACHMENT_NO.NEXTVAL ,SEQ_COMMUNITY_NO.CURRVAL , ? , ? , ? )";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, attachmentVo.getOriginName());
			pstmt.setString(2, attachmentVo.getChangeName());
			pstmt.setString(3, attachmentVo.getFilePath());
			
			result = pstmt.executeUpdate();
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	
		return result;
	
	}//insertAttachment

	
	
	
	//첨부파일 조회
	public AttachmentVo selectAttachment(Connection conn, String bno) {

		String sql = "SELECT * FROM ATTACHMENT WHERE STATUS = 'O' AND COMMUNITY_NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AttachmentVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String no = rs.getString("NO");
				String communityNo = rs.getString("COMMUNITY_NO");
				String originName = rs.getString("ORIGIN_NAME");
				String changeName = rs.getString("CHANGE_NAME");
				String filePath = rs.getString("FILE_PATH");
				String enrollDate = rs.getString("ENROLL_DATE");
				String thumbYn = rs.getString("THUMB_YN");
				String status = rs.getString("STATUS");	
				
				vo = new AttachmentVo();
				vo.setNo(no);
				vo.setCommunityNo(communityNo);
				vo.setOriginName(originName);
				vo.setChangeName(changeName);
				vo.setFilePath(filePath);
				vo.setEnrollDate(enrollDate);
				vo.setThumbYn(thumbYn);
				vo.setStatus(status);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return vo;
	
	}//selectAttachment


	//커뮤니티 댓글 리스트(select)
	public List<CommentVo> selectReplyList(Connection conn, String commuNo) {
		
		String sql = "SELECT C.NO , C.CONTENT , M.NICK AS NICK , C.ENROLL_DATE FROM COMMUNITY_CMT C JOIN MEMBER M ON C.M_NO = M.NO WHERE M.QUIT_YN = 'N' AND C.DELETE_YN = 'N' AND C.COMMU_NO = ? ORDER BY C.ENROLL_DATE DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CommentVo> list = new ArrayList<CommentVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, commuNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String no = rs.getString("NO");
				String content = rs.getString("CONTENT");
				String nick = rs.getString("NICK");
				String enrollDate = rs.getString("ENROLL_DATE");
				
				
				CommentVo vo = new CommentVo();
				vo.setNo(no);
				vo.setNo(content);
				vo.setNo(nick);
				vo.setNo(enrollDate);
				
				list.add(vo);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}//selectReplyList


	




	
	

	
			

}//class
