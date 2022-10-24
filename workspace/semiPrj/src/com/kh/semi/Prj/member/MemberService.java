package com.kh.semi.Prj.member;

import java.sql.Connection;
import common.JDBCTemplate;

public class MemberService {

	//회원가입
	public int join(MemberVo vo) {
		
		//커넥션 준비
		//SQL
		//트랙잭션 , 자원반납
		
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		int result = dao.insertOne(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public MemberVo login(MemberVo vo) {
		
		
		Connection conn = JDBCTemplate.getConnection();
		MemberVo loginMember = new MemberDao().selectOne(conn, vo);
		JDBCTemplate.close(conn);
		return loginMember;
	}

}
