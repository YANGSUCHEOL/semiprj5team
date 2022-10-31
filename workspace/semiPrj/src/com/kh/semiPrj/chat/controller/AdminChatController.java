package com.kh.semiPrj.chat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.chat.service.ChatService;

@WebServlet(urlPatterns = "/chat/admin")
public class AdminChatController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		String room = req.getParameter("room");
		
		String chat = new ChatService().selectAdminChat(room);
		int result = new ChatService().updatePrintYn(chat, room);
		
		if(result == 1) {
			out.write(chat);
		}
		
	}
	

}
