package com.kh.semiPrj.chat.service;

import java.sql.Connection;
import java.util.List;

import com.kh.semiPrj.chat.dao.ChatDao;
import com.kh.semiPrj.chat.vo.ChatVo;

import common.JDBCTemplate;

public class ChatService {
	
	private final ChatDao dao = new ChatDao();

	public int insertOne(ChatVo vo) {
		
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.insertOne(conn, vo);

		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result;
		
	}

	public String findRoom() {
		
		Connection conn = JDBCTemplate.getConnection();

		String num = dao.selectRoom(conn);

		JDBCTemplate.close(conn);

		return num;
		
	}

	public String selectAdminChat(String room) {
		
		Connection conn = JDBCTemplate.getConnection();

		String chat = dao.selectAdminChat(conn, room);

		JDBCTemplate.close(conn);

		return chat;
		
	}

	public int updatePrintYn(String chat, String room) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.updatePrintYn(conn, chat, room);
				
		JDBCTemplate.close(conn);
				
		return result;
	}

	public List<String> findChatRoomList() {
		
		Connection conn = JDBCTemplate.getConnection();

		List<String> chat = dao.findChatRoomList(conn);

		JDBCTemplate.close(conn);

		return chat;
	}

	public List<ChatVo> findChatList(String num) {
		
		Connection conn = JDBCTemplate.getConnection();

		List<ChatVo> chat = dao.findChatList(conn, num);

		JDBCTemplate.close(conn);

		return chat;
		
	}

}
