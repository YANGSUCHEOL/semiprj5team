package com.kh.semiPrj.bqna.service;

import java.sql.Connection;
import java.util.List;

import com.kh.semiPrj.bqna.dao.BqnaDao;
import com.kh.semiPrj.bqna.vo.BanswerVo;
import com.kh.semiPrj.bqna.vo.BquestionVo;
import com.kh.semiPrj.qna.dao.QnaDao;
import com.kh.semiPrj.qna.vo.PageVo;
import com.kh.semiPrj.qna.vo.QuestionVo;

import common.JDBCTemplate;

public class BqnaService {
	
	private final BqnaDao bdao = new BqnaDao();

	//사업자 질문 작성
	public int write(BquestionVo bvo) {

		Connection conn = JDBCTemplate.getConnection();
		
		//게시글 insert
		int result = bdao.insertBqna(conn, bvo);

		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result;
	}

	public List<BquestionVo> selectQuestionList(BquestionVo bvo) {

		Connection conn = JDBCTemplate.getConnection();
		
		List<BquestionVo> bvoList = bdao.selectQuestionList(conn, bvo);

		JDBCTemplate.close(conn);

		return bvoList;
	}

	public BquestionVo selectOne(String no) {
		
		Connection conn = JDBCTemplate.getConnection();
		BquestionVo bvo = null;

		int result = bdao.increaseHit(conn, no);

		if(result == 1) {
			JDBCTemplate.commit(conn);
			bvo = bdao.selectOne(conn , no);
		}

		JDBCTemplate.close(conn);
		
		return bvo;
	}

	public int edit(BquestionVo bvo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = bdao.updateOneByNo(conn , bvo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//삭제
	public int delete(String no) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = bdao.delete(conn , no);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int selectCount() {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = bdao.selectCount(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public List<BquestionVo> selectList(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<BquestionVo> x = bdao.selectList(conn , pv);
		
		JDBCTemplate.close(conn);
		
		return x;
	
	}

	public BquestionVo selectAdminOne(String bno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = bdao.increaseHit(conn, bno);
		
		BquestionVo bvo = null;
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
			bvo = bdao.selectAdminOne(conn, bno);
		}
		
		JDBCTemplate.close(conn);
		
		return bvo;	
	
	}

	public int insertAnswer(BanswerVo bavo) {
		Connection conn = JDBCTemplate.getConnection();
		//QuestionVo vo = null;
		
		int result = new BqnaDao().insertAnswer(conn, bavo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
			//vo = new BqnaDao().updateYn(conn , qno);
			
		}else{
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	
	}

	public BanswerVo selectAnswerOne(String bno) {
		
		Connection conn = JDBCTemplate.getConnection();
		BanswerVo bavo = null;

		int result = bdao.increaseHit(conn, bno);

		if(result == 1) {
			JDBCTemplate.commit(conn);
			bavo = bdao.selectAnswerOne(conn , bno);
		}

		JDBCTemplate.close(conn);
		
		return bavo;
	
	}

	

	public int edit(BanswerVo bavo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = bdao.updateOneByNo(conn , bavo);
		System.out.println("돌아갔어?");
		System.out.println(result);
		if(result == 1) {
			JDBCTemplate.commit(conn);
			
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	

}
