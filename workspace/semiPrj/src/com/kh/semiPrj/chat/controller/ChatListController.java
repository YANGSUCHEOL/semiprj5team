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
import com.kh.semiPrj.chat.vo.ChatVo;

@WebServlet(urlPatterns = "/chat/list")
public class ChatListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		String num = req.getParameter("num");

		List<ChatVo> list = new ChatService().findChatList(num);
		
		Gson gson = new Gson();
		String str = gson.toJson(list);
		
		out.write(str);
		
	}

}
