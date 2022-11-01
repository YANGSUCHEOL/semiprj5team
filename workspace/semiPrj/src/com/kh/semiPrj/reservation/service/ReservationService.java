package com.kh.semiPrj.reservation.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.semiPrj.coupon.CouponVo;
import com.kh.semiPrj.reservation.dao.ReservationDao;
import com.kh.semiPrj.reservation.vo.ReservationVo;
import com.kh.semiPrj.review.vo.ReviewVo;

import common.JDBCTemplate;
import common.PageVo;

public class ReservationService {
	
public int reservation(ReservationVo vo) {
		
		Connection conn = getConnection();
		
		int result = new ReservationDao().insertOne(conn, vo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public ReservationVo selectOne(ReservationVo vo) {
		
		Connection conn = getConnection();
		
		ReservationVo res = new ReservationDao().selectOne(conn, vo);
		
		close(conn);
		
		return res;
		
	}

	public String rsvTime(String date, String restaurant) {
		
		Connection conn = getConnection();
		
		String result = new ReservationDao().getRsvTimes(conn, date, restaurant);
		
		close(conn);
		
		return result;
		
	}
	
	public List<ReservationVo> getReservationByMNo(String no) {
		
		Connection conn = getConnection();
		
		List<ReservationVo> voList = new ReservationDao().getListByMNo(conn, no);
		
		close(conn);
		
		return voList;
		
	}
	
	public List<ReservationVo> getReservationByRNo(String no) {
		
		Connection conn = getConnection();
		
		List<ReservationVo> voList = new ReservationDao().getListByRNo(conn, no);
		
		close(conn);
		
		return voList;
		
	}
	
	// 한 회원이 한 식당에서 했던 예약 list 조회 (리뷰 작성 시 사용)
	public List<ReservationVo> getReservationByRMNo(String mno, String rno) {
		
		Connection conn = getConnection();
		
		List<ReservationVo> voList = new ReservationDao().getListByRMNo(conn, mno, rno);
		
		close(conn);
		
		return voList;
		
	}

	// 예약번호로 vo 찾기
	public ReservationVo getOneByNo(String reNo) {
		
		Connection conn = getConnection();
		
		ReservationVo vo = new ReservationDao().getOneByNo(conn, reNo);
		
		close(conn);
		
		return vo;
		
	}

	// 리뷰 작성 후 작성 여부 바꾸기
	public int reviewYnCheck(String reNo) {
		
		Connection conn = getConnection();
		
		int result = new ReservationDao().editReviewYn(conn, reNo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}

	public int editOne(ReservationVo vo) {
		
		Connection conn = getConnection();
		
		int result = new ReservationDao().editOne(conn, vo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}

	public int delete(String no) {
		
		Connection conn = getConnection();

		int result = new ReservationDao().deleteOne(conn, no);

		if (result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
		
	}

	public int selectCountMember(String mno) {
		
		Connection conn = JDBCTemplate.getConnection();

		int result = new ReservationDao().selectCount(conn, mno);

		JDBCTemplate.close(conn);

		return result;
	}

	public List<ReservationVo> getListByMNo(String mno, PageVo pv) {
		
		Connection conn = JDBCTemplate.getConnection();

		List<ReservationVo> voList = null;

		voList = new ReservationDao().getListByMNo(conn, mno, pv);

		JDBCTemplate.close(conn);

		return voList;
		
	}

	public List<CouponVo> callCouList(String mno, String resno) {
		
		Connection conn = JDBCTemplate.getConnection();

		List<CouponVo> voList = null;

		voList = new ReservationDao().callCouList(conn, mno, resno);

		JDBCTemplate.close(conn);

		return voList;
		
	}

}
