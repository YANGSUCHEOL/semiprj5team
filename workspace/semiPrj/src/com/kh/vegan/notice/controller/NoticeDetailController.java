package com.kh.vegan.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.vegan.notice.service.NoticeService;
import com.kh.vegan.notice.vo.NoticeVo;

@WebServlet(urlPatterns = "/notice/detail")
public class NoticeDetailController extends HttpServlet {

	//게시글 상세 조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String no = req.getParameter("no");
		
		
		NoticeVo noticeVo = new NoticeService().selectNoticeDetail(no);
	
		//화면 선택
		req.setAttribute("noticeVo", noticeVo);
		req.getRequestDispatcher("/WEB-INF/views/noticeBoard/detail.jsp").forward(req, resp);
		
	}//get
	
	
	
	
	
	
}
