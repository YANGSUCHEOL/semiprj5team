package com.kh.semiPrj.qna.service;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;


import com.kh.semiPrj.qna.dao.QnaDao;
import com.kh.semiPrj.qna.vo.AnswerVo;
import com.kh.semiPrj.qna.vo.PageVo;
import com.kh.semiPrj.qna.vo.QuestionVo;

public class QnaService {

	private final QnaDao dao = new QnaDao();
	
		// 질문 작성
		public int write(QuestionVo vo) {
			//커넥션 준비
			//sql
			//트랜젝션, 자원반납
	
			Connection conn = JDBCTemplate.getConnection();
	
			//게시글 insert
			int result = dao.insertQna(conn, vo);
	
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
	
			JDBCTemplate.close(conn);
	
			return result;
		}
	
		//목록 조회
		public List<QuestionVo> selectQuestionList(QuestionVo vo) {
	
			//커넥션
			//sql
			//트랜젝션 처리. 자원반납
	
			Connection conn = JDBCTemplate.getConnection();
	
			List<QuestionVo> voList = dao.selectQuestionList(conn, vo);
	
			JDBCTemplate.close(conn);
	
			return voList;
		}
	
		//상세조회
		public QuestionVo selectOne(String no) {
	
			//커넥션 준비
			//sql
			//트랜젝션 자원반납
	
			Connection conn = JDBCTemplate.getConnection();
			QuestionVo vo = null;
	
			int result = dao.increaseHit(conn, no);
	
			if(result == 1) {
				JDBCTemplate.commit(conn);
				vo = dao.selectOne(conn , no);
			}
	
			JDBCTemplate.close(conn);
			
			return vo;
	
		}
		
		
		
		
		
		//수정
		public int edit(QuestionVo vo) {
			// 커넥션 준비
			// SQL
			// 트랜잭션 , 자원반납
			
			Connection conn = JDBCTemplate.getConnection();
			
			int result = dao.updateOneByNo(conn , vo);
			
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
			JDBCTemplate.close(conn);
			
			return result;
		
		}

		public int delete(String no) {
			
			// 커넥션 준비
			// SQL
			// 트랜잭션 처리 , 자원반납
			
			Connection conn = JDBCTemplate.getConnection();
			
			int result = dao.delete(conn , no);
			
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
			JDBCTemplate.close(conn);
			
			return result;
		}

		
		//개시글 갯수 조회
		public int selectCount() {
			//커넥션준비
			//SQL
			//트랜잭션 , 자원반납
			
			Connection conn = JDBCTemplate.getConnection();
			
			int result = dao.selectCount(conn);
			
			JDBCTemplate.close(conn);
			
			return result;
		}
		
		
		//목록 조회
		public List<QuestionVo> selectList(PageVo pv) {
			//커넥션 준비
			//SQL
			//트랜잭션 , 자원반납
			
			Connection conn = JDBCTemplate.getConnection();
			
			List<QuestionVo> x = dao.selectList(conn , pv);
			
			JDBCTemplate.close(conn);
			
			return x;
		}


		
		//관리자 상세조회
		public QuestionVo selectAdminOne(String bno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.increaseHit(conn, bno);
		
		QuestionVo vo = null;
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
			vo = dao.selectAdminOne(conn, bno);
		}
		
		JDBCTemplate.close(conn);
		
		return vo;	
		}

		
		//////답변 작성
		public int insertAnswer(AnswerVo avo) {
			Connection conn = JDBCTemplate.getConnection();
			
			int result = new QnaDao().insertAnswer(conn, avo);
			
			if(result == 1) {
				JDBCTemplate.commit(conn);
				
			}else{
				JDBCTemplate.rollback(conn);
			}
			
			JDBCTemplate.close(conn);
			
			return result;
		}
		
		
	
		//답 작성
		//노션에 있음 붙여와
	
		//public int writeAnswer(AnswerVo avo) {
			// TODO Auto-generated method stub
			//return 0;
		//}
	
	
	
	}