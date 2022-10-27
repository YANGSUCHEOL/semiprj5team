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
