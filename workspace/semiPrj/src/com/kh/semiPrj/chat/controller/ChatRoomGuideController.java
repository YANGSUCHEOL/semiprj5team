package com.kh.semiPrj.chat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semiPrj.chat.service.ChatService;

@WebServlet(urlPatterns = "/chat/roomguide")
public class ChatRoomGuideController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		List<String> list = new ChatService().findChatRoomList();
		
		Gson gson = new Gson();
		String str = gson.toJson(list);
		
		out.write(str);
		
	}

}
