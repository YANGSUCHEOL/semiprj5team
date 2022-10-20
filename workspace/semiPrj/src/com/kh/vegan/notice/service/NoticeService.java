package com.kh.vegan.notice.service;

import java.sql.Connection;
import java.util.List;

import static com.kh.vegan.common.JDBCTemplate.*;
import com.kh.vegan.notice.dao.NoticeDao;
import com.kh.vegan.notice.vo.NoticeVo;

public class NoticeService {

	NoticeDao dao = new NoticeDao();
	
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
		
		Connection conn = getConnection();
		
		NoticeVo noticeVo = dao.selectNoticeDetail(conn, no);
		
		close(conn);
		
		return noticeVo;
		
	}//selectNoticeDetail

}
