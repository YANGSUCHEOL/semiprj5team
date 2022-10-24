package com.kh.semiPrj.faq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.faq.service.*;
import com.kh.semiPrj.faq.vo.*;

@WebServlet(urlPatterns = "/faq/edit")
public class FaqEditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no = req.getParameter("no");
		
		FaqVo vo = new FaqService().selectFaqOne(no);
		
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/WEB-INF/views/faq/edit.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String no = req.getParameter("no");
		
		FaqVo vo = new FaqVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setNo(no);
		
		int result = new FaqService().edit(vo);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "글 수정이 완료되었습니다.");
			resp.sendRedirect("/WEB-INF/views/faq/detail?no=" + no);
		}else {
			req.setAttribute("msg", "수정 중 오류가 발생했습니다ㅠ");
			req.getRequestDispatcher("/views/errorPage.jsp").forward(req, resp);
		}
	}
}
