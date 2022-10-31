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
		
		for(int i = 0; i < voList.size(); ++i) {
			String a = voList.get(i).getDayoff();
			String[] b = a.split(",");
			String[] c = setDay(b);
			
			voList.get(i).setOffDay(c);
		}
		
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
		
		String a = vo.getDayoff();
		String[] b = a.split(",");
		String[] c = setDay(b);
		
		vo.setOffDay(c);
		
		JDBCTemplate.close(conn);
		
		return vo;
		
	}
	
	public RestaurantVo resFindVo(String rNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		RestaurantVo vo = dao.selectOneByReNo(conn, rNo);
		
		String a = vo.getDayoff();
		String[] b = a.split(",");
		String[] c = setDay(b);
		
		vo.setOffDay(c);
		
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
	
	public String[] setDay(String[] d) {
		
		for(int i = 0; i < d.length; i++) {
			switch(d[i]) {
			case "0": d[i] = "일"; break;
			case "1": d[i] = "월"; break;
			case "2": d[i] = "화"; break;
			case "3": d[i] = "수"; break;
			case "4": d[i] = "목"; break;
			case "5": d[i] = "금"; break;
			case "6": d[i] = "토"; break;
			}
		}
		
		return d;
		
	}

	public List<RestaurantVo> searchDistrictList(String district) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<RestaurantVo> voList = null;
		
		voList = dao.selectList(conn, district);
		
		for(int i = 0; i < voList.size(); ++i) {
			String a = voList.get(i).getDayoff();
			String[] b = a.split(",");
			String[] c = setDay(b);
			
			voList.get(i).setOffDay(c);
		}
		
		JDBCTemplate.close(conn);
		
		return voList;
		
	}
	
}
