package com.kh.semiPrj.chat.service;

import java.sql.Connection;

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

}
