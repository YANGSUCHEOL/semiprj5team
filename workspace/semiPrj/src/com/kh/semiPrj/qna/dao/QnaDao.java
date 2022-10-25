package com.kh.semiPrj.qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;


import com.kh.semiPrj.qna.vo.PageVo;
import com.kh.semiPrj.qna.vo.QuestionVo;

public class QnaDao {

	
		//게시글 작성 >> 이건 일반 회원인데...?
		public int insertQna(Connection conn, QuestionVo vo) {
		
			String sql = "INSERT INTO QUESTION ( NO , TITLE , CONTENT, M_NO ) VALUES ( SEQ_Q_NO.NEXTVAL  , ? , ? , ?)";
			PreparedStatement pstmt = null;
			int result = 0;
			//m_no 지움
			try {
				pstmt = conn.prepareStatement(sql);
		
				//
				pstmt.setString(1,  vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setString(3, vo.getmNo());// 추후 닉네임으로 나오게 쿼리 수정
		
				result = pstmt.executeUpdate();
		
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				common.JDBCTemplate.close(pstmt);
			}
		
			return result;
		
		}
		
		//question 목록조회
		public List<QuestionVo> selectQuestionList(Connection conn, QuestionVo vo) {
		
			String sql = "SELECT * FROM QUESTION WHERE DELETE_YN = 'N' AND M_NO = ? ORDER BY NO DESC";
		
			//쿼리에 AND M_NO = '?' 지움
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
					String answerYn = rs.getString("ANSWER_YN");
		
					vo = new QuestionVo();
					vo.setNo(no);
					vo.setmNo(mNo);
					vo.setTitle(title);
					vo.setEnrollDate(enrollDate);
					vo.setUpdateDate(updateDate);
					vo.setDeleteYn(deleteYn);
					vo.setAnswerYn(answerYn);
		
					voList.add(vo);
		
				}
		
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("qnadao 목록조회 돌아가니?");
			} finally {
				common.JDBCTemplate.close(rs);
				common.JDBCTemplate.close(pstmt);
			}
		
