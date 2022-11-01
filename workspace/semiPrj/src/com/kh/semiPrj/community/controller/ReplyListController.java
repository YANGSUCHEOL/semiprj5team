package com.kh.semiPrj.community.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.community.service.CommuService;
import com.kh.semiPrj.community.vo.CommentVo;
import com.kh.semiPrj.member.MemberVo;

@WebServlet(urlPatterns = "/selectReplyList")
public class ReplyListController extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String commuNo = req.getParameter("commuNo");
		
		//현재 로그인 한 멤버 가지고 오기
		MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");

		List<CommentVo> list = new CommuService().selectReplyList(commuNo);
		req.setAttribute("CommentVo", list);
		req.setAttribute("commuNo", commuNo);
		
		
	
	}//get
	

	
	
}
