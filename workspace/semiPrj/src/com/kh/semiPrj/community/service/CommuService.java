package com.kh.semiPrj.community.service;

import java.sql.Connection;
import java.util.List;

import static common.JDBCTemplate.*;

import common.PageVo;
import com.kh.semiPrj.community.dao.CommuDao;
import com.kh.semiPrj.community.vo.CategoryVo;
import com.kh.semiPrj.community.vo.CommuVo;

public class CommuService {
	
	private final CommuDao dao = new CommuDao();

	//커뮤니티 카테고리 목록 조회(select)
	public List<CategoryVo> selectCategoryList() {
		
		Connection conn = getConnection();
		
		List<CategoryVo> list  = dao.selectCategoryList(conn);
		
		close(conn);
		
		return list;
		
	}//selectCategoryList

	
	//커뮤니티 글 작성하기(insert)
	public int write(CommuVo vo) {
		
		Connection conn = getConnection();
		
		int result = dao.insertBoard(conn, vo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}//write


	//커뮤니티 리스트 조회하기(select)
	public List<CommuVo> selectList(PageVo pv) {

		Connection conn = getConnection();
		
		List<CommuVo> voList = dao.selectList(conn, pv);
		
		close(conn);
		
		return voList;
		
	}//selectList


	//게시글 갯수 조회(select)
	public int selectCount() {
		
		Connection conn = getConnection();
		
		int result = dao.selectCount(conn);
		
		close(conn);
		
		return result;
	
	}//selectCount


	
	//게시글 상세 조회
	public CommuVo selectOne(String bno) {
		
		Connection conn = getConnection();
		
		int result = dao.increaseHit(conn, bno);
		
		CommuVo vo = null;
		
		if(result == 1) {
			commit(conn);
			vo = dao.selectOne(conn, bno);			
		}
		
		close(conn);
		
		return vo;
		
	}//selectOne
	
	

}
