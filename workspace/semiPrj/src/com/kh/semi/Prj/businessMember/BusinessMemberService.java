package com.kh.semi.Prj.businessMember;

import java.sql.Connection;

import com.kh.semi.Prj.member.MemberVo;

import common.JDBCTemplate;

public class BusinessMemberService {

	public int join(BusinessMemberVo vo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		BusinessMemberDao dao = new BusinessMemberDao();
		int result = dao.insertOne(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public BusinessMemberVo login(BusinessMemberVo vo) {
		
		Connection conn = JDBCTemplate.getConnection();
		BusinessMemberVo bsloginMember = new BusinessMemberDao().selectOne(conn, vo);
		JDBCTemplate.close(conn);
		return bsloginMember;
	}

}
