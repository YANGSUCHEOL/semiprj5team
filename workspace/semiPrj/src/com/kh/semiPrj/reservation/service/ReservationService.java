package com.kh.semiPrj.reservation.service;

import java.sql.Connection;
import java.util.List;

import com.kh.semiPrj.reservation.dao.ReservationDao;
import com.kh.semiPrj.reservation.vo.ReservationVo;

import common.JDBCTemplate;

public class ReservationService {
	
public int reservation(ReservationVo vo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new ReservationDao().insertOne(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	public ReservationVo ReservationEdit(ReservationVo vo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new ReservationDao().updateOne(conn, vo);
		ReservationVo res = null;
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
			res = new ReservationDao().selectOne(conn, vo);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return res;
		
	}

	public String rsvTime(String date, String restaurant) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		String result = new ReservationDao().getRsvTimes(conn, date, restaurant);
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	public List<ReservationVo> getReservationByMNo(String no) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<ReservationVo> voList = new ReservationDao().getListByMNo(conn, no);
		
		JDBCTemplate.close(conn);
		
		return voList;
		
	}
	
	public List<ReservationVo> getReservationByRNo(String no) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<ReservationVo> voList = new ReservationDao().getListByRNo(conn, no);
		
		JDBCTemplate.close(conn);
		
		return voList;
		
	}
	
	public List<ReservationVo> getReservationByRMNo(String mno, String rno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<ReservationVo> voList = new ReservationDao().getListByRMNo(conn, mno, rno);
		
		JDBCTemplate.close(conn);
		
		return voList;
		
	}

}
