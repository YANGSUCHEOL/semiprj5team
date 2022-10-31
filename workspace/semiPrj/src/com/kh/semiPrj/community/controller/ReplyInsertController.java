package com.kh.semiPrj.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiPrj.community.service.CommuService;
import com.kh.semiPrj.community.vo.CommentVo;
import com.kh.semiPrj.member.MemberVo;

@WebServlet(urlPatterns = "/replyInsert")
public class ReplyInsertController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	
	}//get
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String replyContent = req.getParameter("content");
		int commuNo = Integer.parseInt(req.getParameter("commuNo"));
		
		//현재 로그인 한 멤버 가지고 오기
		
		String loginMember = ((MemberVo)req.getSession().getAttribute("loginMember")).getNo();
		
		CommentVo r = new CommentVo();
		r.setCommuNo(commuNo);
		r.setContent(replyContent);
		r.setmNo(Integer.parseInt(loginMember));
		
		int result = new CommuService().insertReply(r);
		resp.setContentType("text/html; charset=UTF-8");
		
		resp.getWriter().print(result);
		
		
	}//post
	
	
}
