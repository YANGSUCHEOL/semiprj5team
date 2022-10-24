package com.kh.semiPrj.faq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.faq.service.*;

@WebServlet(urlPatterns = "/faq/delete")
public class FaqDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no = req.getParameter("no");
		
		int result = new FaqService().delete(no);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "삭제되었습니다.");
			resp.sendRedirect("/semiPrj/faq/list");
		}else {
			req.setAttribute("msg", "삭제 중 에러가 발생하였습니다ㅠ");
			req.getRequestDispatcher("/views/errorPage.jsp");
		}
	}
}
