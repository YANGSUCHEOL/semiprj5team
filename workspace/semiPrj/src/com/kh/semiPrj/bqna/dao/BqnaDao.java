package com.kh.semiPrj.bqna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.semiPrj.bqna.vo.BanswerVo;
import com.kh.semiPrj.bqna.vo.BquestionVo;
import com.kh.semiPrj.qna.vo.AnswerVo;
import com.kh.semiPrj.qna.vo.PageVo;
import com.kh.semiPrj.qna.vo.QuestionVo;

import common.JDBCTemplate;

public class BqnaDao {

	
	//질문 작성
	public int insertBqna(Connection conn, BquestionVo bvo) {
		
		 String sql = "INSERT INTO BQUESTION ( NO , TITLE , CONTENT, B_NO ) VALUES ( SEQ_BQ_NO.NEXTVAL  , ? , ? , ?)";
		 PreparedStatement pstmt = null;
         int result = 0;
         
         try {
             pstmt = conn.prepareStatement(sql);
       
             //
             pstmt.setString(1,  bvo.getTitle());
             pstmt.setString(2, bvo.getContent());
             pstmt.setString(3, bvo.getbNo());// 추후 닉네임으로 나오게 쿼리 수정
       
             result = pstmt.executeUpdate();
       
          } catch (SQLException e) {
             e.printStackTrace();
          } finally {
             common.JDBCTemplate.close(pstmt);
          }
       
          return result;
	}

	public List<BquestionVo> selectQuestionList(Connection conn, BquestionVo bvo) {

		String sql = "SELECT * FROM BQUESTION WHERE DELETE_YN = 'N' AND B_NO = ? ORDER BY NO DESC";
	
		 PreparedStatement pstmt = null;
         ResultSet rs = null;
         List<BquestionVo> bvoList = new ArrayList<BquestionVo>();
	
         try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bvo.getbNo());
			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				
				String no = rs.getString("NO");
				String bNo = rs.getString("B_NO");
				String title = rs.getString("TITLE");
				String enrollDate = rs.getString("ENROLL_DATE");
				String updateDate = rs.getString("UPDATE_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				String answerYn = rs.getString("ANSWER_YN");
			
				bvo = new BquestionVo();
				
				bvo.setNo(no);
				bvo.setbNo(bNo);
				bvo.setTitle(title);
				bvo.setEnrollDate(enrollDate);
				bvo.setUpdateDate(updateDate);
				bvo.setDeleteYn(deleteYn);
				bvo.setAnswerYn(answerYn);
				
				bvoList.add(bvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	 JDBCTemplate.close(rs);
        	 JDBCTemplate.close(pstmt);
         }
         
         return bvoList;
	}

	//조회수..... 주석처리하고싶음
	public int increaseHit(Connection conn, String bno) {
		String sql = "UPDATE BQUESTION SET HIT = HIT + 1 WHERE NO = ?";
		   
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

	public BquestionVo selectOne(Connection conn, String bno) {

	String sql = "SELECT BQ.NO , BQ.TITLE , BQ.CONTENT , BQ.ENROLL_DATE , BQ.UPDATE_DATE , BQ.DELETE_YN , BQ.ANSWER_YN , M.NICK AS NICK FROM BQUESTION BQ JOIN MEMBER M ON BQ.B_NO= M.NO WHERE BQ.NO = ? AND BQ.DELETE_YN = 'N'";
	
	PreparedStatement pstmt = null;
    ResultSet rs = null;
    BquestionVo bvo = null;
    
    try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, bno);
        rs = pstmt.executeQuery();
        
        if(rs.next()) {
            String no = rs.getString("NO");
            String bNo = rs.getString("NICK");
            String title = rs.getString("TITLE");
            String content = rs.getString("CONTENT");
            String enrollDate = rs.getString("ENROLL_DATE");
            String updateDate = rs.getString("UPDATE_DATE");
            String deleteYn = rs.getString("DELETE_YN");
            String answerYn = rs.getString("ANSWER_YN");
            
            bvo = new BquestionVo();
            bvo.setNo(no);
            bvo.setbNo(bNo);
            bvo.setTitle(title);
            bvo.setContent(content);
            bvo.setEnrollDate(enrollDate);
            bvo.setUpdateDate(updateDate);
            bvo.setDeleteYn(deleteYn);
            bvo.setAnswerYn(answerYn);
        }
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
	}
    
