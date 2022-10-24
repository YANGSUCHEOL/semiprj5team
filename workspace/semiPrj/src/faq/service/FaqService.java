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

	//FAQ 상세조회
	public FaqVo selectFaqOne(String no) {
		
		Connection conn = JDBCTemplate.getConnection();
		FaqVo vo = null;
		int result = 0;
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
			vo = new FaqDao().selectFaqOne(conn, no);
		}
		
		JDBCTemplate.close(conn);
		
		return vo;
	}

	//FAQ 수정하기
	public int edit(FaqVo vo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new FaqDao().updateOne(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//FAQ 삭제하기
	public int delete(String no) {
		
		Connection conn = null;
		
		int result = new FaqDao().delet(conn, no);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	
	
	

	
	
	
}
