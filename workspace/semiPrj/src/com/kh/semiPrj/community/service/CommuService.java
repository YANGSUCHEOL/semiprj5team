package com.kh.semiPrj.community.service;

import java.sql.Connection;
import java.util.List;

import static common.JDBCTemplate.*;

import common.PageVo;
import com.kh.semiPrj.community.dao.CommuDao;
import com.kh.semiPrj.community.vo.AttachmentVo;
import com.kh.semiPrj.community.vo.CategoryVo;
import com.kh.semiPrj.community.vo.CommentVo;
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
	public int write(CommuVo vo, AttachmentVo attachmentVo) {
		
		Connection conn = getConnection();
		
		//게시글 insert
		int result = dao.insertBoard(conn, vo);
		
		//첨부파일 insert
		int result2 = 1;
		if(attachmentVo != null) {
			result2 = dao.insertAttachment(conn, attachmentVo);			
		}
		
		if(result * result2 == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result * result2;
		
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
	
	//게시글 수정하기(update)
	public int edit(CommuVo vo) {
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


	//게시글 삭제하기
	public int delete(String bno) {

		Connection conn = getConnection();
		
		int result = dao.delete(conn, bno);
	
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	
	}
	
	
	


	//게시글에 댓글 달기(insert)
	public int insertReply(CommentVo r) {

		Connection conn = getConnection();
		
		int result = dao.insertReply(conn, r);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);
		
		return result;
	
	}

	//댓글 리스트 (select)
	public List<CommentVo> selectReplyList(String commuNo) {

		Connection conn = getConnection();
		
		List<CommentVo> list = dao.selectReplyList(conn, commuNo);
		
		close(conn);
		
		return list;
	
	}
	
	//댓글 삭제하기
	public int replyDel(String rno) {

		Connection conn = getConnection();
		
		int result = dao.replyDel(conn, rno);
	
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	
	}


	//첨부파일 조회
	public AttachmentVo selectAttachment(String bno) {
		
		Connection conn = getConnection();
		
		AttachmentVo vo = dao.selectAttachment(conn, bno);
		
		close(conn);
		
		return vo;
	
	}//selectAttachment
	
	
	
	
	

}