			return voList;
		
		}
		
		//QUESTION 상세조회
		public QuestionVo selectOne(Connection conn, String no) {
		
			String sql = "SELECT Q.NO , Q.TITLE , Q.CONTENT , Q.ENROLL_DATE , Q.UPDATE_DATE , Q.DELETE_YN , Q.ANSWER_YN, M.NICK AS M_NO FROM QUESTION Q JOIN MEMBER M ON Q.M_NO= M.NO WHERE Q.NO = ? AND Q.DELETE_YN = 'N'";
		
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			QuestionVo vo = null;
		
			try {
				pstmt = conn.prepareStatement(sql);
		
				pstmt.setString(1, no);
				rs = pstmt.executeQuery();
		
				if(rs.next()) {
					//String no1 = rs.getString("NO");
					String mNo = rs.getString("M_NO");
					String title = rs.getString("TITLE");
					String content = rs.getString("CONTENT");
					String enrollDate = rs.getString("ENROLL_DATE");
					String updateDate = rs.getString("UPDATE_DATE");
					String deleteYn = rs.getString("DELETE_YN");
					String answerYn = rs.getString("ANSWER_YN");
		
					vo = new QuestionVo();
					vo.setNo(no);
					vo.setmNo(mNo);
					vo.setTitle(title);
					vo.setContent(content);
					vo.setEnrollDate(enrollDate);
					vo.setUpdateDate(updateDate);
					vo.setDeleteYn(deleteYn);
					vo.setAnswerYn(answerYn);
		
				}
		
			} catch (SQLException e) {
		
				e.printStackTrace();
			}finally {
				common.JDBCTemplate.close(rs);
				common.JDBCTemplate.close(pstmt);
			}
		
			return vo;
	
	}
	
	//조회수 증가
	
	public int increaseHit(Connection conn, String bno) {
	
			//SQL
	
				String sql = "UPDATE QUESTION SET HIT = HIT + 1 WHERE NO = ?";
	
				PreparedStatement pstmt = null;
				int result = 0;
	
				try {
					pstmt = conn.prepareStatement(sql);
	
					pstmt.setString(1, bno);
	
					result = pstmt.executeUpdate();
	
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JDBCTemplate.close(pstmt);
				}
	
				return result;
	
	}

	//수정
	public int updateOneByNo(Connection conn, QuestionVo vo) {
		
		// SQL (준비, 완성, 실행)
		
				String sql = "UPDATE QUESTION SET TITLE = ? , CONTENT = ? , UPDATE_DATE = SYSDATE WHERE NO = ?";

				
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
					JDBCTemplate.close(pstmt);
				}
				
				return result;
		
	}

	public int delete(Connection conn, String no) {
		//SQL (준비 , 완성 , 실행)
		
				
		String sql = "UPDATE QUESTION SET DELETE_YN = 'Y' WHERE NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	//페이징 갯수 세기
	public int selectCount(Connection conn) {
		String sql = "SELECT COUNT(*) AS CNT FROM QUESTION WHERE DELETE_YN = 'N'";
		
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
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	
	//관리자 목록 조회
	public List<QuestionVo> selectList(Connection conn, PageVo pv) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , T.* FROM ( SELECT Q.NO ,Q.M_NO ,Q.TITLE ,Q.CONTENT ,Q.HIT ,Q.ENROLL_DATE ,Q.UPDATE_DATE ,Q.DELETE_YN ,Q.ANSWER_YN ,M.NICK AS WRITER FROM QUESTION Q JOIN MEMBER M ON Q.M_NO = M.NO WHERE Q.DELETE_YN = 'N' ORDER BY Q.NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QuestionVo> voList = new ArrayList<QuestionVo>();
		System.out.println("여기까지 왔어? 관리자 select dao");
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
			int end = start + pv.getBoardLimit() - 1;
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				
				String no = rs.getString("NO");
				String mNo = rs.getString("M_NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String hit = rs.getString("HIT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String updateDate = rs.getString("UPDATE_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				String answerYn = rs.getString("ANSWER_YN");
			
				QuestionVo vo = new QuestionVo();
				
				vo.setNo(no);
				vo.setmNo(mNo);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setHit(hit);
				vo.setEnrollDate(enrollDate);
				vo.setUpdateDate(updateDate);
				vo.setDeleteYn(deleteYn);
				vo.setAnswerYn(answerYn);
				
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

	//관리자 상세 조회
	public QuestionVo selectAdminOne(Connection conn, String bno) {
		
	String sql = "SELECT Q.NO , Q.TYPE , Q.TITLE , Q.CONTENT , Q.HIT , Q.ENROLL_DATE , Q.MODIFY_DATE , Q.STATUS , M.NICK AS Q.M_NO FROM QUESTION Q JOIN MEMBER M ON Q.M_NO = M.NO WHERE Q.NO = ? AND Q.DELETE_YN = 'N'";
	System.out.println("여기까지 왔어? 관리자 detail dao");
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	QuestionVo vo = null;
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, bno);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
		
			
			String no = rs.getString("NO");
			String mNo = rs.getString("M_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String updateDate = rs.getString("UPDATE_DATE");
			String deleteYn = rs.getString("DELETE_YN");
			String answerYn = rs.getString("ANSWER_YN");
			
			vo = new QuestionVo();
			
			vo.setNo(no);
			vo.setmNo(mNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setHit(hit);
			vo.setEnrollDate(enrollDate);
			vo.setUpdateDate(updateDate);
			vo.setDeleteYn(deleteYn);
			vo.setAnswerYn(answerYn);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
	}
	return vo;
	
	}
	
	
	
	//답변 작성
	//public int insertAnswer(Connection conn, AnswerVo avo) {
		//String sql = "INSERT INTO ANSWER ( NO , TITLE , CONTENT, Q_NO) VALUES ( SEQ_Q_NO.NEXTVAL  , ? , ? , ?)";
	
		//PreparedStatement pstmt = null;
		//int result = 0;
	
	
	
	//	}

}