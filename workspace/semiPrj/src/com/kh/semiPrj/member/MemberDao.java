package com.kh.semiPrj.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;

public class MemberDao {

	public int insertOne(Connection conn, MemberVo vo) {
		
		//SQL
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "INSERT INTO MEMBER ( NO ,NICK ,ID ,PWD ,BIRTH ,NAME ,PHONE ) VALUES ( SEQ_MEMBER_NO.NEXTVAL , ? , ? , ? , ? , ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getNick());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getBirth());
			pstmt.setString(5, vo.getName());
			pstmt.setString(6, vo.getPhone());
						
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public MemberVo selectOne(Connection conn, MemberVo vo) {
		
		String sql = "SELECT NO ,GRADE_NO ,NICK ,ID ,PWD ,BIRTH ,NAME ,PHONE ,QUIT_YN ,ENROLL_DATE FROM MEMBER WHERE ID = ? AND PWD = ? AND QUIT_YN = 'N'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo loginMember = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String no = rs.getString("NO");
				String gradeNo = rs.getString("GRADE_NO");
				String nick = rs.getString("NICK");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String birth = rs.getString("BIRTH");
				String name = rs.getString("NAME");
				String phone = rs.getString("PHONE");
				String quitYn = rs.getString("QUIT_YN");
				String enrollDate = rs.getString("ENROLL_DATE");
				
				loginMember = new MemberVo();
				loginMember.setNo(no);
				loginMember.setGradeNo(gradeNo);
				loginMember.setNick(nick);
				loginMember.setId(id);
				loginMember.setPwd(pwd);
				loginMember.setBirth(birth);
				loginMember.setName(name);
				loginMember.setPhone(phone);
				loginMember.setQuitYn(quitYn);
				loginMember.setEnrollDate(enrollDate);
				
				

				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return loginMember;
	}

	public int quit(Connection conn, String no) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE MEMBER SET QUIT_YN = 'Y' WHERE NO = ?";
		try {
			pstmt = conn.prepareCall(sql);
			
			pstmt.setString(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updateOneByNo(Connection conn, MemberVo vo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql ="UPDATE MEMBER SET NICK = ? , ID = ? , PWD = ? , BIRTH = ? , NAME = ? , PHONE = ? WHERE NO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getNick());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getBirth());
			pstmt.setString(5, vo.getName());
			pstmt.setString(6, vo.getPhone());
			pstmt.setString(7, vo.getNo());
						
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	

}
