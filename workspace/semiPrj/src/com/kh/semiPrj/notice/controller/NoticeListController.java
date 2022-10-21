package com.kh.semiPrj.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.notice.service.NoticeService;
import com.kh.semiPrj.notice.vo.NoticeVo;

@WebServlet(urlPatterns = "/notice/list")
public class NoticeListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		List<NoticeVo> voList = new NoticeService().selectNoticeList();
		
		
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/WEB-INF/views/noticeBoard/list.jsp").forward(req, resp);
	
	}//get
	
	
	
}