    return bvo;
	}

	public int updateOneByNo(Connection conn, BquestionVo bvo) {
		
		 String sql = "UPDATE BQUESTION SET TITLE = ? , CONTENT = ? , UPDATE_DATE = SYSDATE WHERE NO = ?";
		
		 PreparedStatement pstmt = null;
         int result = 0;
         
         try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, bvo.getTitle());
            pstmt.setString(2, bvo.getContent());
            pstmt.setString(3, bvo.getNo());
            
            result = pstmt.executeUpdate();
            
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            JDBCTemplate.close(pstmt);
         }
         
         return result;
	}

	public int delete(Connection conn, String no) {
		String sql = "UPDATE BQUESTION SET DELETE_YN = 'Y' WHERE NO = ?";
		
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

	public int selectCount(Connection conn) {
		String sql = "SELECT COUNT(*) AS CNT FROM BQUESTION WHERE DELETE_YN = 'N'";
	      
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

	public List<BquestionVo> selectList(Connection conn, PageVo pv) {

		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , T.* FROM ( SELECT BQ.NO ,BQ.B_NO ,BQ.TITLE ,BQ.CONTENT ,BQ.HIT ,BQ.ENROLL_DATE ,BQ.UPDATE_DATE ,BQ.DELETE_YN ,BQ.ANSWER_YN ,B.NICK AS WRITER FROM BQUESTION BQ JOIN BUSINESS B ON BQ.B_NO = B.NO WHERE BQ.DELETE_YN = 'N' ORDER BY BQ.NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
	
		
		 PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      List<BquestionVo> bvoList = new ArrayList<BquestionVo>();
	      
	      try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
	         int end = start + pv.getBoardLimit() - 1;
	         
	         pstmt.setInt(1, start);
	         pstmt.setInt(2, end);
	         
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	             
	             
	             String no = rs.getString("NO");
	             String bNo = rs.getString("WRITER");
	             String title = rs.getString("TITLE");
	             String content = rs.getString("CONTENT");
	             String hit = rs.getString("HIT");
	             String enrollDate = rs.getString("ENROLL_DATE");
	             String updateDate = rs.getString("UPDATE_DATE");
	             String deleteYn = rs.getString("DELETE_YN");
	             String answerYn = rs.getString("ANSWER_YN");
	          
	             BquestionVo bvo = new BquestionVo();
	             
	             bvo.setNo(no);
	             bvo.setbNo(bNo);
	             bvo.setTitle(title);
	             bvo.setContent(content);
	             bvo.setHit(hit);
	             bvo.setEnrollDate(enrollDate);
	             bvo.setUpdateDate(updateDate);
	             bvo.setDeleteYn(deleteYn);
	             bvo.setAnswerYn(answerYn);
	             
	             bvoList.add(bvo);
	          }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	         JDBCTemplate.close(rs);
	         JDBCTemplate.close(pstmt);
	      }
	      
	      return bvoList;
	      
	}

	public BquestionVo selectAdminOne(Connection conn, String bno) {

		 String sql = "SELECT BQ.NO , BQ.TITLE , BQ.CONTENT , BQ.HIT , BQ.ENROLL_DATE , BQ.UPDATE_DATE , BQ.DELETE_YN , BQ.ANSWER_YN , B.NICK AS NICK FROM BQUESTION BQ JOIN BUSINESS B ON BQ.B_NO = B.NO WHERE BQ.NO = ? AND BQ.DELETE_YN = 'N'";
	
		 PreparedStatement pstmt = null;
		   ResultSet rs = null;
		   
		   BquestionVo bvo = null;
		   
		   try {
			      pstmt = conn.prepareStatement(sql);
			      
			      pstmt.setString(1, bno);
			      
			      rs = pstmt.executeQuery();
			      
			      if(rs.next()) {
			         
			         String no = rs.getString("NO");
			         String bNo = rs.getString("NICK");
			         String title = rs.getString("TITLE");
			         String content = rs.getString("CONTENT");
			         String hit = rs.getString("HIT");
			         String enrollDate = rs.getString("ENROLL_DATE");
			         String updateDate = rs.getString("UPDATE_DATE");
			         String deleteYn = rs.getString("DELETE_YN");
			         String answerYn = rs.getString("ANSWER_YN");
			         
			         bvo = new BquestionVo();
			         
			         bvo.setNo(no);
			         bvo.setbNo(bNo);
			         bvo.setTitle(title);
			         bvo.setContent(content);
			         bvo.setHit(hit);
			         bvo.setEnrollDate(enrollDate);
			         bvo.setUpdateDate(updateDate);
			         bvo.setDeleteYn(deleteYn);
			         bvo.setAnswerYn(answerYn);
			         
			      }
			      
				   } catch (SQLException e) {
				      // TODO Auto-generated catch block
				      e.printStackTrace();
				   } finally {
				      JDBCTemplate.close(rs);
				      JDBCTemplate.close(pstmt);
				   }
				   return bvo;
	}

	public int insertAnswer(Connection conn, BanswerVo bavo) {
		
		String sql = "INSERT INTO BANSWER(NO, B_NO, M_NO, CONTENT) VALUES (SEQ_BA_NO.NEXTVAL, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
	    int result = 0;
	    
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bavo.getbNo());
			pstmt.setString(2, bavo.getmNo());
			pstmt.setString(3, bavo.getContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
	    
	    return result;

	}

	public BanswerVo selectAnswerOne(Connection conn, String bno) {
	
		String sql = "SELECT NO , CONTENT , ENROLL_DATE , UPDATE_DATE , DELETE_YN FROM BANSWER WHERE B_NO = ? AND DELETE_YN = 'N'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		BanswerVo bavo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String no = rs.getString("NO");			
				//String bNo = rs.getString("B_NO");
				
				String content = rs.getString("CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String updateDate = rs.getString("UPDATE_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				
				bavo = new BanswerVo();
				bavo.setNo(no);
				//bavo.setbNo(bNo);
				
				bavo.setContent(content);
				bavo.setEnrollDate(enrollDate);
				bavo.setUpdateDate(updateDate);
				bavo.setDeleteYn(deleteYn);
									
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return bavo;
	}	 

}
