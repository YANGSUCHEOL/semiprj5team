package com.kh.semiPrj.review.service;

import java.sql.Connection;
import java.util.List;

import com.kh.semiPrj.review.dao.ReviewDao;
import com.kh.semiPrj.review.vo.ReviewVo;

import common.JDBCTemplate;
import common.PageVo;

public class ReviewService {

	private final ReviewDao dao = new ReviewDao();

	public int reviewWrite(ReviewVo vo) {

		Connection conn = JDBCTemplate.getConnection();

		int result = dao.insertOne(conn, vo);

		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result;

	}

	public int selectCount(String rno) {

		Connection conn = JDBCTemplate.getConnection();

		int result = dao.selectCount(conn, rno);

		JDBCTemplate.close(conn);

		return result;

	}
	
	public int selectCountMember(String mno) {

		Connection conn = JDBCTemplate.getConnection();

		int result = dao.selectCount(conn, mno);

		JDBCTemplate.close(conn);

		return result;

	}

	public List<ReviewVo> searchList(String resNo, PageVo pv) {

		Connection conn = JDBCTemplate.getConnection();

		List<ReviewVo> voList = null;

		voList = dao.selectList(conn, resNo, pv);

		JDBCTemplate.close(conn);

		return voList;

	}
	
	public List<ReviewVo> searchList(String resNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<ReviewVo> voList = null;
		
		voList = dao.selectListExceptPage(conn, resNo);
		
		JDBCTemplate.close(conn);
		
		return voList;
		
	}

	public int editOne(ReviewVo vo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.editOne(conn, vo);

		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);
		
		return result;
		
	}

	public List<ReviewVo> searchListClient(String mno, PageVo pv) {
		
		Connection conn = JDBCTemplate.getConnection();

		List<ReviewVo> voList = null;

		voList = dao.selectListClient(conn, mno, pv);

		JDBCTemplate.close(conn);

		return voList;
		
	}

}
