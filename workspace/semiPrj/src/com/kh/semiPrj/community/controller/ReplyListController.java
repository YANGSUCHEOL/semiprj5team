package com.kh.semiPrj.community.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semiPrj.community.service.CommuService;
import com.kh.semiPrj.community.vo.CommentVo;
import com.kh.semiPrj.member.MemberVo;

@WebServlet(urlPatterns = "/selectReplyList")
public class ReplyListController extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String commuNo = req.getParameter("commuNo");
		
		List<CommentVo> list = new CommuService().selectReplyList(commuNo);
		
		resp.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(list, resp.getWriter());

	}//get
	

	
	
}
