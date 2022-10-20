package faq.service;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;
import faq.dao.FaqDao;
import faq.vo.FaqVo;

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

	
	
	
}
