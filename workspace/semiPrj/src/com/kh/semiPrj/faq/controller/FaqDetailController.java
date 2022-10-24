package com.kh.semiPrj.faq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.faq.service.*;
import com.kh.semiPrj.faq.vo.*;

@WebServlet(urlPatterns = "/faq/detail")
public class FaqDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no = req.getParameter("no");
		
		FaqVo vo = new FaqService().selectFaqOne(no);
		
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/WEB-INF/views/faq/detail.jsp").forward(req, resp);
	}
}
