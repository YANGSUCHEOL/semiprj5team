package com.kh.semiPrj.qna.service;

import java.sql.Connection;
import java.util.List;

import com.kh.semiPrj.common.JDBCTemplate;
import com.kh.semiPrj.qna.dao.QnaDao;
import com.kh.semiPrj.qna.vo.QuestionVo;

public class QnaService {
	
	private final QnaDao dao = new QnaDao();


		
		//게시글 작성 // 질문 작성
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



		public List<QuestionVo> selectQuestionList(QuestionVo vo) {
			
			//커넥션
			//sql
			//트랜젝션 처리. 자원반납
			
			Connection conn = JDBCTemplate.getConnection();
			
			List<QuestionVo> voList = dao.selectQuestionList(conn, vo);
			
			JDBCTemplate.close(conn);
			
			
			return voList;
		}



		public QuestionVo selectOne(String qno) {
			
			//커넥션 준비
			//sql
			//트랜젝션 자원반납
			
			Connection conn = JDBCTemplate.getConnection();
			
			QuestionVo vo = null;
			
			vo = dao.selectOne(conn, qno);
			
			return vo;
			
			
			
		}
		
	

}
