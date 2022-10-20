package com.kh.semiPrj.restaurant.service;

import java.sql.Connection;
import java.util.List;

import com.kh.semiPrj.restaurant.dao.RestaurantDao;
import com.kh.semiPrj.restaurant.vo.MenuVo;
import com.kh.semiPrj.restaurant.vo.RestaurantVo;
import com.kh.semiPrj.review.vo.ReviewVo;

import common.JDBCTemplate;
import common.PageVo;

public class RestaurantService {

	private final RestaurantDao dao = new RestaurantDao();

	public List<RestaurantVo> searchList(String resName, PageVo pv) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<RestaurantVo> voList = null;
		
		voList = dao.selectList(conn, resName, pv);
		
		JDBCTemplate.close(conn);
		
		return voList;
		
	}

	public int selectCount(String resName) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.selectCount(conn, resName);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public RestaurantVo detailView(String rNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		RestaurantVo vo = dao.selectOneByNo(conn, rNo);
		
		JDBCTemplate.close(conn);
		
		return vo;
		
	}

	public List<MenuVo> selectMenuList(String rno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<MenuVo> voList = null;
		
		voList = dao.selectMenuList(conn, rno);
		
		JDBCTemplate.close(conn);
		
		return voList;
		
	}

	public List<ReviewVo> selectReviewList(String rno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<ReviewVo> voList = null;
		
		voList = dao.selectReviewList(conn, rno);
		
		JDBCTemplate.close(conn);
		
		return voList;
		
	}
	
}
