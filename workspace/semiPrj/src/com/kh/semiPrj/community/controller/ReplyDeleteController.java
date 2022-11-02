package com.kh.semiPrj.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.community.dao.CommuDao;
import com.kh.semiPrj.community.service.CommuService;

@WebServlet(urlPatterns = "/deleteReply")
public class ReplyDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String rno = req.getParameter("rno");	//댓글 no
		CommuService service = new CommuService();
		
		int result = new CommuService().replyDel(rno);
		
		resp.getWriter().write(result);
	
	}//get
	

}
