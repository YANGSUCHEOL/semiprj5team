package com.kh.semiPrj.chat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List<String> findChatRoomList(Connection conn) {
		
		String sql = "SELECT ROOM_NO FROM CHAT GROUP BY ROOM_NO ORDER BY ROOM_NO";
		
		PreparedStatement pstmt = null;
		List<String> chat = new ArrayList<String>();
		ResultSet rs = null;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String r = rs.getString("ROOM_NO");
				chat.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return chat;
	}

	public List<ChatVo> findChatList(Connection conn, String num) {
		
		String sql = "SELECT M_NO, CONTENT FROM CHAT WHERE ROOM_NO = ? ORDER BY CHATTIME";
		
		PreparedStatement pstmt = null;
		List<ChatVo> chat = new ArrayList<ChatVo>();
		ResultSet rs = null;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String mno = rs.getString("M_NO");
				String content = rs.getString("CONTENT");
				
				ChatVo vo = new ChatVo();
				
				vo.setmNo(mno);
				vo.setChat(content);
				
				chat.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return chat;
		
	}

}