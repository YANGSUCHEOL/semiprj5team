package com.kh.semiPrj.review.service;

import java.sql.Connection;

import com.kh.semiPrj.review.dao.ReviewDao;
import com.kh.semiPrj.review.vo.ReviewVo;

import common.JDBCTemplate;

public class ReviewService {

public int reviewWrite(ReviewVo vo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new ReviewDao().insertOne(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}

}
