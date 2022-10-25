package com.kh.semiPrj.faq.service;

import java.sql.Connection;
import java.util.List;

import com.kh.semiPrj.faq.dao.FaqDao;
import com.kh.semiPrj.faq.vo.FaqVo;

import common.JDBCTemplate;

public class FaqService {

	//FAQ 목록 조회
	public List<FaqVo> selectFaqList() {
		
		//커넥션 준비
		//SQL 준비
		//트랜잭션 처리, 자원 반납
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<FaqVo> voList = new FaqDao().selectFaqList(conn);
		
		JDBCTemplate.close(conn);
		
		return voList;
	}

	//FAQ 작성
	public int write(FaqVo vo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new FaqDao().insertFaq(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//FAQ 삭제
	public int delete(String no) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new FaqDao().delete(conn, no);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	//FAQ 수정
	public int edit(FaqVo vo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new FaqDao().updateByNo(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//FAQ 상세조회
	public FaqVo selectFaqOne(String no) {
		
		//커넥션 준비
		//SQL 준비
		//트랜잭션 처리, 자원반납
		Connection conn = JDBCTemplate.getConnection();
		
		FaqVo vo = new FaqDao().selectFaqOne(conn, no);
		
		JDBCTemplate.close(conn);
		
		return vo;
		
	}

	
	
	
}
