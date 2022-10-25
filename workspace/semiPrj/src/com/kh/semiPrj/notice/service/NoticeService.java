package com.kh.semiPrj.notice.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.semiPrj.notice.dao.NoticeDao;
import com.kh.semiPrj.notice.vo.NoticeVo;

public class NoticeService {

	private final NoticeDao dao = new NoticeDao();
	
	//공지 작성하기(insert)
	public int write(NoticeVo vo) {

		Connection conn = getConnection();
		
		int result = dao.insertNotice(conn, vo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}//write
	
	

	//공지 목록 조회(select)
	public List<NoticeVo> selectNoticeList() {
		
		Connection conn = getConnection();
		
		List<NoticeVo> voList = dao.selectNoticeList(conn);
		
		close(conn);
		
		return voList;
	
	}//selectNoticeList


	//공지 게시글 상세 조회(select)
	public NoticeVo selectNoticeDetail(String no) {
		
		// 조회수 증가 , 상세 조회
		Connection conn = getConnection();
		NoticeVo noticeVo = null;
		
		int result = dao.increaseHit(conn, no);	
		if(result == 1) {
			commit(conn);
			noticeVo = dao.selectNoticeDetail(conn, no);			
		}
		
		
		close(conn);
		
		return noticeVo;
		
	}//selectNoticeDetail


	//공지 수정하기(update)
	public int edit(NoticeVo vo) {
		
		Connection conn = getConnection();
		
		int result = dao.updateByNo(conn, vo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;

	}//edit


	//공지 삭제(delete)
	public int delete(String no) {

		Connection conn = getConnection();
		
		int result = dao.delete(conn, no);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
	
		return result;
		
	}//delete

}
