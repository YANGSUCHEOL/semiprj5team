package com.kh.semiPrj.review.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

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

		int result = dao.selectCountMember(conn, mno);

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

	public List<ReviewVo> searchListClient(String mno, PageVo pv) {

		Connection conn = JDBCTemplate.getConnection();

		List<ReviewVo> voList = null;

		voList = dao.selectListClient(conn, mno, pv);

		JDBCTemplate.close(conn);

		return voList;

	}

	// 리뷰 no로 하나 가지고 오기
	public ReviewVo getOne(String no) {

		Connection conn = JDBCTemplate.getConnection();

		ReviewVo vo = dao.getOneByNo(conn, no);

		JDBCTemplate.close(conn);

		return vo;

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

	public int deleteOne(String no) {

		Connection conn = getConnection();

		int result = dao.deleteOne(conn, no);

		if (result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;

	}

}
