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
		public List<QuestionVo> selectQuestionList(PageVo pv, QuestionVo vo) {
			
			//커넥션
			//sql
			//트랜젝션 처리. 자원반납
			
			Connection conn = JDBCTemplate.getConnection();
			
			List<QuestionVo> voList = dao.selectQuestionList(conn, vo, pv);
			
			JDBCTemplate.close(conn);
			
			
			return voList;
		}
		
		//갯수 조회
		public int selectCount(QuestionVo vo) {
			
			Connection conn = JDBCTemplate.getConnection();
			
			int result = dao.selectCount(conn, vo);
			
			JDBCTemplate.close(conn);
			
			return result;
		}
				


		//상세조회
		public QuestionVo selectOne(String bno) {
			
			//커넥션 준비
			//sql
			//트랜젝션 자원반납
			
			Connection conn = JDBCTemplate.getConnection();
			
			int result = dao.increaseHit(conn, bno);

			QuestionVo vo = null;
			if(result == 1) {
				JDBCTemplate.commit(conn);
				vo = dao.selectOne(conn , bno);
			}
			
			JDBCTemplate.close(conn);
			System.out.println("service 도니?");
			return vo;
			
			
			
		}




		//답 작성
		//노션에 있음 붙여와

		public int writeAnswer(AnswerVo avo) {
			// TODO Auto-generated method stub
			return 0;
		}

		
	

}
