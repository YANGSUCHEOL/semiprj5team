package com.kh.semiPrj.chat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.semiPrj.chat.vo.ChatVo;

import common.JDBCTemplate;

public class ChatDao {

	public int insertOne(Connection conn, ChatVo vo) {
		
		String sql = "INSERT INTO CHAT VALUES (SEQ_CHAT_NO.NEXTVAL, ?, ?, ?, SYSDATE, 'N')";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getRoomNo());
			pstmt.setString(2, vo.getmNo());
			pstmt.setString(3, vo.getChat());
			
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

	public String selectRoom(Connection conn) {
		
		String sql = "SELECT SEQ_CHATROOM_NO.NEXTVAL FROM DUAL";
		
		PreparedStatement pstmt = null;
		String num = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getString("NEXTVAL");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return num;
		
	}

	public String selectAdminChat(Connection conn, String room) {
		
		String sql = "SELECT * FROM (SELECT ROWNUM AS NUM, CONTENT FROM CHAT WHERE M_NO = 1 AND ROOM_NO = ? AND PRINT_YN = 'N') A ORDER BY A.NUM DESC";
		
		PreparedStatement pstmt = null;
		String chat = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, room);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				chat = rs.getString("CONTENT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return chat;
		
	}

	public int updatePrintYn(Connection conn, String chat, String room) {
		
		String sql = "UPDATE CHAT SET PRINT_YN = 'Y' WHERE CONTENT = ? AND ROOM_NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, chat);
			pstmt.setString(2, room);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

}
