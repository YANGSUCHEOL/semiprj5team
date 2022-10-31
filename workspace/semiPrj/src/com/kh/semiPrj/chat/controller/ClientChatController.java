package com.kh.semiPrj.chat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.chat.service.ChatService;
import com.kh.semiPrj.chat.vo.ChatVo;

@WebServlet(urlPatterns = "/chat/client")
public class ClientChatController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		String chat = req.getParameter("chat");
		String room = req.getParameter("room");
		String mno = req.getParameter("mno");
		
		ChatVo vo = new ChatVo();
		vo.setChat(chat);
		vo.setRoomNo(room);
		vo.setmNo(mno);
		
		int result = new ChatService().insertOne(vo);
		
		if(result == 1) {
			out.write(chat);
		} else {
			out.write("error");
		}
		
	}
	


}
