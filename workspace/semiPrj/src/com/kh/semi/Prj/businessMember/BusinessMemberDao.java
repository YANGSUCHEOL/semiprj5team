package com.kh.semi.Prj.businessMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.semi.Prj.member.MemberVo;

import common.JDBCTemplate;

public class BusinessMemberDao {

	public int insertOne(Connection conn, BusinessMemberVo vo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "INSERT INTO BUSINESS ( NO ,R_NO ,ID ,PWD ,NAME ,PHONE ,NICK ,B_NUM ) VALUES ( SEQ_BUSINESS_NO.NEXTVAL , ( SELECT NO FROM RESTAURANT WHERE NAME = ? ), ? , ? , ? , ?, ?, ? )";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getrNo());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getName());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getNick());
			pstmt.setString(7, vo.getbNum());
			
						
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public BusinessMemberVo selectOne(Connection conn, BusinessMemberVo vo) {
		
		String sql = "SELECT * FROM BUSINESS WHERE ID = ? AND PWD = ? AND QUIT_YN = 'N'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BusinessMemberVo bsloginMember = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String no = rs.getString("NO");
				String rNo = rs.getString("R_NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String phone = rs.getString("PHONE");
				String nick = rs.getString("NICK");
				String bNume = rs.getString("B_NUM");
				String quitYn = rs.getString("QUIT_YN");
				String enrollDate = rs.getString("ENROLL_DATE");
				
				bsloginMember = new BusinessMemberVo();
				bsloginMember.setNo(no);
				bsloginMember.setrNo(rNo);
				bsloginMember.setId(id);
				bsloginMember.setPwd(pwd);
				bsloginMember.setName(name);
				bsloginMember.setPhone(phone);
				bsloginMember.setNick(nick);
				bsloginMember.setbNum(bNume);
				bsloginMember.setQuitYn(quitYn);
				bsloginMember.setEnrollDate(enrollDate);
				
				

				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return bsloginMember;
	}

}
