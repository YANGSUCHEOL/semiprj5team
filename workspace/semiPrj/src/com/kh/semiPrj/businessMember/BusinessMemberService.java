package com.kh.semiPrj.businessMember;

import java.sql.Connection;

import com.kh.semiPrj.member.MemberVo;

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
